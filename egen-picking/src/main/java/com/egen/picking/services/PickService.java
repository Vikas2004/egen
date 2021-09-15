package com.egen.picking.services;

import com.egen.picking.models.DataModels.Pick;
import com.egen.picking.models.DataModels.PickStatus;
import com.egen.picking.repositories.EmployeeRepository;
import com.egen.picking.repositories.PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PickService {

    @Autowired
    private PickRepository pickRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Pick savePick(Pick pick){
        int orderCount = getEmployeeOrdersCountByStatus(pick.getEmployeeId(), PickStatus.NOTPICKED, PickStatus.PICKED);
        if(orderCount <= 10)
            return pickRepository.save(pick);
        else
            return null;
    }

    public int getEmployeeOrdersCountByStatus(Long employeeId, PickStatus pickStatus, PickStatus pickStatus1){
        return pickRepository.getEmployeeOrdersCountByStatus(employeeId, pickStatus.ordinal(), pickStatus1.ordinal());
    }

    public void cancelPick(Long id) {
       pickRepository.updatePickStatus(id,PickStatus.CANCELLED.ordinal());
    }

    public List<Pick> getAllPicks(){
        return pickRepository.findAll();
    }

    public PickStatus getPickStatus(int orderId){
        return pickRepository.getPickStatus(orderId);
    }
}
