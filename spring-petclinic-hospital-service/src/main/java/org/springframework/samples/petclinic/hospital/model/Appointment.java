package org.springframework.samples.petclinic.hospital.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.core.style.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
public class Appointment {
	
	@Id
	private int id;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column
    private Date appointmentDate;
	
	@Size(max = 8192)
	@NotEmpty
	@Column
	private String description;
	
	@Column
	private int petId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id <= 0) {
			throw new IllegalStateException("Invalid id");
		}
		this.id = id;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		if (petId <= 0) {
			throw new IllegalStateException("Invalid petId");
		}
		this.petId = petId;
	}
	
	@Override
    public String toString() {
        return new ToStringCreator(this)
            .append("id", this.getId())
            .append("date", this.getAppointmentDate())
            .append("description", this.getDescription())
            .append("petId", this.getPetId())
            .toString();
    }
}
