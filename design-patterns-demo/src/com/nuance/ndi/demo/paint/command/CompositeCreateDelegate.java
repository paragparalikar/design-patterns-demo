package com.nuance.ndi.demo.paint.command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.nuance.ndi.demo.paint.shape.CompositeShape;
import com.nuance.ndi.demo.paint.shape.Shape;
import com.nuance.ndi.demo.paint.ui.Container;
import com.nuance.ndi.demo.paint.ui.drawing.DrawingPresenter;

public class CompositeCreateDelegate implements ReversibleCommand{
	
	private final String[] tokens;
	private final Container container;
	private final CompositeShape shape;
	
	public CompositeCreateDelegate(final CompositeShape shape, final String[] tokens, final Container container) {
		this.shape = shape;
		this.tokens = tokens;
		this.container = container;
	}

	@Override
	public void execute() {
		final DrawingPresenter drawingPresenter = container.getDrawingPresenter();
		final List<String> names = Arrays.asList(tokens[2].split(","));
		final List<Shape> shapes = names.stream().map(name -> drawingPresenter.getShape(name)).collect(Collectors.toList());
		shape.setShapes(shapes);
		names.forEach(name -> drawingPresenter.remove(name));
	}

	@Override
	public void rollback() {
		final DrawingPresenter drawingPresenter = container.getDrawingPresenter();
		final List<Shape> shapes = shape.getShapes();
		shapes.forEach(shape -> drawingPresenter.add(shape));
	}

}
