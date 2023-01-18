package ru.ufimtsev.datasy.sickleave.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ufimtsev.datasy.sickleave.app.api.AddCodeTypeRepository;
import ru.ufimtsev.datasy.sickleave.app.api.EmployeeRepository;
import ru.ufimtsev.datasy.sickleave.app.api.SickLeaveRepository;
import ru.ufimtsev.datasy.sickleave.app.api.SickTypeRepository;
import ru.ufimtsev.datasy.sickleave.app.impl.SickLeaveMapper;
import ru.ufimtsev.datasy.sickleave.domain.*;

import java.util.List;

@RestController
@RequestMapping("/sick-leave")
@RequiredArgsConstructor
public class Controller {
    private final EmployeeRepository employeeRepository;
    private final SickLeaveRepository sickLeaveRepository;
    private final SickTypeRepository sickTypeRepository;
    private final AddCodeTypeRepository addCodeTypeRepository;
    private final SickLeaveMapper sickLeaveMapper;

    @GetMapping("/all-employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/types")
    public List<SickType> getSickTypes() {
        return sickTypeRepository.findAll();
    }

    @GetMapping("/add-code-types")
    public List<AddCodeType> getAddCodeTypes() {
        return addCodeTypeRepository.findAll();
    }

    @GetMapping("/employee/{id}/all-sick-leave")
    public List<SickLeave> getEmployeeSickLeaveList(@PathVariable("id") Long id) {
        Employee employee = employeeRepository.findById(id);
        return sickLeaveRepository.findByEmployee(employee);
    }

    @GetMapping("/{id}")
    public SickLeave getSickLeave(@PathVariable("id") Long id) {
        return sickLeaveRepository.findById(id);
    }

    @PostMapping("/create-sick-leave")
    public SickLeave createSickLeave(@RequestBody SickLeaveDTO sickLeaveDTO) {
        return sickLeaveRepository.save(sickLeaveMapper.createSickLeave(sickLeaveDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteSickLeave(@PathVariable("id") Long id) {
        sickLeaveRepository.delete(id);
    }


}
