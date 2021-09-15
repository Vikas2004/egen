package com.egen.picking.controllers;

import com.egen.picking.services.BulkPick;
import com.egen.picking.models.DataModels.Pick;
import com.egen.picking.models.DataModels.PickStatus;
import com.egen.picking.services.PickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pick")
@RestController
public class SingleOrderPickingController {

    @Autowired
    PickService pickService;

    @PostMapping("/create")
    @ResponseBody
    public Pick createPick(@RequestBody Pick pick){
        return pickService.savePick(pick);
    }

    @DeleteMapping("/cancel")
    public void cancelPick(@RequestParam(value = "id") Long id){
        pickService.cancelPick(id);
    }

    @GetMapping("")
    @ResponseBody
    public List<Pick> getAllPicks(){
        return pickService.getAllPicks();
    }

    @GetMapping("/status")
    @ResponseBody
    public PickStatus getPickStatus(@RequestParam(value = "orderId") int orderId){
        return pickService.getPickStatus(orderId);
    }

}
