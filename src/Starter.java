public class Starter {
    public static void main(String[] args) {
        VehicleRentalManager manager = new VehicleRentalManager();
        TUI tui = new TUI(manager);
        tui.start();
    }
}
