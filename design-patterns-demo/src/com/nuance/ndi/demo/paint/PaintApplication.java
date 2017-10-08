package com.nuance.ndi.demo.paint;

import com.nuance.ndi.demo.paint.command.CommandFactory;
import com.nuance.ndi.demo.paint.command.CommandInterpreter;
import com.nuance.ndi.demo.paint.command.chain.AuditCommandExecutionStep;
import com.nuance.ndi.demo.paint.command.chain.AuthenticationCommandExecutionStep;
import com.nuance.ndi.demo.paint.command.chain.CommandExecutionChain;
import com.nuance.ndi.demo.paint.command.chain.ExecutingCommandExecutionStep;
import com.nuance.ndi.demo.paint.command.chain.NullCommandExecutionStep;
import com.nuance.ndi.demo.paint.ui.CommandLineListener;
import com.nuance.ndi.demo.paint.ui.Container;
import com.nuance.ndi.demo.paint.ui.FrontController;
import com.nuance.ndi.demo.paint.ui.drawing.DrawingPresenter;
import com.nuance.ndi.demo.paint.ui.info.InfoPresenter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PaintApplication extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		final BorderPane root = new BorderPane();
		final InfoPresenter infoPresenter = new InfoPresenter();
		final Container container = Container.builder(stage, new Scene(root), root).maximized(true)
				.drawingPresenter(new DrawingPresenter(infoPresenter)).infoPresenter(infoPresenter).build();
		container.show();

		final AuthenticationCommandExecutionStep head = new AuthenticationCommandExecutionStep();
		final CommandExecutionChain commandExecutionChain = new CommandExecutionChain(head);
		head.next(new ExecutingCommandExecutionStep()).next(new AuditCommandExecutionStep(commandExecutionChain))
				.next(new NullCommandExecutionStep());

		final CommandFactory commandFactory = new CommandFactory(container, commandExecutionChain);
		final CommandInterpreter commandInterpreter = new CommandInterpreter(commandFactory);
		final FrontController frontController = new FrontController(commandInterpreter, commandExecutionChain);
		final CommandLineListener commandLineListener = new CommandLineListener(System.in, frontController);
		startCLIService(commandLineListener);
	}

	private void startCLIService(final CommandLineListener commandLineListener) {
		final Thread thread = new Thread() {
			public void run() {
				commandLineListener.listen();
			};
		};
		thread.setDaemon(true);
		thread.start();
	}

}
