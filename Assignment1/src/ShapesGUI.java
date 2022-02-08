
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.shape.Polygon;

public class ShapesGUI extends Application {

	@Override
	public void start(Stage stage) {

		// create a text field
		TextField sidesField = new TextField();
		sidesField.setMaxWidth(50);

		// create and configure a non-editable text area to display the results
		Label display = new Label();

		// create and configure Labels for the text fields
		Label sidesLabel = new Label("Number of Sides:");
		sidesLabel.setFont(Font.font("Arial", 20));

		// create and configure an HBox for the labels and text inputs
		HBox inputComponents = new HBox(10);
		inputComponents.setAlignment(Pos.CENTER);
		inputComponents.getChildren().addAll(sidesLabel, sidesField);

		Polygon poly = new Polygon();
		Shapes displayShapes = new Shapes(100, poly);

		// create and configure a button to perform the calculations
		Button submitButton = new Button();
		submitButton.setText("Submit");
		submitButton.setOnAction(e -> { // check that field is not empty
			if (sidesField.getText().isEmpty()) {
				display.setText("Please enter the number of sides you require!");
				display.setTextFill(Color.RED);
				displayShapes.setSides(0);
			} else {
				// check that input is an integer that lies between 4 and 8 inclusive
				try {
					int sides = Integer.parseInt(sidesField.getText());

					if (sides < 4 || sides > 8) {
						display.setText("Please input a number between 4 and 8!");
						display.setTextFill(Color.RED);
						displayShapes.setSides(0);

					} else {
						displayShapes.setSides(sides);
						display.setText("This shape has " + sides + " sides! ");
						display.setTextFill(Color.BLACK);
					}
				} catch (NumberFormatException nfe) {
					display.setText("Try inputting an integer!");
					display.setTextFill(Color.RED);
					displayShapes.setSides(0);
				}
			}
		});

		// create and configure a vertical container to hold all the components
		VBox root = new VBox(25);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(inputComponents, submitButton, display, poly);

		// create a new scene and add it to the stage
		Scene scene = new Scene(root, 350, 500);
		stage.setScene(scene);
		stage.setTitle("Shapes GUI");
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
