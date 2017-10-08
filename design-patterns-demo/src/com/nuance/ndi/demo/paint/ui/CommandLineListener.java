package com.nuance.ndi.demo.paint.ui;

import java.io.InputStream;
import java.util.Scanner;

//$DP$ - Listener
public class CommandLineListener {

	private final Scanner scanner;
	private final FrontController frontController;

	public CommandLineListener(final InputStream inputStream, final FrontController frontController) {
		this.scanner = new Scanner(inputStream);
		this.frontController = frontController;
	}

	public void listen() {
		String text = "";
		while (true) {
			System.out.print("> ");
			text = scanner.nextLine();
			frontController.service(text);
		}
	}

}
