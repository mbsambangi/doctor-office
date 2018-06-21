package com.hospital.doctoroffice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids = "com.healthfirst:member-function:+:stubs:8080", stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void scheduleAppointmentWhenPatientHasCoverage() throws Exception {
        Appointment appointment = new Appointment();

        appointment.setFirstName("Madhu");
        appointment.setLastName("Sambangi");
        appointment.setMemberId("123456789");
        appointment.setDateOfBirth("01/01/2018");

        mockMvc.perform(post("/api/v1/appointments")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(appointment))
        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("status").value("CONFIRMED"));
    }
}
