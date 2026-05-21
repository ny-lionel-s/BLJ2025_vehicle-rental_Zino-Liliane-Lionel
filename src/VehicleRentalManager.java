import vehicles.Vehicle;

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


    void addPersonToDenylist(Person p) {
        denyList.add(p);
    }

    void createContract() {

    }

    void addPersonToCustomerList(Person p) {
        customerList.add(p);
    }

    void addVehicleToVehicles(Vehicle v) {
        vehicles.add(v);
    }

    void printCustomerList() {
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println(customerList.get(i).getLastName());
            System.out.println(customerList.get(i).getFirstName());
            System.out.println(customerList.get(i).getBirthYear());
        }
    }

    void printVehicles() {
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i).getLastName());
            System.out.println(vehicles.get(i).getFirstName());
            System.out.println(vehicles.get(i).getBirthYear());
        }
    }

    void printContractList() {
        for (int i = 0; i < contracts.size(); i++) {
            System.out.println(contracts.get(i).getLastName());
            System.out.println(contracts.get(i).getFirstName());
            System.out.println(contracts.get(i).getBirthYear());
        }
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
