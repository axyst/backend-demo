package com.example.demo.repository;

import com.example.demo.domain.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HelloRepository extends JpaRepository<Hello, Integer> { // integer is id
    // select by tempvar
    public List<Hello> findByTempvar(String tempvar);
}
