package es.seguro.persistencia;
 
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Utilidades {
	
	    private static final String PERSISTENCE_UNIT_NAME = "mavensegurohoja1";
	    
	    private static EntityManagerFactory factory;
	    
	    public static EntityManagerFactory getEntityManagerFactory() {
	        if(factory == null) {
	        	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	        }
	        return factory;
	    }
	    
	    public static void closeEntityManagerFactory() {
	    	if (factory != null) {
	    		factory.close();
	    	}
	    }
	    
}
