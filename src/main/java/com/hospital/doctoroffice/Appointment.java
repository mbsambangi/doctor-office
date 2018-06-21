package com.hospital.doctoroffice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    private String firstName;
    private String lastName;
    private String memberId;
    private String dateOfBirth;
}
