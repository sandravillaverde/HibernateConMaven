package es.seguro.presentacion;

import javax.persistence.EntityManager;

import es.seguro.persistencia.Utilidades;


public class App 
{
    public static void main( String[] args )
    {
		EntityManager em = null; 
		
		
		try {
			em = Utilidades.getEntityManagerFactory().createEntityManager();			


			
		} catch (Exception e ) {
			if (em != null) {
				e.printStackTrace();
				System.out.println("Se va a hacer rollback de la transacción");
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		es.seguro.persistencia.Utilidades.closeEntityManagerFactory();
    }
    
}
