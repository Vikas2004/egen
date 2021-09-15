package com.egenlabourmanagement.models;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "last_export_date")
public class LastExportDate {

    @Id
    @GeneratedValue(generator = "last_export_date_generator")
    @SequenceGenerator(
            name = "last_export_date_generator",
            sequenceName = "last_export_date_sequence",
            initialValue = 1
    )
    private Long id;

    @Column(name = "latest_export_Date")
    private Date latestExportDate;

    public Date getLatestExportDate() {
        return latestExportDate;
    }

    public void setLatestExportDate(Date latestExportDate) {
        this.latestExportDate = latestExportDate;
    }
}
