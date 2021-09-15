package com.egen.picking.controllers;

import com.egen.picking.services.BulkPick;
import com.egen.picking.models.DataModels.BulkPickDataModel;
import com.egen.picking.services.BulkPickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/pick/bulk")
@RestController
public class BulkOrderPickingController {

    @Autowired
    BulkPickService bulkPickService;

    @PostMapping("/create")
    @ResponseBody
    public BulkPickDataModel createPick(@RequestBody BulkPick bulkPick){
        return bulkPickService.saveBulkPick(bulkPick);
    }
}
