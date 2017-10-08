package com.nuance.ndi.demo.paint.ui.info;

import com.nuance.ndi.demo.paint.ui.View;

import javafx.scene.Node;
import javafx.scene.control.ListView;

public class InfoView implements View{
	
	private final ListView<String> listView = new ListView<>();

	public InfoView() {
		listView.setPrefHeight(300);
	}
	
	@Override
	public Node getNode() {
		return listView;
	}
	
	public void add(final String message) {
		listView.getItems().add(message);
	}

}
