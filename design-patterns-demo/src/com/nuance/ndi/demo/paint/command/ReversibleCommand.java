package com.nuance.ndi.demo.paint.command;


public interface ReversibleCommand extends Command{
	
	void rollback();
	
}
