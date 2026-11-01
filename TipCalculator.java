import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TipCalculator extends Application {

    public void start(Stage stage) {

        Label title = new Label("Tip Calculator");

        TextField bill = new TextField();
        bill.setPromptText("Enter Bill Amount");

        TextField percent = new TextField();
        percent.setPromptText("Enter Tip Percentage");

        Label result = new Label();
        Label error = new Label();

        Button calculate = new Button("Calculate Tip");
        Button reset = new Button("Reset");

        calculate.setOnAction(e -> {
            try {
                double b = Double.parseDouble(bill.getText());
                double p = Double.parseDouble(percent.getText());

                if (b < 0 || p < 0) {
                    error.setText("Enter positive numbers");
                    result.setText("");
                } else {
                    double tip = b * p / 100;
                    result.setText(String.format("Tip Amount: $%.2f", tip));
                    error.setText("");
                }
            } catch (NumberFormatException ex) {
                error.setText("Error: Invalid input. Please enter numbers.");
                result.setText("");
            }
        });

        reset.setOnAction(e -> {
            bill.clear();
            percent.clear();
            result.setText("");
            error.setText("");
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(
            title, bill, percent, calculate, reset, result, error
        );

        Scene scene = new Scene(root, 300, 300);
        stage.setTitle("Tip Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
