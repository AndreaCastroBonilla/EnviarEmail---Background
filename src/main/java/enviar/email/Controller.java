package enviar.email;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import enviar.email.main.EnviarEmailApp;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller implements Initializable {

	// model
	Model model = new Model();

	private StringProperty estado = new SimpleStringProperty();
	private IntegerProperty progreso = new SimpleIntegerProperty();
	private BooleanProperty ejecutando = new SimpleBooleanProperty();

	private Task<Void> tarea;

	// view
	private Alert alert;
	@FXML
	private GridPane view;
	@FXML
	private TextField ipServidorText, puertoText, remitenteText, destinatarioText, contraseñaText, asuntoText;
	@FXML
	private TextArea mensajeTextArea;
	@FXML
	private CheckBox conexionCheckBox;
	@FXML
	private Button aceptarButton, vaciarButton, cerrarButton;

	public Controller() throws IOException {

		// cargar FXML
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// bindings
		model.nombreServidorProperty().bind(ipServidorText.textProperty());
		model.puertoProperty().bind(puertoText.textProperty());
		model.emailRemitenteProperty().bind(remitenteText.textProperty());
		model.emailDestinatarioProperty().bind(destinatarioText.textProperty());
		model.mensajeProperty().bind(mensajeTextArea.textProperty());

		aceptarButton.setOnAction(e -> onAceptarAction(e));
		vaciarButton.setOnAction(e -> onVaciarAction(e));
		cerrarButton.setOnAction(e -> onCerrarAction(e));

		aceptarButton.disableProperty().bind(ejecutando);

	}

	private void onCerrarAction(ActionEvent e) {
		EnviarEmailApp.primaryStage.close();
	}

	private void onVaciarAction(ActionEvent e) {
		ipServidorText.setText("");
		puertoText.setText("");
		remitenteText.setText("");
		destinatarioText.setText("");
		asuntoText.setText("");
		remitenteText.setText("");
		contraseñaText.setText("");
		mensajeTextArea.setText("");

	}

	private void onAceptarAction(ActionEvent event) {

		tarea = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				if (model.isUsarSSL()) {
					envioCorrecto();

				} else {
					envioIncorrecto();
				}
				updateMessage("Proceso terminado");
				return null;
			}
		};

		tarea.setOnSucceeded(e -> {
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Mensaje enviado");
			alert.setHeaderText("Mensaje enviado con éxtito " + destinatarioText.getText());
			alert.showAndWait();
		});

		tarea.setOnFailed(e -> {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No se pudo enviar el email");
			alert.setContentText("Invalid message supplied");
			alert.showAndWait();
		});

		tarea.setOnCancelled(e -> {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Cancelado");
			alert.setHeaderText("Se canceló la tarea");
			alert.setContentText(e.getSource().getMessage());
			alert.showAndWait();

			progreso.unbind();
			estado.unbind();

			progreso.set(0);
			estado.set("Tarea cancelada");
		});

		estado.bind(tarea.messageProperty());
		ejecutando.bind(tarea.runningProperty());

		new Thread(tarea).start();

	}

	private void envioIncorrecto() {
		alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("No se pudo enviar el email");
		alert.setContentText("Invalid message supplied");
		alert.showAndWait();
	}

	private void envioCorrecto() {
		alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Mensaje enviado");
		alert.setHeaderText("Mensaje enviado con éxtito " + destinatarioText.getText());
		alert.showAndWait();
	}

	public GridPane getView() {
		return view;
	}

}
