import vehicles.Vehicle;
import vehicles.LuxuryCar;
import vehicles.Camper;
import vehicles.Trailer;
import vehicles.Truck;
import vehicles.SmallCar;
import Exceptions.DenylistedPersonException;
import Exceptions.LeaseLengthCollisionException;
import Exceptions.MinorAgeException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class TUI {
    private final VehicleRentalManager manager;
    private final Scanner scanner;

    public TUI(VehicleRentalManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Vehicle Rental System ===");
        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Manage People");
            System.out.println("2. Manage Vehicles");
            System.out.println("3. Manage Contracts");
            System.out.println("4. Manage Denylist");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            switch (scanner.nextLine().trim()) {
                case "1" -> personMenu();
                case "2" -> vehicleMenu();
                case "3" -> contractMenu();
                case "4" -> denylistMenu();
                case "0" -> { System.out.println("Goodbye!"); running = false; }
                default  -> System.out.println("Invalid input.");
            }
        }
    }

    private void personMenu() {
        System.out.println("\n--- Person Menu ---");
        System.out.println("1. Add Person");
        System.out.println("2. List all People");
        System.out.println("3. Remove Person");
        System.out.print("Choice: ");
        switch (scanner.nextLine().trim()) {
            case "1" -> addPerson();
            case "2" -> manager.printCustomerList();
            case "3" -> removePerson();
            default  -> System.out.println("Invalid input.");
        }
    }

    private void addPerson() {
        System.out.print("First name: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine().trim();
        LocalDate birth = promptDate("Birth date (YYYY-MM-DD): ");
        if (birth == null) return;
        Person p = new Person(firstName, lastName, birth);
        manager.addPersonToCustomerList(p);
        System.out.println("Person added: " + p);
    }

    private void removePerson() {
        manager.printCustomerList();
        ArrayList<Person> list = manager.getCustomerList();
        if (list.isEmpty()) return;
        System.out.print("Select index: ");
        try {
            Person p = list.get(Integer.parseInt(scanner.nextLine().trim()));
            manager.removePersonFromCustomerList(p);
            System.out.println("Removed: " + p);
        } catch (Exception e) {
            System.out.println("Invalid index.");
        }
    }

    private void vehicleMenu() {
        System.out.println("\n--- Vehicle Menu ---");
        System.out.println("1. Add Luxury Car");
        System.out.println("2. Add Camper");
        System.out.println("3. Add Trailer");
        System.out.println("4. Add Truck");
        System.out.println("5. Add Small Car");

        System.out.println("6. List all Vehicles");
        System.out.println("7. Remove Vehicle");
        System.out.print("Choice: ");
        switch (scanner.nextLine().trim()) {
            case "1" -> addLuxuryCar();
            case "2" -> addCamper();
            case "3" -> addTrailer();
            case "4" -> addTruck();
            case "5" -> addSmallCar();
            case "6" -> manager.printVehicles();
            case "7" -> removeVehicle();
            default  -> System.out.println("Invalid input.");
        }
    }

    private void addLuxuryCar() {
        String[] base = promptBaseVehicle();
        if (base == null) return;
        System.out.print("Number of seats: ");
        int seats = parseInt(scanner.nextLine().trim(), 5);
        System.out.print("Automatic transmission? (true/false): ");
        boolean automatic = Boolean.parseBoolean(scanner.nextLine().trim());
        LuxuryCar car = new LuxuryCar(base[0], base[1], base[2],
                parseInt(base[3], 18), parseDouble(base[4], 50.0),
                true, seats, automatic);
        car.setMaxLeaseDays(parseInt(base[5], 30));
        manager.addVehicleToVehicles(car);
        System.out.println("Car added: " + car);
    }

    private void addCamper() {
        String[] base = promptBaseVehicle();
        if (base == null) return;
        System.out.print("Sleeping places: ");
        int sleeping = parseInt(scanner.nextLine().trim(), 2);
        System.out.print("Has kitchen? (true/false): ");
        boolean kitchen = Boolean.parseBoolean(scanner.nextLine().trim());
        Camper camper = new Camper(base[0], base[1], base[2],
                parseInt(base[3], 18), parseDouble(base[4], 80.0),
                true, sleeping, kitchen);
        camper.setMaxLeaseDays(parseInt(base[5], 30));
        manager.addVehicleToVehicles(camper);
        System.out.println("Camper added: " + camper);
    }

    private void addTrailer() {
        String[] base = promptBaseVehicle();
        if (base == null) return;
        System.out.print("Trailer type: ");
        String type = scanner.nextLine().trim();
        System.out.print("Max load (kg): ");
        double maxLoad = parseDouble(scanner.nextLine().trim(), 1000.0);
        Trailer trailer = new Trailer(base[0], base[1], base[2],
                parseInt(base[3], 18), parseDouble(base[4], 30.0),
                true, type, maxLoad);
        trailer.setMaxLeaseDays(parseInt(base[5], 30));
        manager.addVehicleToVehicles(trailer);
        System.out.println("Trailer added: " + trailer);
    }

    private void addTruck() {
        String[] base = promptBaseVehicle();
        if (base == null) return;
        System.out.print("Max load (kg): ");
        double maxLoad = parseDouble(scanner.nextLine().trim(), 5000.0);
        Truck truck = new Truck(base[0], base[1], base[2],
                parseInt(base[3], 21), parseDouble(base[4], 120.0),
                true, maxLoad);
        truck.setMaxLeaseDays(parseInt(base[5], 30));
        manager.addVehicleToVehicles(truck);
        System.out.println("Truck added: " + truck);
    }

    private void addSmallCar() {
        String[] base = promptBaseVehicle();
        if (base == null) return;
        System.out.print("Number of seats: ");
        int seats = parseInt(scanner.nextLine().trim(), 4);
        SmallCar car = new SmallCar(base[0], base[1], base[2],
                parseInt(base[3], 21), parseDouble(base[4], 120.0),
                true, seats, false);
        car.setMaxLeaseDays(parseInt(base[5], 30));
        manager.addVehicleToVehicles(car);
        System.out.println("Small car added: " + car);
    }

    private String[] promptBaseVehicle() {
        System.out.print("Brand: ");
        String brand = scanner.nextLine().trim();
        System.out.print("Model: ");
        String model = scanner.nextLine().trim();
        System.out.print("License plate: ");
        String plate = scanner.nextLine().trim();
        System.out.print("Min driver age: ");
        String age = scanner.nextLine().trim();
        System.out.print("Rental price per day: ");
        String price = scanner.nextLine().trim();
        System.out.print("Max lease days: ");
        String maxLeaseDays = scanner.nextLine().trim();
        return new String[]{brand, model, plate, age, price, maxLeaseDays};
    }

    private void removeVehicle() {
        manager.printVehicles();
        ArrayList<Vehicle> list = manager.getVehicles();
        if (list.isEmpty()) return;
        System.out.print("Select index: ");
        try {
            Vehicle v = list.get(Integer.parseInt(scanner.nextLine().trim()));
            manager.removeVehicleFromVehicles(v);
        } catch (Exception e) {
            System.out.println("Invalid index.");
        }
    }

    private void contractMenu() {
        System.out.println("\n--- Contract Menu ---");
        System.out.println("1. Create Contract");
        System.out.println("2. List all Contracts");
        System.out.println("3. Remove Contract");
        System.out.print("Choice: ");
        switch (scanner.nextLine().trim()) {
            case "1" -> createContract();
            case "2" -> manager.printContractList();
            case "3" -> removeContract();
            default  -> System.out.println("Invalid input.");
        }
    }

    private void createContract() {
        manager.printCustomerList();
        ArrayList<Person> persons = manager.getCustomerList();
        if (persons.isEmpty()) { System.out.println("No person available."); return; }
        System.out.print("Select person index: ");
        Person person;
        try {
            person = persons.get(Integer.parseInt(scanner.nextLine().trim()));
        } catch (Exception e) { System.out.println("Invalid index."); return; }

        manager.printVehicles();
        ArrayList<Vehicle> vehicleList = manager.getVehicles();
        if (vehicleList.isEmpty()) { System.out.println("No vehicles available."); return; }
        System.out.print("Select vehicle index: ");
        Vehicle vehicle;
        try {
            vehicle = vehicleList.get(Integer.parseInt(scanner.nextLine().trim()));
        } catch (Exception e) { System.out.println("Invalid index."); return; }

        LocalDate start = promptDate("Start date (YYYY-MM-DD): ");
        if (start == null) return;
        LocalDate end = promptDate("End date (YYYY-MM-DD): ");
        if (end == null) return;

        try {
            Contract contract = manager.createContract(start, end, person, vehicle);
            System.out.println("Contract created: " + contract);
        } catch (MinorAgeException e) {
            System.out.println("ERROR - Minor Age: " + e.getMessage());
        } catch (LeaseLengthCollisionException e) {
            System.out.println("ERROR - Lease Collision: " + e.getMessage());
        } catch (DenylistedPersonException e) {
            System.out.println("ERROR - Denylisted Person: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void removeContract() {
        manager.printContractList();
        ArrayList<Contract> list = manager.getContracts();
        if (list.isEmpty()) return;
        System.out.print("Select index: ");
        try {
            Contract c = list.get(Integer.parseInt(scanner.nextLine().trim()));
            manager.removeContract(c);
            System.out.println("Contract removed.");
        } catch (Exception e) {
            System.out.println("Invalid index.");
        }
    }

    private void denylistMenu() {
        System.out.println("\n--- Denylist Menu ---");
        System.out.println("1. Add Person to Denylist");
        System.out.println("2. Remove Person from Denylist");
        System.out.println("3. Show Denylist");
        System.out.print("Choice: ");
        switch (scanner.nextLine().trim()) {
            case "1" -> addToDenylist();
            case "2" -> removeFromDenylist();
            case "3" -> manager.printDenyList();
            default  -> System.out.println("Invalid input.");
        }
    }

    private void addToDenylist() {
        manager.printCustomerList();
        ArrayList<Person> list = manager.getCustomerList();
        if (list.isEmpty()) return;
        System.out.print("Select index of person: ");
        try {
            Person p = list.get(Integer.parseInt(scanner.nextLine().trim()));
            manager.addPersonToDenylist(p);
            System.out.println(p.getFirstName() + " added to denylist.");
        } catch (Exception e) {
            System.out.println("Invalid index.");
        }
    }

    private void removeFromDenylist() {
        manager.printDenyList();
        ArrayList<Person> list = manager.getDenyList();
        if (list.isEmpty()) return;
        System.out.print("Select index: ");
        try {
            Person p = list.get(Integer.parseInt(scanner.nextLine().trim()));
            manager.removePersonFromDenylist(p);
            System.out.println(p.getFirstName() + " removed from denylist.");
        } catch (Exception e) {
            System.out.println("Invalid index.");
        }
    }

    private LocalDate promptDate(String prompt) {
        System.out.print(prompt);
        try {
            return LocalDate.parse(scanner.nextLine().trim());
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date. Use YYYY-MM-DD.");
            return null;
        }
    }

    private int parseInt(String input, int fallback) {
        try { return Integer.parseInt(input); }
        catch (NumberFormatException e) { return fallback; }
    }

    private double parseDouble(String input, double fallback) {
        try { return Double.parseDouble(input); }
        catch (NumberFormatException e) { return fallback; }
    }


}
