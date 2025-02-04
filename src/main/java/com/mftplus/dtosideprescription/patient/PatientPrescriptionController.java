package com.mftplus.dtosideprescription.patient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patients")
@Slf4j
public class PatientPrescriptionController {

    private final PatientPrescriptionService patientPrescriptionService;
    private final PatientService patientService;
    private final PrescriptionService prescriptionService;

    public PatientPrescriptionController(PatientPrescriptionService patientPrescriptionService, PatientService patientService, PrescriptionService prescriptionService) {
        this.patientPrescriptionService = patientPrescriptionService;
        this.patientService = patientService;
        this.prescriptionService = prescriptionService;
    }

    @GetMapping
    public String patientHome(Model model) {
        model.addAttribute("patientPrescriptionDto", new PatientPrescriptionDto());
        model.addAttribute("patients",patientService.findAll());
        model.addAttribute("prescriptions",prescriptionService.findAll());
        return "patients";

    }

    @PostMapping
    public String savePatient(PatientPrescriptionDto patientPrescriptionDto) {
        patientPrescriptionService.create(patientPrescriptionDto);
        log.info("Saved patient: {}", patientPrescriptionDto);
        return "redirect:/patients";

    }
}
