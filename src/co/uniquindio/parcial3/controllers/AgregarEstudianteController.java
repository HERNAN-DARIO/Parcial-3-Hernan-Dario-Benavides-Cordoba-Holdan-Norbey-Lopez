package co.uniquindio.parcial3.controllers;


import co.uniquindio.parcial3.model.Diplomado;
import co.uniquindio.parcial3.model.TipoGenero;
import co.uniquindio.parcial3.others.CupoLlenoException;
import co.uniquindio.parcial3.others.EstudianteExistenteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class AgregarEstudianteController {
    @FXML
    private TextField txtNota1;
    @FXML
    private TextField txtNota2;
    @FXML
    private TextField txtNota3;
    @FXML
    private TextField txtNota4;
    @FXML
    private TextField txtNota5;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtIdentificacion;
    @FXML
    private Button btnAceptar;
    @FXML
    private ComboBox<String> comboBox;

    public void initialize() {
        ObservableList<String> generos = FXCollections.observableArrayList("Masculino","Femenino","Otro");
        comboBox.setItems(generos);
    }

    // Evento del botón btnAceptar
    @FXML
    public void agregarEstudiante(ActionEvent event) {
       String nombre = txtNombre.getText();
       TipoGenero genero = determinarTipoGenero(comboBox.getValue());
       String ide = txtIdentificacion.getText();

       Float nota1 = Float.parseFloat(txtNota1.getText());
       Float nota2 = Float.parseFloat(txtNota2.getText());
       Float nota3 = Float.parseFloat(txtNota3.getText());
       Float nota4 = Float.parseFloat(txtNota4.getText());
       Float nota5 = Float.parseFloat(txtNota5.getText());

       try {
    	    boolean isEstudiante = Diplomado.getInstancia().agregarEstudiante(nombre, genero, ide, new Float[]{nota1, nota2, nota3, nota4, nota5});
    	    if (isEstudiante) {
    	    	mostrarAlerta("Registro Exitoso");
    	    }
    	} catch (CupoLlenoException e) {
    	    	mostrarAlerta("No hay cupos");
    	} catch (EstudianteExistenteException e) {
	    	mostrarAlerta("Ya existe un usuario registrado con este ID");
	    }



    }


	private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerta de Información");
        alert.setHeaderText("Alerta de información");
        alert.setContentText(mensaje);
        alert.showAndWait();
	}
	private TipoGenero determinarTipoGenero(String value) {
		if(value.equals("Masculino")){
			return TipoGenero.MASCULINO;
		}else if(value.equals("Femenino")){
			return TipoGenero.FEMENINO;
		}else{
			return TipoGenero.OTRO;
		}
	}
}

