package champ;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreateAccountView extends StackPane {
    private static final Bank bank = new Bank();
    public CreateAccountView() {
        Label label = new Label("Create Account");
        label.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label accNumberLabel = new Label("Account number: ");
        TextField accNumberField = new TextField();

        Label accNameLabel = new Label("Account Holder name: ");
        TextField accNameField = new TextField();

        Label balanceLabel = new Label("Balance: ");
        TextField balanceField = new TextField();

        Button createButton = new Button("Create");

        VBox initialLayout = new VBox(10, label, accNumberLabel, accNumberField, accNameLabel, accNameField, balanceLabel, balanceField, createButton);
        initialLayout.setStyle("-fx-padding: 10px;");
        initialLayout.setAlignment(Pos.TOP_LEFT);

        this.getChildren().addAll(initialLayout);

        createButton.setOnAction(e -> {
            String accNum = accNumberField.getText();
            String accName = accNameField.getText();
            double balance;

            try {
                balance = Double.parseDouble(balanceField.getText());
            } catch (NumberFormatException ex) {
                showAlert("Invalid Balance", "Please enter a valid number!");
                return;
            }

            bank.createAccount(accNum, accName, balance);
            showAlert("Succes", "Account created successfully!");
        });
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

