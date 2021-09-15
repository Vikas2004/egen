package com.egenlabourmanagement.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "picking")
public class Pick {
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "pick_generator",
            sequenceName = "pick_sequence",
            initialValue = 1
    )
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "warehouse_id")
    private Long warehouseId;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private PickStatus pickStatus;

    @Column(name = "store")
    private String store;

    @Column(name = "zone")
    private String zone;

    @Column(name = "type")
    private PickType type;

    @Column(name = "start_dt_tm")
    private Date startDateTime;

    @Column(name = "end_dt_tm")
    private Date endDateTime;

    @Column(name = "emp_id")
    private Long employeeId;

    @Column(name = "bulk_id")
    private Long bulkId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PickStatus getPickStatus() {
        return pickStatus;
    }

    public void setPickStatus(PickStatus pickStatus) {
        this.pickStatus = pickStatus;
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

    public PickType getType() {
        return type;
    }

    public void setType(PickType type) {
        this.type = type;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getBulkId() {
        return bulkId;
    }

    public void setBulkId(Long bulkId) {
        this.bulkId = bulkId;
    }
}
