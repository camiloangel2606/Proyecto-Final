package Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import Helpers.CSVPatient;
import Models.DietPlan;
import Models.Meal;
import Models.Patient;

public class PatientService {
    private static List<Patient> patientList = new ArrayList<>();

    public static void addPatient(int patientId, String fullName, int birthYear, float weight, float height,
            String[] preexistingConditions) {
        List<String> preexistingConditionsList = Arrays.asList(preexistingConditions);
        Patient newPatient = new Patient(patientId, fullName, birthYear, weight, height, preexistingConditionsList);
        for (Iterator<Patient> iterator = patientList.iterator(); iterator.hasNext();) {
            Patient patient = iterator.next();
            if (patient.getPatientId() == patientId) {
                System.out.println("El paciente ya se encuentra agregado.");
                return; // Salir del método si el paciente ya está agregado
            }
        }
        patientList.add(newPatient);
        System.out.println("Se agregó correctamente al paciente.");
        CSVPatient.saveInfo(patientList); // Guardamos la lista actualizada en archivos CSV.
    }

    public static void addPatientToList(Patient patient) {
        patientList.add(patient);
    }

    public static void addPatientList(List<Patient> patients) {
        patientList.addAll(patients);
    }

    public static void removePatient(int PatientId) {
        for (Iterator<Patient> iterator = patientList.iterator(); iterator.hasNext();) {
            Patient patient = iterator.next();
            if (patient.getPatientId() == PatientId) {
                iterator.remove(); // Elimina el paciente de la lista
                System.out.println("Paciente eliminado exitosamente.");
                CSVPatient.saveInfo(patientList); // Guardamos la lista actualizada en archivos CSV.
                return; // Salir del método una vez que se elimine el paciente
            }
        }
        System.out.println("No se encontró ningún paciente con el ID especificado.");
    }

    public static void updatePatient(int patientId, String fullName, int birthYear, float weight, float height,
            String[] preexistingConditions) {
        for (Patient patient : patientList) {
            if (patient.getPatientId() == patientId) {
                patient.setFullName(fullName);
                patient.setAge(birthYear);
                patient.setWeight(weight);
                patient.setHeight(height);
                patient.setPreexistingConditions(Arrays.asList(preexistingConditions));
                System.out.println("Se actualizó correctamente la información del paciente.");
                CSVPatient.saveInfo(patientList); // Guardamos la lista actualizada en archivos CSV.
                return; // Salir del método una vez que se actualice el paciente
            }
        }
        System.out.println("No se encontró ningún paciente con el ID especificado.");
    }

    public static Patient getPatientById(int id) {
        for (Patient patient : patientList) {
            if (patient.getPatientId() == id) {
                return patient; // Retorna el paciente si se encuentra
            }
        }
        return null; // Retorna null si no se encuentra el paciente
    }

    public static void addMealToPatient(int patientId, Meal meal) {
        Patient patient = getPatientById(patientId);
        if (patient != null) {
            patient.getMealPlan().add(meal);
            System.out.println("Se agregó correctamente la comida al paciente.");
            CSVPatient.saveInfo(patientList); // Guardamos la lista actualizada en archivos CSV.
        } else {
            System.out.println("No se encontró ningún paciente con el ID especificado.");
        }
    }

    public static void removeMealFromPatient(int patientId, Meal meal) {
        Patient patient = getPatientById(patientId);
        if (patient != null) {
            patient.getMealPlan().remove(meal);
            System.out.println("Se eliminó correctamente la comida del paciente.");
            CSVPatient.saveInfo(patientList); // Guardamos la lista actualizada en archivos CSV.
        } else {
            System.out.println("No se encontró ningún paciente con el ID especificado.");
        }
    }

    public static void updateMealForPatient(int patientId, Meal meal) {
        Patient patient = getPatientById(patientId);
        if (patient != null) {
            patient.getMealPlan().set(patient.getMealPlan().indexOf(meal), meal);
            System.out.println("Se actualizó correctamente la comida del paciente.");
            CSVPatient.saveInfo(patientList); // Guardamos la lista actualizada en archivos CSV.
        } else {
            System.out.println("No se encontró ningún paciente con el ID especificado.");
        }
    }

    public static void addDietPlanToPatient(int patientId, DietPlan dietPlan) {
        Patient patient = getPatientById(patientId);
        if (patient != null) {
            patient.setDietPlan(dietPlan);
            System.out.println("Se agregó correctamente el plan de alimentación al paciente.");
            CSVPatient.saveInfo(patientList); // Guardamos la lista actualizada en archivos CSV.
        } else {
            System.out.println("No se encontró ningún paciente con el ID especificado.");
        }
    }

    public static void removeDietPlanFromPatient(int patientId) {
        Patient patient = getPatientById(patientId);
        if (patient != null) {
            patient.setDietPlan(null);
            System.out.println("Se eliminó correctamente el plan de alimentación del paciente.");
            CSVPatient.saveInfo(patientList); // Guardamos la lista actualizada en archivos CSV.
        } else {
            System.out.println("No se encontró ningún paciente con el ID especificado.");
        }
    }

    public static void updateDietPlanForPatient(int patientId, DietPlan dietPlan) {
        Patient patient = getPatientById(patientId);
        if (patient != null) {
            patient.setDietPlan(dietPlan);
            System.out.println("Se actualizó correctamente el plan de alimentación del paciente.");
            CSVPatient.saveInfo(patientList); // Guardamos la lista actualizada en archivos CSV.
        } else {
            System.out.println("No se encontró ningún paciente con el ID especificado.");
        }
    }

    public static List<Patient> getPatientList() {
        return patientList;
    }
}
