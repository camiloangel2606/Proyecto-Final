import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatientManager {
    private static final String CSV_FILE_PATH = "data/Patients.csv";

    // Método para cargar la información de los pacientes desde un archivo CSV
    public static void loadInfo() {
        List<Patient> patients = new ArrayList<>();
        try {
            readFromFile(CSV_FILE_PATH, patients);
            for (Patient patient : patients) {
                // Aquí puedes hacer lo que necesites con cada paciente, como agregarlo a una
                // lista de pacientes
                System.out.println(patient); // Por ejemplo, imprimir cada paciente
            }
            System.out.println("Información de pacientes cargada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al intentar leer el archivo: " + e.getMessage());
        }
    }

    // Método para guardar la información de los pacientes en un archivo CSV
    public static void saveInfo(List<Patient> patients) {
        try {
            writeToFile(CSV_FILE_PATH, patients);
            System.out.println("Información de pacientes guardada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al intentar guardar el archivo: " + e.getMessage());
        }
    }

    // Método para escribir la información de los pacientes en un archivo CSV
    private static void writeToFile(String filePath, List<Patient> patients) throws IOException {
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

    // Método para leer la información de los pacientes desde un archivo CSV
    private static void readFromFile(String filePath, List<Patient> patients) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int PatientId = Integer.parseInt(parts[0]);
                String FullName = parts[1];
                int Age = Integer.parseInt(parts[2]);
                float Weight = Float.parseFloat(parts[3]);
                float Height = Float.parseFloat(parts[4]);
                String[] PreexistingConditions = parts[5].split(";");
                List<String> preexistingConditionsList = Arrays.asList(PreexistingConditions);
                Patient patient = new Patient(PatientId, FullName, Age, Weight, Height, preexistingConditionsList);
                patients.add(patient);
            }
        }
    }
}
