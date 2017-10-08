package com.nuance.ndi.demo.paint.command;

import com.nuance.ndi.demo.paint.command.chain.CommandExecutionChain;

public class RedoCommand implements Command {
	
	private final CommandExecutionChain commandExecutionChain;
	
	public RedoCommand(final CommandExecutionChain commandExecutionChain) {
		this.commandExecutionChain = commandExecutionChain;
	}

	@Override
	public void execute() {
		final ReversibleCommand nextCommand = commandExecutionChain.getCommand(commandExecutionChain.getCurrentCommandIndex() + 1);
		if(null != nextCommand) {
			nextCommand.execute();
			commandExecutionChain.setCurrentCommandIndex(commandExecutionChain.getCurrentCommandIndex() + 1);
		}else {
			System.out.println("Nothing to redo");
		}
	}

}
