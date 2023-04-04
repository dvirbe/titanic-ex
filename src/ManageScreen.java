import javax.swing.*;
import java.io.File;
import java.util.EventListener;
import java.util.List;

public class ManageScreen extends JPanel implements EventListener {
    private JComboBox<String> classComboBox;
    private JLabel classLabel;

    private JComboBox<String> sexComboBox;
    private JLabel sexLabel;

    private JComboBox<String> embarkedComboBox;
    private JLabel embarkedLabel;


    private JTextField passengerNumberMinField;
    private JLabel passengerNumberMinLabel;

    private JTextField passengerNumberMaxField;
    private JLabel passengerNumberMaxLabel;

    private JTextField sibSpField;
    private JLabel sibSpLabel;

    private JTextField parchField;
    private JLabel parchLabel;

    private JTextField maxFareField;
    private JLabel maxFareLabel;

    private JTextField minFareField;
    private JLabel minFareLabel;

    private JTextField nameField;
    private JLabel nameLabel;

    private JTextField cabinField;
    private JLabel cabinLabel;

    private JTextField ticketNumberField;
    private JLabel ticketNumberLabel;
    private JLabel showAnswerLabel;
    private JButton sortButton;
    private JButton statisticsButton;



    public ManageScreen(int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE); //this is the path to the data file
        if (file.exists()) {
            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);


