package org.example;

public class Appointment {
    Slot slot;
    Speciality speciality;
    Doctor doctor;

    public Appointment(Slot slot, Speciality speciality, Doctor doctor) {
        this.slot = slot;
        this.speciality = speciality;
        this.doctor = doctor;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
