package com.nuance.ndi.demo.paint.shape;

import java.util.Observable;
import java.util.Observer;

//$DP$ - Observer 
public abstract class AbstractShape extends Observable implements Shape {

	private final String name;

	public AbstractShape(final String name) {
		this.name = name;
	}
	
	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
		setChanged();
		notifyObservers();
	}

	@Override
	public String getName() {
		return name;
	}

}
