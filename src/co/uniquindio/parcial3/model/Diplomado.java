package co.uniquindio.parcial3.model;

import java.util.ArrayList;
import java.util.List;

import co.uniquindio.parcial3.others.CupoLlenoException;
import co.uniquindio.parcial3.others.EstudianteExistenteException;

public class Diplomado {

    private final static String nombre = "Programacion en java";
    private final static int cupo = 10;
    private Estudiante[] listEstudiantes;
    private static Diplomado instancia;

    public Diplomado() {
        super();
        this.listEstudiantes = new Estudiante[cupo];
        quemarDatosEstudiantes();
    }

    public Estudiante[] getListEstudiantes() {
        return listEstudiantes;
    }

    public void setListEstudiantes(Estudiante[] listEstudiantes) {
        this.listEstudiantes = listEstudiantes;
    }

    public static String getNombre() {
        return nombre;
    }

    public static int getCupo() {
        return cupo;
    }

    /**
     * Agrega un estudiante a la lista de estudiantes si no existe un estudiante con el mismo nombre y número de identificación.
     * El estudiante se agrega en la primera posición libre encontrada en el arreglo.
     *
     * @param nombre            El nombre del estudiante a agregar.
     * @param genero            El género del estudiante a agregar.
     * @param numIdentificacion El número de identificación del estudiante a agregar.
     * @param notasEstudiante   Un arreglo de notas del estudiante a agregar.
     * @return true si el estudiante fue agregado exitosamente, false si no se pudo agregar.
     * @throws CupoLlenoException 
     */
    public Boolean agregarEstudiante(String nombre, TipoGenero genero, String numIdentificacion, Float[] notasEstudiante) throws EstudianteExistenteException, CupoLlenoException {
        if (!verificarEstudiante(numIdentificacion)) {
            Estudiante estudiante = new Estudiante(nombre, genero, numIdentificacion, notasEstudiante);
            List<Integer> posicionesLibres = encontrarPosicionesLibres(listEstudiantes);
            if (!posicionesLibres.isEmpty()) {
                int posicionLibre = posicionesLibres.get(0);
                listEstudiantes[posicionLibre] = estudiante;
                return true;
            } else {
                throw new CupoLlenoException("No hay cupos disponibles");
            }
        } else {
            throw new EstudianteExistenteException("Ya existe un estudiante registrado con ese id");
        }
    }


