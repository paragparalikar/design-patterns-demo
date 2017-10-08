package com.nuance.ndi.demo.paint.command.chain;

import com.nuance.ndi.demo.paint.command.Command;

public interface CommandExecutionStep {

	void execute(final Command command);
	
	<T extends CommandExecutionStep> T next(T next);
	
}
