package com.nuance.ndi.demo.paint.command;

import com.nuance.ndi.demo.paint.shape.Shape;
import com.nuance.ndi.demo.paint.shape.TransparentShape;
import com.nuance.ndi.demo.paint.ui.Container;
import com.nuance.ndi.demo.paint.ui.drawing.DrawingPresenter;

import javafx.scene.paint.Color;

public class OpaqueCommand implements ReversibleCommand {
	
	private double previousOpacity;
	private final String[] tokens;
	private final Container container;
	
	public OpaqueCommand(final String[] tokens, final Container container) {
		this.tokens = tokens;
		this.container = container;
	}

	@Override
	public void execute() {
		final String name = tokens[0];
		final double opacity = Double.parseDouble(tokens[1]);
		final DrawingPresenter drawingPresenter = container.getDrawingPresenter();
		final Shape shape = drawingPresenter.getShape(name);
		final Color color = (Color)shape.getFillColor();
		previousOpacity = color.getOpacity();
		final TransparentShape transparentShape = new TransparentShape(shape);
		transparentShape.setOpacity(opacity);
	}

	@Override
	public void rollback() {
		final String name = tokens[0];
		final DrawingPresenter drawingPresenter = container.getDrawingPresenter();
		final Shape shape = drawingPresenter.getShape(name);
		final TransparentShape transparentShape = new TransparentShape(shape);
		transparentShape.setOpacity(previousOpacity);
	}

}
