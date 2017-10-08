package com.nuance.ndi.demo.paint.shape;

public enum ShapeType {

	RECTANGLE("rectangle"), CIRCLE("circle"), COMPOSITE("composite");
	
	public static ShapeType findByType(final String text) {
		for(final ShapeType type : values()) {
			if(type.getText().equalsIgnoreCase(text.trim())) {
				return type;
			}
		}
		return null;
	}
	
	private final String text;

	private ShapeType(final String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
}
