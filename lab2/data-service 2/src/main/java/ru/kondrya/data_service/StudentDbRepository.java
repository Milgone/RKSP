package ru.kondrya.data_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDbRepository extends JpaRepository<StudentDb, Long> {
}
