package co.uniquindio.parcial3.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

import co.uniquindio.parcial3.model.Diplomado;
import co.uniquindio.parcial3.model.Estudiante;
import javafx.event.ActionEvent;

public class VentanaPrincipalController {
	@FXML
	private Button mostrarNotasEstudiante;
	@FXML
	private Button mostrarListaEstudiantes;
	@FXML
	private Button mostrarPromGeneral;
	@FXML
	private Button mostrarEstudianteMayorNota;
	@FXML
	private Button agregarEstudiante;

	// Event Listener on Button[#mostrarNotasEstudiante].onAction
	@FXML
	public void mostrarNotasEstudiante(ActionEvent event) {
		mostrarVentanaMostrarNotasEstudiante(event);
	}
	private void mostrarVentanaMostrarNotasEstudiante(ActionEvent event) {
		try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/uniquindio/parcial3/views/VentanaMostrarNotasEstudiante.fxml"));
	        Parent root = loader.load();
	        Scene scene = new Scene(root);
	        Stage stage = new Stage();
	        stage.setScene(scene);
	        stage.show();
	        ((Node)(event.getSource())).getScene().getWindow().hide();
	    } catch (IOException ex) {
	        System.out.println("Error al abrir la ventana VentanaMostrarNotasEstudiante: " + ex.getMessage());
	    }
	}



	// Event Listener on Button[#mostrarListaEstudiantes].onAction
	@FXML
	public void mostrarListaEstudiantes(ActionEvent event) {
		StringBuilder sb = new StringBuilder();
		for (Estudiante elemento : Arrays.asList(Diplomado.getInstancia().getListEstudiantes())) {
		    sb.append(elemento);
		    sb.append("\n");
		}
		String lista = sb.toString();
		abrirVentanaMensaje(event, "Los estudiantes inscritos son:\n" + lista);
	}



	// Event Listener on Button[#mostrarPromGeneral].onAction
	@FXML
	public void mostrarPromGeneral(ActionEvent event) {
		Float promGrupo = Diplomado.getInstancia().calcularPromedioDePromedios();
		abrirVentanaMensaje(event, "El promedio del grupo es: " + promGrupo);
	}



	// Event Listener on Button[#mostrarEstudianteMayorNota].onAction
	@FXML
	public void mostrarEstudianteMayorNota(ActionEvent event) {
		Estudiante estudiante = Diplomado.getInstancia().obtenerEstudianteConMejorPromedio();
		abrirVentanaMensaje(event, "El estudiante con mejor promedio es: " + estudiante);
	}




	// Event Listener on Button[#agregarEstudiante].onAction
	@FXML
	public void agregarEstudiante(ActionEvent event) {
		abrirVentanaAgregarEstudiante(event);
	}
	private void abrirVentanaAgregarEstudiante(ActionEvent event) {
		try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/uniquindio/parcial3/views/AgregarEstudiante.fxml"));
	        Parent root = loader.load();
	        Scene scene = new Scene(root);
	        Stage stage = new Stage();
	        stage.setScene(scene);
	        stage.show();
	        ((Node)(event.getSource())).getScene().getWindow().hide();
	    } catch (IOException ex) {
	        System.out.println("Error al abrir la ventana AgregarEstudiante: " + ex.getMessage());
	    }
	}

	private void abrirVentanaMensaje(ActionEvent event, String mensaje) {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/uniquindio/parcial3/views/VentanaMensaje.fxml"));
	        Parent root = loader.load();
	        Scene scene = new Scene(root);
	        Stage stage = new Stage();
	        stage.setScene(scene);
	        stage.initModality(Modality.APPLICATION_MODAL);

	        VentanaMensajeController controller = loader.getController();
	        controller.setCadena(mensaje);
	        controller.initialize();

	        stage.show();
	    } catch (IOException ex) {
	        System.out.println("Error al abrir la ventana VentanaMensaje: " + ex.getMessage());
	    }
	}


}
