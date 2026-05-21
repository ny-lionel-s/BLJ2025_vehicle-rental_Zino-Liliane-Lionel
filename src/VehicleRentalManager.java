import vehicles.Vehicle;
import vehicles.Car;
import vehicles.Camper;
import vehicles.Trailer;
import vehicles.Truck;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class    VehicleRentalManager {
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

    void addPersonToDenylist(Person p) {
        denyList.add(p);
    }

    void createContract(LocalDate startingDate, LocalDate endingDate, Person person, Vehicle vehicle) {
        try {
            contracts.add(new Contract(startingDate,endingDate,person,vehicle));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    void createPerson(String firstName, String lastName, LocalDate birthYear) {
        customerList.add(new Person(firstName, lastName, birthYear));
    }

    void createCamper(String brand, String model, String licensePlate, int minDriverAge, double rentalPricePerDay, boolean available, int sleepingPlaces, boolean hasKitchen) {
        vehicles.add(new Camper(brand,model,licensePlate,minDriverAge,rentalPricePerDay,available,sleepingPlaces,hasKitchen));
    }

    void createCar(String brand, String model, String licensePlate, int minDriverAge, double rentalPricePerDay, boolean available, int numberOfSeats, boolean automaticTransmission) {
        vehicles.add(new Car(brand,model,licensePlate,minDriverAge,rentalPricePerDay,available,numberOfSeats,automaticTransmission));
    }

    void createTrailer(String brand, String model, String licensePlate, int minDriverAge, double rentalPricePerDay, boolean available, String trailerType, double maxLoadKg) {
        vehicles.add(new Trailer(brand,model,licensePlate,minDriverAge,rentalPricePerDay,available,trailerType,maxLoadKg));
    }

    void createTruck(String brand, String model, String licensePlate, int minDriverAge, double rentalPricePerDay, boolean available, double maxLoadKg) {
        vehicles.add(new Truck(brand,model,licensePlate,minDriverAge,rentalPricePerDay,available,maxLoadKg));
    }


    void printCustomerList() {
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println(formatPerson(customerList.get(i)));
        }
    }

    void printVehicles() {
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(formatVehicle(vehicles.get(i)));
        }
    }

    void printContractList() {
        for (int i = 0; i < contracts.size(); i++) {
            System.out.println(formatContract(contracts.get(i)));
        }
    }

    private String formatPerson(Person person) {
        return person.getPersonId() + " | " +
                person.getLastName() + " | " +
                person.getFirstName() + " | " +
                person.getBirthYear();
    }

    private String formatVehicle(Vehicle vehicle) {
        String vehicleStats = vehicle.getVehicleId() + " | " +
                vehicle.getClass().getSimpleName() + " | " +
                vehicle.getBrand() + " | " +
                vehicle.getModel() + " | " +
                vehicle.getLicensePlate() + " | " +
                vehicle.getMinDriverAge() + " | " +
                vehicle.getRentalPricePerDay() + " | " +
                vehicle.isAvailable();

        if (vehicle instanceof Car) {
            Car car = (Car) vehicle;
            return vehicleStats + " | " + car.getNumberOfSeats();
        } else if (vehicle instanceof Camper) {
            Camper camper = (Camper) vehicle;
            return vehicleStats + " | " + camper.getSleepingPlaces() + " | " + camper.isHasKitchen();
        } else if (vehicle instanceof Trailer) {
            Trailer trailer = (Trailer) vehicle;
            return vehicleStats + " | " + trailer.getTrailerType() + " | " + trailer.getMaxLoadKg();
        } else if (vehicle instanceof Truck) {
            Truck truck = (Truck) vehicle;
            return vehicleStats + " | " + truck.getMaxLoadKg();
        }

        return vehicleStats;
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
