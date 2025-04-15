package com.SpringLayer.CrudOperationonTest.controller;

import com.SpringLayer.CrudOperationonTest.DtoLayer.ResponseStructure;
import com.SpringLayer.CrudOperationonTest.Entity.Shipment;
import com.SpringLayer.CrudOperationonTest.service.ShipmentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipments")
public class Controller {
	@Autowired
    private ShipmentService service;

    // Add new shipment
    @PostMapping
    public ResponseEntity<ResponseStructure<Shipment>> addShipment(@RequestBody Shipment shipment) {
        return service.addShipment(shipment);
    }

    // Get all shipments
    @GetMapping
    public ResponseEntity<ResponseStructure<List<Shipment>>> getAllShipments() {
        return service.getAllShipment();
    }

    // Get shipment by ID
    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Shipment>> getShipmentById(@PathVariable int id) {
        return service.getShipmentById(id);
    }

    // Update shipment
    @PutMapping
    public ResponseEntity<ResponseStructure<Shipment>> updateShipment(@RequestBody Shipment shipment) {
        return service.updateShipment(shipment);
    }

    // Delete shipment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<Void>> deleteShipmentById(@PathVariable int id) {
        return service.deletShipmentById(id);
    }

    // Get shipment by tracking number
    @GetMapping("/track/{trackNo}")
    public ResponseEntity<ResponseStructure<Shipment>> getShipmentByTrackingNo(@PathVariable int trackNo) {
        return service.getShipmentByTrackno(trackNo);
    }
}
