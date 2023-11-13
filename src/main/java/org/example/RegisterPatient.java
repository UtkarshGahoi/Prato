package org.example;

import java.util.ArrayList;
import java.util.List;

public class RegisterPatient {
    List<Patient>patientList=new ArrayList<>();
    public void  registerPatient(Patient patient){
        patientList.add(patient);
        System.out.println("Patient registered successfully");
    }
    public List<Patient> getPatientList(){
        return patientList;
    }

}
