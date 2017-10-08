package com.nuance.ndi.demo.paint.shape;

public class ShapeFactory {

	//$DP$ - Singleton
	private interface Wrapper {
		ShapeFactory INSTANCE = new ShapeFactory();
	}

	public static ShapeFactory getInstance() {
		return Wrapper.INSTANCE;
	}

	private ShapeFactory() {

	}

	public Shape getByType(final ShapeType type, final String name) {
		if (null != type) {
			switch (type) {
			case CIRCLE:
				return new CircleShape(name);
			case RECTANGLE:
				return new RectangleShape(name);
			case COMPOSITE:
				return new CompositeShape(name);
			}
		}
		return null;
	}

}
