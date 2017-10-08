package com.nuance.ndi.demo.paint.command;

import com.nuance.ndi.demo.paint.User;

public class LoginCommand implements Command {

	private final String[] tokens;
	private final User authenticUser = new User("parag","parag"); // Code smell : hard coded value object
	
	public LoginCommand(final String[] tokens) {
		this.tokens = tokens;
	}

	@Override
	public void execute() {
		final User user = new User(tokens[0], tokens[1]);
		if(!user.equals(authenticUser)) {
			throw new AuthenticationException("Invalid username or password");
		}
	}

}
