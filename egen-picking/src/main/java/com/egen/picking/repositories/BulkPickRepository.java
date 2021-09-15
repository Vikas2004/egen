package com.egen.picking.repositories;

import com.egen.picking.models.DataModels.BulkPickDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BulkPickRepository extends JpaRepository<BulkPickDataModel, Long> {
}
