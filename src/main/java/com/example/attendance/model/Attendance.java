package com.example.attendance.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Boolean present;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public Boolean getPresent() { return present; }
    public void setPresent(Boolean present) { this.present = present; }
    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}
