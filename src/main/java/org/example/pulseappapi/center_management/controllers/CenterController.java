package org.example.pulseappapi.center_management.controllers;

import org.example.pulseappapi.center_management.DTOs.CenterRequestDTO;
import org.example.pulseappapi.center_management.enums.AccreditationStatus;
import org.example.pulseappapi.center_management.models.Center;
import org.example.pulseappapi.center_management.services.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/centers")
public class CenterController {
    @Autowired
    private CenterService centerService;

    @PostMapping(name = "/new", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Center> createNewCenterRequest(@RequestParam("name") String name,
                                                         @RequestParam("address") String address,
                                                         @RequestParam("phoneNumber") String phoneNumber,
                                                         @RequestParam("email") String email,
                                                         @RequestParam("latitude") String latitude,
                                                         @RequestParam("longitude") String longitude,
                                                         @RequestParam("files") MultipartFile[] files) {
        CenterRequestDTO requestDTO = new CenterRequestDTO();
        requestDTO.setName(name);
        requestDTO.setAddress(address);
        requestDTO.setPhoneNumber(phoneNumber);
        requestDTO.setEmail(email);
        requestDTO.setLatitude(latitude);
        requestDTO.setLongitude(longitude);
        requestDTO.setDocuments(Arrays.asList(files));
        Center requestedCenter = centerService.createNewCenterRequest(requestDTO);
        return ResponseEntity.ok(requestedCenter);

    }

    @PutMapping("/{centerId}/validate")
    public ResponseEntity<Center> validateCenterRequest(@PathVariable(name = "centerId") Long centerId
    ) {
        return ResponseEntity.ok(centerService.updateCenterStatus(centerId, AccreditationStatus.APPROVED));
    }
    @PutMapping("/{centerId}/reject")
    public ResponseEntity<Center> rejectCenterRequest(@PathVariable(name = "centerId") Long centerId
    ) {
        return ResponseEntity.ok(centerService.updateCenterStatus(centerId, AccreditationStatus.REJECTED));
    }
}
