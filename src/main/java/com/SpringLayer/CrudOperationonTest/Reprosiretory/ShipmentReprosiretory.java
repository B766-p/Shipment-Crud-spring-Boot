package com.SpringLayer.CrudOperationonTest.Reprosiretory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringLayer.CrudOperationonTest.Entity.Shipment;

public interface ShipmentReprosiretory extends JpaRepository<Shipment, Integer> {
 Optional<Shipment> findByTrackNo(int trackNo);
}
