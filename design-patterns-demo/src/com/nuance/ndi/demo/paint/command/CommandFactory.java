package com.nuance.ndi.demo.paint.command;

import com.nuance.ndi.demo.paint.command.chain.CommandExecutionChain;
import com.nuance.ndi.demo.paint.ui.Container;

//$DP$ - Factory
public class CommandFactory {

	private final Container container;
	private final CommandExecutionChain commandExecutionChain;
	
	public CommandFactory(final Container container, final CommandExecutionChain commandExecutionChain) {
		this.container = container;
		this.commandExecutionChain = commandExecutionChain;
	}

	public Command getByType(final CommandType type, final String[] tokens) {
		if (null != type) {
			switch (type) {
			case COPY:
				return new CopyCommand(tokens, container);
			case CREATE:
				return new CreateCommand(tokens, container);
			case DELETE:
				return new DeleteCommand(tokens, container);
			case EXIT:
				return new ExitCommand();
			case MOVE:
				return new MoveCommand(tokens, container);
			case FILL:
				return new FillCommand(tokens, container);
			case BORDER:
				return new BorderCommand(tokens, container);
			case RESIZE:
				return new ResizeCommand(tokens, container);
			case UNDO : 
				return new UndoCommand(commandExecutionChain);
			case REDO : 
				return new RedoCommand(commandExecutionChain);
			case OPAQUE:
				return new OpaqueCommand(tokens, container);
			case LOGIN:
				return new LoginCommand(tokens);
			}
		}
		return null;
	}

}
