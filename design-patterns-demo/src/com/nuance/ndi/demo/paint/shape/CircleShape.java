package com.nuance.ndi.demo.paint.shape;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class CircleShape extends AbstractShape {

	private final Circle circle = new Circle(100, 100, 100, Color.BLUE);

	public CircleShape(String name) {
		super(name);
	}
	
	@Override
	public Shape copyAs(final String name) {
		final CircleShape shape = new CircleShape(name);
		shape.setPosition(getPosition());
		shape.setSize(getSize());
		shape.setFillColor(getFillColor());
		shape.setBorderColor(getBorderColor());
		return shape;
	}

	// Covarient return type
	@Override
	public Circle getNode() {
		return circle;
	}

	@Override
	public double[] getPosition() {
		return new double[] { circle.getCenterX(), circle.getCenterY() };
	}

	@Override
	public void setPosition(double[] position) {
		circle.setCenterX(position[0]);
		circle.setCenterY(position[1]);
		setChanged();
		notifyObservers();
	}

	@Override
	public double[] getSize() {
		return new double[] { circle.getRadius() };
	}

	@Override
	public void setSize(double[] size) {
		circle.setRadius(size[0]);
		setChanged();
		notifyObservers();
	}

	@Override
	public Paint getFillColor() {
		return circle.getFill();
	}

	@Override
	public void setFillColor(Paint color) {
		circle.setFill(color);
		setChanged();
		notifyObservers();
	}

	@Override
	public Paint getBorderColor() {
		return circle.getStroke();
	}

	@Override
	public void setBorderColor(Paint color) {
		circle.setStroke(color);
		setChanged();
		notifyObservers();
	}
	
	@Override
	public String toString() {
		return "Circle "+getName()+" x="+circle.getCenterX()+" y="+circle.getCenterY()+" r="+circle.getRadius()+" fill="+circle.getFill()+" border="+circle.getStroke();
	}

}
