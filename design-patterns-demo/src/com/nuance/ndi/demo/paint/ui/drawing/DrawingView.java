package com.nuance.ndi.demo.paint.ui.drawing;

import com.nuance.ndi.demo.paint.shape.Shape;
import com.nuance.ndi.demo.paint.ui.View;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

//$DP$ - MVC
public class DrawingView implements View{
	
	private final Pane pane = new Pane();
	
	@Override
	public Node getNode() {
		return pane;
	}
	
	public void add(final Shape shape) {
		pane.getChildren().add(shape.getNode());
	}
	
	public void remove(final Shape shape) {
		pane.getChildren().remove(shape.getNode());
	}
	
}
