package org.example.pulseappapi.center_management.services;

import org.example.pulseappapi.center_management.DTOs.CenterRequestDTO;
import org.example.pulseappapi.center_management.enums.AccreditationStatus;
import org.example.pulseappapi.center_management.models.Center;
import org.example.pulseappapi.center_management.repository.CenterRepository;
import org.example.pulseappapi.core.email.EmailService;
import org.example.pulseappapi.core.file.FileSystemStorageService;
import org.example.pulseappapi.notification.DTOs.CreateNotificationDTO;
import org.example.pulseappapi.notification.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CenterService {
    @Autowired
    private CenterRepository centerRepository;
    @Autowired
    private FileSystemStorageService fileSystemStorageService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private EmailService emailService;

    /**
     * Enregistre un centre et stocke ses documents.
     *
     * @param request Les données du centre
     * @return Le centre enregistré
     */
    public Center createNewCenterRequest(CenterRequestDTO request) {
        Center center = new Center();
        center.setName(request.getName());
        center.setPhoneNumber(request.getPhoneNumber());
        center.setEmail(request.getEmail());
        center.setLatitude(request.getLatitude());
        center.setLongitude(request.getLongitude());

        List<String> documentPaths = request.getDocuments().stream()
                .map(fileSystemStorageService::storeAndGetPath)
                .collect(Collectors.toList());

        center.setDocumentUrls(documentPaths);

        return centerRepository.save(center);
    }

    public Center updateCenterStatus(Long centerId, AccreditationStatus status) {
        Center center = centerRepository.findById(centerId)
                .orElseThrow(() -> new RuntimeException("Centre introuvable"));

        center.setAccreditationStatus(status);
        centerRepository.save(center);

        String notificationMessage = generateStatusMessage(status);

        final CreateNotificationDTO createNotificationDTO = new CreateNotificationDTO();
        createNotificationDTO.setCenter(center);
        createNotificationDTO.setBody(notificationMessage);
        createNotificationDTO.setTitle("Approbation");

        notificationService.registerNotification(createNotificationDTO);
        String emailContent = emailService.generateCenterApprobationStatusEmailContent(center.getName(), status);
        emailService.sendEmail(center.getEmail(), createNotificationDTO.getTitle(), emailContent);

        return center;
    }

    /**
     * Génère un message adapté selon le changement de statut.
     *
     * @param newStatus Le nouveau statut
     * @return Un message explicatif
     */
    private String generateStatusMessage(AccreditationStatus newStatus) {
        switch (newStatus) {
            case APPROVED:
                return "Félicitations ! Votre centre de don a été approuvé et est désormais opérationnel.";
            case REJECTED:
                return "Malheureusement, votre demande d'enregistrement a été rejetée. Veuillez nous contacter pour plus d'informations.";
            case REVOKED:
                return "Votre accréditation a été révoquée. Votre centre ne peut plus recevoir de dons. Contactez-nous pour plus d’informations.";
            default:
                return "Votre statut a été mis à jour.";
        }
    }

}
