package Helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Models.Patient;
import Services.PatientService;

public class CSVPatient {
    private static final String DATA_DIRECTORY = "../Proyecto-Final-jarvyRama/Data/";
    private static final String PATIENTS_CSV_FILE_NAME = "Patients.csv";

    public static void loadInfo() {
        String patientsFilePath = Paths.get(DATA_DIRECTORY, PATIENTS_CSV_FILE_NAME).toString();

        System.out.println("Current directory in CSVPatient.loadInfo(): " + System.getProperty("user.dir"));

        List<Patient> patients = new ArrayList<>();
        try {
            readPatientsFromFile(patientsFilePath, patients);
            for (Patient patient : patients) {
                PatientService.addPatientToList(patient); // Agregar paciente a la lista estática
            }
            System.out.println("Información de pacientes cargada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al intentar leer el archivo de pacientes: " + e.getMessage());
        }
    }

    public static void saveInfo(List<Patient> patients) {
        String patientsFilePath = Paths.get(DATA_DIRECTORY, PATIENTS_CSV_FILE_NAME).toString();

        try {
            writePatientsToFile(patientsFilePath, patients);
            System.out.println("Información de pacientes guardada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al intentar guardar el archivo de pacientes: " + e.getMessage());
        }
    }

    private static void writePatientsToFile(String filePath, List<Patient> patients) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Patient patient : patients) {
                String line = String.join(",", Integer.toString(patient.getPatientId()), patient.getFullName(),
                        Integer.toString(patient.getAge()), Float.toString(patient.getWeight()),
                        Float.toString(patient.getHeight()), String.join(";", patient.getPreexistingConditions()));
                writer.write(line);
                writer.newLine();
            }
        }
    }

    private static void readPatientsFromFile(String filePath, List<Patient> patients) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int patientId = Integer.parseInt(parts[0]);
                String fullName = parts[1];
                int age = Integer.parseInt(parts[2]);
                float weight = Float.parseFloat(parts[3]);
                float height = Float.parseFloat(parts[4]);
                String[] preexistingConditions = parts[5].split(";");
                List<String> preexistingConditionsList = Arrays.asList(preexistingConditions);
                Patient patient = new Patient(patientId, fullName, age, weight, height, preexistingConditionsList);
                patients.add(patient);
            }
        }
    }
}
