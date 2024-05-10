package ArchivosCSV;

import java.io.FileWriter;
import java.io.IOException;

//Revisar CSV más a fondo.
public class CSVPatient {
    public static void main(String[] args) {
        String patients = "datos.csv"; // Nombre del archivo

        try {
            FileWriter writer = new FileWriter(patients);

            // Escribimos datos del archivo.
            writer.append("Nombre, Apellido,Edad,Sexo, Ciudad\n");// Encabezados
            writer.append("Camilo,Angel,19,M,Mzl\n");// Datos de la primera fila
            writer.append("Juan,Angel,13,M,Cali\n");// Datos de la segunda fila.

            // Cerramos FileWriter
            writer.close();

            System.out.println("Se creó el archivo CSV correctamente.");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
