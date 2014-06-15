package hibernate;

import java.util.Iterator;
import java.util.List;

import model.Episodio;
import model.Pelicula;
import model.Reproduccion;
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
	        consulta_d("2013");
	        consulta_c();
	        consulta_e();
	        consulta_f();
	        consulta_g();
	        consulta_h();
	        consulta_i();
	        consulta_j();
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
			Query consulta = session.createQuery("FROM Serie");		
			tx = session.beginTransaction();
			List<Serie> series = consulta.list();		
			tx.commit();
			
			Iterator<Serie> series_iterator = series.iterator();
			while (series_iterator.hasNext()) {
				Serie serie = series_iterator.next();
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
			Query consulta = session.createQuery("FROM Serie s WHERE s.titulo LIKE :sequence");
			consulta.setParameter("sequence", "%"+sequence+"%");	
			tx = session.beginTransaction();
			List<Serie> series = consulta.list();	
			tx.commit();			
			Iterator<Serie> series_iterator = series.iterator();
			while (series_iterator.hasNext()) {
				Serie serie = series_iterator.next();
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
	
	private static void consulta_c(){
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Listar los 5 episodios de series más vistos en el sistema.");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{				
			Query consulta = session.createQuery("select e.titulo,count(r.reproducible.id) as reproducciones from Reproduccion as r,Episodio e where r.reproducible.class='Episodio' and e.id=r.reproducible.id group by r.reproducible.id order by reproducciones DESC ");
			tx = session.beginTransaction();
			List <Object> resultado = consulta.list();
			tx.commit();			
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
	
	
	private static void consulta_d(String year){
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Informar la película más vista en un determinado año.");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{				
			Query consulta = session.createQuery("select c.titulo , count (r.reproducible.id) as reproducciones from Reproduccion as r,Contenido as c  where YEAR(r.fecha)=2013 and r.reproducible.class=Pelicula and c.id=r.reproducible.id group by r.reproducible.id order by reproducciones DESC");
			//consulta.setParameter("sequence", "%"+year+"%");	
			tx = session.beginTransaction();
			//List <Pelicula> peliculas = consulta.list();
			/*List <Reproduccion> peliculas =  consulta.list();	
			
			Iterator<Reproduccion> peliculas_string_it = peliculas.iterator();
			while (peliculas_string_it.hasNext()) {
				Reproduccion string = (Reproduccion) peliculas_string_it.next();
				System.out.println("Título de la Pelicula: "+ string);
			}*/
			
			List <Object> resultado = consulta.list();
			tx.commit();
			
			
			
			/*Iterator<Pelicula> peliculas_iterator = peliculas.iterator();
			while (peliculas_iterator.hasNext()) {
				Pelicula pelicula = peliculas_iterator.next();
				System.out.println("Título de la Pelicula: "+ pelicula.getTitulo());
			}*/			
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
	
	private static void consulta_e(){
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Listar los usuarios que reprodujeron más de n películas");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{				
			Query consulta = session.createQuery("select u,count(u) as reproducciones from Usuario as u join u.gestor as g join g.reproducciones as r where r.reproducible.class=Pelicula group by u having count(u) > 10 order by reproducciones DESC ");	
			tx = session.beginTransaction();
			List <Object> resultado = consulta.list();
			tx.commit();	
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
	
	private static void consulta_f(){
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Listar los usuarios que vieron al menos un episodio por menos de 65 segundos");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{				
			Query consulta = session.createQuery("select u.email,count(u) as reproducciones from Usuario as u join u.gestor as g join g.reproducciones as r where r.reproducible.class='Episodio' and r.tiempo < 65000 group by u order by u.email  ");	
			tx = session.beginTransaction();
			List <Object> resultado = consulta.list();
			tx.commit();	
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
	
	private static void consulta_g(){
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Listar las 3 películas más vista en el sistema");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{				
			Query consulta = session.createQuery("select c.titulo , count (r.reproducible.id) as reproducciones from Reproduccion as r,Contenido as c  where  r.reproducible.class=Pelicula and c.id=r.reproducible.id group by r.reproducible.id order by reproducciones DESC");	
			tx = session.beginTransaction();
			List <Object> resultado = consulta.list();
			tx.commit();	
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
	
	private static void consulta_h(){
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Listar usuarios que reprodujeron el episodio 'Be a friend'");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{				
			Query consulta = session.createQuery("select u.email from Usuario as u join u.gestor as g join g.reproducciones as r,Episodio e where r.reproducible.class='Episodio' and e.id=r.reproducible.id  and e.titulo like 'Be a friend'  group by u order by u.email  ");	
			tx = session.beginTransaction();
			List <Object> resultado = consulta.list();
			tx.commit();	
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
	
	
	private static void consulta_i(){
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Listar usuarios que reprodujeron al menos una película cuya edad mínima sea 12 años");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{				
			Query consulta = session.createQuery("select u,count(u) as reproducciones from Usuario as u join u.gestor as g join g.reproducciones as r,Contenido as cont where r.reproducible.class=Pelicula and cont.id=r.reproducible.id and cont.edadMinima>12 group by u  order by reproducciones DESC ");	
			tx = session.beginTransaction();
			List <Object> resultado = consulta.list();
			tx.commit();	
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
	
	private static void consulta_j(){
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Listar usuarios que estén a menos de 30 reproducciones de llegar al límite de su categoría");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{				
			Query consulta = session.createQuery("select u.email  from Usuario as u join u.suscripcion as s join s.categoria as c where (c.limiteReproducciones - (select count(r) from u.gestor as g join g.reproducciones as r  ) ) < 30  ");	
			tx = session.beginTransaction();
			List <Object> resultado = consulta.list();
			tx.commit();	
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
