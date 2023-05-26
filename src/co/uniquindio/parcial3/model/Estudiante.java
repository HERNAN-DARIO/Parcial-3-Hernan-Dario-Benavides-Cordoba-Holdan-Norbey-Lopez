package co.uniquindio.parcial3.model;

import java.util.Arrays;

public class Estudiante {
	private String nombre;
	private TipoGenero genero;
	private String numIdentificacion;
	private Float[] listNotas;

	public Estudiante() {
		super();
	}

	public Estudiante(String nombre, TipoGenero genero, String numIdentificacion, Float[] listNotas) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.numIdentificacion = numIdentificacion;
		this.listNotas = listNotas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoGenero getGenero() {
		return genero;
	}

	public void setGenero(TipoGenero genero) {
		this.genero = genero;
	}

	public String getNumIdentificacion() {
		return numIdentificacion;
	}

	public void setNumIdentificacion(String numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}

	public Float[] getListNotas() {
		return listNotas;
	}

	public void setListNotas(Float[] listNotas) {
		this.listNotas = listNotas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numIdentificacion == null) ? 0 : numIdentificacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numIdentificacion == null) {
			if (other.numIdentificacion != null)
				return false;
		} else if (!numIdentificacion.equals(other.numIdentificacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nEstudiante:\nNombre = " + nombre + "\nGenero = " + genero + "\nIdentificacion = " + numIdentificacion
				+ "\nNotas = " + Arrays.asList(listNotas);
	}

	/**
	 * Calcula el promedio de las notas del estudiante.
	 *
	 * @return El promedio de las notas del estudiante, o null si no hay notas registradas.
	 */
	public Float calcularPromedioNotas() {
		if (listNotas != null && listNotas.length > 0) {
			float sumaNotas = 0f;
			for (Float nota : listNotas) {
				sumaNotas += nota;
			}
			return sumaNotas / listNotas.length;
		}
		return null;
	}



}
