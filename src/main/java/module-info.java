module com.jhtraining.snakes_ladders {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jhtraining.snakes_ladders to javafx.fxml;
    exports com.jhtraining.snakes_ladders;
}