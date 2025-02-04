package com.mftplus.dtosideprescription.patient;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientPrescriptionService {
    private final PatientService patientService;
    private final PrescriptionService prescriptionService;

    public PatientPrescriptionService(PatientService patientService, PrescriptionService prescriptionService) {
        this.patientService = patientService;
        this.prescriptionService = prescriptionService;
    }

    public void create(PatientPrescriptionDto patientPrescriptionDto) {

        Patient patient = patientPrescriptionDto.getPatient();
        Prescription prescription = patientPrescriptionDto.getPrescription();
        patientService.save(patient);
        prescription.setPatient(patient);
        prescriptionService.save(patientPrescriptionDto.getPrescription());

        patient.setPrescription(prescription);
        patientService.update(patient);
    }
}
