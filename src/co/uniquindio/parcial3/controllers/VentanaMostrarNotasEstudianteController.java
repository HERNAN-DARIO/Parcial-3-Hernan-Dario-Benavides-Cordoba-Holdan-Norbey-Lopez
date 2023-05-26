package co.uniquindio.parcial3.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import co.uniquindio.parcial3.model.Diplomado;
import co.uniquindio.parcial3.model.Estudiante;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class VentanaMostrarNotasEstudianteController {
	@FXML
	private TextField txtIde;
	@FXML
	private Button btnVolver;
	@FXML
	private Button btnAceptar;
	@FXML
	private Label label;

	// Event Listener on Button[#btnVolver].onAction
	@FXML
	public void volver(ActionEvent event) {
		try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/uniquindio/parcial3/views/VentanaPrincipal.fxml"));
	        Parent root = loader.load();
	        Scene scene = new Scene(root);
	        Stage stage = new Stage();
	        stage.setScene(scene);
	        stage.show();
	        ((Node)(event.getSource())).getScene().getWindow().hide();
	    } catch (IOException ex) {
	        System.out.println("Error al abrir la ventana VentanaPrincipal: " + ex.getMessage());
	    }
	}
	// Event Listener on Button[#btnAceptar].onAction
	@FXML
	public void aceptar(ActionEvent event) {
		String ide = txtIde.getText();
		Boolean isEstudiante = Diplomado.getInstancia().verificarEstudiante(ide);
		if(isEstudiante){
			Estudiante estudiante = Diplomado.getInstancia().obtenerEstudiante(ide);
			abrirVentanaMensaje(event, "El promedio del estudiante es: " + Diplomado.getInstancia().calcularPromedioEstudiante(estudiante));
		}else{
			mostrarAlerta();
		}
	}
	private void mostrarAlerta() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerta de Información");
        alert.setHeaderText("Alerta de información");
        alert.setContentText("El numero de identificacion ingresado no se encuentra registrado");
        alert.showAndWait();
	}
	private void abrirVentanaMensaje(ActionEvent event, String mensaje) {
		try {
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/uniquindio/parcial3/views/VentanaMensaje.fxml"));
		    Parent root = loader.load();
		    Scene scene = new Scene(root);
		    Stage stage = new Stage();
		    stage.setScene(scene);
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.showAndWait();

		    VentanaMensajeController controller = loader.getController();
		    controller.setCadena(mensaje);
		} catch (IOException ex) {
		    System.out.println("Error al abrir la ventana VentanaMensaje: " + ex.getMessage());
		}
	}
}
