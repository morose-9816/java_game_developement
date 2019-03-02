package com.vinayakbh_19;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	private Controller controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
		GridPane rootGridPane = loader.load();
		controller = loader.getController();
		controller.createPlayground();


		Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
		MenuBar menuBar = createMenu();
		menuPane.getChildren().add(menuBar);
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());


		Scene scene = new Scene(rootGridPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Connect 4");
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public MenuBar createMenu() {
		Menu fileMenu = new Menu("File");
		MenuItem newGame = new MenuItem("New Game");
		MenuItem resetGame = new MenuItem("Reset Game");
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitGame = new MenuItem("Quit Game");
		fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, quitGame);
		newGame.setOnAction(event -> controller.resetGame());
		resetGame.setOnAction(event -> controller.resetGame());
		quitGame.setOnAction(event -> exitGame());


		Menu helpMenu = new Menu("Help");
		MenuItem aboutMe = new MenuItem("About the Developer");
		MenuItem aboutGame = new MenuItem("About Connect 4 Game");
		SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();
		helpMenu.getItems().addAll(aboutMe, separatorMenuItem1, aboutGame);
		aboutMe.setOnAction(event -> aboutMe());
		aboutGame.setOnAction(event -> aboutGame());
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);
		return menuBar;


	}

	private void aboutGame() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Connect 4");
		alert.setHeaderText("How to Play");
		alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves.");
		alert.show();
	}

	private void aboutMe() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Me");
		alert.setHeaderText("I am Vinayak Bhardwaj");
		alert.setContentText("This is my very first Java Application and I love challenges");
		alert.show();
	}

	private void exitGame() {
		Platform.exit();
		System.exit(0);
	}

	private void resetGame() {
	}

}
