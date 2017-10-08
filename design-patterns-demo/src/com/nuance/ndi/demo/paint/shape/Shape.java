package com.nuance.ndi.demo.paint.shape;

import java.util.Observer;

import javafx.scene.Node;
import javafx.scene.paint.Paint;

// $DP$ - Bridge - Shape + Command hierarchy
public interface Shape {
	
	String getName();
	
	Node getNode();
	
	void addObserver(final Observer observer);

	double[] getPosition();
	
	void setPosition(final double[] position);
	
	double[] getSize();
	
	void setSize(final double[] size);
	
	Paint getFillColor();
	
	void setFillColor(final Paint color);
	
	Paint getBorderColor();
	
	void setBorderColor(Paint color);
	
	//$DP$ - Prototype
	Shape copyAs(final String name);
	
}
