package com.egenlabourmanagement.models;

import java.io.Serializable;
import java.util.Date;

public class EmployeePerformance {

    private String employeeId;
    private String employeeName;
    private String employeeMailId;
    private Date startDateTime;
    private Date endDateTime;
    private PickType type;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeMailId() {
        return employeeMailId;
    }

    public void setEmployeeMailId(String employeeMailId) {
        this.employeeMailId = employeeMailId;
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

    public PickType getType() {
        return type;
    }

    public void setType(PickType type) {
        this.type = type;
    }
}
