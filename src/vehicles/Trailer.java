package vehicles;

import java.util.UUID;

public class Trailer extends Vehicle {
    private String trailerType;
    private double maxLoadKg;

    public Trailer(String brand, String model, String licensePlate,
                   int minDriverAge, double rentalPricePerDay, boolean available,
                   String trailerType, double maxLoadKg) {
        super(brand, model, licensePlate, minDriverAge, rentalPricePerDay, available);
        this.trailerType = trailerType;
        this.maxLoadKg = maxLoadKg;
    }

    public String getTrailerType() {
        return trailerType;
    }

    public void setTrailerType(String trailerType) {
        this.trailerType = trailerType;
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
                ", trailerType='" + trailerType + '\'' +
                ", maxLoadKg=" + maxLoadKg;
    }
}
