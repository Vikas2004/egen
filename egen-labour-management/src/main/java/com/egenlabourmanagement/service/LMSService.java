package com.egenlabourmanagement.service;

import com.egenlabourmanagement.models.Employee;
import com.egenlabourmanagement.models.EmployeePerformance;
import com.egenlabourmanagement.models.Pick;
import com.egenlabourmanagement.models.PickStatus;
import com.egenlabourmanagement.repositories.EmployeeRepository;
import com.egenlabourmanagement.repositories.PickRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

@Service
public class LMSService {
    @Autowired
    private PickRepository pickRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public void export() throws IOException {
        List<EmployeePerformance> employeePerformances = employeePerformances();
        ByteArrayInputStream byteArrayInputStream = writeToCSV(employeePerformances);
        IOUtils.copy(byteArrayInputStream, new FileOutputStream("Output.csv"));
    }

    private ByteArrayInputStream writeToCSV(List<EmployeePerformance> employeePerformances) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format)) {
            List<String> headers = Arrays.asList(
                    "Employee Id",
                    "Employee Mail Id",
                    "Employee Name",
                    "Pick Start Time",
                    "Pick Start Time");
            csvPrinter.printRecord(headers);
            for (EmployeePerformance performance : employeePerformances) {
                List<String> data = Arrays.asList(
                        String.valueOf(performance.getEmployeeId()),
                        String.valueOf(performance.getEmployeeMailId()),
                        String.valueOf(performance.getEmployeeName()),
                                String.valueOf(performance.getStartDateTime()),
                                        String.valueOf(performance.getEndDateTime()));

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("failed to import data to CSV file: " + e.getMessage());
        }
    }

    private List<EmployeePerformance> employeePerformances(){
        List<EmployeePerformance> employeePerformances = new ArrayList<>();
        List<Pick> picks =  pickRepository.getEmployeeOrdersCountByStatus(PickStatus.DELIVERED.ordinal());
        picks.stream().forEach(p ->{
            Employee employee = employeeRepository.findById(p.getEmployeeId()).get();
            EmployeePerformance employeePerformance = new EmployeePerformance();
            employeePerformance.setEmployeeId(String.valueOf(p.getEmployeeId()));
            employeePerformance.setEmployeeMailId(employee.getMail_id());
            employeePerformance.setEmployeeName(employee.getName());
            employeePerformance.setEndDateTime(p.getEndDateTime());
            employeePerformance.setStartDateTime(p.getStartDateTime());
            employeePerformance.setType(p.getType());
            employeePerformances.add(employeePerformance);
        });
        return employeePerformances;
    }
}