    /**
     * Verifica si existe un estudiante en la lista con el número de identificación.
     *
     * @param numIdentificacion El número de identificación del estudiante a verificar.
     * @return true si el estudiante existe en la lista, false si no existe.
     */
    public boolean verificarEstudiante(String numIdentificacion) {
        for (Estudiante estudiante : listEstudiantes) {
            if (estudiante != null && estudiante.getNumIdentificacion().equals(numIdentificacion)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Encuentra las posiciones libres en el arreglo de estudiantes.
     *
     * @param lisEstudiantes El arreglo de estudiantes en el cual buscar posiciones libres.
     * @return Una lista de posiciones libres en el arreglo.
     */
    private List<Integer> encontrarPosicionesLibres(Estudiante[] lisEstudiantes) {
        List<Integer> posicionesLibres = new ArrayList<>();
        for (int i = 0; i < lisEstudiantes.length; i++) {
            if (listEstudiantes[i] == null) {
                posicionesLibres.add(i);
            }
        }
        return posicionesLibres;
    }

    /**
     * Calcula el promedio de notas de un estudiante.
     *
     * @param estudiante El estudiante del cual se desea calcular el promedio.
     * @return El promedio de notas del estudiante.
     */
    public float calcularPromedioEstudiante(Estudiante estudiante) {
        if (estudiante != null && estudiante.getListNotas() != null) {
            Float[] notasEstudiante = estudiante.getListNotas();
            float suma = 0;
            for (float nota : notasEstudiante) {
                suma += nota;
            }
            return suma / notasEstudiante.length;
        }
        return 0;
    }

    /**
     * Obtiene un estudiante de la lista de estudiantes por su número de identificación.
     *
     * @param numIdentificacion El número de identificación del estudiante a obtener.
     * @return El estudiante encontrado o null si no se encontró ningún estudiante con ese número de identificación.
     */
    public Estudiante obtenerEstudiante(String numIdentificacion) {
        for (Estudiante estudiante : listEstudiantes) {
            if (estudiante != null && estudiante.getNumIdentificacion().equals(numIdentificacion)) {
                return estudiante;
            }
        }
        return null;
    }

    /**
     * Obtiene el estudiante con el mejor promedio de notas.
     *
     * @return El estudiante con el mejor promedio de notas o null si no hay estudiantes registrados.
     */
    public Estudiante obtenerEstudianteConMejorPromedio() {
        Estudiante estudianteConMejorPromedio = null;
        float mejorPromedio = 0;
        for (Estudiante estudiante : listEstudiantes) {
            if (estudiante != null) {
                float promedio = calcularPromedioEstudiante(estudiante);
                if (promedio > mejorPromedio) {
                    mejorPromedio = promedio;
                    estudianteConMejorPromedio = estudiante;
                }
            }
        }
        return estudianteConMejorPromedio;
    }

    public void quemarDatosEstudiantes() {
    	Estudiante estudiante1 = new Estudiante("Holdan", TipoGenero.MASCULINO, "001", new Float[]{4.5f, 3.8f, 4.2f, 3.9f, 4.1f});
    	Estudiante estudiante2 = new Estudiante("Mary", TipoGenero.FEMENINO, "002", new Float[]{3.7f, 4.0f, 4.1f, 3.5f, 3.9f});
    	Estudiante estudiante3 = new Estudiante("Juan", TipoGenero.MASCULINO, "003", new Float[]{4.2f, 3.9f, 4.4f, 4.1f, 4.3f});
    	Estudiante estudiante4 = new Estudiante("Sol", TipoGenero.FEMENINO, "004", new Float[]{3.5f, 4.2f, 4.0f, 3.8f, 3.9f});
    	Estudiante estudiante5 = new Estudiante("Norbey", TipoGenero.OTRO, "005", new Float[]{4.1f, 3.7f, 3.9f, 4.0f, 3.8f});
    	Estudiante estudiante6 = new Estudiante("Jose", TipoGenero.MASCULINO, "006", new Float[]{3.8f, 4.0f, 4.2f, 3.6f, 3.9f});
    	Estudiante estudiante7 = new Estudiante("Natalia", TipoGenero.FEMENINO, "007", new Float[]{4.3f, 3.5f, 4.1f, 3.7f, 4.0f});
    	Estudiante estudiante8 = new Estudiante("David", TipoGenero.MASCULINO, "008", new Float[]{3.9f, 4.2f, 3.8f, 4.0f, 3.6f});
    	Estudiante estudiante9 = new Estudiante("Tatiana", TipoGenero.FEMENINO, "009", new Float[]{4.0f, 3.7f, 4.3f, 3.5f, 4.1f});

    	listEstudiantes[0] = estudiante1;
    	listEstudiantes[1] = estudiante2;
    	listEstudiantes[2] = estudiante3;
    	listEstudiantes[3] = estudiante4;
    	listEstudiantes[4] = estudiante5;
    	listEstudiantes[5] = estudiante6;
    	listEstudiantes[6] = estudiante7;
    	listEstudiantes[7] = estudiante8;
    	listEstudiantes[8] = estudiante9;

    }

    /**
     * Obtiene la instancia única del diplomado (implementación del patrón Singleton).
     *
     * @return La instancia del diplomado.
     */
    public static Diplomado getInstancia() {
        if (instancia == null) {
            instancia = new Diplomado();
        }
        return instancia;
    }

    /**
     * Calcula el promedio de promedios de todos los estudiantes registrados.
     *
     * @return El promedio de promedios de los estudiantes, 0 si no hay estudiantes registrados.
     */
    public float calcularPromedioDePromedios() {
        int totalEstudiantes = 0;
        float sumaPromedios = 0;

        for (Estudiante estudiante : listEstudiantes) {
            if (estudiante != null) {
                float promedioEstudiante = calcularPromedioEstudiante(estudiante);
                sumaPromedios += promedioEstudiante;
                totalEstudiantes++;
            }
        }

        if (totalEstudiantes > 0) {
            return sumaPromedios / totalEstudiantes;
        } else {
            return 0;
        }
    }
}

