package com.nuance.ndi.demo.paint.shape;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class RectangleShape extends AbstractShape {

	private final Rectangle rectangle = new Rectangle(100, 100, Color.YELLOW);

	public RectangleShape(String name) {
		super(name);
	}

	@Override
	public Shape copyAs(final String name) {
		final RectangleShape shape = new RectangleShape(name);
		shape.setPosition(getPosition());
		shape.setSize(getSize());
		shape.setFillColor(getFillColor());
		shape.setBorderColor(getBorderColor());
		return shape;
	}

	// Covarient return type
	@Override
	public Rectangle getNode() {
		return rectangle;
	}

	@Override
	public double[] getPosition() {
		return new double[] { rectangle.getLayoutX(), rectangle.getLayoutY() };
	}

	@Override
	public void setPosition(double[] position) {
		rectangle.setLayoutX(position[0]);
		rectangle.setLayoutY(position[1]);
		notifyObservers();
	}

	@Override
	public double[] getSize() {
		return new double[] { rectangle.getWidth(), rectangle.getHeight() };
	}

	@Override
	public void setSize(double[] size) {
		rectangle.setWidth(size[0]);
		rectangle.setHeight(size[1]);
		notifyObservers();
	}

	@Override
	public Paint getFillColor() {
		return rectangle.getFill();
	}

	@Override
	public void setFillColor(Paint color) {
		rectangle.setFill(color);
		notifyObservers();
	}

	@Override
	public Paint getBorderColor() {
		return rectangle.getStroke();
	}

	@Override
	public void setBorderColor(Paint color) {
		rectangle.setStroke(color);
		notifyObservers();
	}

	@Override
	public String toString() {
		return "Rectangle " + getName() + " x=" + rectangle.getLayoutX() + " y=" + rectangle.getLayoutY() + " w="
				+ rectangle.getWidth() + " h=" + rectangle.getHeight() + " fill=" + rectangle.getFill() + " border="
				+ rectangle.getStroke();
	}

}
