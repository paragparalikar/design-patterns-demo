package com.nuance.ndi.demo.paint.command.chain;

import com.nuance.ndi.demo.paint.command.Command;

import javafx.application.Platform;

public class ExecutingCommandExecutionStep implements CommandExecutionStep {

	private CommandExecutionStep next;

	public <T extends CommandExecutionStep> T next(T next) {
		this.next = next;
		return next;
	}

	@Override
	public void execute(final Command command) {
		if (Platform.isFxApplicationThread()) {
			doExecute(command);
		} else {
			Platform.runLater(() -> {
				doExecute(command);
			});
		}
	}

	private void doExecute(final Command command) {
		command.execute();
		if (null != next) {
			next.execute(command);
		}
	}

}
