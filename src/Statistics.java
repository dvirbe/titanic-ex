import java.util.ArrayList;
import java.util.List;

public class Statistics {

    public static void makeStatistics() {
        List<String> statisticsList = new ArrayList<>();
        statisticsByClass(statisticsList);
        statisticsBySex(statisticsList);
        statisticsOfAgeGroup(statisticsList);
        statisticsOfFamilyMembers(statisticsList);
        statisticsOfTicketCost(statisticsList);
        statisticsOfPortEmbarked(statisticsList);
        FileHandler.createStatisticsFile(statisticsList);
    }
    private static float calculateSurvivorsPercents(int totalCount, int survivorsCount) {
        try {
            float percent = (float)survivorsCount * 100 / totalCount;
            int temp = Math.round(percent*100);
            percent = (float)temp/100;
            return  percent;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
    private static void statisticsOfPortEmbarked(List<String> statisticsList) {
        statisticsList.add(Constants.SURVIVORS_BY_PORT);
        for (char port : Constants.EMBARKED_STATISTICS_OPTIONS) {
            statisticsList.add(port + " :  " + portEmbarkingCounter(port) + "%");
        }
    }

    private static void statisticsOfTicketCost(List<String> statisticsList) {
        statisticsList.add(Constants.SURVIVORS_BY_TICKET_COST);
        for (String prices : Constants.TICKET_COST_GROUP_STATISTICS_OPTIONS) {
            String[] ages = (prices.split("-"));
            if (Integer.parseInt(ages[1]) > Constants.FROM_PRICE_PLUS) {
                statisticsList.add("price group " + ages[0] + "+ :  " + ticketCostCounter(Integer.parseInt(ages[0]), Integer.parseInt(ages[1])) + "%");
            } else {
                statisticsList.add("price group " + ages[0] + "-" + ages[1] + " :  " + ticketCostCounter(Integer.parseInt(ages[0]), Integer.parseInt(ages[1])) + "%");
            }
        }
    }

    private static void statisticsOfFamilyMembers(List<String> statisticsList) {
        statisticsList.add(Constants.SURVIVORS_WITH_FAMILY);
        for (boolean withFamily : Constants.FAMILY_STATISTICS_OPTIONS) {
            String temp;
            if (withFamily) {
                temp = "with family members";
            } else {
                temp = "on his own";
            }
            statisticsList.add(temp + " :  " + familyCounter(withFamily) + "%");
        }
    }

    private static void statisticsOfAgeGroup(List<String> statisticsList) {
        statisticsList.add(Constants.SURVIVOR_BY_AGE);
        for (String age : Constants.AGE_GROUP_STATISTICS_OPTIONS) {
            String[] ages = (age.split("-"));
            if (Float.valueOf(ages[1]) > Constants.FROM_AGE_PLUS) {
                statisticsList.add("age group " + ages[0] + "+ :  " + ageRangeCounter(Float.valueOf(ages[0]), Float.valueOf(ages[1])) + "%");
            } else {
                statisticsList.add("age group " + ages[0] + "-" + ages[1] + " :  " + ageRangeCounter(Float.valueOf(ages[0]), Float.valueOf(ages[1])) + "%");
            }
        }
    }

    private static void statisticsBySex(List<String> statisticsList) {
        statisticsList.add("survivors by sex:");
        for (String sex : Constants.SEX_STATISTICS_OPTIONS) {
            statisticsList.add(sex + " :  " + sexCounter(sex) + "%");
        }
    }
    private static float sexCounter(String sex) {
        int totalCount = 0;
        int survivorsCount = 0;
        for (Passenger passenger : Titanic.getPassengersList()) {
            if (Passenger.searchBySex(passenger, sex)) {
                totalCount++;
                if (passenger.getSurvived()) {
                    survivorsCount++;
                }
            }
        }
        return calculateSurvivorsPercents(totalCount, survivorsCount);
    }

    private static void statisticsByClass(List<String> statisticsList) {
        statisticsList.add("survivors by class:");
        for (int pasClass : Constants.CLASS_STATISTICS_OPTIONS) {
            statisticsList.add("class " + pasClass + " :  " + classCounter(pasClass) + "%");
        }
    }

    private static float ageRangeCounter(float minAge, float maxAge) {
        int totalCount = 0;
        int survivorsCount = 0;
        for (Passenger passenger : Titanic.getPassengersList()) {
            if ((passenger.getAge() >= minAge) && (passenger.getAge() <= maxAge)) {
                totalCount++;
                if (passenger.getSurvived()) {
                    survivorsCount++;
                }
            }
        }
        return calculateSurvivorsPercents(totalCount, survivorsCount);
    }

    private static float classCounter(int pClass) {
        int totalCount = 0;
        int survivorsCount = 0;
        for (Passenger passenger : Titanic.getPassengersList()) {
            if (Passenger.searchByClass(passenger,pClass)) {
                totalCount++;
                if (passenger.getSurvived()) {
                    survivorsCount++;
                }
            }
        }
        return calculateSurvivorsPercents(totalCount, survivorsCount);
    }
    private static float familyCounter(boolean familyMember) {
        int totalCount = 0;
        int survivorsCount = 0;
        for (Passenger passenger : Titanic.getPassengersList()) {
            boolean withFamily = passenger.getSibSp() + passenger.getParch() >=1;
            if (withFamily == familyMember) {
                totalCount++;
                if (passenger.getSurvived()) {
                    survivorsCount++;
                }
            }
        }
        return calculateSurvivorsPercents(totalCount, survivorsCount);
    }

    private static float ticketCostCounter(int minFare, int maxFare) {
        int totalCount = 0;
        int survivorsCount = 0;
        for (Passenger passenger : Titanic.getPassengersList()) {
            if (Passenger.searchByFareRange(passenger,String.valueOf(minFare),String.valueOf(maxFare))) {
                totalCount++;
                if (passenger.getSurvived()) {
                    survivorsCount++;
                }
            }
        }
        return calculateSurvivorsPercents(totalCount, survivorsCount);
    }

    private static float portEmbarkingCounter(char embarked) {
        int totalCount = 0;
        int survivorsCount = 0;
        for (Passenger passenger : Titanic.getPassengersList()) {
            if (Passenger.searchByEmbarking(passenger,embarked)) {
                totalCount++;
                if (passenger.getSurvived()) {
                    survivorsCount++;
                }
            }
        }
        return calculateSurvivorsPercents(totalCount, survivorsCount);
    }

}
