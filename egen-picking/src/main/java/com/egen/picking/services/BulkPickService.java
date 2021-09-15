package com.egen.picking.services;

import com.egen.picking.models.DataModels.BulkPickDataModel;
import com.egen.picking.models.DataModels.Pick;
import com.egen.picking.models.DataModels.PickStatus;
import com.egen.picking.models.DataModels.PickType;
import com.egen.picking.repositories.BulkPickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BulkPickService {

    @Autowired
    private BulkPickRepository bulkPickRepository;

    @Autowired
    private PickService pickService;

    public BulkPickDataModel saveBulkPick(BulkPick bulkPick){
        BulkPickDataModel bulkPickDataModel = new BulkPickDataModel(bulkPick);
        BulkPickDataModel bulkPickGen = bulkPickRepository.save(bulkPickDataModel);
        int activeOrderCount = pickService.getEmployeeOrdersCountByStatus(bulkPick.getEmployeeId(), PickStatus.NOTPICKED, PickStatus.PICKED);
        if(bulkPick.getOrderList().size() <= (10-activeOrderCount)) {
            bulkPick.getOrderList().stream().forEach(orderId -> {
                Pick pick = new Pick();
                pick.setBulkId(bulkPick.getId());
                pick.setEmployeeId(bulkPick.getEmployeeId());
                pick.setOrderId(orderId);
                pick.setType(PickType.BULK);
                pick.setPickStatus(PickStatus.NOTPICKED);
                pick.setWarehouseId(bulkPick.getWarehouseId());
                pick.setZone(bulkPick.getZone());
                pickService.savePick(pick);
            });
            return bulkPickGen;
        }
        return null;
    }
}
