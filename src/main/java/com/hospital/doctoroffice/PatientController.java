package com.hospital.doctoroffice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class PatientController {

    private HealthFirstService healthFirstService;

    public PatientController(HealthFirstService healthFirstService) {
        this.healthFirstService = healthFirstService;
    }

    @PostMapping("/appointments")
    public AppointmentResponse appointments(@RequestBody Appointment appointment) {
        AppointmentResponse response = new AppointmentResponse();
        HealthFirstMember member = new HealthFirstMember();
        member.setMemberId(appointment.getMemberId());

        member = healthFirstService.verifyCoverage(member);

        if (member.getCoverage() == HealthFirstMember.Coverage.MEDICAL) {
            response.setStatus(AppointmentResponse.AppointmentStatus.CONFIRMED);
        }

        return response;
    }
}
