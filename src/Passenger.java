import java.util.ArrayList;
import java.util.List;

public class Passenger {
    //private static List<Passenger> passengerList;
    private int passengerID;
    private Boolean survived;
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
            line = checker(line);
            this.passengerID = Integer.parseInt(line[0]);
            this.survived = (Integer.valueOf(line[1]) == 1);
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
            //  this.passengerList = new ArrayList<>();
        } catch (Exception ignored) {
            System.out.println("Something is not working");
        }
    }

    public static int calculateSurvivedPercentageByClass(int pClass) {
        int result = 0;
        for (Passenger passenger : Titanic.getPassengersList()) {
            if (passenger.searchByClass(passenger, pClass)) {
                result++;
            }
        }
        result = (result * 100) / Titanic.getPassengersList().size();
        return result;
    }

    public static int calculateSurvivedPercentageBySex(String sex) {
        int result = 0;
        for (Passenger passenger : Titanic.getPassengersList()) {
            if (passenger.searchBySex(passenger, sex)) {
                result++;
            }
        }
        result = (result * 100) / Titanic.getPassengersList().size();
        return result;
    }

    public static int calculateSurvivedPercentageByUserDefineAgeRange(float age, float maxAge, float minAge) {
        int result = 0;
        for (Passenger passenger : Titanic.getPassengersList()) {
            if (passenger.searchByAge(passenger, age) && passenger.age >= minAge && passenger.age <= maxAge) {
                result++;
            }
        }
        result = (result * 100) / Titanic.getPassengersList().size();
        return result;
    }


    private String getFormattedName(String lastName, String firstName) {
        String[] temp = firstName.split("\\.");
        return temp[1].substring(0, temp[1].length() - 1) + " " + lastName.trim().substring(1, lastName.length());
    }

    @Override
    public String toString() {
        return "{" + passengerID +
                "," + survived +
                ", " + pClass +
                ", " + name +
                ", " + sex +
                ", " + age +
                ", " + sibSp +
                ", " + parch +
                ", " + ticket +
                ", " + fare +
                ", " + cabin +
                ", " + embarked +
                "}\n";
    }

    private String[] checker(String[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].isEmpty() || data[i].isBlank()) {
                data[i] = Constants.UNKNOWN_DATA;
            }
        }
        return data;
    }

    private static boolean searchByAge(Passenger passenger, float age) {
        return passenger.age == age;
    }

    public static List<Passenger> createPassenger(List<String> passengers) {
        List<Passenger> passengerList = new ArrayList<>();
        for (String data : passengers) {
            data = data + " ";
            Passenger passenger = new Passenger(data.split(","));
            passengerList.add(passenger);
        }
        return passengerList;
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
        return (passenger.name.contains(nameToSearch) || nameToSearch.isEmpty());
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
        return passenger.ticket.contains(ticket);
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

    public static boolean searchByRangeOfCabin(Passenger passenger, String cabin) {
        return passenger.cabin.contains(cabin);
    }

    public static boolean searchByEmbarking(Passenger passenger, char embarked) {
        boolean result = false;
        if (embarked == Constants.ALL_EMBARKED_BOX || passenger.embarked == Integer.valueOf(embarked)) {
            result = true;
        }
        return result;
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
                            && searchByRangeOfCabin(passenger, cabin)
                            && searchByEmbarking(passenger, embarked)
                            && searchBySex(passenger, sex)
            ) {

                filteredPassengers.add(passenger);
            }
        }
        return filteredPassengers;
    }
    public String passengerToCsv(){
        return passengerID+","+survived+","+pClass+","+name+","+sex+","+age+","+sibSp+","+parch+","+ticket+","+fare+","+cabin+","+embarked+"\n";
    }
}
