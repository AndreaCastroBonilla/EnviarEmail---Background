package enviar.email.main;

import enviar.email.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EnviarEmailApp extends Application {

	public static Stage primaryStage;
	private Controller controller;

	@Override
	public void start(Stage primaryStage) throws Exception {

		EnviarEmailApp.primaryStage = primaryStage;

		controller = new Controller();

		primaryStage.setTitle("Enviar email");
		primaryStage.setScene(new Scene(controller.getView()));
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
