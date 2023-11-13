package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Map<Slot,Boolean>timeSlots=new HashMap<>();
        List<DoctorBooking>doctorBookingList=new ArrayList<>();
        //declaring the doctors.
       Doctor doctor=new Doctor("JN BHALLA","GP",Speciality.GENERAL_PHYSICIAN,timeSlots,doctorBookingList);
       Doctor doctor1=new Doctor("Sanjveev Gupta","PG",Speciality.GENERAL_PHYSICIAN,timeSlots,doctorBookingList);
       //adding the doctor to the list, so we can search over the doctors.
        List<Doctor>doctors=new ArrayList<>();
        doctors.add(doctor1);
        doctors.add(doctor);

        //Declaring the patient
        Map<String,Appointment>empty=new HashMap<>();
        Patient patient=new Patient("Rajeev Kumar", empty);

        //Initializing the assignment service ,so we can search over the doctors and speciality
        AppointmentServiceImpl appointmentService=new AppointmentServiceImpl(doctors);


        //defining the slots for booking
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = sdf.parse("2023-11-08 09:00");
            endDate = sdf.parse("2023-11-08 10:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Creating a Slot object
        Slot mySlot = new Slot(startDate, endDate);
        timeSlots.put(mySlot,true);

        //setting availability for doctor.
        doctor.setAvailability(timeSlots);
        var appointment = appointmentService.bookAppointment(doctor, mySlot, patient);
        System.out.println(appointment.getDoctor().getUserName());

        //patient appointment list
        var appointmentList = patient.getAppointmentList();
        for (Map.Entry<String, Appointment> entry : appointmentList.entrySet()) {
            System.out.println(entry.getKey() +" "+ entry.getValue().getDoctor().getUserName());
        }
        //doctor's booking list
        var doctorBookingList1 = doctor.getDoctorBookingList();
        for(DoctorBooking doctorBooking:doctorBookingList1){
            System.out.println(doctorBooking.getPatient().getName()+" "+doctorBooking.getSlot().startTime+" "+doctorBooking.getSlot().getEndTime());
        }

    }
    }
