package com.egenlabourmanagement.repositories;


import com.egenlabourmanagement.models.Pick;
import com.egenlabourmanagement.models.PickStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PickRepository extends JpaRepository<Pick, Long> {

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM picking WHERE status in(?1)", nativeQuery = true)
    public List<Pick> getEmployeeOrdersCountByStatus(int pickStatus);
}
