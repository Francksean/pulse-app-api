package org.example.pulseappapi.donation.service;

import org.example.pulseappapi.center_management.models.Center;
import org.example.pulseappapi.core.user.models.User;
import org.example.pulseappapi.core.user.repositories.UserRepository;
import org.example.pulseappapi.donation.DTOs.CreateAppointmentDTO;
import org.example.pulseappapi.donation.enums.AppointmentStatus;
import org.example.pulseappapi.donation.model.Appointment;
import org.example.pulseappapi.donation.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CenterRepository centerRepository;

    public Appointment scheduleAppointment(CreateAppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();

        User userReference = userRepository.getReferenceById(appointmentDTO.getDonorId());
        appointment.setDonor(userReference);

        Center centerReference = centerRepository.getReferenceById(appointmentDTO.getCenterId());
        appointment.setCenter(centerReference);

        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setStatus(AppointmentStatus.SCHEDULED);
        appointmentRepository.save(appointment);
        return appointment;
    }

    public Appointment updateAppointmentStatus(Long appointmentId, AppointmentStatus appointmentStatus) {
        return appointmentRepository.updateFirstById(appointmentId, appointmentStatus);
    }

    public Appointment getAppointmentById(Long id){
        return appointmentRepository.findById(id).orElse(null);
    }

    public Page<Appointment> getUserAppointments(Long userId, Pageable pageable) {
        return appointmentRepository.findFirstByDonor_Id(userId, pageable);
    }
}
