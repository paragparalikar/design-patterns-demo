package com.nuance.ndi.demo.paint.shape;

import java.util.Observer;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

//$DP$ - Decorator
public class TransparentShape implements Shape {

	private final Shape shape;

	public TransparentShape(final Shape shape) {
		this.shape = shape;
	}

	public void setOpacity(final double value) {
		final Color color = (Color) shape.getFillColor();
		shape.setFillColor(Color.rgb((int) (255 * color.getRed()), (int) (255 * color.getGreen()),
				(int) (255 * color.getBlue()), value));
	}

	@Override
	public String getName() {
		return shape.getName();
	}

	@Override
	public Node getNode() {
		return shape.getNode();
	}

	@Override
	public void addObserver(Observer observer) {
		shape.addObserver(observer);
	}

	@Override
	public double[] getPosition() {
		return shape.getPosition();
	}

	@Override
	public void setPosition(double[] position) {
		shape.setPosition(position);
	}

	@Override
	public double[] getSize() {
		return shape.getSize();
	}

	@Override
	public void setSize(double[] size) {
		shape.setSize(size);
	}

	@Override
	public Paint getFillColor() {
		return shape.getFillColor();
	}

	@Override
	public void setFillColor(Paint color) {
		shape.setFillColor(color);
	}

	@Override
	public Paint getBorderColor() {
		return shape.getBorderColor();
	}

	@Override
	public void setBorderColor(Paint color) {
		shape.setBorderColor(color);
	}

	@Override
	public Shape copyAs(String name) {
		return shape.copyAs(name);
	}

}
