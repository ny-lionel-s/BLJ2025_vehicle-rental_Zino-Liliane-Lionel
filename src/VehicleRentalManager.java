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


    void addPersonToDenylist(Person p){
        denyList.add(p);
    }

    void createContract(){

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
