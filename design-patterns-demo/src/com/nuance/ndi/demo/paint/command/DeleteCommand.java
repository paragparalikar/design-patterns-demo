package com.nuance.ndi.demo.paint.command;

import com.nuance.ndi.demo.paint.shape.Shape;
import com.nuance.ndi.demo.paint.ui.Container;
import com.nuance.ndi.demo.paint.ui.drawing.DrawingPresenter;

public class DeleteCommand implements ReversibleCommand {

	private Shape shape;
	private final String[] tokens;
	private final Container container;
	
	public DeleteCommand(final String[] tokens, final Container container) {
		this.tokens = tokens;
		this.container = container;
	}
	
	@Override
	public void execute() {
		final String name = tokens[0];
		final DrawingPresenter drawingPresenter = container.getDrawingPresenter();
		shape = drawingPresenter.remove(name);
	}

	@Override
	public void rollback() {
		final DrawingPresenter drawingPresenter = container.getDrawingPresenter();
		drawingPresenter.add(shape);
	}

}
