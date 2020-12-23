package org.springframework.samples.petclinic.customers.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.samples.petclinic.hospital.controller.AppointmentController;
import org.springframework.samples.petclinic.hospital.model.Appointment;
import org.springframework.samples.petclinic.hospital.service.AppointmentService;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AppointmentController.class)
@ContextConfiguration(classes = AppointmentController.class)
@ActiveProfiles("test")
class AppointmentControllerTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	AppointmentService service;

	@Test
	void shouldGetAPetInJSonFormat() throws Exception {

		Appointment appointment = setupAppointment();

		given(service.getAppointmentById(1)).willReturn(Optional.of(appointment));

		mvc.perform(get("/appointment/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json")).andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.petId").value(1)).andExpect(jsonPath("$.description").value("cannot eat food"));
	}

	private Appointment setupAppointment() {
		Appointment appointment = new Appointment();
		appointment.setId(1);
		appointment.setAppointmentDate(new Date());
		appointment.setDescription("cannot eat food");
		appointment.setPetId(1);
		return appointment;
	}
}
