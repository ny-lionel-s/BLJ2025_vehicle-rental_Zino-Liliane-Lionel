import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VehicleManager {
    private List<Vehicle> vehicles;

    public VehicleManager() {
        this.vehicles = new ArrayList<>();
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Fahrzeug darf nicht null sein.");
        }
        if (findVehicleById(vehicle.getVehicleId()) != null) {
            throw new IllegalArgumentException("Fahrzeug-ID existiert bereits.");
        }
        vehicles.add(vehicle);
    }

    public Vehicle findVehicleById(String vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }

    public void updateVehicle(String vehicleId, Vehicle updatedVehicle) {
        if (updatedVehicle == null) {
            throw new IllegalArgumentException("Das updatete Fahrzeug darf nicht null sein.");
        }

        Vehicle existingVehicle = findVehicleById(vehicleId);
        if (existingVehicle == null) {
            throw new IllegalArgumentException("Fahrzeug nicht gefunden.");
        }

        existingVehicle.setVehicleId(updatedVehicle.getVehicleId());
        existingVehicle.setBrand(updatedVehicle.getBrand());
        existingVehicle.setModel(updatedVehicle.getModel());
        existingVehicle.setLicensePlate(updatedVehicle.getLicensePlate());
        existingVehicle.setMinDriverAge(updatedVehicle.getMinDriverAge());
        existingVehicle.setRentalPricePerDay(updatedVehicle.getRentalPricePerDay());
        existingVehicle.setAvailable(updatedVehicle.isAvailable());
    }

    public void deleteVehicle(String vehicleId) {
        Iterator<Vehicle> iterator = vehicles.iterator();
        while (iterator.hasNext()) {
            Vehicle vehicle = iterator.next();
            if (vehicle.getVehicleId().equals(vehicleId)) {
                iterator.remove();
                return;
            }
        }
        throw new IllegalArgumentException("Fahrzeug nicht gefunden.");
    }
}