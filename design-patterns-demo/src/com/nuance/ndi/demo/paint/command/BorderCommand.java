package com.nuance.ndi.demo.paint.command;

import com.nuance.ndi.demo.paint.ui.Container;
import com.nuance.ndi.demo.paint.ui.drawing.DrawingPresenter;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class BorderCommand implements ReversibleCommand {

	private final String[] tokens;
	private final Container container;
	private Paint previousBorderColor;

	public BorderCommand(final String[] tokens, final Container container) {
		this.tokens = tokens;
		this.container = container;
	}
	
	@Override
	public void execute() {
		final String name = tokens[0];
		final DrawingPresenter drawingPresenter = container.getDrawingPresenter();
		previousBorderColor = drawingPresenter.getBorderColor(name);
		drawingPresenter.setBorderColor(name, Color.web(tokens[1]));
	}

	@Override
	public void rollback() {
		final String name = tokens[0];
		final DrawingPresenter drawingPresenter = container.getDrawingPresenter();
		drawingPresenter.setBorderColor(name, previousBorderColor);
	}
}
