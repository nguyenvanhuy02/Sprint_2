package com.example.demo.repository;

import com.example.demo.model.QuanLyCCDC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IQuanLyCCDCReposiotyr extends JpaRepository<QuanLyCCDC, Integer> {

}
