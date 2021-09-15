package com.egen.picking.models.DataModels;

import com.egen.picking.services.BulkPick;
import nonapi.io.github.classgraph.json.JSONSerializer;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bulk_pick")
public class BulkPickDataModel implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_ids")
    private String orderIds;

    @Column(name = "warehouse_id")
    private Long warehouseId;

    @Column(name = "store")
    private String store;

    @Column(name = "zone")
    private String zone;

    @Column(name = "emp_id")
    private Long employeeId;

    public BulkPickDataModel(BulkPick bulkPick) {
        this.orderIds = JSONSerializer.serializeObject(bulkPick.getOrderList());
        this.employeeId = bulkPick.getEmployeeId();
        this.store = bulkPick.getStore();
        this.warehouseId = bulkPick.getWarehouseId();
        this.zone = bulkPick.getZone();
    }

    public void setOrderIds(String orderIds) {
        this.orderIds = orderIds;
    }

    public String getOrderIds() {
        return orderIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
