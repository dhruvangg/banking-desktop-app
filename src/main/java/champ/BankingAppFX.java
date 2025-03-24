package champ;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BankingAppFX extends Application {
    private StackPane contentArea;

    @Override
    public void start(Stage primaryStage) {
        VBox sidebar = createSidebar(primaryStage);

        contentArea = new StackPane();
        showView(new DashboardView()); // Load default view

        BorderPane root = new BorderPane();
        root.setLeft(sidebar);
        root.setCenter(contentArea);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Banking System");
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    private VBox createSidebar(Stage primaryStage) {
        VBox sidebar = new VBox(10);
        sidebar.setStyle("-fx-background-color: #333; -fx-padding: 10px;");
        sidebar.setPrefWidth(200);

        Button dashboardBtn = createSidebarButton("Dashboard", e -> showView(new DashboardView()));
        Button createAccountBtn = createSidebarButton("Create Account", e -> showView(new CreateAccountView()));
        Button accountBtn = createSidebarButton("Accounts", e -> showView(new AccountsView()));
        Button transactionBtn = createSidebarButton("Transactions", e -> showView(new TransactionsView()));

        VBox mainButtons = new VBox(10, dashboardBtn, createAccountBtn, accountBtn, transactionBtn);
        VBox.setVgrow(mainButtons, Priority.ALWAYS);

        Button logoutBtn = createSidebarButton("Logout", e -> primaryStage.close());

        sidebar.getChildren().addAll(mainButtons, logoutBtn);
        return sidebar;
    }

    private Button createSidebarButton(String text, EventHandler<ActionEvent> eventHandler) {
        Button button = new Button(text);
        button.setMaxWidth(Double.MAX_VALUE); // Make the button full width
        button.setOnAction(eventHandler);
        return button;
    }

    private void showView(StackPane view) {
        contentArea.getChildren().clear();
        contentArea.getChildren().add(view);
    }

    public static void main(String[] args) {
        launch(args);
    }
}