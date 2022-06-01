package com.transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TransactionCRUD<T> {

	protected EntityManager entityManager;
	
	public TransactionCRUD() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaescolarPU");
		entityManager = emf.createEntityManager();
	}
	
	protected T salvarDados(T entidade) {
		try {			
		    entityManager.getTransaction().begin();
			entityManager.persist(entidade);
			entityManager.getTransaction().commit();
			System.out.println("salvo com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entidade;
	}
	
	public void alterarDados(T entidade) {
		try {
			entityManager.getTransaction().begin();
			T entidadeMerge = entityManager.merge(entidade);
			entityManager.persist(entidadeMerge);
			entityManager.getTransaction().commit();
			System.out.println("aterado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void excluirDados(T entidade) {
		try {
			entityManager.getTransaction().begin();
			T entidadeMerge = entityManager.merge(entidade);
			entityManager.remove(entidadeMerge);
			entityManager.getTransaction().commit();
			System.out.println("deletado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	
}
