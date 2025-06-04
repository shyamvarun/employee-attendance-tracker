package com.example.attendance.controller;

import com.example.attendance.model.Attendance;
import com.example.attendance.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceRepository repository;

    @GetMapping
    public List<Attendance> all() { return repository.findAll(); }

    @PostMapping
    public Attendance create(@RequestBody Attendance a) { return repository.save(a); }

    @GetMapping("/{id}")
    public Attendance get(@PathVariable Long id) { return repository.findById(id).orElse(null); }

    @PutMapping("/{id}")
    public Attendance update(@PathVariable Long id, @RequestBody Attendance a) {
        a.setId(id);
        return repository.save(a);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repository.deleteById(id); }
}
