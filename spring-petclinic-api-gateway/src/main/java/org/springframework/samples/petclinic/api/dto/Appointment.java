package org.springframework.samples.petclinic.api.dto;

import lombok.Data;

@Data
public class Appointment {

    private int id;

    private String appointmentDate;

    private String description;

    private int petId;

}
