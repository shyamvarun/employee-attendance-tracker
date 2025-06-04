package com.example.attendance.controller;

import com.example.attendance.model.Employee;
import com.example.attendance.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    public List<Employee> all() { return repository.findAll(); }

    @PostMapping
    public Employee create(@RequestBody Employee e) { return repository.save(e); }

    @GetMapping("/{id}")
    public Employee get(@PathVariable Long id) { return repository.findById(id).orElse(null); }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee e) {
        e.setId(id);
        return repository.save(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repository.deleteById(id); }
}
