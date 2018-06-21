package com.hospital.doctoroffice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthFirstMember {

    private String memberId;
    private Coverage coverage;

    public enum Coverage {
        MEDICAL, DENTAL, VISION, NONE
    }
}
