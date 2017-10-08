package com.nuance.ndi.demo.paint.command;

import com.nuance.ndi.demo.paint.ui.Container;
import com.nuance.ndi.demo.paint.ui.drawing.DrawingPresenter;

public class ResizeCommand implements ReversibleCommand {

	private final String[] tokens;
	private final Container container;
	private double[] previousSize;
	
	public ResizeCommand(final String[] tokens, final Container container) {
		this.tokens = tokens;
		this.container = container;
	}
	
	@Override
	public void execute() {
		final String name = tokens[0];
		final DrawingPresenter drawingPresenter = container.getDrawingPresenter();
		previousSize = drawingPresenter.getSize(name);
		drawingPresenter.setSize(name, parseSize());
	}
	
	private double[] parseSize() {
		final double[] size = new double[tokens.length - 1];
		for(int index = 1; index < tokens.length; index++) {
			size[index - 1] = Double.parseDouble(tokens[index]);
		}
		return size;
	}

	@Override
	public void rollback() {
		final String name = tokens[0];
		final DrawingPresenter drawingPresenter = container.getDrawingPresenter();
		drawingPresenter.setSize(name, previousSize);
	}

}
