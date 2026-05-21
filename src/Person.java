import java.time.LocalDate;
import java.util.UUID;

public class Person {
    private UUID personId;
    private String firstName;
    private String lastName;
    private LocalDate birthYear;
    private boolean denylisted;

    public Person(UUID personId, String firstName, String lastName, LocalDate birthYear, boolean denylisted) {
        this.personId   = personId;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.birthYear  = birthYear;
        this.denylisted = denylisted;
    }

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(LocalDate birthYear) {
        this.birthYear = birthYear;
    }

    public boolean isDenylisted() {
        return this.denylisted;
    }

    public void setDenylisted(boolean denylisted) {
        this.denylisted = denylisted;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                ", denylisted=" + denylisted +
                '}';
    }
}