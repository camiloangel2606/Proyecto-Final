package Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Helpers.CSVDietitian;
import Models.Dietitian;

public class DietitianService {
    private List<Dietitian> dietitianList = new ArrayList<>();

    public DietitianService() {
        loadInfo();
    }

    // ELIMINAR
    // Agregar el método addDietitianList
    public void addDietitianList(List<Dietitian> dietitians) {
        dietitianList.addAll(dietitians);
        CSVDietitian.saveInfo(dietitianList);
    }
    // ELIMINAR

    public void addDietitian(int dietitianId, String fullName, String[] preexistingConditions) {
        List<String> preexistingConditionsList = Arrays.asList(preexistingConditions);
        String capitalizedFullName = Dietitian.capitalizeName(fullName); // Capitalizar el nombre aquí
        Dietitian newDietitian = new Dietitian(dietitianId, capitalizedFullName, preexistingConditionsList);
        if (!dietitianList.contains(newDietitian)) {
            dietitianList.add(newDietitian);
            CSVDietitian.saveInfo(dietitianList);

            System.out.println("Se agregó correctamente al nutricionista " + capitalizedFullName + ".");
        } else {
            System.out.println("El Nutricionista " + capitalizedFullName + " ya se encuentra agregado.");
        }
    }

    public void printDietitianList() {
        for (Dietitian dietitian : dietitianList) {
            System.out.println(dietitian);
        }
    }

    private void loadInfo() {
        // Cargar información de los dietistas desde el archivo CSV
    }
}