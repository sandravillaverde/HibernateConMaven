package es.seguro.persistencia;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import es.seguro.modelo.Asistencia;
//hereda todos los metodo del generico, las especifica para el SEguro e implementa todos esos metodos que tiene que tener canción
//cumple con la herencia y el polimorfismo
import es.seguro.modelo.Seguro;


public class SeguroDAOImpl extends GenericDAOImpl<Seguro,Integer> implements  SeguroDAO {

		//Aqui va todos los metodos de consulta que usaremos siempre son los metodos
		//Las CONSULTAS tienen que ir con sus propios METODOS
	
		/**
		 * 1. Obtener todos los seguros que hay en la base de datos.
		 */
		//Ejercicio	1
		public List<Seguro> todosSeguros()
		{
			EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();	 
			TypedQuery<Seguro> q = em.createQuery("select c from Seguro c", Seguro.class);
			List<Seguro> l	= q.getResultList(); 
			return l;
			
			
		}
	
	
		/**
		 * 2. Obtener solo las columnas NIF y Nombre de todos los seguros que hay en la base de datos.
		 */
		//Ejercicio2
		public List<Object[]> verNIFyNombre() //Ejercicio 2:Es un array ya que tenemos que conseguir NIF Y NOMBRE
		{
			EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();	 
			TypedQuery<Object []> q = em.createQuery( "select nif, nombre from Seguro", Object[].class);
			List<Object[]> s	= q.getResultList(); //trae de la bd el resultado
			
			return s;
			
		}
		
		
		/**
		 * . Obtener sólo el NIF para el seguro con nombre “Maria Garcia Lozano”. Usa el
		método uniqueResult() y 3 parámetros con nombre para el nombre y los apellidos.
		 */	
		//Ejercicio 3
		public String verMariaLozano(String nombre, String apellido1, String apellido2)
		{		
			EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
			TypedQuery<String> q = em.createQuery("select nif from Seguro where nombre = :no and ape1 = :ape1 and ape2 = :ape2'",String.class);
			q.setParameter("no", nombre);
			q.setParameter("ape1", apellido1);
			q.setParameter("ape2", apellido2);
			String resultadoNif = (String) q.getSingleResult();
			
			return resultadoNif;
					
		}
		
		
		/**
		 * 4. Obtener aquellas AsistenciaMedica con importe mayor o igual a 10.000 €. Muestra
			el idAsistenciaMedica en pantalla.
		 */	
		//Ejercicio 4
		public List<Asistencia> verAsistenciaMayorDiezMil()
		{
			EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();	 
			TypedQuery<Asistencia> q = em.createQuery("select tipoAsistencia, id from Asistencia where importe >= 10000", Asistencia.class);
			List<Asistencia> asistencias	= q.getResultList(); 
			
			return asistencias;
		}
		
		
		/**
		 * 5. Obtener el idAsistenciaMedica de todas las asistencias médicas cuyo importe esté entre
		8.000 y 15.000 euros. Usa parámetros para los valores 8000 y 15000.
		 */
		//Ejercicio 5
		public List<Integer> obtenerIdAsistenciaMedica()
		{
			EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();	 
			TypedQuery<Integer> q = em.createQuery("select id from Asistencia where importe between :numero1 and :numero2", Integer.class);
			q.setParameter( "numero1", 8000 );
			q.setParameter( "numero2", 15000 );
			List<Integer> lista_id	= q.getResultList(); 
			
			return lista_id;
		}
		
		
		/**
		 * 6. Calcular la suma de todos los importes de todas las asistencias médicas.
		 */
		//Ejercicio 6
		public int sumaImporteAsistenciaMedica()
		{
			EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
			TypedQuery<Integer> q = em.createQuery("select sum(importe) from Asistencia", Integer.class);
			Integer resultado = q.getSingleResult();
			
			return resultado;
		}
		
		
		/**
		 * 7. Calcular el saldo medio de todas las asistencias médicas.
		 */
		//Ejercicio 7
		public int salarioMedioAsistenciaMedica()
		{
			EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
			TypedQuery<Integer> q = em.createQuery("select avg(importe) from Asistencia", Integer.class);
			Integer resultado = q.getSingleResult();
			
			return resultado;
		}
		
		
		/**
		 * 8. Calcular cuántos seguros hay. Haz que se muestren en pantalla.
		 */
		//Ejercicio 8
		public Integer cuantosSeguros()
		{
			EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();	 
			TypedQuery<Integer> q = em.createQuery("select count(DISTINCT(id)) from Seguro;", Integer.class);
			Integer cuantos = q.getSingleResult();
			
			return cuantos;
		}
		
		
		/**
		 * 9. Mostrar para cada seguro, el nombre, el nif y cuántas asistencias médicas posee.
		 */
		//Ejercicio 9
		public List<Object[]> mostrarSeguroNombreNifAsistencias()
		{
			EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();	 
			TypedQuery<Object[]> q = em.createQuery("select s.id,s.nombre, s.nif, Asistencia.tipoAsistencia, count(tipoAsistencia) from Seguro s, Asistencia where s.id = Asistencia.seguroId group by  s.id, tipoAsistencia", Object[].class);
			List<Object[]> seguritos	= q.getResultList(); 
			
			return seguritos;
		}
		
		
		/**
		 * 10. Obtener todos los objetos Seguro en la parte del FROM pero que en la parte del SELECT
			retorne el nombre de la alergia que padecen (algunos valdrán null). Haz que se muestren en
			pantalla.
		 */
		//Ejercicio 10
		public List <Object[]> obtenerObjetosSeguro()
		{
			EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();	 
			TypedQuery<Object[]> q = em.createQuery("select e.nombreAlergia from Enfermedad e left outer join Seguro on s.enfermedadId = e.id", Object[].class);
			List<Object[]> resultado	= q.getResultList(); 
			return resultado;
		}
		
		
		/**
		 * 11. Obtener todos los seguros. Debe mostrar en pantalla el idAsistenciaMedica de cada
		asistencia médica (No debes lanzar otra consulta).
		 */
		//Ejercicio 11
		public void  conseguirSegurosIdMedicaVeridAsistencia()
		{
			EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();	 
			TypedQuery<String[]> q = em.createQuery("select a.id, Id Asistencia Medica, a.tipoAsistencia, s.id from Seguro s, Asistencia a where a.seguroId = s.id", String[].class);
			
			List<String[]> lista	= q.getResultList(); 
			
			for (String[] resultado: lista) {
				System.out.println("Id asistencia medica: " + resultado[0] + ", Tipo asistencia: " + resultado[1]+ ", id seguro "+resultado[2]);			
			
			}
		}
		
		
		
		
	
	
}
