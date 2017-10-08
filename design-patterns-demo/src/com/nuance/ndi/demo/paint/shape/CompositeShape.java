package com.nuance.ndi.demo.paint.shape;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Paint;

//$DP$ - Composite
public class CompositeShape extends AbstractShape {

	private final Group group = new Group();
	private final List<Shape> shapes = new LinkedList<>();

	public CompositeShape(final String name) {
		super(name);
	}

	public void setShapes(Collection<Shape> shapes) {
		this.shapes.clear();
		this.shapes.addAll(shapes);
		group.getChildren().setAll(shapes.stream().map(Shape::getNode).collect(Collectors.toSet()));
	}

	@Override
	public Node getNode() {
		return group;
	}

	@Override
	public double[] getPosition() {
		return new double[] { group.getLayoutX(), group.getLayoutY() };
	}

	@Override
	public void setPosition(double[] position) {
		group.setLayoutX(position[0]);
		group.setLayoutY(position[1]);
	}

	@Override
	public double[] getSize() {
		return null;
	}

	@Override
	public void setSize(double[] size) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Paint getFillColor() {
		return null;
	}

	@Override
	public void setFillColor(Paint color) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Paint getBorderColor() {
		return null;
	}

	@Override
	public void setBorderColor(Paint color) {
		throw new UnsupportedOperationException();
	}

	public List<Shape> getShapes() {
		return shapes;
	}

	@Override
	public Shape copyAs(String name) {
		final List<Shape> shapesCopy = shapes.stream().map(shape -> shape.copyAs("Copy of " + shape.getName()))
				.collect(Collectors.toList());
		final CompositeShape copy = new CompositeShape(name);
		copy.setShapes(shapesCopy);
		return copy;
	}

	@Override
	public String toString() {
		return "Composite " + getName() +" "+ shapes.stream().map(Shape::getName).collect(Collectors.joining(","));
	}

}
