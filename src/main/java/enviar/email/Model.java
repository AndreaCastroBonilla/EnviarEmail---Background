package enviar.email;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {

	private StringProperty nombreServidor = new SimpleStringProperty();
	private StringProperty puerto = new SimpleStringProperty();
	private StringProperty emailRemitente = new SimpleStringProperty();
	private StringProperty emailDestinatario = new SimpleStringProperty();
	private StringProperty asunto = new SimpleStringProperty();
	private StringProperty mensaje = new SimpleStringProperty();
	private BooleanProperty usarSSL = new SimpleBooleanProperty();

	public final StringProperty nombreServidorProperty() {
		return this.nombreServidor;
	}

	public final String getNombreServidor() {
		return this.nombreServidorProperty().get();
	}

	public final void setNombreServidor(final String nombreServidor) {
		this.nombreServidorProperty().set(nombreServidor);
	}

	public final StringProperty puertoProperty() {
		return this.puerto;
	}

	public final String getPuerto() {
		return this.puertoProperty().get();
	}

	public final void setPuerto(final String puerto) {
		this.puertoProperty().set(puerto);
	}

	public final StringProperty emailRemitenteProperty() {
		return this.emailRemitente;
	}

	public final String getEmailRemitente() {
		return this.emailRemitenteProperty().get();
	}

	public final void setEmailRemitente(final String emailRemitente) {
		this.emailRemitenteProperty().set(emailRemitente);
	}

	public final StringProperty emailDestinatarioProperty() {
		return this.emailDestinatario;
	}

	public final String getEmailDestinatario() {
		return this.emailDestinatarioProperty().get();
	}

	public final void setEmailDestinatario(final String emailDestinatario) {
		this.emailDestinatarioProperty().set(emailDestinatario);
	}

	public final StringProperty asuntoProperty() {
		return this.asunto;
	}

	public final String getAsunto() {
		return this.asuntoProperty().get();
	}

	public final void setAsunto(final String asunto) {
		this.asuntoProperty().set(asunto);
	}

	public final StringProperty mensajeProperty() {
		return this.mensaje;
	}

	public final String getMensaje() {
		return this.mensajeProperty().get();
	}

	public final void setMensaje(final String mensaje) {
		this.mensajeProperty().set(mensaje);
	}

	public final BooleanProperty usarSSLProperty() {
		return this.usarSSL;
	}

	public final boolean isUsarSSL() {
		return this.usarSSLProperty().get();
	}

	public final void setUsarSSL(final boolean usarSSL) {
		this.usarSSLProperty().set(usarSSL);
	}

}
