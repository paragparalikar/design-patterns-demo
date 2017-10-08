package com.nuance.ndi.demo.paint.command;

import com.nuance.ndi.demo.paint.ui.Container;
import com.nuance.ndi.demo.paint.ui.drawing.DrawingPresenter;

public class MoveCommand implements ReversibleCommand {
	
	private final String[] tokens;
	private final Container container;
	private double[] previousPosition;
	
	public MoveCommand(final String[] tokens, final Container container) {
		this.tokens = tokens;
		this.container = container;
	}

	@Override
	public void execute() {
		final String name = tokens[0];
		final DrawingPresenter drawingPresenter = container.getDrawingPresenter();
		previousPosition = drawingPresenter.getPosition(name);
		drawingPresenter.setPosition(name, parsePosition());
	}
	
	private double[] parsePosition() {
		final double[] position = new double[tokens.length - 1];
		for(int index = 1; index < tokens.length; index++) {
			position[index - 1] = Double.parseDouble(tokens[index]);
		}
		return position;
	}

	@Override
	public void rollback() {
		final String name = tokens[0];
		final DrawingPresenter drawingPresenter = container.getDrawingPresenter();
		drawingPresenter.setPosition(name, previousPosition);
	}

}
