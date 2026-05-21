package vehicles;

public class Car extends Vehicle {
    private int numberOfSeats;

    public Car(String vehicleId, String brand, String model, String licensePlate,
               int minDriverAge, double rentalPricePerDay, boolean available,
               int numberOfSeats, boolean automaticTransmission) {
        super(vehicleId, brand, model, licensePlate, minDriverAge, rentalPricePerDay, available);
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