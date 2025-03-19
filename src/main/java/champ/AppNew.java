/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package champ;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author dhruvang.gajjar
 */
public class AppNew extends Application {

    private static final Bank bank = new Bank();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Banking App");

        Label title = new Label("Banking App");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Button createAccountBtn = new Button("Create Account");
        createAccountBtn.setOnAction(e -> showCreateAccountWindow());

        Button depositBtn = new Button("Deposit Funds");
        depositBtn.setOnAction(e -> showDepositWindow());
        
        Button withdrawBtn = new Button("Withdraw Funds");
        withdrawBtn.setOnAction(e -> showWithdrawWindow());

        VBox layout = new VBox(10, title, createAccountBtn, depositBtn, withdrawBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20px;");

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showCreateAccountWindow() {
        Stage createAccountStage = new Stage();
        createAccountStage.setTitle("Create Account");

        Label accNumberLabel = new Label("Account number: ");
        TextField accNumberField = new TextField();

        Label accNameLabel = new Label("Account Holder name: ");
        TextField accNameField = new TextField();

        Label balanceLabel = new Label("Balance: ");
        TextField balanceField = new TextField();

        Button createButton = new Button("Create");

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
            createAccountStage.close();
        });

        VBox layout = new VBox(10, accNumberLabel, accNumberField, accNameLabel, accNameField, balanceLabel,
                balanceField, createButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 300);
        createAccountStage.setScene(scene);
        createAccountStage.show();
    }

    private void showDepositWindow() {
    showAlert("Feature Pending", "Deposit feature will be implemented soon!");
    }

    private void showWithdrawWindow() {
    showAlert("Feature Pending", "Withdraw feature will be implemented soon!");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }

}
