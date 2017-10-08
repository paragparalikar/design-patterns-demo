package com.nuance.ndi.demo.paint.command;

import com.nuance.ndi.demo.paint.shape.Shape;
import com.nuance.ndi.demo.paint.ui.Container;
import com.nuance.ndi.demo.paint.ui.drawing.DrawingPresenter;

public class CopyCommand implements ReversibleCommand {
	
	private final String[] tokens;
	private final Container container;

	public CopyCommand(final String[] tokens, final Container container) {
		this.tokens = tokens;
		this.container = container;
	}
	
	@Override
	public void execute() {
		final String name = tokens[0];
		final DrawingPresenter drawingPresenter = container.getDrawingPresenter();
		final Shape shape = drawingPresenter.getShape(name);
		final Shape clone = shape.copyAs(tokens[1]);
		drawingPresenter.add(clone);
	}

	@Override
	public void rollback() {
		final DrawingPresenter drawingPresenter = container.getDrawingPresenter();
		drawingPresenter.remove(tokens[1]);
	}

}
