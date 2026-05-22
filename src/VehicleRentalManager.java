import vehicles.Camper;
import vehicles.LuxuryCar;
import vehicles.Trailer;
import vehicles.Truck;
import vehicles.Vehicle;
import vehicles.SmallCar;

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

        customerList.add(new Person("Luca", "Meier", LocalDate.of(1998, 5, 14)));
        customerList.add(new Person("Sofia", "Keller", LocalDate.of(2001, 11, 2)));
        customerList.add(new Person("Noah", "Brunner", LocalDate.of(1995, 8, 21)));
        customerList.add(new Person("Emma", "Fischer", LocalDate.of(2003, 3, 9)));
        customerList.add(new Person("Leon", "Weber", LocalDate.of(1999, 12, 30)));
        customerList.add(new Person("Mia", "Baumann", LocalDate.of(2000, 7, 17)));

        vehicles.add(new Camper("Hymer", "Hymermobil", "ZH1001", 21, 220.0, true, 4, true));
        vehicles.add(new Camper("VW", "California", "ZH1002", 21, 180.0, true, 4, true));

        vehicles.add(new SmallCar("Opel", "Corsa", "ZH1101", 18, 70.0, true, 5, true));
        vehicles.add(new SmallCar("Fiat", "500", "ZH1102", 18, 65.0, true, 4, true));
        vehicles.add(new SmallCar("Hyundai", "i10", "ZH1103", 18, 68.0, true, 5, true));
        vehicles.add(new SmallCar("Suzuki", "Swift", "ZH1104", 18, 72.0, true, 5, true));

        vehicles.add(new LuxuryCar("Mercedes", "S-Klasse", "ZH2001", 25, 250.0, true, 5, true));
        vehicles.add(new LuxuryCar("BMW", "Z4 Cabriolet", "ZH2002", 25, 210.0, true, 2, true));
        vehicles.add(new LuxuryCar("Mazda", "MX5 Cabriolet", "ZH2003", 23, 160.0, true, 2, true));
        vehicles.add(new LuxuryCar("BMW", "i8", "ZH2004", 25, 280.0, true, 2, true));

        vehicles.add(new Truck("Mercedes", "Vito", "ZH3001", 21, 140.0, true, 1200.0));
        vehicles.add(new Truck("VW", "Crafter", "ZH3002", 21, 150.0, true, 1400.0));
        vehicles.add(new Truck("Iveco", "Daily", "ZH3003", 21, 160.0, true, 1800.0));
        vehicles.add(new Truck("Opel", "Combo E", "ZH3004", 21, 130.0, true, 800.0));
        vehicles.add(new Truck("VW", "e-Crafter", "ZH3005", 21, 170.0, true, 1300.0));

        vehicles.add(new Trailer("Böckmann", "Hochlader", "ZH4001", 18, 60.0, true, "Heissluftballon", 2000.0));
        vehicles.add(new Trailer("Böckmann", "Bootsanhänger", "ZH4002", 18, 55.0, true, "Boot", 1800.0));
        vehicles.add(new Trailer("Böckmann", "Tieflader", "ZH4003", 18, 45.0, true, "Velos", 750.0));



    }
    void addPersonToCustomerList(Person p) {
        customerList.add(p);    }


    void removePersonFromCustomerList(Person p) {
        customerList.remove(p);    }


    void addPersonToDenylist(Person p) {
        p.setDenylisted(true);
        if (!denyList.contains(p)) {
            denyList.add(p);    }

    }

    void removePersonFromDenylist(Person p) {
        p.setDenylisted(false);
        denyList.remove(p);    }


    void addVehicleToVehicles(Vehicle v) {
        vehicles.add(v);    }


    void removeVehicleFromVehicles(Vehicle v) {
        for (Contract c : contracts) {
            if (c.getVehicle().equals(v)) {
                System.out.println("Cannot remove vehicle - it is used in an active contract.");
                return;
            }
        }
        vehicles.remove(v);    }


    Contract createContract(LocalDate startingDate, LocalDate endingDate, Person person, Vehicle vehicle) throws Exception {
        if (hasLeaseCollision(vehicle, startingDate, endingDate)) {
            throw new Exceptions.LeaseLengthCollisionException("Vehicle is already rented during this period.");    }

        Contract contract = new Contract(startingDate, endingDate, person, vehicle);
        contracts.add(contract);
        return contract;
    }

    private boolean hasLeaseCollision(Vehicle vehicle, LocalDate start, LocalDate end) {
        for (Contract c : contracts) {
            if (c.getVehicle().equals(vehicle)
                    && c.getStartingDate().isBefore(end)
                    && c.getEndingDate().isAfter(start)) {
                return true;
            }
        }
        return false;
    }

    void removeContract(Contract c) {
        contracts.remove(c);    }


    void printCustomerList() {
        if (customerList.isEmpty()) {
            System.out.println("No customers registered.");
            return;
        }
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println(i + ": " + formatPerson(customerList.get(i)));    }

    }

    void printDenyList() {
        if (denyList.isEmpty()) {
            System.out.println("Denylist is empty.");
            return;
        }
        for (int i = 0; i < denyList.size(); i++) {
            System.out.println(i + ": " + formatPerson(denyList.get(i)));    }

    }

    void printVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles registered.");
            return;
        }
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(i + ": " + formatVehicle(vehicles.get(i)));    }

    }

    void printContractList() {
        if (contracts.isEmpty()) {
            System.out.println("No contracts registered.");
            return;
        }
        for (int i = 0; i < contracts.size(); i++) {
            System.out.println(i + ": " + formatContract(contracts.get(i)));    }

    }

    private String formatPerson(Person person) {
        return "ID: " + person.getPersonId() + " | " +
                "Last Name: " + person.getLastName() + " | " +
                "First Name: " + person.getFirstName() + " | " +
                "Birthday: " + person.getBirthYear();    }


    private String formatVehicle(Vehicle vehicle) {
        String s = "ID: " + vehicle.getVehicleId() + " | " +
                "Name: " + vehicle.getClass().getSimpleName() + " | " +
                "Brand: " + vehicle.getBrand() + " | " +
                "Model: " + vehicle.getModel() + " | " +
                "License Plate: " + vehicle.getLicensePlate() + " | " +
                "Driver Age: " + vehicle.getMinDriverAge() + " | " +
                "Price: " + vehicle.getRentalPricePerDay() + " | " +
                "Availability: " + vehicle.isAvailable();

        if (vehicle instanceof LuxuryCar car) return s + " | " + "Seats: " + car.getNumberOfSeats();
        if (vehicle instanceof Camper camper) return s + " | " + "Sleeping: " + camper.getSleepingPlaces() + " | " + "has kitchen: " + camper.isHasKitchen();
        if (vehicle instanceof Trailer trailer) return s + " | " + "Type: " + trailer.getTrailerType() + " | " + "Load: " +trailer.getMaxLoadKg();
        if (vehicle instanceof Truck truck) return s + " | " + "Load: " + truck.getMaxLoadKg();

        return s;
    }

    private String formatContract(Contract contract) {
        return "Start: " + contract.getStartingDate() + " | " +
                "End: " + contract.getEndingDate() + " | " +
                "Person: " + formatPerson(contract.getPerson()) + " | " +
                "Vehicle: " + formatVehicle(contract.getVehicle());    }


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
