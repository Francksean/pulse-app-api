package org.example.pulseappapi.donation.controller;

import org.example.pulseappapi.donation.DTOs.CreateAppointmentDTO;
import org.example.pulseappapi.donation.model.Appointment;
import org.example.pulseappapi.donation.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointements")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/{userId}")
    public ResponseEntity<Page<Appointment>> fetchUserAppointment(
            @PathVariable Long userId,
            @RequestParam(required = false) int page,
            @RequestParam(required = false) int pageSize) {
        final Pageable pageable = PageRequest.of(page, pageSize);
        return ResponseEntity.ok(appointmentService.getUserAppointments(userId, pageable));
    }

    @PostMapping("/create")
    public ResponseEntity<Appointment> createAppointment(@RequestBody CreateAppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(appointmentService.scheduleAppointment(appointmentDTO));
    }




}
