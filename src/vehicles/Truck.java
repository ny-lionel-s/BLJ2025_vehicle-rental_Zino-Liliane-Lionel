package vehicles;

import java.util.UUID;

public class Truck extends Vehicle {
    private double maxLoadKg;

    public Truck(String brand, String model, String licensePlate,
                 int minDriverAge, double rentalPricePerDay, boolean available,
                 double maxLoadKg) {
        super(brand, model, licensePlate, minDriverAge, rentalPricePerDay, available);
        this.maxLoadKg = maxLoadKg;
    }

    public double getMaxLoadKg() {
        return maxLoadKg;
    }

    public void setMaxLoadKg(double maxLoadKg) {
        this.maxLoadKg = maxLoadKg;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", maxLoadKg=" + maxLoadKg;
    }
}