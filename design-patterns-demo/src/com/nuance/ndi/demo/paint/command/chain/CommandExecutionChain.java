package com.nuance.ndi.demo.paint.command.chain;

import java.util.LinkedList;
import java.util.List;

import com.nuance.ndi.demo.paint.command.Command;
import com.nuance.ndi.demo.paint.command.ReversibleCommand;

//$DP$ - Chain of Responsibility
public class CommandExecutionChain {
	
	private int currentCommandIndex;
	private final CommandExecutionStep head;
	private final List<ReversibleCommand> commands = new LinkedList<>(); //$DP$ - Memento
	
	public CommandExecutionChain(final CommandExecutionStep head) {
		this.head = head;
	}
	
	public void submit(final Command command) {
		head.execute(command);
	}
	
	public ReversibleCommand getCommand(final int index) {
		if(0 <= index && index < commands.size()) {
			return commands.get(index);
		}
		return null;
	}
	
	public void append(final ReversibleCommand command) {
		if(currentCommandIndex < commands.size() - 1) {
			commands.removeAll(commands.subList(currentCommandIndex+1, commands.size()));
		}
		commands.add(command);
		currentCommandIndex = commands.size() - 1;
	}
	
	public int getCurrentCommandIndex() {
		return currentCommandIndex;
	}
	
	public void setCurrentCommandIndex(int currentCommandIndex) {
		this.currentCommandIndex = currentCommandIndex;
	}

}
