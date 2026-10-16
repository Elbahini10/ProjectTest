package com.example.demo.service;

import com.example.demo.entity.employe;
import com.example.demo.repository.repositoryEmploye;
import jakarta.persistence.Embeddable;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor @NoArgsConstructor
public class employeServicesImpl implements employeServices {

    @Autowired
    private repositoryEmploye repositoryEmploye;

    @Override
    public employe createEmploye(employe employe) {
        List<employe> checkEmploye =
                repositoryEmploye.getEmployeByCin(employe.getCin());
        if (!checkEmploye.isEmpty()) {
            throw new RuntimeException("Un employé avec ce CIN existe déjà !");
        }
        return repositoryEmploye.save(employe);
    }

    @Override
    public List<employe> getAllEmploye() {
        return repositoryEmploye.findAll();
    }

    @Override
    public void deleteEmployeById(Long id) {
        employe employe1 = repositoryEmploye.getById(id);
        repositoryEmploye.delete(employe1);
    }

    @Override
    public Optional<employe> updateEmployeById(employe employe, Long id) {
        return repositoryEmploye.findById(id)
                .map(employe1 -> {
                    employe1.setPrenom(employe.getPrenom());
                    employe1.setNom(employe.getNom());
                    employe1.setDataNaissance(employe.getDataNaissance());
                    employe1.setEmail(employe.getEmail());
                    employe1.setPhone(employe.getPhone());
                    return repositoryEmploye.save(employe1);
                });
    }
}
