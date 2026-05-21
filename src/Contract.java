import Exceptions.DenylistedPersonException;
import Exceptions.LeaseLengthCollisionException;
import Exceptions.MinorAgeException;
import vehicles.Vehicle;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Contract {
    LocalDate startingDate;
    LocalDate endingDate;
    Person person;
    Vehicle vehicle;

    public Contract(LocalDate startingDate, LocalDate endingDate, Person person, Vehicle vehicle) throws Exception {
        int age = Period.between(person.getBirthYear(), LocalDate.now()).getYears();

        if (isUnderage(age)) {
            throw new MinorAgeException("You need to be older for this vehicle");

        } else if (!isLeaseLengthValid(startingDate, endingDate)) {
            throw new LeaseLengthCollisionException("You broke the contract length");

        } else if (person.isDenylisted()) {
            throw new DenylistedPersonException("You are on the denyed List");

        } else {
            this.startingDate = startingDate;
            this.endingDate   = endingDate;
            this.person       = person;
            this.vehicle      = vehicle;
        }
    }

    public boolean isUnderage(int age) {
        return age < vehicle.getMinDriverAge();
    }


    public boolean isLeaseLengthValid(LocalDate startingDate, LocalDate endingDate) {
        if (endingDate.isBefore(startingDate) || endingDate.isEqual(startingDate)) {
            return false;
        }
        long months = ChronoUnit.MONTHS.between(startingDate, endingDate);
        return months <= vehicle.getMaxLeaseMonths();
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