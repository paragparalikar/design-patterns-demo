package com.nuance.ndi.demo.paint.ui.info;

import java.util.Observable;
import java.util.Observer;

import com.nuance.ndi.demo.paint.ui.Container;
import com.nuance.ndi.demo.paint.ui.Presenter;

import javafx.application.Platform;

public class InfoPresenter implements Presenter, Observer {

	private final InfoView infoView = new InfoView();

	@Override
	public void present(final Container container) {
		container.setBottom(infoView.getNode());
	}

	@Override
	public void update(Observable observable, Object arg) {
		Platform.runLater(() -> {
			infoView.add(observable.toString());
		});
	}

}
