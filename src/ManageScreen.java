import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

public class ManageScreen extends JPanel {
    private JComboBox<String> classComboBox;
    private JComboBox<String> sexComboBox;
    private JComboBox<String> embarkedComboBox;
    private JTextField passengerNumberMinField;
    private JTextField passengerNumberMaxField;
    private JTextField sibSpField;
    private JTextField parchField;
    private JTextField maxFareField;
    private JTextField minFareField;
    private JTextField nameField;
    private JTextField cabinField;
    private JTextField ticketNumberField;
    private JLabel showAnswerLabel;

    public ManageScreen(int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE); //this is the path to the data file
        if (file.exists()) {
            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);


            JLabel classLabel = new JLabel("Passenger Class: ");
            classLabel.setBounds(Constants.RELATIVE_WIDTH, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(classLabel);

            JLabel sexLabel = new JLabel("sex: ");
            sexLabel.setBounds(classLabel.getX() + Constants.X_SPACE_FROM_LABEL, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(sexLabel);

            JLabel embarkedLabel = new JLabel("embarked");
            embarkedLabel.setBounds(sexLabel.getX() + Constants.X_SPACE_FROM_LABEL, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(embarkedLabel);


            this.classComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
            this.classComboBox.setBounds(classLabel.getX(), classLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.classComboBox);


            this.sexComboBox = new JComboBox<>(Constants.SEX_OPTIONS);
            this.sexComboBox.setBounds(sexLabel.getX(), sexLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.sexComboBox);


            this.embarkedComboBox = new JComboBox<>(Constants.EMBARKED_OPTIONS);
            this.embarkedComboBox.setBounds(embarkedLabel.getX(), embarkedLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.embarkedComboBox);


            JLabel passengerNumberMinLabel = new JLabel("Min Pass Number");
            passengerNumberMinLabel.setBounds(Constants.RELATIVE_WIDTH, sexComboBox.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(passengerNumberMinLabel);

            JLabel passengerNumberMaxLabel = new JLabel("Max Pass Number");
            passengerNumberMaxLabel.setBounds(passengerNumberMinLabel.getX() + Constants.X_SPACE_FROM_LABEL, sexComboBox.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(passengerNumberMaxLabel);

            this.passengerNumberMinField = new JTextField();
            this.passengerNumberMinField.setBounds(passengerNumberMinLabel.getX(), passengerNumberMinLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
            this.add(this.passengerNumberMinField);


            this.passengerNumberMaxField = new JTextField();
            this.passengerNumberMaxField.setBounds(passengerNumberMaxLabel.getX(), passengerNumberMaxLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
            this.add(this.passengerNumberMaxField);


            JLabel sibSpLabel = new JLabel("sib number");
            sibSpLabel.setBounds(Constants.RELATIVE_WIDTH, passengerNumberMinField.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(sibSpLabel);


            JLabel parchLabel = new JLabel(" parch Number");
            parchLabel.setBounds(sibSpLabel.getX() + Constants.X_SPACE_FROM_LABEL, passengerNumberMaxField.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(parchLabel);

            this.sibSpField = new JTextField();
            this.sibSpField.setBounds(sibSpLabel.getX(), sibSpLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
            this.add(this.sibSpField);


            this.parchField = new JTextField();
            this.parchField.setBounds(parchLabel.getX(), parchLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
            this.add(this.parchField);


            JLabel minFareLabel = new JLabel("fare min");
            minFareLabel.setBounds(Constants.RELATIVE_WIDTH, parchField.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(minFareLabel);


            JLabel maxFareLabel = new JLabel(" fare max");
            maxFareLabel.setBounds(minFareLabel.getX() + Constants.X_SPACE_FROM_LABEL, parchField.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(maxFareLabel);


            this.minFareField = new JTextField();
            this.minFareField.setBounds(minFareLabel.getX(), minFareLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
            this.add(this.minFareField);


            this.maxFareField = new JTextField();
            this.maxFareField.setBounds(maxFareLabel.getX(), maxFareLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
            this.add(this.maxFareField);


            JLabel nameLabel = new JLabel("name");
            nameLabel.setBounds(Constants.RELATIVE_WIDTH, maxFareField.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(nameLabel);


            JLabel cabinLabel = new JLabel(" cabin");
            cabinLabel.setBounds(nameLabel.getX() + Constants.X_SPACE_FROM_LABEL, maxFareField.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(cabinLabel);


            JLabel ticketNumberLabel = new JLabel(" ticket number");
            ticketNumberLabel.setBounds(cabinLabel.getX() + Constants.X_SPACE_FROM_LABEL, maxFareField.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(ticketNumberLabel);


            this.nameField = new JTextField();
            this.nameField.setBounds(nameLabel.getX(), nameLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
            this.add(this.nameField);


            this.cabinField = new JTextField();
            this.cabinField.setBounds(cabinLabel.getX(), cabinLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
            this.add(this.cabinField);


            this.ticketNumberField = new JTextField();
            this.ticketNumberField.setBounds(ticketNumberLabel.getX(), ticketNumberLabel.getY() + Constants.Y_SPACE_FROM_LABEL, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
            this.add(this.ticketNumberField);


            JButton sortButton = new JButton("Search");
            sortButton.setBounds((Constants.WINDOW_WIDTH - Constants.LABEL_WIDTH) / 2, this.ticketNumberField.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(sortButton);
            sortButton.addActionListener(e -> sendToSearch());


            JButton statisticsButton = new JButton("Statistics");
            statisticsButton.setBounds((Constants.WINDOW_WIDTH - Constants.LABEL_WIDTH) / 2, sortButton.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(statisticsButton);
            statisticsButton.addActionListener(e -> Statistics.makeStatistics());


            this.showAnswerLabel = new JLabel("");
            this.showAnswerLabel.setBounds((Constants.WINDOW_WIDTH - Constants.ANSWER_LABEL_WIDTH) / 2, statisticsButton.getY() + Constants.Y_SPACE_FOR_NEW_ROW, Constants.ANSWER_LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(this.showAnswerLabel);
        }else {
            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);
            JLabel errorLabel = new JLabel("could not find CSV File");
            errorLabel.setFont(new Font("Ariel ",Font.BOLD,25));
            errorLabel.setBounds((this.getWidth()-Constants.ERROR_LABEL_WIDTH)/2, (this.getHeight()  - Constants.ERROR_LABEL_HEIGHT)/2 ,Constants.ERROR_LABEL_WIDTH,Constants.ERROR_LABEL_HEIGHT);
            this.add(errorLabel);
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
            int survived = Passenger.survivedCounter(filteredPassengerList);
            changeAnswerLabelText(filteredPassengerList.size() + " Matches (" + survived + " Survived , " + (filteredPassengerList.size() - survived) + " did not )");
            if (filteredPassengerList.size() >= 1) {
                FileHandler.createFile(filteredPassengerList);
            }
        } catch (NumberFormatException e) {
            changeAnswerLabelText("please enter a valid input!");
        }
    }

}
