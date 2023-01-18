package ru.ufimtsev.datasy.paysheet.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.bind.annotation.*;
import ru.ufimtsev.datasy.paysheet.app.api.*;
import ru.ufimtsev.datasy.paysheet.app.impl.PaySheetMapper;
import ru.ufimtsev.datasy.paysheet.domain.*;

import java.util.List;

@RestController
@RequestMapping("/pay-sheet")
@RequiredArgsConstructor
public class Controller {
    private final PaySheetRepository paySheetRepository;
    private final PayTypeRepository payTypeRepository;
    private final PayRepository payRepository;
    private final EmployeeRepository employeeRepository;
    private final GeneratePaySheetDocument generatePaySheetDocument;
    private final PaySheetMapper paySheetMapper;


    @GetMapping("/all-employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/types")
    public List<PayType> getVacationTypes() {
        return payTypeRepository.findAll();
    }

    @PostMapping("/create-pay")
    public Pay createPay(@RequestBody PayDTO payDTO) {
        return payRepository.save(paySheetMapper.createPay(payDTO));
    }

    @GetMapping("/all-pays")
    public List<Pay> getAllPays() {
        return payRepository.findAll();
    }

    @DeleteMapping("/pay/{id}")
    public void deletePay(@PathVariable("id") Long id) {
        payRepository.delete(id);
    }

    @GetMapping("/pay/{id}")
    public Pay getPay(@PathVariable("id") Long id) {
        return payRepository.findById(id);
    }

    @GetMapping("/employee/{id}/pay-sheets")
    public List<PaySheet> getEmployeePaySheets(@PathVariable("id") Long id) {
        Employee employee = employeeRepository.findById(id);
        return paySheetRepository.findByEmployee(employee);
    }

    @GetMapping("/{id}")
    public PaySheet getPaySheet(@PathVariable("id") Long id){
        return paySheetRepository.findById(id);
    }

    @PostMapping("/create-pay-sheet")
    public PaySheet createPaySheet(@RequestBody PaySheetDTO paySheetDTO){
        return paySheetRepository.save(paySheetMapper.createPaySheet(paySheetDTO));
    }

    @DeleteMapping("/{id}")
    public void deletePaySheet(@PathVariable("id") Long id){
        paySheetRepository.delete(id);
    }

    @GetMapping("/{id}/download-document")
    public ByteArrayResource downloadPaySheetDocument(@PathVariable("id") Long id){
        PaySheet paySheet = paySheetRepository.findById(id);
        return new ByteArrayResource(generatePaySheetDocument.execute(paySheet).toByteArray());
    }
}
