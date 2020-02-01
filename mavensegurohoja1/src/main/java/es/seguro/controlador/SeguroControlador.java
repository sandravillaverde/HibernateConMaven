package es.seguro.controlador;

import es.seguro.persistencia.SeguroDAO;
import es.seguro.persistencia.SeguroDAOImpl;
import java.util.List;

import es.seguro.modelo.Asistencia;
import es.seguro.modelo.Cobertura;
import es.seguro.modelo.Enfermedad;
import es.seguro.modelo.Seguro;
import es.seguro.persistencia.Utilidades;


public class SeguroControlador {
	//En esta clase haremos las llamadas a los metodos implementados en la capa de persistencia 
	SeguroDAO seguroDao;
	
		public SeguroControlador()
		{
			//creamos un seguro DAO
			seguroDao = new SeguroDAOImpl(); //es porque se tiene que instanciar una clase, SeguroDAO es una interfaz y no se puede instanciar
			
		}
		
		public void ejercicio1()
		{
			List<Seguro> l = seguroDao.todosSeguros();
			
			for (Seguro s : l)
			{
				System.out.println("Seguro: "+s.toString());

			}
		}
		
		public void ejercicio2()
		{	
			List<Object[]> seguros = seguroDao.verNIFyNombre();
			for (Object[] resultado: seguros) 
			{
				System.out.println("NIF: " + resultado[0] + ", Nombre:: " + resultado[1]);
			}
		}
			
		
		public void ejercicio3(String ape1, String ape2, String nombre)
		{
			String nifMaria = seguroDao.verMariaLozano(nombre, ape1, ape2);
			System.out.println("El DNI con esos parámetros es: "+nifMaria);
		}
		
		public void ejercicio4()
		{
			List<Asistencia> a = seguroDao.verAsistenciaMayorDiezMil();
			System.out.println("Asistencia mayor de 10000: ");
			for (Asistencia resultado: a) 
			{
				System.out.println("Es:" + resultado);
			}

		}
		
		public void ejercicio5()
		{
			List<Integer> a = seguroDao.obtenerIdAsistenciaMedica();
			for (Integer s : a)
			{
				System.out.println("Id de asistencia medica: "+s);

			}
		}
		
		public void ejercicio6()
		{
			int suma = seguroDao.sumaImporteAsistenciaMedica();
			System.out.println("La suma de todos los importes de asistencia médica es: "+suma);
		}
		
		public void ejercicio7()
		{
			int saldo = seguroDao.salarioMedioAsistenciaMedica();
			System.out.println("El saldo medio de todas las asistencias médicas es: "+saldo);
		}
		
		public void ejercicio8() 
		{
			int numeroSeguros = seguroDao.cuantosSeguros();
			System.out.println("Número de seguros: "+numeroSeguros);
		}
		
		public void ejercicio9()
		{
			List<Object[]> seguros = seguroDao.mostrarSeguroNombreNifAsistencias();
			for (Object[] resultado: seguros) {
				System.out.println("ID: " + resultado[0] + ", Nombre: " + resultado[1] + "Tipo de asistencia" + resultado[2]+ "numero de tipo de asistencias: "+resultado[3]);
			}
		}
		
		public void ejercicio10()
		{
			List<Object[]> ob = seguroDao.obtenerObjetosSeguro();
			for(Object[] resultado: ob)
			{
				System.out.println("Obtención de todos los objetos seguros que retona el nombre de la alergia: "+resultado[0]);
			}
		}
		
		public void ejercicio11()
		{
			 seguroDao.conseguirSegurosIdMedicaVeridAsistencia();
		}
		
		
		/* o tambien o eso creo 
		List <Seguro> listaSeguros = seguroDao.findAll();
		for(Seguro seg: listaSeguros)
		{
			System.out.println("NIF: "+seg.getNif()+"Nombre:"+seg.getNombre());
		}	
		*/
	
	
}
