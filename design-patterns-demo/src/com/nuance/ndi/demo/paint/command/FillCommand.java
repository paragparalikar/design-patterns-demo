package com.nuance.ndi.demo.paint.command;

import com.nuance.ndi.demo.paint.ui.Container;
import com.nuance.ndi.demo.paint.ui.drawing.DrawingPresenter;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class FillCommand implements ReversibleCommand {

	private final String[] tokens;
	private final Container container;
	private Paint previousFillColor;

	public FillCommand(final String[] tokens, final Container container) {
		this.tokens = tokens;
		this.container = container;
	}

	@Override
	public void execute() {
		final String name = tokens[0];
		final DrawingPresenter drawingPresenter = container.getDrawingPresenter();
		previousFillColor = drawingPresenter.getFillColor(name);
		drawingPresenter.setFillColor(name, Color.web(tokens[1]));
	}

	@Override
	public void rollback() {
		final String name = tokens[0];
		final DrawingPresenter drawingPresenter = container.getDrawingPresenter();
		drawingPresenter.setFillColor(name, previousFillColor);
	}

}
