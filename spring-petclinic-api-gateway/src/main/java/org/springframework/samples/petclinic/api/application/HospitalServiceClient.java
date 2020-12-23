package org.springframework.samples.petclinic.api.application;

import org.springframework.samples.petclinic.api.dto.Appointment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class HospitalServiceClient {

    private String hostname = "http://hospital-service/";

    private WebClient.Builder webClientBuilder;

    public Mono<Appointment> getAppointment(final int id) {
        return webClientBuilder.build()
            .get()
            .uri(hostname + "appointment/{id}", id)
            .retrieve()
            .bodyToMono(Appointment.class);
    }
    
    public Mono<Appointment> makeAppointment(Appointment appointment) {
        return webClientBuilder.build()
            .post()
            .uri(hostname + "appointment")
            .body(Mono.just(appointment), Appointment.class)
            .retrieve()
            .bodyToMono(Appointment.class);
    }

    void setHostname(String hostname) {
        this.hostname = hostname;
    }
}
