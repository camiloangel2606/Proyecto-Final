package Helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVDietPlan {
    
    //Desayuno
    // Lee el archivo "cheeses_and_substitutes.csv" y devuelve una lista de opciones de quesos y sustitutos
public static List<String[]> readCheesesAndSubstitutes() throws IOException {
    List<String[]> options = new ArrayList<>();
    // Usa un bloque try-with-resources para asegurarse de que el recurso se cierre correctamente
    try (BufferedReader br = new BufferedReader(new FileReader("cheeses_and_substitutes.csv"))) {
        // Lee cada línea del archivo
        String line;
        while ((line = br.readLine()) != null) {
            // Divide la línea en columnas usando la coma como delimitador
            String[] columns = line.split(",");
            // Agrega la matriz de columnas a la lista de opciones
            options.add(columns);
        }
    }
    // Devuelve la lista de opciones
    return options;
}

// Lee el archivo "flours_cereals_and_derivados.csv" y devuelve una lista de opciones de harinas, cereales y derivados
public static List<String[]> readFloursCerealsAndDerivados() throws IOException {
    List<String[]> options = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("flours_cereals_and_derivados.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] columns = line.split(",");
            options.add(columns);
        }
    }
    return options;
}

// Lee el archivo "fruits.csv" y devuelve una lista de opciones de frutas
public static List<String[]> readFruits() throws IOException {
    List<String[]> options = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("fruits.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] columns = line.split(",");
            options.add(columns);
        }
    }
    return options;
}

// Lee el archivo "fats.csv" y devuelve una lista de opciones de grasas
public static List<String[]> readFats() throws IOException {
    List<String[]> options = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("fats.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] columns = line.split(",");
            options.add(columns);
        }
    }
    return options;
}

//Almuerzo

public static List<String[]> readLeguminosas() throws IOException {
    List<String[]> options = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("leguminosas.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] columns = line.split(",");
            options.add(columns);
        }
    }
    return options;
}

public static List<String[]> readLeanMeats() throws IOException {
    List<String[]> options = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("lean_meats.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] columns = line.split(",");
            options.add(columns);
        }
    }
    return options;
}

public static List<String[]> readVegetables() throws IOException {
    List<String[]> options = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("vegetables.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] columns = line.split(",");
            options.add(columns);
        }
    }
    return options;
}

public static List<String[]> readNutsAndSeeds() throws IOException {
    List<String[]> options = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("nuts_and_seeds.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] columns = line.split(",");
            options.add(columns);
        }
    }
    return options;
}

}
