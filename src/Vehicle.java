import java.util.UUID;

public abstract class Vehicle {
    private UUID vehicleId;
    private String brand;
    private String model;
    private String licensePlate;
    private int minDriverAge;
    private double rentalPricePerDay;
    private boolean available;

    public Vehicle(UUID vehicleId, String brand, String model, String licensePlate, int minDriverAge, double rentalPricePerDay, boolean available) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.minDriverAge = minDriverAge;
        this.rentalPricePerDay = rentalPricePerDay;
        this.available = available;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getMinDriverAge() {
        return minDriverAge;
    }

    public void setMinDriverAge(int minDriverAge) {
        this.minDriverAge = minDriverAge;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setRentalPricePerDay(double rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "vehicleId='" + vehicleId + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", minDriverAge=" + minDriverAge +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", available=" + available +
                '}';
    }
}