            this.classLabel = new JLabel("Passenger Class: ");
            this.classLabel.setBounds(Constants.RELATIVE_WIDTH, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(this.classLabel);

            this.sexLabel = new JLabel("sex: ");
            this.sexLabel.setBounds(classLabel.getX() + Constants.X_SPACE_FROM_LABEL, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(this.sexLabel);

            this.embarkedLabel = new JLabel("embarked");
            this.embarkedLabel.setBounds(sexLabel.getX() + Constants.X_SPACE_FROM_LABEL, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(this.embarkedLabel);

            this.classComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
            this.classComboBox.setBounds(classLabel.getX(), classLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.classComboBox);
//            this.classComboBox.addActionListener((e) -> {
//                sendToSearch();
//            });

            this.sexComboBox = new JComboBox<>(Constants.SEX_OPTIONS);
            this.sexComboBox.setBounds(sexLabel.getX(), sexLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.sexComboBox);
//            this.sexComboBox.addActionListener((e) -> {
//                sendToSearch();
//            });

            this.embarkedComboBox = new JComboBox<>(Constants.EMBARKED_OPTIONS);
            this.embarkedComboBox.setBounds(embarkedLabel.getX(), embarkedLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.embarkedComboBox);
//            this.embarkedComboBox.addActionListener((e) -> {
//                sendToSearch();
//            });

            this.passengerNumberMinLabel = new JLabel("Min Pass Number");
            this.passengerNumberMinLabel.setBounds(Constants.RELATIVE_WIDTH, sexComboBox.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(this.passengerNumberMinLabel);

            this.passengerNumberMaxLabel = new JLabel("Max Pass Number");
            this.passengerNumberMaxLabel.setBounds(this.passengerNumberMinLabel.getX() + Constants.X_SPACE_FROM_LABEL, sexComboBox.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(this.passengerNumberMaxLabel);

            this.passengerNumberMinField = new JTextField();
            this.passengerNumberMinField.setBounds(this.passengerNumberMinLabel.getX(), this.passengerNumberMinLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
            this.add(this.passengerNumberMinField);
//            this.passengerNumberMinField.addActionListener(e -> {
//                sendToSearch();
//            });

            this.passengerNumberMaxField = new JTextField();
            this.passengerNumberMaxField.setBounds(this.passengerNumberMaxLabel.getX(), this.passengerNumberMaxLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
            this.add(this.passengerNumberMaxField);
//            this.passengerNumberMaxField.addActionListener(e -> {
//                sendToSearch();
//            });

            this.sibSpLabel = new JLabel("sib number");
            this.sibSpLabel.setBounds(Constants.RELATIVE_WIDTH, passengerNumberMinField.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(this.sibSpLabel);

            this.parchLabel = new JLabel(" parch Number");
            this.parchLabel.setBounds(this.sibSpLabel.getX() + Constants.X_SPACE_FROM_LABEL, passengerNumberMaxField.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(this.parchLabel);

            this.sibSpField = new JTextField();
            this.sibSpField.setBounds(this.sibSpLabel.getX(), this.sibSpLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
            this.add(this.sibSpField);
//            this.sibSpField.addActionListener(e -> {
//                sendToSearch();
//            });

            this.parchField = new JTextField();
            this.parchField.setBounds(this.parchLabel.getX(), this.parchLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
            this.add(this.parchField);
//            this.parchField.addActionListener(e -> {
//                sendToSearch();
//            });

            this.minFareLabel = new JLabel("fare min");
            this.minFareLabel.setBounds(Constants.RELATIVE_WIDTH, parchField.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(this.minFareLabel);


            this.maxFareLabel = new JLabel(" fare max");
            this.maxFareLabel.setBounds(this.minFareLabel.getX() + Constants.X_SPACE_FROM_LABEL, parchField.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(this.maxFareLabel);

            this.minFareField = new JTextField();
            this.minFareField.setBounds(this.minFareLabel.getX(), this.minFareLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
            this.add(this.minFareField);
//            this.minFareField.addActionListener(e -> {
//                sendToSearch();
//            });

            this.maxFareField = new JTextField();
            this.maxFareField.setBounds(this.maxFareLabel.getX(), this.maxFareLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
            this.add(this.maxFareField);
//            this.maxFareField.addActionListener(e -> {
//                sendToSearch();
//            });

            this.nameLabel = new JLabel("name");
            this.nameLabel.setBounds(Constants.RELATIVE_WIDTH, maxFareField.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(this.nameLabel);


            this.cabinLabel = new JLabel(" cabin");
            this.cabinLabel.setBounds(this.nameLabel.getX() + Constants.X_SPACE_FROM_LABEL, maxFareField.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(this.cabinLabel);

            this.ticketNumberLabel = new JLabel(" ticket number");
            this.ticketNumberLabel.setBounds(this.cabinLabel.getX() + Constants.X_SPACE_FROM_LABEL, maxFareField.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(this.ticketNumberLabel);


            this.nameField = new JTextField();
            this.nameField.setBounds(this.nameLabel.getX(), this.nameLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
            this.add(this.nameField);
//            this.nameField.addActionListener(e -> {
//                sendToSearch();
//            });

            this.cabinField = new JTextField();
            this.cabinField.setBounds(this.cabinLabel.getX(), this.cabinLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
            this.add(this.cabinField);
//            this.cabinField.addActionListener(e -> {
//                sendToSearch();
//            });

            this.ticketNumberField = new JTextField();
            this.ticketNumberField.setBounds(this.ticketNumberLabel.getX(), this.ticketNumberLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
            this.add(this.ticketNumberField);
//            this.ticketNumberField.addActionListener(e -> {
//                sendToSearch();
//            });

            this.sortButton = new JButton("Search");
            this.sortButton.setBounds((Constants.WINDOW_WIDTH-Constants.LABEL_WIDTH)/2,this.ticketNumberField.getY()+Constants.Y_SPACE_FOR_NEW_ROW,Constants.LABEL_WIDTH , Constants.LABEL_HEIGHT);
            this.add(this.sortButton);
            this.sortButton.addActionListener(e -> sendToSearch());

            this.statisticsButton = new JButton("Statistics");
            this.statisticsButton.setBounds((Constants.WINDOW_WIDTH-Constants.LABEL_WIDTH)/2,this.sortButton.getY()+Constants.Y_SPACE_FOR_NEW_ROW,Constants.LABEL_WIDTH , Constants.LABEL_HEIGHT);
            this.add(this.statisticsButton);
            this.statisticsButton.addActionListener(e -> {

            });


            this.showAnswerLabel = new JLabel("");
            this.showAnswerLabel.setBounds((Constants.WINDOW_WIDTH-Constants.ANSWER_LABEL_WIDTH)/2 , this.statisticsButton.getY()+Constants.Y_SPACE_FOR_NEW_ROW, Constants.ANSWER_LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(this.showAnswerLabel);


        }
    }

    private void changeAnswerLabelText(String textInput) {
        showAnswerLabel.setText(textInput);
    }

    private void sendToSearch() {
        try {
            List<Passenger> filteredPassengerList =
                    Passenger.searchAllOptions(
                            this.classComboBox.getSelectedIndex(),
                            this.passengerNumberMinField.getText(),
                            this.passengerNumberMaxField.getText(),
                            this.nameField.getText(),
                            this.sibSpField.getText(),
                            this.parchField.getText(),
                            this.ticketNumberField.getText(),
                            this.embarkedComboBox.getItemAt(this.embarkedComboBox.getSelectedIndex()).charAt(0),
                            this.minFareField.getText(),
                            this.maxFareField.getText(),
                            this.cabinField.getText(),
                            this.sexComboBox.getItemAt(this.sexComboBox.getSelectedIndex())
                    );
            int survived =Passenger.survivedCounter(filteredPassengerList);
            changeAnswerLabelText(filteredPassengerList.size() + " Matches (" + survived +" Survived , " + (filteredPassengerList.size()-survived)+" did not )" );
            if (filteredPassengerList.size()<= 1){
                FileHandler.createFile(filteredPassengerList);
            }
        } catch (NumberFormatException e) {
            changeAnswerLabelText("please enter a valid input!");
        }


    }

}
