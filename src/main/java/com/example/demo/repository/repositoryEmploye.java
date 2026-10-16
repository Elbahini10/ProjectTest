package com.example.demo.repository;

import com.example.demo.entity.employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface repositoryEmploye extends JpaRepository<employe,Long> {

    @Query("SELECT c employe from employe c where c.cin = :x")
    List<employe> getEmployeByCin(@Param("x") String cin);

}
