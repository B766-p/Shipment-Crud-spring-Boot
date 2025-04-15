package com.SpringLayer.CrudOperationonTest.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Shipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private int trackNo;
	private String Origin;
	private String Destination;
	private LocalDate estimatedDate;
	private String status;
	private String carrier;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTrackNo() {
		return trackNo;
	}
	public void setTrackNo(int trackNo) {
		this.trackNo = trackNo;
	}
	public String getOrigin() {
		return Origin;
	}
	public void setOrigin(String origin) {
		Origin = origin;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public LocalDate getEstimatedDate() {
		return estimatedDate;
	}
	public void setEstimatedDate(LocalDate estimatedDate) {
		this.estimatedDate = estimatedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	@Override
	public String toString() {
		return "Shipment [id=" + id + ", trackNo=" + trackNo + ", Origin=" + Origin + ", Destination=" + Destination
				+ ", estimatedDate=" + estimatedDate + ", status=" + status + ", carrier=" + carrier + "]";
	}
	public Shipment(int id, int trackNo, String origin, String destination, LocalDate estimatedDate, String status,
			String carrier) {
		super();
		this.id = id;
		this.trackNo = trackNo;
		Origin = origin;
		Destination = destination;
		this.estimatedDate = estimatedDate;
		this.status = status;
		this.carrier = carrier;
	}
	public Shipment() {

	}
	

}
