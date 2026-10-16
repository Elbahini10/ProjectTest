package com.example.demo.controller;

import com.example.demo.entity.employe;
import com.example.demo.service.employeServicesImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employe")
@CrossOrigin("*")
public class ControllerEmployer {

    @Autowired
    private final employeServicesImpl employeServices;

    public ControllerEmployer(employeServicesImpl employeServices) {
        this.employeServices = employeServices;
    }

    @PostMapping("/create")
    public employe createEmployer(@RequestBody employe employe) {
        return employeServices.createEmploye(employe);
    }

    @GetMapping("/findAll")
    public List<employe> getAllEmploye() {
        return employeServices.getAllEmploye();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployeeById(@PathVariable Long id) {
        employeServices.deleteEmployeById(id);
    }

    @PutMapping("/update/{id}")
    public Optional<employe> updateEmployeById(
            @RequestBody employe employe,
            @PathVariable Long id) {
        return employeServices.updateEmployeById(employe, id);
    }
}
