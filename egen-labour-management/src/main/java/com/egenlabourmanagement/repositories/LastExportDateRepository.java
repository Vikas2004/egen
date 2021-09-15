package com.egenlabourmanagement.repositories;

import com.egenlabourmanagement.models.LastExportDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastExportDateRepository extends JpaRepository<LastExportDate, Long> {
}
