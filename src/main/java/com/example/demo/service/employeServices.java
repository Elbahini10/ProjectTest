package com.example.demo.service;

import com.example.demo.entity.employe;

import java.util.List;
import java.util.Optional;

public interface employeServices {

    employe createEmploye(employe employe);
    List<employe> getAllEmploye();
    void deleteEmployeById(Long id);
    Optional<employe> updateEmployeById(employe employe, Long id);

}
