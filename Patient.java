public class Patient {
    // Creamos el metodo para guardar la información de los pacientes.
    String PatientId;
    String FullName;
    int Age;
    int Weight;
    int Height;
    String PreexistingConditions;

    // Name, Lastname and Sex (String)
    public String getFullName() {
        return FullName;
    }

    public void setName(String newFullName) {
        FullName = newFullName;
    }

    public String getPreexistingConditions() {
        return PreexistingConditions;
    }

    public void setPreexistingConditions(String newPreexistingConditions) {
        PreexistingConditions = newPreexistingConditions;
    }

    // Age and id (Int)
    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getId() {
        return PatientId;
    }

    public void setId(String newPatientid) {
        PatientId = newPatientid;
    }

    public Patient(String Name, String LastName, int Age, int Weight, int Height, String PreexistingConditions) {
        // Corregimos la asignación de los parámetros a los campos de la clase.
        this.FullName = Name; // Aquí se cambió de FullName a Name
        this.Age = Age;
        this.Weight = Weight;
        this.Height = Height;
        this.PreexistingConditions = PreexistingConditions;
    }

    public String toString() {
        return "Paciente[Name:" + FullName + "Age:" + Age + "Weight:" + Weight + "Height:" + Height
                + "PreexistingConditions:" + PreexistingConditions + "]";
    }
}
