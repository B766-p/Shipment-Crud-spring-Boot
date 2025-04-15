package com.SpringLayer.CrudOperationonTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.SpringLayer.CrudOperationonTest.DaoLayer.ShipmentDao;
import com.SpringLayer.CrudOperationonTest.DtoLayer.ResponseStructure;
import com.SpringLayer.CrudOperationonTest.Entity.Shipment;

@Service
public class ShipmentService {
	@Autowired
    private ShipmentDao dao;
	 // Add new shipment
    public ResponseEntity<ResponseStructure<Shipment>> addShipment(Shipment ship) {
        // Save shipment using DAO
        Shipment shipment = dao.saveShipment(ship);

        // Preparing the response
        ResponseStructure<Shipment> response = new ResponseStructure<>();
        response.setStatus(HttpStatus.CREATED.value());
        response.setMessage("Shipment added successfully");
        response.setData(shipment);
        
       
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get all shipment
    public ResponseEntity<ResponseStructure<List<Shipment>>> getAllShipment() {
   
        List<Shipment> shipment = dao.getAllShipment();  
        ResponseStructure<List<Shipment>> response = new ResponseStructure<>();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("All shipment fetched successfully"); 
       
        response.setData(shipment);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Get shipment by ID
    public ResponseEntity<ResponseStructure<Shipment>> getShipmentById(int id) {
        Optional<Shipment> ship = dao.getShipmentById(id); 
        ResponseStructure<Shipment> response = new ResponseStructure<>();

        if (ship != null) {
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Shipment found");
            response.setData(ship.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage("Stude not found with ID: " + id);
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    // Update shipment
    public ResponseEntity<ResponseStructure<Shipment>> updateShipment(Shipment ship) {
       

      
            Shipment update = dao.updateShipment(ship);

            ResponseStructure<Shipment> response = new ResponseStructure<>();
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Student updated successfully");
            response.setData(update);
            return new ResponseEntity<>(response, HttpStatus.OK);
 
    }

    // Delete 
    public ResponseEntity<ResponseStructure<Void>> deletShipmentById(int id) {
        boolean deleted = dao.deleteshipment(id); 
        
        ResponseStructure<Void> response = new ResponseStructure<>();

        if (deleted) {
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Shipment deleted successfully");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage("Shipment not found with ID: " + id);
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    //get shipment by tracking no
    public ResponseEntity<ResponseStructure<Shipment>> getShipmentByTrackno(int trackNO) {
        Optional<Shipment> ship = dao.getShipmentBytrckno(trackNO); 
        ResponseStructure<Shipment> response = new ResponseStructure<>();

        if (ship != null) {
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Shipment found");
            response.setData(ship.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage("Shipment not found with ID: " + trackNO);
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

}
