package test;

import java.util.Arrays;
import java.util.List;

import co.uniquindio.parcial3.model.Diplomado;
import co.uniquindio.parcial3.model.Estudiante;

public class Main {

	public static void main(String[] args) {
		Diplomado diplomado = Diplomado.getInstancia();
		List<Estudiante> lista = Arrays.asList(diplomado.getListEstudiantes());
		System.out.println(lista);
	}

}
