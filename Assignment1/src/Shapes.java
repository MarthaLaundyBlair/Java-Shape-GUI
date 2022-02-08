
import java.lang.Math;

import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Shapes {

	// attributes
	private final Polygon polygon;
	private final double size;
	private final double coordinateShift;

	private int sides;

	// then the methods
	public Shapes(double size, Polygon polygon) {
		this.polygon = polygon;
		this.size = size;
		this.coordinateShift = 2 * size;
	}

	// getter
	public int getSides() {
		return sides;
	}

	// setter
	public void setSides(int sidesIn) {
		sides = sidesIn;
		this.updateCoordinates();
		this.updateColor();
	}

	// find coordinates and add them to an array
	private void updateCoordinates() {
		if (sides != 0) { 
			Double[] coordinates = new Double[2 * sides];
			for (int i = 0; i < sides; i++) {
	
				double angle = 360.0 / sides;
				double radians = Math.toRadians(angle);
	
				// 
				coordinates[2 * i] = ((Math.sin(i * radians) * size) + coordinateShift);
				coordinates[2 * i + 1] = ((Math.cos(i * radians) * size) + coordinateShift);
	
			}
			
			// Adding coordinates to the polygon
			ObservableList<Double> points = polygon.getPoints();
	
			points.clear();
			points.addAll(coordinates);
		}
		else 
		{
			// Adding coordinates to the polygon
			ObservableList<Double> points = polygon.getPoints();
			points.clear();	
			points.addAll(new Double[]{        
					   0.0, 0.0 
					});
		}

	}

	private void updateColor() {
		// Setting colour of Polygon
		polygon.setFill(Color.WHITE);
		polygon.setStrokeWidth(8.0);

		if (sides % 2 == 0) {
			polygon.setStroke(Color.YELLOW);
		} else {
			polygon.setStroke(Color.GREEN);
		}
	}
}
