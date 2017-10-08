package com.nuance.ndi.demo.paint.command;

import java.util.Arrays;

//$DP$ - Interpreter
public class CommandInterpreter {
	
	private final CommandFactory commandFactory;
	
	public CommandInterpreter(final CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}

	public Command interpret(final String text) {
		String tokens[] = text.split("\\s");
		final CommandType commandType = CommandType.findByText(tokens[0]);
		if(null == commandType) {
			unrecognizedCommand(text);
			return null;
		}
		return commandFactory.getByType(commandType, Arrays.copyOfRange(tokens, 1, tokens.length));
	}
	
	private void unrecognizedCommand(final String text) {
		System.out.println("Unrecognized command : "+text);
	}
	
	
}
