package com.nuance.ndi.demo.paint.command;

public enum CommandType {

	LOGIN("login"),CREATE("create"), MOVE("move"), RESIZE("resize"), FILL("fill"), OPAQUE("opaque"), BORDER("border"), DELETE("delete"), COPY(
			"copy"), UNDO("undo"), REDO("redo"), EXIT("exit");

	public static CommandType findByText(final String text) {
		for (final CommandType type : values()) {
			if (type.getText().equalsIgnoreCase(text.trim())) {
				return type;
			}
		}
		return null;
	}

	private final String text;

	private CommandType(final String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

}
