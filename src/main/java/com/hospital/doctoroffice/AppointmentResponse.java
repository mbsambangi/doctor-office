package com.hospital.doctoroffice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {

    private AppointmentStatus status;

    public enum AppointmentStatus {
        CONFIRMED, PENDING, CANCELLED
    }
}
