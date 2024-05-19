import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Patient.addPatient(1, "John Doe", 30, 70.5f, 180.2f, new String[] { "Diabetes", "Hypertension" });
        Patient.addPatient(2, "Jane Smith", 25, 60.0f, 170.5f, new String[] { "Asthma" });
        Patient.printPatientList();

        // Menú:
        System.out.println("Bienvenido al sistema de Dietas para Pacientes.");
        Scanner scanner = new Scanner(System.in);
        int i;
        do {
            System.out.println("Selecciona la función a realizar:");
            System.out.println("(1) Gestión de Pacientes.");
            System.out.println("(2) Gestión de Nutricionistas.");
            System.out.println("(3) Plan de Alimentación.");
            System.out.println("(4) Registros de Comidas.");
            System.out.println("(0) Salir.");
            i = Integer.parseInt(scanner.nextLine()); // Leemos el valor para saber la función.

            if (i == 1) { // Agregar, actualizar y eliminar información de pacientes.
                int j;
                do {
                    System.out.println("Ingresa la función a realizar:");
                    System.out.println("(1) Registrar un paciente nuevo.");
                    System.out.println("(2) Actualizar información de un paciente.");
                    System.out.println("(3) Eliminar la información de un paciente.");
                    System.out.println("(0) Regresar al menú principal.");
                    j = Integer.parseInt(scanner.nextLine()); // Leemos el valor para saber la función.

                    if (j == 1) {
                        System.out.println("Escribe el id del paciente.");
                        int patientId = Integer.parseInt(scanner.nextLine());
                        System.out.println("Escribe el nombre completo del paciente.");
                        String fullName = scanner.nextLine();
                        System.out.println("Escribe la edad del paciente.");
                        int age = Integer.parseInt(scanner.nextLine());
                        System.out.println("Escribe el peso del paciente.");
                        float weight = Float.parseFloat(scanner.nextLine());
                        System.out.println("Escribe la altura del paciente.");
                        float height = Float.parseFloat(scanner.nextLine());
                        System.out.println("Escribe las condiciones preexistentes separándolas con ','");
                        String preexistingConditions = scanner.nextLine();

                        // Divide la entrada en partes individuales usando el delimitador ","
                        String[] preexistingConditionsArray = preexistingConditions.split(",");

                        // Elimina los espacios en blanco alrededor de cada condición
                        for (int k = 0; k < preexistingConditionsArray.length; k++) {
                            preexistingConditionsArray[k] = preexistingConditionsArray[k].trim();
                        }

                        Patient.addPatient(patientId, fullName, age, weight, height, preexistingConditionsArray);

                    } else if (j == 2) {
                        System.out.println("Escribe el id del paciente a actualizar.");
                        int patientId = Integer.parseInt(scanner.nextLine());
                        System.out.println("Escribe el nuevo nombre completo del paciente.");
                        String fullName = scanner.nextLine();
                        System.out.println("Escribe el año de nacimiento del paciente.");
                        int age = Integer.parseInt(scanner.nextLine());
                        System.out.println("Escribe el nuevo peso del paciente.");
                        float weight = Float.parseFloat(scanner.nextLine());
                        System.out.println("Escribe la nueva altura del paciente.");
                        float height = Float.parseFloat(scanner.nextLine());
                        System.out.println("Escribe las nuevas condiciones preexistentes separándolas con ','");
                        String preexistingConditions = scanner.nextLine();

                        // Divide la entrada en partes individuales usando el delimitador ","
                        String[] preexistingConditionsArray = preexistingConditions.split(",");

                        // Elimina los espacios en blanco alrededor de cada condición
                        for (int k = 0; k < preexistingConditionsArray.length; k++) {
                            preexistingConditionsArray[k] = preexistingConditionsArray[k].trim();
                        }

                        Patient.updatePatient(patientId, fullName, age, weight, height, preexistingConditionsArray);

                    } else if (j == 3) {
                        System.out.println("Escribe el id del paciente a eliminar.");
                        int patientId = Integer.parseInt(scanner.nextLine());
                        Patient.removePatient(patientId);
                    }
                } while (j != 0);
            } else if (i == 2) { // Registro y gestión de nutricionistas.
                // Lógica para gestión de nutricionistas.
            }
        } while (i != 0);
        Patient.printPatientList();
        scanner.close();
    }
}
