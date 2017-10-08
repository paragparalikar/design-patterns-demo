package com.nuance.ndi.demo.paint.command.chain;

import com.nuance.ndi.demo.paint.command.Command;
import com.nuance.ndi.demo.paint.command.ReversibleCommand;

public class AuditCommandExecutionStep implements CommandExecutionStep {

	private CommandExecutionStep next;
	private final CommandExecutionChain commandExecutionChain;

	public AuditCommandExecutionStep(final CommandExecutionChain commandExecutionChain) {
		this.commandExecutionChain = commandExecutionChain;
	}

	public <T extends CommandExecutionStep> T next(T next) {
		this.next = next;
		return next;
	}

	@Override
	public void execute(final Command command) {
		if(command instanceof ReversibleCommand) {
			commandExecutionChain.append((ReversibleCommand) command);
		}
		if (null != next) {
			next.execute(command);
		}
	}

}
