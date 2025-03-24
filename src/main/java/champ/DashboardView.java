package champ;

import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;

public class DashboardView extends StackPane {
    public DashboardView() {
        Label label = new Label("Welcome to Banking System");
        label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        this.getChildren().add(label);
    }
}

