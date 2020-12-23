package org.springframework.samples.petclinic.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.hospital.model.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

}
