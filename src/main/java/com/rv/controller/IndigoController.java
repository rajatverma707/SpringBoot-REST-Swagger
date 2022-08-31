package com.rv.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rv.model.PassengerInfo;
import com.rv.model.TicketInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@Api("This is a Indigo distributed component")
public class IndigoController {

	@ApiOperation("This is used to book ticket")
	@PostMapping(value="/bookticket",
			     consumes = {"application/json", "application/xml"},
			     produces = {"application/json","application/xml"})
	public ResponseEntity<TicketInfo> bookTicket(@RequestBody PassengerInfo pInfo){
		
		TicketInfo ticketInfo = new TicketInfo();
		ticketInfo.setName(pInfo.getName());
		ticketInfo.setFrom(pInfo.getFrom());
		ticketInfo.setTo(pInfo.getTo());
		ticketInfo.setJourneyDate(pInfo.getJourneyDate());
		ticketInfo.setFlightId(pInfo.getFlightId());
		ticketInfo.setTicketPrice("4500.00 INR");
		ticketInfo.setTicketStatus("Confirmed");
		
		return new ResponseEntity<>(ticketInfo, HttpStatus.CREATED);
	}
}
