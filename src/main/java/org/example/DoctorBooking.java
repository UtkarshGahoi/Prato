package org.example;

public class DoctorBooking {
    Patient patient;
    Slot slot;

    public DoctorBooking(Patient patient, Slot slot) {
        this.patient = patient;
        this.slot = slot;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
