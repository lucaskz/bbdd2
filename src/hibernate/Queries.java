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

/**
 * 
 * @author EZEQUIEL PANOFF, LUCAS KASETA
 *
 */

/** Clase Queries, se ejecutan las consultas pedidas a la DB. */
public class Queries {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	public static void main(String[] args) {
		try {

			System.out
					.println("----------------------- Setting up Hibernate -----------------------");
			System.out.println("Building sessions.........");
			createSessionFactory();
			consulta_a();
			consulta_b("Sim");
			consulta_c();
			consulta_d("2013");
			consulta_e("10");
			consulta_f();
			consulta_g("3");
			consulta_h("Be a friend");
			consulta_i();
			consulta_j("30");
		} catch (Exception e) {
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

	/**
	 * Devuelve una lista con el nombre de todas las series del sistema
	 * 
	 */
	@SuppressWarnings("unchecked")
	private static void consulta_a() {
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Listar el nombre de todas las series del sistema.");
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			Query consulta = session.createQuery("FROM Serie");
			tx = session.beginTransaction();
			List<Serie> series = consulta.list();
			tx.commit();

			Iterator<Serie> series_iterator = series.iterator();
			while (series_iterator.hasNext()) {
				Serie serie = series_iterator.next();
				System.out.println("T�tulo de la Serie: " + serie.getTitulo());
			}
			System.out
					.println("---------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			session.close();
		}
		session.disconnect();
	}

	/**
	 * Devuelve una lista con las series cuyo t�tulo contenga una secuencia de
	 * caracteres
	 */
	@SuppressWarnings("unchecked")
	private static void consulta_b(String sequence) {
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out
				.println("Listar las series cuyo t�tulo contenga una secuencia de caracteres (secuencia='Sim').");
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			Query consulta = session
					.createQuery("FROM Serie s WHERE s.titulo LIKE :sequence");
			consulta.setParameter("sequence", "%" + sequence + "%");
			tx = session.beginTransaction();
			List<Serie> series = consulta.list();
			tx.commit();
			Iterator<Serie> series_iterator = series.iterator();
			while (series_iterator.hasNext()) {
				Serie serie = series_iterator.next();
				System.out.println("T�tulo de la Serie: " + serie.getTitulo());
			}
			System.out
					.println("---------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			session.close();
		}
		session.disconnect();
	}

	/**
	 * Devuelve una lista con los 5 episodios de series m�s vistos en el sistema
	 */
	@SuppressWarnings("unchecked")
	private static void consulta_c() {
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out
				.println("Listar los 5 episodios de series m�s vistos en el sistema.");
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			Query consulta = session
					.createQuery("select e.titulo,count(r.reproducible.id) as reproducciones from Reproduccion as r,Episodio e where r.reproducible.class='Episodio' and e.id=r.reproducible.id group by r.reproducible.id order by reproducciones DESC ");
			consulta.setMaxResults(5);
			tx = session.beginTransaction();
			List<Object[]> resultado = consulta.list();
			tx.commit();
			for (Object[] obj : resultado) {

				System.out.println("El episodio '" + (String) obj[0]
						+ "' ha sido visto " + (Long) obj[1] + " veces");

			}
			System.out
					.println("---------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			session.close();
		}
		session.disconnect();
	}

	/** Devuelve la pel�cula m�s vista en un determinado a�o */
	@SuppressWarnings("unchecked")
	private static void consulta_d(String year) {
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out
				.println("Informar la pel�cula m�s vista en un determinado a�o (a�o='2013').");
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			Query consulta = session
					.createQuery("select c.titulo , count (r.reproducible.id) as reproducciones from Reproduccion as r,Contenido as c  where YEAR(r.fecha)= :year and r.reproducible.class=Pelicula and c.id=r.reproducible.id group by r.reproducible.id order by reproducciones DESC");
			consulta.setParameter("year", Integer.parseInt(year));
			consulta.setMaxResults(1);
			tx = session.beginTransaction();
			List<Object[]> resultado = consulta.list();
			tx.commit();
			for (Object[] obj : resultado) {

				System.out.println("La pelicula mas vista de " + year
						+ " es: '" + (String) obj[0] + "' (" + (Long) obj[1]
						+ " reproducciones)");

			}

			System.out
					.println("---------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			session.close();
		}
		session.disconnect();
	}

	/** Devuelve una lista los usuarios que reprodujeron m�s de 'n' pel�culas */
	@SuppressWarnings("unchecked")
	private static void consulta_e(String moviesNumber) {
		// Se listan los resultados correctos, pero se muestran en orden
		// ascedente y no aleatorio como en el documento de referencia.
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out
				.println("Listar los usuarios que reprodujeron m�s de 'n' pel�culas (pel�culas='10'). ");
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			Query consulta = session
					.createQuery("select u.email ,count(u) as reproducciones from Usuario as u join u.gestor as g join g.reproducciones as r where r.reproducible.class=Pelicula group by u having count(u) > :moviesNumber order by reproducciones DESC ");
			consulta.setParameter("moviesNumber", Long.parseLong(moviesNumber));
			tx = session.beginTransaction();
			List<Object[]> resultado = consulta.list();
			tx.commit();
			for (Object[] obj : resultado) {

				System.out
						.println("El usuario '" + (String) obj[0]
								+ "' ha realizado " + (Long) obj[1]
								+ " reproducciones");

			}

			System.out
					.println("---------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			session.close();
		}
		session.disconnect();
	}

	/**
	 * Devuelve una lista con los usuarios que vieron al menos un episodio por
	 * menos de 65 segundos
	 */
	@SuppressWarnings("unchecked")
	private static void consulta_f() {
		// Se listan los resultados correctos, pero se muestran en orden
		// ascedente y no aleatorio como en el documento de referencia.
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out
				.println("Listar los usuarios que vieron al menos un episodio por menos de 65 segundos");
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			Query consulta = session
					.createQuery("select distinct u.email from Usuario as u join u.gestor as g join g.reproducciones as r where r.reproducible.class='Episodio' and r.tiempo < 65000 order by u.email  ");
			tx = session.beginTransaction();

			List<String> resultado = consulta.list();
			tx.commit();
			Iterator<String> resultado_iterator = resultado.iterator();
			while (resultado_iterator.hasNext()) {
				String email = resultado_iterator.next();
				System.out.println("Mail del usuario: " + email);
			}
			System.out
					.println("---------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			session.close();
		}
		session.disconnect();
	}

	/** Devuelve una lista con las 'n' pel�culas m�s vista en el sistema */
	@SuppressWarnings("unchecked")
	private static void consulta_g(String moviesNumber) {
		// LA PELICULA "Stardust" TIENE LA MISMAS REPRODUCCIONES QUE
		// "Jackie Brown" por lo tanto no se lista;
		// si parametrizamos con '4' en lugar de '3' s� se lista.
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out
				.println("Listar las 'n' pel�culas m�s vista en el sistema (pel�culas='3').");
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			Query consulta = session
					.createQuery("select c.titulo , count (r.reproducible.id) as reproducciones from Reproduccion as r,Contenido as c  where  r.reproducible.class=Pelicula and c.id=r.reproducible.id group by r.reproducible.id order by reproducciones DESC");
			tx = session.beginTransaction();
			consulta.setMaxResults(Integer.parseInt(moviesNumber));
			List<Object[]> resultado = consulta.list();
			tx.commit();
			for (Object[] obj : resultado) {

				System.out.println("La pelicula '" + (String) obj[0]
						+ "' ha sido vista " + (Long) obj[1] + " veces");

			}

			System.out
					.println("---------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			session.close();
		}
		session.disconnect();
	}

	/**
	 * Devuelve una lista con los usuarios que vieron un episodio cuyo t�tulo se
	 * ingresa por par�metro
	 */
	@SuppressWarnings("unchecked")
	private static void consulta_h(String eTitle) {
		// Se listan los resultados correctos, pero se muestran en orden
		// ascedente y no aleatorio como en el documento de referencia.
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out
				.println("Listar los usuarios que vieron un episodio cuyo t�tulo se ingresa por par�metro (t�tulo='Be a friend').");
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			Query consulta = session
					.createQuery("select distinct u.email from Usuario as u join u.gestor as g join g.reproducciones as r,Episodio e where r.reproducible.class='Episodio' and e.id=r.reproducible.id  and e.titulo like :eTitle order by u.email  ");
			consulta.setParameter("eTitle", eTitle);
			tx = session.beginTransaction();
			List<String> resultado = consulta.list();
			tx.commit();
			Iterator<String> resultado_iterator = resultado.iterator();
			while (resultado_iterator.hasNext()) {
				String email = resultado_iterator.next();
				System.out.println("Mail del usuario: " + email);
			}
			System.out
					.println("---------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			session.close();
		}
		session.disconnect();
	}

	/**
	 * Devuelve una lista con los usuarios que que reprodujeron al menos una
	 * pel�cula y cuya edad m�nima sea 12 a�os
	 */
	@SuppressWarnings("unchecked")
	private static void consulta_i() {
		// Se listan los resultados correctos, pero se muestran en orden
		// ascedente y no aleatorio como en el documento de referencia.
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out
				.println("Listar usuarios que reprodujeron al menos una pel�cula cuya edad m�nima sea 12 a�os");
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			Query consulta = session
					.createQuery("select distinct u.email from Usuario as u join u.gestor as g join g.reproducciones as r,Contenido as cont where r.reproducible.class=Pelicula and cont.id=r.reproducible.id and cont.edadMinima>=12 order by u.email");
			tx = session.beginTransaction();
			List<String> resultado = consulta.list();
			tx.commit();
			Iterator<String> resultado_iterator = resultado.iterator();
			while (resultado_iterator.hasNext()) {
				String email = resultado_iterator.next();
				System.out.println("Mail del usuario: " + email);
			}
			System.out
					.println("---------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			session.close();
		}
		session.disconnect();
	}

	/**
	 * Devuelve una lista con los usuarios que est�n a menos de una cantidad
	 * dada de reproducciones para llegar al l�mite de las mismas para su
	 * categor�a
	 */
	@SuppressWarnings("unchecked")
	private static void consulta_j(String rNumber) {
		// Se listan los resultados correctos, pero se muestran en orden
		// ascedente y no aleatorio como en el documento de referencia.
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out
				.println("Listar los usuarios que est�n a menos de una cantidad dada de reproducciones para llegar al l�mite de las mismas para su categor�a (cantidad='30').");
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			Query consulta = session
					.createQuery("select u.email  from Usuario as u join u.suscripcion as s join s.categoria as c where (c.limiteReproducciones - (select count(r) from u.gestor as g join g.reproducciones as r  ) ) < :rNumber order by u.email");
			consulta.setParameter("rNumber", Long.parseLong(rNumber));
			tx = session.beginTransaction();
			List<String> resultado = consulta.list();
			tx.commit();
			Iterator<String> resultado_iterator = resultado.iterator();
			while (resultado_iterator.hasNext()) {
				String email = resultado_iterator.next();
				System.out.println("Mail del usuario: " + email);
			}
			System.out
					.println("---------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			session.close();
		}
		session.disconnect();
	}

}
