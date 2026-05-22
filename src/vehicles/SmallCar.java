package vehicles;

import java.util.UUID;

public class SmallCar extends Vehicle {
    private int numberOfSeats;


    public SmallCar(String brand, String model, String licensePlate,
        int minDriverAge, double rentalPricePerDay, boolean available,
        int numberOfSeats, boolean automaticTransmission) {
        super(brand, model, licensePlate, minDriverAge, rentalPricePerDay, available);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", numberOfSeats=" + numberOfSeats;
    }
}
