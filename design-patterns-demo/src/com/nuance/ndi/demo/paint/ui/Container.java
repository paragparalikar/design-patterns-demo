package com.nuance.ndi.demo.paint.ui;

import com.nuance.ndi.demo.paint.ui.drawing.DrawingPresenter;
import com.nuance.ndi.demo.paint.ui.info.InfoPresenter;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Container {
	
	private final Stage stage;
	private final Scene scene;
	private final BorderPane root;
	
	private boolean maximized;
	private InfoPresenter infoPresenter;
	private DrawingPresenter drawingPresenter;
	
	//$DP$ - Builder
	public static class Builder{
		
		private final Stage stage;
		private final Scene scene;
		private final BorderPane root;
		
		private boolean maximized;
		private InfoPresenter infoPresenter;
		private DrawingPresenter drawingPresenter;
		
		
		public Builder(final Stage stage, final Scene scene, final BorderPane root) {
			this.stage = stage;
			this.scene = scene;
			this.root = root;
		}
		
		public Builder maximized(final boolean value) {
			this.maximized = value;
			return this;
		}
		
		public Builder drawingPresenter(final DrawingPresenter presenter) {
			this.drawingPresenter = presenter;
			return this;
		}
		
		public Builder infoPresenter(final InfoPresenter infoPresenter) {
			this.infoPresenter = infoPresenter;
			return this;
		}

		public Stage getStage() {
			return stage;
		}

		public Scene getScene() {
			return scene;
		}

		public BorderPane getRoot() {
			return root;
		}

		public boolean isMaximized() {
			return maximized;
		}

		public DrawingPresenter getDrawingPresenter() {
			return drawingPresenter;
		}
		
		public InfoPresenter getInfoPresenter() {
			return infoPresenter;
		}
		
		public Container build() {
			return new Container(this);
		}
		
	}
	
	public static Builder builder(final Stage stage, final Scene scene, final BorderPane root) {
		return new Builder(stage, scene, root);
	}
	
	private Container(final Builder builder) {
		this.stage = builder.getStage();
		this.scene = builder.getScene();
		this.root = builder.getRoot();
		this.maximized = builder.isMaximized();
		this.infoPresenter = builder.getInfoPresenter();
		this.drawingPresenter = builder.getDrawingPresenter();
		assemble();
	}
	
	private void assemble() {
		scene.setRoot(root);
		stage.setScene(scene);
		stage.setMaximized(maximized);
	}
	
	public void show() {
		if(null != drawingPresenter) {
			drawingPresenter.present(this);
		}
		if(null != infoPresenter) {
			infoPresenter.present(this);
		}
		stage.show();
	}
	
	public DrawingPresenter getDrawingPresenter() {
		return drawingPresenter;
	}
	
	public Parent getNode() {
		return root;
	}
	
	public void setCenter(final Node node) {
		root.setCenter(node);
	}
	
	public void setBottom(final Node node) {
		root.setBottom(node);
	}
	
}
