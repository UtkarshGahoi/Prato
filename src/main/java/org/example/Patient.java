package org.example;

import java.util.List;
import java.util.Map;

public class Patient{
    private String name;
    private Map<String,Appointment>appointmentList;

    public Patient(String name, Map<String, Appointment> appointmentList) {
        this.name = name;
        this.appointmentList = appointmentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(Map<String, Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }
}
