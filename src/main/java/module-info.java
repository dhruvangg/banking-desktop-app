module champ {
    requires javafx.controls;
    requires javafx.fxml;

    opens champ to javafx.fxml;
    exports champ;
}
