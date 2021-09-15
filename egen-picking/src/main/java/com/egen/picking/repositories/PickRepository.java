package com.egen.picking.repositories;

import com.egen.picking.models.DataModels.Pick;
import com.egen.picking.models.DataModels.PickStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PickRepository extends JpaRepository<Pick, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE picking SET status =?2 WHERE id=?1", nativeQuery = true)
    public void updatePickStatus(Long id, int pickStatus);

    @Query(value = "SELECT status from picking WHERE order_id=?1", nativeQuery = true)
    public PickStatus getPickStatus(int orderId);

    @Query(value = "SELECT count(*) FROM picking WHERE emp_id=?1 and status in(?2,?3)", nativeQuery = true)
    public int getEmployeeOrdersCountByStatus(Long employeeId, int pickStatus1, int pickStatus2);
}
