package com.nuance.ndi.demo.paint.command;

import com.nuance.ndi.demo.paint.command.chain.CommandExecutionChain;

public class UndoCommand implements Command {
	
	private final CommandExecutionChain commandExecutionChain;
	
	public UndoCommand(final CommandExecutionChain commandExecutionChain) {
		this.commandExecutionChain = commandExecutionChain;
	}

	@Override
	public void execute() {
		final ReversibleCommand previousCommand = commandExecutionChain.getCommand(commandExecutionChain.getCurrentCommandIndex());
		if(null == previousCommand) {
			System.out.println("Nothing to undo");
		}else {
			previousCommand.rollback();
			commandExecutionChain.setCurrentCommandIndex(commandExecutionChain.getCurrentCommandIndex() - 1);
		}
	}

}
