package domain;

public class Trainee {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String ssn;

    public Trainee(int id, String firstName, String lastName, String phoneNumber, String ssn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
