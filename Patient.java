import java.util.List;

public class Patient {
    private int PatientId;
    private String FullName;
    private int Age;
    private float Weight;
    private float Height;
    private List<String> preexistingConditions;

    public Patient(int PatientId, String FullName, int Age, float Weight, float Height,
            List<String> preexistingConditions) {
        this.PatientId = PatientId;
        this.FullName = FullName;
        this.Age = Age;
        this.Weight = Weight;
        this.Height = Height;
        this.preexistingConditions = preexistingConditions;
    }

    public int getPatientId() {
        return PatientId;
    }

    public void setPatientId(int PatientId) {
        this.PatientId = PatientId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float Weight) {
        this.Weight = Weight;
    }

    public float getHeight() {
        return Height;
    }

    public void setHeight(float Height) {
        this.Height = Height;
    }

    public List<String> getPreexistingConditions() {
        return preexistingConditions;
    }

    public void setPreexistingConditions(List<String> preexistingConditions) {
        this.preexistingConditions = preexistingConditions;
    }

    @Override
    public String toString() {
        return "Patient[PatientId:" + PatientId + ", FullName:" + FullName + ", Age:" + Age + ", Weight:" + Weight
                + ", Height:" + Height
                + ", PreexistingConditions:" + preexistingConditions + "]";
    }
}
