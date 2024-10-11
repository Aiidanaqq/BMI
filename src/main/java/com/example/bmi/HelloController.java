package com.example.bmi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField weightInput, heightInput;
    @FXML
    private Label bmiResultLabel, bmiStatusLabel;

    @FXML
    protected void onCalculateBMI() {
        try {
            double weight = Double.parseDouble(weightInput.getText());
            double height = Double.parseDouble(heightInput.getText()) / 100.0;

            double bmi = weight / (height * height);
            bmiResultLabel.setText(String.format("BMI: %.2f", bmi));
            bmiStatusLabel.setText("Status: " + getBMIStatus(bmi));
        } catch (NumberFormatException e) {
            bmiResultLabel.setText("Invalid input.");
        }
    }

    private String getBMIStatus(double bmi) {
        return (bmi < 18.5) ? "Underweight" :
                (bmi < 24.9) ? "Normal" :
                        (bmi < 29.9) ? "Overweight" : "Obese";
    }

    @FXML
    protected void onClearFields() {
        weightInput.clear();
        heightInput.clear();
        bmiResultLabel.setText("BMI: ");
        bmiStatusLabel.setText("Status: ");
    }
}
