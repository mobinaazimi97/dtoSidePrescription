package com.mftplus.dtosideprescription.patient;

import java.util.List;

public interface PrescriptionService {

    Prescription save(Prescription prescription);

    Prescription update(Prescription prescription);

    void delete(Long id);

    List<Prescription> findAll();

    Prescription findById(Long id);
}
