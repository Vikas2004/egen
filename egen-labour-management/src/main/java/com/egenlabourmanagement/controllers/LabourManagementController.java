package com.egenlabourmanagement.controllers;

import com.egenlabourmanagement.service.LMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("/lms")
@RestController
public class LabourManagementController {

    @Autowired
    LMSService lmsService;

    @Scheduled(fixedRate = 30000)
    @GetMapping("/export")
    @ResponseBody
    public void export() throws IOException {
        lmsService.export();
    }
}