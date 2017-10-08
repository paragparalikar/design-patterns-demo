package com.nuance.ndi.demo.paint.ui.drawing;

import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

import com.nuance.ndi.demo.paint.shape.Shape;
import com.nuance.ndi.demo.paint.shape.ShapeNotFoundException;
import com.nuance.ndi.demo.paint.ui.Container;
import com.nuance.ndi.demo.paint.ui.Presenter;

import javafx.application.Platform;
import javafx.scene.paint.Paint;

public class DrawingPresenter implements Presenter {

	private final Observer observer;
	private final DrawingView drawingView = new DrawingView();
	private final Map<String, Shape> shapes = new HashMap<>();

	public DrawingPresenter(final Observer observer) {
		this.observer = observer;
	}
	
	@Override
	public void present(final Container container) {
		container.setCenter(drawingView.getNode());
	}

	public void add(final Shape shape) {
		shapes.put(shape.getName(), shape);
		shape.addObserver(observer);
		Platform.runLater(() -> {
			drawingView.add(shape);
		});
	}

	public Shape remove(final String name) {
		final Shape shape = shapes.get(name);
		Platform.runLater(() -> {
			drawingView.remove(shape);
		});
		return shape;
	}

	public Shape getShape(final String name) {
		final Shape shape = shapes.get(name);
		if (null == shape) {
			throw new ShapeNotFoundException("No shape with name \"" + name + "\" was found");
		}
		return shape;
	}

	public double[] getPosition(final String name) {
		return getShape(name).getPosition();
	}

	public void setPosition(final String name, final double[] position) {
		getShape(name).setPosition(position);
	}

	public double[] getSize(final String name) {
		return getShape(name).getSize();
	}

	public void setSize(final String name, final double[] size) {
		getShape(name).setSize(size);
	}

	public Paint getFillColor(final String name) {
		return getShape(name).getFillColor();
	}

	public void setFillColor(final String name, final Paint color) {
		getShape(name).setFillColor(color);
	}

	public Paint getBorderColor(final String name) {
		return getShape(name).getBorderColor();
	}

	public void setBorderColor(final String name, final Paint color) {
		getShape(name).setBorderColor(color);
	}

}
