package champ;

import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;

public class TransactionsView extends StackPane {
    public TransactionsView() {
        Label label = new Label("Transactions View");
        this.getChildren().add(label);
    }
}
