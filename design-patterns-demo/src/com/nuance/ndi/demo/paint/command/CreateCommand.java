package com.nuance.ndi.demo.paint.command;

import com.nuance.ndi.demo.paint.shape.CompositeShape;
import com.nuance.ndi.demo.paint.shape.Shape;
import com.nuance.ndi.demo.paint.shape.ShapeFactory;
import com.nuance.ndi.demo.paint.shape.ShapeType;
import com.nuance.ndi.demo.paint.ui.Container;
import com.nuance.ndi.demo.paint.ui.drawing.DrawingPresenter;

public class CreateCommand implements ReversibleCommand{

	private final Shape shape;
	private final String[] tokens;
	private final Container container;
	private final ShapeType shapeType;
	private CompositeCreateDelegate compositeDelegate;  // $DP$ Delegation
	
	
	public CreateCommand(final String[] tokens, final Container container) {
		this.tokens = tokens;
		this.container = container;
		shapeType = ShapeType.findByType(tokens[0]);
		shape = ShapeFactory.getInstance().getByType(shapeType, tokens[1]);
	}
	
	@Override
	public void execute() {
		final DrawingPresenter drawingPresenter = container.getDrawingPresenter();
		if(ShapeType.COMPOSITE.equals(shapeType)) {
			compositeDelegate = new CompositeCreateDelegate((CompositeShape) shape, tokens, container);
			compositeDelegate.execute();
		}
		drawingPresenter.add(shape);
	}
	
	@Override
	public void rollback() {
		final DrawingPresenter drawingPresenter = container.getDrawingPresenter();
		drawingPresenter.remove(shape.getName());
		if(null != compositeDelegate) {
			compositeDelegate.rollback();
		}
	}
	
	
}
