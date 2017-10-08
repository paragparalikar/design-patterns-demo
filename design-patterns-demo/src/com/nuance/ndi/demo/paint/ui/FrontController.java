package com.nuance.ndi.demo.paint.ui;

import com.nuance.ndi.demo.paint.command.CommandInterpreter;
import com.nuance.ndi.demo.paint.command.chain.CommandExecutionChain;

//$DP$ - Front Controller
public class FrontController {

	private final CommandInterpreter commandInterpreter;
	private final CommandExecutionChain commandExecutionChain;

	public FrontController(final CommandInterpreter commandInterpreter,
			final CommandExecutionChain commandExecutionChain) {
		this.commandInterpreter = commandInterpreter;
		this.commandExecutionChain = commandExecutionChain;
	}

	public void service(final String request) {
		if (null != request && 0 < request.length()) {
			try {
				commandExecutionChain.submit(commandInterpreter.interpret(request));
			}catch(final UnsupportedOperationException uoe) { 
				System.out.println("This operation is not supported");
			}catch (final Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

}
