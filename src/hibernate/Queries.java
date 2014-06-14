package hibernate;

import java.util.Iterator;
import java.util.List;

import model.Serie;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Queries {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	public static void main(String[] args) {
		try {

			System.out.println("----------------------- Setting up Hibernate -----------------------");
			System.out.println("Building sessions.........");
	        createSessionFactory();
	        consulta_a();
	        consulta_b("Sim");
		}
		catch (Exception e) {
			System.out
					.println("------------------------FAIL.------------------------");
			e.printStackTrace();
		}
	}
	
	private static SessionFactory createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure("hibernate/hibernate.cfg.xml");
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
	
	private static void consulta_a(){
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Listar el nombre de todas las series del sistema.");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Query consulta = session.createQuery("FROM Serie");
			tx.commit();
			List series = consulta.list();
			Iterator<Serie> series_iterator = series.iterator();
			while (series_iterator.hasNext()) {
				Serie serie = (Serie) series_iterator.next();
				System.out.println("Título de la Serie: "+ serie.getTitulo());
			}
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		}
		catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			session.close();
		}		
		session.disconnect();		
	}
	
	private static void consulta_b(String sequence){
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Listar las series cuyo título contenga una secuencia de caracteres.");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Query consulta = session.createQuery("FROM Serie s WHERE s.titulo LIKE :sequence");
			consulta.setParameter("sequence", "%"+sequence+"%");
			tx.commit();
			List<Serie> series = consulta.list();
			Iterator<Serie> series_iterator = series.iterator();
			while (series_iterator.hasNext()) {
				Serie serie = (Serie) series_iterator.next();
				System.out.println("Título de la Serie: "+ serie.getTitulo());
			}
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		}
		catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			session.close();
		}		
		session.disconnect();		
	}
	
	

}
