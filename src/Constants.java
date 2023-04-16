public class Constants {
    public static final String PATH_TO_DATA_FILE = "src/data/titanic.csv";
    public static final String PATH_TO_STATISTICS_FILE ="src/data/Statistics.txt";

    public static final int WINDOW_WIDTH = 600;
    public static final int RELATIVE_WIDTH = 100;
    public static final int X_SPACE_FROM_LABEL = 150;
    public static final int Y_SPACE_FROM_LABEL = 30;
    public static final int Y_SPACE_FOR_NEW_ROW = 45;
    public static final int WINDOW_HEIGHT = 700;
    public static final String[] PASSENGER_CLASS_OPTIONS = { "All", "1st", "2nd", "3rd"};
    public static final String[] SEX_OPTIONS = { "All", "Male", "Female"};
    public static final String[] EMBARKED_OPTIONS = { "All", "C", "Q", "S"};
    public static final int MARGIN_FROM_TOP = 10;
    public static final int LABEL_WIDTH = 110;
    public static final int LABEL_HEIGHT = 30;
    public static final int ANSWER_LABEL_WIDTH =250;
    public static final int TEXT_FIELD_WIDTH = 130;
    public static final int TEXT_FIELD_HEIGHT = 30;
    public static final int COMBO_BOX_WIDTH = 80;
    public static final int COMBO_BOX_HEIGHT = 30;
    public  static  final int ALL_CLASS_BOX = 0;
    public  static  final String ALL_SEX_BOX = "All";
    public  static  final char ALL_EMBARKED_BOX = 'A';
    public static final String UNKNOWN_DATA = "-1";

    public static final String[] SEX_STATISTICS_OPTIONS = {"Male", "Female"};
    public static final String[] AGE_GROUP_STATISTICS_OPTIONS ={"0-10","11-20","21-30","31-40","41-50","51-"+Integer.MAX_VALUE};
    public static final int[] CLASS_STATISTICS_OPTIONS = {1,2,3};
    public static final boolean[] FAMILY_STATISTICS_OPTIONS = {false,true};
    public static final char[] EMBARKED_STATISTICS_OPTIONS = {'C','Q' ,'S'};
    public static final String[] TICKET_COST_GROUP_STATISTICS_OPTIONS ={"0-10","11-30","31-"+Integer.MAX_VALUE};
}
