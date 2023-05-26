package co.uniquindio.parcial3.controllers;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class VentanaMensajeController {
	@FXML
	private Button btnAceptar;
	@FXML
	private TextArea txtArea;
	private String cadena;

	// Event Listener on Button[#btnAceptar].onAction
	@FXML
	public void aceptar(ActionEvent event) {
        Stage stage = (Stage) btnAceptar.getScene().getWindow();
        stage.close();
	}

	public void setCadena(String mensaje){
		this.cadena = mensaje;
	}

	@FXML
	public void initialize() {
		txtArea.setText(cadena);
	}



}
