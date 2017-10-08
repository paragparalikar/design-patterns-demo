package com.nuance.ndi.demo.paint.command.chain;

import com.nuance.ndi.demo.paint.command.Command;

//$DP$ - Null Object
public class NullCommandExecutionStep implements CommandExecutionStep {

	@Override
	public void execute(Command command) {

	}
	
	public <T extends CommandExecutionStep> T next(T next) {
		throw new UnsupportedOperationException();
	}

}
