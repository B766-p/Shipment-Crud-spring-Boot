package com.SpringLayer.CrudOperationonTest.DaoLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.SpringLayer.CrudOperationonTest.Entity.Shipment;
import com.SpringLayer.CrudOperationonTest.Reprosiretory.ShipmentReprosiretory;

@Repository
public class ShipmentDao {
	@Autowired(required=true)
    private ShipmentReprosiretory customRepo;

    public List<Shipment> getAllShipment() {
        return customRepo.findAll();
    }

    public Optional<Shipment> getShipmentById(int id) {
        return customRepo.findById(id);
    }

    public Shipment saveShipment(Shipment ship) {
        return customRepo.save(ship);
    }

    public Shipment updateShipment(Shipment ship) {
        return customRepo.save(ship);
    }

    public boolean deleteshipment(int id) {
        if(customRepo.existsById(id)) {
        	customRepo.deleteById(id);
        	return true;
        	}
        return false;
    }
    public Optional<Shipment> getShipmentBytrckno(int trackNo) {
    	
    	  return customRepo.findByTrackNo(trackNo);
    }

}
