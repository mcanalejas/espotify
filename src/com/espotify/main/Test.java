package com.espotify.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.espotify.modelo.Cancion;
import com.espotify.modelo.Playlist;
import com.espotify.utilidades.Utilidades;

public class Test {
	public void borrarCancion(Cancion cancion) {
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(cancion);
			session.getTransaction().commit();
			System.out.println("Borrando cancion: " + cancion.toString());

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void actualizaCancion(Cancion cancion) {
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(cancion);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void almacenaCancion(Cancion cancion) {
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(cancion);
			System.out.println("Cancion añadida: " + cancion.toString());
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public Cancion RecuperaCancion(int id) {
		Session session = Utilidades.getSessionFactory().openSession();
		Cancion seg = new Cancion();
		session.beginTransaction();
		seg = (Cancion) session.load(Cancion.class, id);
		session.getTransaction().commit();
		return seg;
	}

	public static void main(String[] args) {
		Test t = new Test();
		
		Playlist p1 = new Playlist();
		p1.setLikes(50);
		p1.setNombre("Reggeaton");
		
		Cancion c1 = new Cancion();
		c1.setTitulo("China");
		c1.setArtista("Anuel AA");
		c1.setDuracion(420);
		c1.setReproducciones(5000000);
		c1.getPlaylists().add(p1);
		
		t.almacenaCancion(c1);
		Utilidades.getSessionFactory().close();
	}
}