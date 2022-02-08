
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.shape.Polygon;

public class ShapesGUI2 extends Application {

	@Override
	public void start(Stage stage) {

		// create a button to add a side
		Button addSideButton = new Button("Add side");

		// create a button to remove a side
		Button minusSideButton = new Button("Minus side");

		HBox buttonBox = new HBox(10);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(addSideButton, minusSideButton);

		// make a polygon:
		Polygon poly = new Polygon();
		Shapes testShapes = new Shapes(100, poly);
		testShapes.setSides(4);

		// create a label to display either an error message or the number of sides
		Label errorMessage = new Label();
		errorMessage.setTextFill(Color.BLACK);
		errorMessage.setFont(Font.font("Arial", 20));
		errorMessage.setText("This shape has " + testShapes.getSides() + " sides! ");

		// create a label to give a hint when an error message is displayed
		Label hint = new Label();
		hint.setTextFill(Color.BLACK);
		hint.setFont(Font.font("Arial", 20));

		// supply the code that is executed when the add button is pressed
		addSideButton.setOnAction(e -> {
			if (testShapes.getSides() < 8) {

				testShapes.setSides(testShapes.getSides() + 1);
				errorMessage.setText("This shape has " + testShapes.getSides() + " sides! ");
				errorMessage.setTextFill(Color.BLACK);
				hint.setText("");
			} else {
				errorMessage.setText("The maximum number of sides is 8!");
				errorMessage.setTextFill(Color.RED);
				hint.setText("Try removing a side to continue!");
			}

		});

		// supply the code that is executed when the MINUS button is pressed
		minusSideButton.setOnAction(e -> {
			if (testShapes.getSides() > 4) {

				testShapes.setSides(testShapes.getSides() - 1);
				errorMessage.setText("This shape has " + testShapes.getSides() + " sides! ");
				errorMessage.setTextFill(Color.BLACK);
				hint.setText("");
			} else {
				errorMessage.setText("The minimum number of sides is 4!");
				errorMessage.setTextFill(Color.RED);
				hint.setText("Try adding a side to continue!");
			}

		});

		// create and configure a vertical container to hold all the components
		VBox root = new VBox(25);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(buttonBox, errorMessage, poly, hint);

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
