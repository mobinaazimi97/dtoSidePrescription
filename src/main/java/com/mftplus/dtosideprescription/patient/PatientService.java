package com.mftplus.dtosideprescription.patient;

import java.util.List;

public interface PatientService {

    Patient save(Patient patient);

    Patient update(Patient patient);

    void delete(Long id);

    List<Patient> findAll();

    Patient findById(Long id);
}
