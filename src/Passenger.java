import java.util.ArrayList;
import java.util.List;

public class Passenger {

    private int passengerID;
    private boolean survived;
    private int pClass;
    private String name;
    private String sex;
    private float age;
    private int sibSp;
    private int parch;
    private String ticket;
    private float fare;
    private String cabin;
    private char embarked;

    public Passenger(String[] line) {
        try {
            line = checkData(line);
            this.passengerID = Integer.parseInt(line[0]);
            this.survived = (Integer.parseInt(line[1]) == 1);
            this.pClass = Integer.parseInt(line[2]);
            this.name = getFormattedName(line[3], line[4]);
            this.sex = line[5];
            this.age = Float.valueOf(line[6]);
            this.sibSp = Integer.parseInt(line[7]);
            this.parch = Integer.parseInt(line[8]);
            this.ticket = line[9];
            this.fare = Float.valueOf(line[10]);
            this.cabin = line[11];
            this.embarked = line[12].charAt(0);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Something is not working");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Invalid data");
        }
    }

    private String getFormattedName(String lastName, String firstName) {
        String[] temp = firstName.split("\\.");
        firstName = temp[1];
        temp = firstName.split("\"");
        firstName = temp[0];
        return firstName + " " + lastName.trim().substring(1);
    }

    private String[] checkData(String[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].isEmpty() || data[i].isBlank()) {
                data[i] = Constants.UNKNOWN_DATA;
            }
        }
        return data;
    }

    public static List<Passenger> createPassenger(List<String> passengers) {
        List<Passenger> passengerList = new ArrayList<>();
        for (String data : passengers) {
            try {
                data = data + " ";
                Passenger passenger = new Passenger(data.split(","));
                passengerList.add(passenger);
            } catch (NullPointerException e) {
            }
        }
        return passengerList;
    }

    public boolean getSurvived() {
        return this.survived;
    }


    public int getSibSp() {
        return sibSp;
    }

    public float getAge() {
        return age;
    }

    public int getParch() {
        return parch;
    }

    public static boolean searchBySex(Passenger passenger, String sex) {
        return (passenger.sex.equals(sex.toLowerCase()) || sex.equals(Constants.ALL_SEX_BOX));
    }

    public static boolean searchByClass(Passenger passenger, int classNumber) {
        return (classNumber == Constants.ALL_CLASS_BOX || classNumber == passenger.pClass);
    }

    public static boolean searchByIdNumberRange(Passenger passenger, String minIdNumber, String maxIdNumber) {
        if (minIdNumber.isEmpty()) {
            minIdNumber = "0";
        }
        if (maxIdNumber.isEmpty()) {
            maxIdNumber = Integer.MAX_VALUE + "";
        }
        return (passenger.passengerID >= Integer.valueOf(minIdNumber) && passenger.passengerID <= Integer.valueOf(maxIdNumber));
    }

    public static boolean searchByName(Passenger passenger, String nameToSearch) {
        return (nameToSearch.isEmpty() || passenger.name.contains(nameToSearch));
    }

    public static boolean searchBySibSp(Passenger passenger, String sibSpAmount) {
        boolean result = true;
        if (!sibSpAmount.isEmpty()) {
            result = (passenger.sibSp == Integer.valueOf(sibSpAmount));
        }
        return result;
    }

    public static boolean searchByParch(Passenger passenger, String parch) {
        boolean result = true;
        if (!parch.isEmpty()) {
            result = (passenger.sibSp == Integer.valueOf(parch));
        }
        return result;
    }

    public static boolean searchByTicket(Passenger passenger, String ticket) {
        boolean result = false;
        if (passenger.ticket != null) {
            result = passenger.ticket.contains(ticket);
        }
        return result;
    }

    public static boolean searchByFareRange(Passenger passenger, String minFare, String maxFare) {
        if (minFare.isEmpty()) {
            minFare = "0";
        }
        if (maxFare.isEmpty()) {
            maxFare = Integer.MAX_VALUE + "";
        }
        return passenger.fare >= Integer.valueOf(minFare) && passenger.fare <= Integer.valueOf(maxFare);
    }

    public static boolean searchByCabin(Passenger passenger, String cabin) {
        return passenger.cabin.contains(cabin);
    }

    public static boolean searchByEmbarking(Passenger passenger, char embarked) {
        return embarked == Constants.ALL_EMBARKED_BOX || passenger.embarked == Integer.valueOf(embarked);
    }

    public static int survivedCounter(List<Passenger> passengerList) {
        int count = 0;
        for (Passenger passenger : passengerList) {
            if (passenger.survived) {
                count++;
            }
        }
        return count;
    }

    public static List<Passenger> searchAllOptions(
            int classNumber,
            String minNumber,
            String maxNumber,
            String name,
            String sibSpAmount,
            String parch,
            String ticket,
            char embarked,
            String minFare,
            String maxFare,
            String cabin,
            String sex
    ) {
        List<Passenger> filteredPassengers = new ArrayList<>();
        for (Passenger passenger : Titanic.getPassengersList()) {
            if (
                    searchByClass(passenger, classNumber)
                            && searchByIdNumberRange(passenger, minNumber, maxNumber)
                            && searchByName(passenger, name)
                            && searchBySibSp(passenger, sibSpAmount)
                            && searchByParch(passenger, parch)
                            && searchByTicket(passenger, ticket)
                            && searchByFareRange(passenger, minFare, maxFare)
                            && searchByCabin(passenger, cabin)
                            && searchByEmbarking(passenger, embarked)
                            && searchBySex(passenger, sex)
            ) {

                filteredPassengers.add(passenger);
            }
        }
        return filteredPassengers;
    }

    @Override
    public String toString() {
        return passengerID + "," + survived + "," + pClass + "," + name + "," + sex + "," + age + "," + sibSp + "," + parch + "," + ticket + "," + fare + "," + cabin + "," + embarked + "\n";
    }
}
