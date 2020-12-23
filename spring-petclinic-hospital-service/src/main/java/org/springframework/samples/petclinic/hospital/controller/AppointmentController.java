package org.springframework.samples.petclinic.hospital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.hospital.exception.ResourceNotFoundException;
import org.springframework.samples.petclinic.hospital.model.Appointment;
import org.springframework.samples.petclinic.hospital.service.AppointmentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/appointment")
@RestController
@Timed("petclinic.appointment")
@RequiredArgsConstructor
@Slf4j
public class AppointmentController {

	@Autowired
	AppointmentService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Appointment saveAppointment(@RequestBody Appointment appointment) {
		service.saveOrUpdate(appointment);
		return appointment;
	}
	
	@PutMapping
	private Appointment update(@RequestBody Appointment appointment) {
		service.saveOrUpdate(appointment);
		return appointment;
	}
	
	@GetMapping("/{id}")
	private Appointment getAppointment(@PathVariable("id") int id) {
		Optional<Appointment> appointment = service.getAppointmentById(id);
		if (!appointment.isPresent()) {
            throw new ResourceNotFoundException("appointment "+id+" not found");
        }
		return appointment.get();
	}
	
	@GetMapping
	private List<Appointment> getAllAppointment() {
		return service.getAllAppointment();
	}

	@DeleteMapping("/{id}")
	private void deleteAppointment(@PathVariable("id") int id) {
		service.delete(id);
	}
}
