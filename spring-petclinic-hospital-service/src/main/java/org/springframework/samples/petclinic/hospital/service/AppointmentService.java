package org.springframework.samples.petclinic.hospital.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.hospital.model.Appointment;
import org.springframework.samples.petclinic.hospital.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository repo;
	
	public void saveOrUpdate(Appointment appointment) {
		repo.save(appointment);
	}

	public List<Appointment> getAllAppointment() {
		List<Appointment> appointments = new ArrayList<Appointment>();
		repo.findAll().forEach(appointment1 -> appointments.add(appointment1));
		return appointments;
	}

	public Optional<Appointment> getAppointmentById(int id) {
		return repo.findById(id);
	}

	public void delete(int id) {
		repo.deleteById(id);
	}

	public void update(Appointment appointment, int id) {
		repo.save(appointment);
	}

}
