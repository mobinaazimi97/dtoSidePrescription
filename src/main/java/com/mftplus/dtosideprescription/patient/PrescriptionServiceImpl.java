package com.mftplus.dtosideprescription.patient;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class PrescriptionServiceImpl implements PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public Prescription save(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription update(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    @Override
    public void delete(Long id) {
        prescriptionRepository.deleteById(id);

    }

    @Override
    public List<Prescription> findAll() {
        return prescriptionRepository.findAll();
    }

    @Override
    public Prescription findById(Long id) {
        return prescriptionRepository.findById(id).orElse(null);
    }
}
