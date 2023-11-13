package org.example;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Doctor extends User {
    private Speciality speciality;
    private Map<Slot, Boolean> availability;
    private List<DoctorBooking> doctorBookingList;

    public Doctor(String userName, String password, Speciality speciality, Map<Slot, Boolean> availability, List<DoctorBooking> doctorBookingList) {
        super(userName, password);
        this.speciality = speciality;
        this.availability = availability;
        this.doctorBookingList = doctorBookingList;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Map<Slot, Boolean> getAvailability() {
        return availability;
    }

    public void setAvailability(Map<Slot, Boolean> availability) {
        this.availability = availability;
    }

    public List<DoctorBooking> getDoctorBookingList() {
        return doctorBookingList;
    }

    public void setDoctorBookingList(List<DoctorBooking> doctorBookingList) {
        this.doctorBookingList = doctorBookingList;
    }
}