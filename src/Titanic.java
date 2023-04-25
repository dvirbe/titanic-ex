import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


class Titanic extends JFrame {
   private static List<Passenger> passengersList = new ArrayList<>();
    public static void main(String[] args) {
        new Titanic();
        passengersList = (Passenger.createPassenger(FileHandler.readFile()));
    }
    public static List<Passenger> getPassengersList() {
        return passengersList;
    }
    public Titanic() {
        this.setTitle("Titanic Passengers Data");
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        this.add(new ManageScreen(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.setVisible(true);
    }
}