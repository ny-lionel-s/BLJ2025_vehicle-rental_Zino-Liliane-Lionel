import Exceptions.DenylistedPersonException;
import Exceptions.LeaseLengthCollisionException;
import Exceptions.MinorAgeException;
import vehicles.Vehicle;

import java.time.LocalDate;
import java.time.Period;

public class Contract {
    LocalDate startingDate;
    LocalDate endingDate;
    Person person;
    Vehicle vehicle;


    public Contract(LocalDate startingDate, LocalDate endingDate, Person person, Vehicle vehicle) throws Exception {
        int age = Period.between(person.getBirthYear(), LocalDate.now()).getYears();
        if (isAgeValid(age)) {
            throw new MinorAgeException("You need to be older for this vehicle");
        } else if () {//check lease length
            throw new LeaseLengthCollisionException("You broke the contract length");
        } else if () {//check if person is in denyed list
            throw new DenylistedPersonException("You are on the denyed List");
        } else {
            this.startingDate = startingDate;
            this.endingDate = endingDate;
            this.person = person;
            this.vehicle = vehicle;
        }
    }

    public boolean isAgeValid(int age) {
        return vehicle.getMinDriverAge() < age;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
