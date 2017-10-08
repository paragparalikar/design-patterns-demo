package com.nuance.ndi.demo.paint.command;

import javafx.application.Platform;

public class ExitCommand implements Command {
	
	@Override
	public void execute() {
		Platform.exit();
	}

}
