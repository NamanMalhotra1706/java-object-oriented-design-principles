import java.util.ArrayList;
import java.util.List;

class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void listDoctors() {
        System.out.println(name + " is consulting with:");
        for (Doctor doctor : doctors) {
            System.out.println(" - Dr. " + doctor.getName());
        }
    }
}

class Doctor {
    private String name;
    private List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this); // Ensure bidirectional relationship
        }
    }

    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " is consulting with " + patient.getName());
    }

    public void listPatients() {
        System.out.println("Dr. " + name + " is treating:");
        for (Patient patient : patients) {
            System.out.println(" - " + patient.getName());
        }
    }
}

class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void listDoctors() {
        System.out.println("Doctors at " + name + ":");
        for (Doctor doctor : doctors) {
            System.out.println(" - Dr. " + doctor.getName());
        }
    }

    public void listPatients() {
        System.out.println("Patients at " + name + ":");
        for (Patient patient : patients) {
            System.out.println(" - " + patient.getName());
        }
    }
}

public class HospitalDoctorsAndPatients {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor drNaman = new Doctor("Naman");
        Doctor drManvi = new Doctor("Manvi");

        Patient NM = new Patient("NM");
        Patient MG = new Patient("MG");

        hospital.addDoctor(drNaman);
        hospital.addDoctor(drManvi);
        hospital.addPatient(NM);
        hospital.addPatient(MG);

        drNaman.addPatient(NM);
        drNaman.addPatient(MG);
        drManvi.addPatient(NM);

        // Consultations
        drNaman.consult(NM);
        drManvi.consult(NM);
        drNaman.consult(MG);

        // List doctors and patients
        hospital.listDoctors();
        hospital.listPatients();

        drNaman.listPatients();
        drManvi.listPatients();

        NM.listDoctors();
        MG.listDoctors();
    }
}
