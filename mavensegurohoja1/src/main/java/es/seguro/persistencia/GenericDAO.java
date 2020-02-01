package es.seguro.persistencia;

import java.io.Serializable;
import java.util.List;
import  es.seguro.modelo.Seguro;


public interface GenericDAO<T,ID extends Serializable> {
	void persist(T entity);
    void merge(T entity);
    void remove(ID id);
    T findById(ID id);
    List<T> findAll();
}
