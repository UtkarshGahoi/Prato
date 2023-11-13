package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AppointmentServiceImpl implements AppointmentService{

    private List<Doctor>doctorList;
    public AppointmentServiceImpl(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    @Override
    public Appointment  bookAppointment(Doctor doctor, Slot slot, Patient patient) {
        Random random=new Random();
        int randomNumber = random.nextInt();
        Appointment appointment=new Appointment(slot,doctor.getSpeciality(),doctor);
        var appointmentList = patient.getAppointmentList();

        appointmentList.put(String.valueOf(randomNumber),appointment);
        patient.setAppointmentList(appointmentList);
        //setting that slot false for remaining appointments.
        var availability = doctor.getAvailability();
        System.out.println(availability);
        availability.put(slot,false);
        doctor.setAvailability(availability);

        DoctorBooking doctorBooking=new DoctorBooking(patient,slot);
        var doctorBookingList = doctor.getDoctorBookingList();
        doctorBookingList.add(doctorBooking);
        doctor.setDoctorBookingList(doctorBookingList);
        return appointment;
    }

    @Override
    public void cancelAppointment(Doctor doctor, Patient patient, String bookingNumber,String bookingId) {
        var appointmentList = patient.getAppointmentList();
        Map<String,Appointment>newMap = (Map<String, Appointment>) appointmentList.remove(bookingId);
        patient.setAppointmentList(newMap);

    }

    @Override
    public List<Slot> searchByDoctor(Doctor doctor) {
       List<Slot>slots=new ArrayList<>();
       for(Doctor doctor1:doctorList){
           if(doctor1.equals(doctor)){
               var availability = doctor1.getAvailability();
               for (Map.Entry<Slot, Boolean> entry : availability.entrySet()) {
                   if(entry.getValue()){
                       slots.add(entry.getKey());
                   }
               }
           }
       }
       return slots;

    }

    @Override
    public List<Doctor> searchBySlot(Slot slot, Doctor doctor) {
        List<Doctor>doctorList1=new ArrayList<>();
        for(Doctor doctor1:doctorList1){
            if(doctor1.equals(doctor) && doctor1.getAvailability().get(slot)==true){
                doctorList1.add(doctor);
                System.out.println("We got the match for the doctors for the specific time");

            }
        }
        return doctorList1;
    }

    @Override
    public List<Doctor> searchBySpeciality(Speciality speciality) {
        List<Doctor>doctorList1=new ArrayList<>();
        for(Doctor doctor1:doctorList1){
            if(doctor1.getSpeciality().equals(speciality)){
                doctorList1.add(doctor1);
                System.out.println("We got the match for the doctor");
            }
        }
        return doctorList1;
    }
}
