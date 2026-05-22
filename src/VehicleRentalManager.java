import vehicles.Camper;
import vehicles.LuxuryCar;
import vehicles.Trailer;
import vehicles.Truck;
import vehicles.Vehicle;

import java.time.LocalDate;
import java.util.ArrayList;

public class VehicleRentalManager {
    private final ArrayList<Person> customerList;
    private final ArrayList<Person> denyList;
    private final ArrayList<Vehicle> vehicles;
    private final ArrayList<Contract> contracts;

    public VehicleRentalManager() {
        customerList = new ArrayList<>();
        denyList = new ArrayList<>();
        vehicles = new ArrayList<>();
        contracts = new ArrayList<>();
    }

    void createPerson(String firstName, String lastName, LocalDate birthYear) {
        customerList.add(new Person(firstName, lastName, birthYear));
    }

    void addPersonToCustomerList(Person p) {
        customerList.add(p);
    }

    void removePersonFromCustomerList(Person p) {
        customerList.remove(p);
    }

    void addPersonToDenylist(Person p) {
        p.setDenylisted(true);
        if (!denyList.contains(p)) {
            denyList.add(p);
        }
    }

    void removePersonFromDenylist(Person p) {
        p.setDenylisted(false);
        denyList.remove(p);
    }

    void createCamper(String brand, String model, String licensePlate, int minDriverAge, double rentalPricePerDay, boolean available, int sleepingPlaces, boolean hasKitchen) {
        vehicles.add(new Camper(brand, model, licensePlate, minDriverAge, rentalPricePerDay, available, sleepingPlaces, hasKitchen));
    }

    void createCar(String brand, String model, String licensePlate, int minDriverAge, double rentalPricePerDay, boolean available, int numberOfSeats, boolean automaticTransmission) {
        vehicles.add(new LuxuryCar(brand, model, licensePlate, minDriverAge, rentalPricePerDay, available, numberOfSeats, automaticTransmission));
    }

    void createTrailer(String brand, String model, String licensePlate, int minDriverAge, double rentalPricePerDay, boolean available, String trailerType, double maxLoadKg) {
        vehicles.add(new Trailer(brand, model, licensePlate, minDriverAge, rentalPricePerDay, available, trailerType, maxLoadKg));
    }

    void createTruck(String brand, String model, String licensePlate, int minDriverAge, double rentalPricePerDay, boolean available, double maxLoadKg) {
        vehicles.add(new Truck(brand, model, licensePlate, minDriverAge, rentalPricePerDay, available, maxLoadKg));
    }

    void addVehicleToVehicles(Vehicle v) {
        vehicles.add(v);
    }

    void removeVehicleFromVehicles(Vehicle v) {
        for (Contract c : contracts) {
            if (c.getVehicle().equals(v)) {
                System.out.println("Cannot remove vehicle - it is used in an active contract.");
                return;
            }
        }
        vehicles.remove(v);
    }

    Contract createContract(LocalDate startingDate, LocalDate endingDate, Person person, Vehicle vehicle) throws Exception {
        if (hasLeaseCollision(vehicle, startingDate, endingDate)) {
            throw new Exceptions.LeaseLengthCollisionException("Vehicle is already rented during this period.");
        }
        Contract contract = new Contract(startingDate, endingDate, person, vehicle);
        contracts.add(contract);
        return contract;
    }

    private boolean hasLeaseCollision(Vehicle vehicle, LocalDate start, LocalDate end) {
        for (Contract c : contracts) {
            if (c.getVehicle().equals(vehicle) && c.getStartingDate().isBefore(end) && c.getEndingDate().isAfter(start)) {
                return true;
            }
        }
        return false;
    }

    void removeContract(Contract c) {
        contracts.remove(c);
    }

    void printCustomerList() {
        if (customerList.isEmpty()) {
            System.out.println("No customers registered.");
            return;
        }
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println(i + ": " + formatPerson(customerList.get(i)));
        }
    }

    void printDenyList() {
        if (denyList.isEmpty()) {
            System.out.println("Denylist is empty.");
            return;
        }
        for (int i = 0; i < denyList.size(); i++) {
            System.out.println(i + ": " + formatPerson(denyList.get(i)));
        }
    }

    void printVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles registered.");
            return;
        }
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(i + ": " + formatVehicle(vehicles.get(i)));
        }
    }

    void printContractList() {
        if (contracts.isEmpty()) {
            System.out.println("No contracts registered.");
            return;
        }
        for (int i = 0; i < contracts.size(); i++) {
            System.out.println(i + ": " + formatContract(contracts.get(i)));
        }
    }

    private String formatPerson(Person person) {
        return "ID: " + person.getPersonId() + " | " +
                "Last Name: " + person.getLastName() + " | " +
                "First Name: " + person.getFirstName() + " | " +
                "Birthday: " + person.getBirthYear();
    }

    private String formatVehicle(Vehicle vehicle) {
        String s = vehicle.getVehicleId() + " | " +
                vehicle.getClass().getSimpleName() + " | " +
                vehicle.getBrand() + " | " +
                vehicle.getModel() + " | " +
                vehicle.getLicensePlate() + " | " +
                vehicle.getMinDriverAge() + " | " +
                vehicle.getRentalPricePerDay() + " | " +
                vehicle.isAvailable();

        if (vehicle instanceof LuxuryCar car) return s + " | " + car.getNumberOfSeats();
        if (vehicle instanceof Camper camper) return s + " | " + camper.getSleepingPlaces() + " | " + camper.isHasKitchen();
        if (vehicle instanceof Trailer trailer) return s + " | " + trailer.getTrailerType() + " | " + trailer.getMaxLoadKg();
        if (vehicle instanceof Truck truck) return s + " | " + truck.getMaxLoadKg();

        return s;
    }

    private String formatContract(Contract contract) {
        return contract.getStartingDate() + " | " +
                contract.getEndingDate() + " | " +
                formatPerson(contract.getPerson()) + " | " +
                formatVehicle(contract.getVehicle());
    }

    public ArrayList<Person> getCustomerList() {
        return customerList;
    }

    public ArrayList<Person> getDenyList() {
        return denyList;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public ArrayList<Contract> getContracts() {
        return contracts;
    }
}
