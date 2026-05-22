package vehicles;

import java.util.UUID;

public class Vehicle {
    private UUID vehicleId;
    private String brand;
    private String model;
    private String licensePlate;
    private int minDriverAge;
    private double rentalPricePerDay;
    private boolean available;
    private int maxLeaseDays = 30;

    public Vehicle(String brand, String model, String licensePlate, int minDriverAge, double rentalPricePerDay, boolean available, int maxLeaseDays) {
        this.vehicleId = UUID.randomUUID();
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.minDriverAge = minDriverAge;
        this.rentalPricePerDay = rentalPricePerDay;
        this.available = available;
        this.maxLeaseDays = maxLeaseDays;
    }
    public Vehicle(String brand, String model, String licensePlate, int minDriverAge, double rentalPricePerDay, boolean available) {
        this(brand, model, licensePlate, minDriverAge, rentalPricePerDay, available, 30);
    }



    public int getMaxLeaseDays() {
        return maxLeaseDays;
    }

    public void setMaxLeaseDays(int maxLeaseDays) {
        this.maxLeaseDays = maxLeaseDays;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(UUID vehicleId) {
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
        return getClass().getSimpleName() + "{" + "vehicleId='" + vehicleId + '\'' + ", brand='" + brand + '\'' + ", model='" + model + '\'' + ", licensePlate='" + licensePlate + '\'' + ", minDriverAge=" + minDriverAge + ", rentalPricePerDay=" + rentalPricePerDay + ", available=" + available + '}';
    }


}


