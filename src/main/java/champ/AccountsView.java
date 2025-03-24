package champ;

import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;

public class AccountsView extends StackPane {
    public AccountsView() {
        Label label = new Label("Accounts View");
        this.getChildren().add(label);
    }
}
