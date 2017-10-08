package com.nuance.ndi.demo.paint.command.chain;

import com.nuance.ndi.demo.paint.command.AuthenticationException;
import com.nuance.ndi.demo.paint.command.Command;
import com.nuance.ndi.demo.paint.command.LoginCommand;

public class AuthenticationCommandExecutionStep implements CommandExecutionStep {

	private boolean authenticated;
	private CommandExecutionStep next;

	public <T extends CommandExecutionStep> T next(T next) {
		this.next = next;
		return next;
	}

	@Override
	public void execute(Command command) {
		if (!authenticated) {
			if (command instanceof LoginCommand) {
				command.execute();
				authenticated = true;
			} else {
				throw new AuthenticationException("Please login");
			}
		} else if (null != next) {
			next.execute(command);
		}
	}

}
