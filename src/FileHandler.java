import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public static List<String> readFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Constants.PATH_TO_DATA_FILE));
            List<String> passengerData = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                passengerData.add(line);
            }
            passengerData.remove(0);
            bufferedReader.close();
            return passengerData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void createStatisticsFile(List<String> list){
        try {
            File statisticsFile = new File(Constants.PATH_TO_STATISTICS_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(statisticsFile));
            statisticsFile.createNewFile();
            for (String line:list) {
                bufferedWriter.write(line +"\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createFile(List<Passenger> passengerList) {
        int index = isFileExist();
        try {
            File file = new File("src/data/" + index + ".csv");
            file.createNewFile();
            if (file.exists() && file.canWrite()) {
                writeToFile(passengerList, file);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeToFile(List<Passenger> passengerList, File file) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("PassengerId,Survived,PClass,Name,Sex,Age,SibSp,Parch,Ticket,Fare,Cabin,Embarked\n");
            for (Passenger passenger : passengerList
            ) {
                bufferedWriter.write(passenger.toString());
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int isFileExist() {
        int index = 1;
        File file = new File("src/data/" + index + ".csv");
        while (file.exists()) {
            index++;
            file = new File("src/data/" + index + ".csv");
        }
        return index;
    }


}
