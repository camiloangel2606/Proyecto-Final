import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVDietitian {
    private static final String CSV_FILE_PATH = "Dietitian.csv";

    public static void loadInfo() {
        List<Dietitian> dietitians = new ArrayList<>();
        try {
            readFromFile(CSV_FILE_PATH, dietitians);
            for (Dietitian dietitian : dietitians) {
                Dietitian.addDietitianToList(dietitian); // Agregar dietista a la lista estática
            }
            System.out.println("Información de dietistas cargada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al intentar leer el archivo: " + e.getMessage());
        }
    }

    public static void saveInfo(List<Dietitian> dietitians) {
        try {
            writeToFile(CSV_FILE_PATH, dietitians);
            System.out.println("Información de dietistas guardada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al intentar guardar el archivo: " + e.getMessage());
        }
    }

    private static void writeToFile(String filePath, List<Dietitian> dietitians) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Dietitian dietitian : dietitians) {
                String line = String.join(",",
                        Integer.toString(dietitian.getPatientId()),
                        dietitian.getFullName(),
                        String.join(";", dietitian.getPreexistingConditions()));
                writer.write(line);
                writer.newLine();
            }
        }
    }

    private static void readFromFile(String filePath, List<Dietitian> dietitians) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int dietitianId = Integer.parseInt(parts[0]);
                String fullName = parts[1];
                String[] preexistingConditions = parts[2].split(";");
                List<String> preexistingConditionsList = Arrays.asList(preexistingConditions);
                Dietitian dietitian = new Dietitian(dietitianId, fullName, preexistingConditionsList);
                dietitians.add(dietitian);
            }
        }
    }
}
