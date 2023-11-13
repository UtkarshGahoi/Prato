package org.example;

import java.util.List;

public interface AppointmentService {
    public Appointment bookAppointment(Doctor doctor,Slot slot,Patient patient);
    public void cancelAppointment(Doctor doctor,Patient patient,String bookingNumber,String bookingId);
    public List<Slot> searchByDoctor(Doctor doctor);
    public List<Doctor> searchBySlot(Slot slot,Doctor doctor);

    public List<Doctor> searchBySpeciality(Speciality speciality);

}
