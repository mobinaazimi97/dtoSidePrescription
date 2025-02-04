package com.mftplus.dtosideprescription.patient;

import com.github.mfathi91.time.PersianDate;

import java.time.LocalDate;

public class PatientPrescriptionDto {

    private Long patientId;
    private String firstName;
    private String lastName;
    private String sickness;

    private Long prescriptionId;
    private String description;
    private LocalDate prescriptionDate;


    public Patient getPatient() {
        return Patient.builder()
                .id(patientId)
                .firstName(firstName)
                .lastName(lastName)
                .sickness(sickness)
                .build();
    }

    public Prescription getPrescription() {

        return Prescription.builder()
                .id(prescriptionId)
                .description(description)
                .prescriptionDate(prescriptionDate)
                .build();
    }

    public String getPersianPrescriptionDate() {
        return PersianDate.fromGregorian(prescriptionDate).toString();
    }

    public void setPersianDate(String persianDate) {
        this.prescriptionDate = PersianDate.parse(persianDate).toGregorian();
    }
}
