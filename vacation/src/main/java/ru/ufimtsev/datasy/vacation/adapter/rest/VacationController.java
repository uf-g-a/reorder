package ru.ufimtsev.datasy.vacation.adapter.rest;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;
import ru.ufimtsev.datasy.vacation.app.api.employee.EmployeeRepository;
import ru.ufimtsev.datasy.vacation.app.api.vacation.CreateVacationDocument;
import ru.ufimtsev.datasy.vacation.app.api.vacation.CreateVacationInbound;
import ru.ufimtsev.datasy.vacation.app.api.vacation.VacationRepository;
import ru.ufimtsev.datasy.vacation.app.api.vacationtype.VacationTypeRepository;
import ru.ufimtsev.datasy.vacation.domain.Employee;
import ru.ufimtsev.datasy.vacation.domain.Vacation;
import ru.ufimtsev.datasy.vacation.domain.VacationDTO;
import ru.ufimtsev.datasy.vacation.domain.VacationType;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;


@Slf4j
@RestController
@RequestMapping("/vacation")
@RequiredArgsConstructor
public class VacationController {
    private final EmployeeRepository employeeRepository;
    private final VacationRepository vacationRepository;
    private final VacationTypeRepository vacationTypeRepository;
    private final CreateVacationDocument createVacationDocument;
    private final CreateVacationInbound createVacationInbound;

    @GetMapping("/all-employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/save")
    public void saveVacation(@RequestBody VacationDTO vacationDTO) {
        Vacation vacation = createVacationInbound.execute(vacationDTO);
        vacationRepository.save(vacation);
    }

    @GetMapping("/employee/{id}/vacations")
    public List<Vacation> getEmployeeAllVacations(@PathVariable("id") Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId);
        return vacationRepository.findByEmployee(employee);
    }

    @GetMapping("/{id}")
    public Vacation getVacationById(@PathVariable("id") Long vacationId){
        return vacationRepository.findById(vacationId).orElseThrow();
    }

    @GetMapping("/types")
    public List<VacationType> getVacationTypes(){
        return vacationTypeRepository.findAll();
    }


    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> testRequest() {
        System.out.println("test request");
        Employee testEmployee = new Employee();
        testEmployee.setName("test");
        return ResponseEntity.ok().body(testEmployee);
    }

    @GetMapping(value = "/{id}/download-document", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ByteArrayResource downloadVacationDocument(@PathVariable("id") Long vacationId){
        Vacation vacation = vacationRepository.findById(vacationId).orElseThrow();
        return new ByteArrayResource(createVacationDocument.execute(vacation).toByteArray());
    }

    @DeleteMapping("/{id}")
    public void deleteVacation(@PathVariable("id") Long id){
        Vacation vacation = vacationRepository.findById(id).orElseThrow();
        vacationRepository.delete(vacation);
    }
}
