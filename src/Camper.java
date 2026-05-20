public class Camper extends Vehicle {
    private int sleepingPlaces;
    private boolean hasKitchen;

    public Camper(String vehicleId, String brand, String model, String licensePlate,
                  int minDriverAge, double rentalPricePerDay, boolean available,
                  int sleepingPlaces, boolean hasKitchen) {
        super(vehicleId, brand, model, licensePlate, minDriverAge, rentalPricePerDay, available);
        this.sleepingPlaces = sleepingPlaces;
        this.hasKitchen = hasKitchen;
    }

    public int getSleepingPlaces() {
        return sleepingPlaces;
    }

    public void setSleepingPlaces(int sleepingPlaces) {
        this.sleepingPlaces = sleepingPlaces;
    }

    public boolean isHasKitchen() {
        return hasKitchen;
    }

    public void setHasKitchen(boolean hasKitchen) {
        this.hasKitchen = hasKitchen;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", sleepingPlaces=" + sleepingPlaces +
                ", hasKitchen=" + hasKitchen;
    }
}
