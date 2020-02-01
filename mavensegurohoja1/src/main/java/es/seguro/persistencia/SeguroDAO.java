package es.seguro.persistencia;

import java.util.List;

import es.seguro.modelo.Asistencia;
import es.seguro.modelo.Seguro;

public interface SeguroDAO extends GenericDAO <Seguro,Integer>  {
	
	public List<Seguro>  todosSeguros();
	public List<Object[]> verNIFyNombre();
	public String verMariaLozano(String nombre, String apellido1, String apellido2);
	public List<Asistencia> verAsistenciaMayorDiezMil();
	public List<Integer> obtenerIdAsistenciaMedica();
	public int sumaImporteAsistenciaMedica();
	public int salarioMedioAsistenciaMedica();
	public Integer cuantosSeguros();
	public List<Object[]> mostrarSeguroNombreNifAsistencias();
	public List <Object[]> obtenerObjetosSeguro();
	public void  conseguirSegurosIdMedicaVeridAsistencia();
	
	

}
