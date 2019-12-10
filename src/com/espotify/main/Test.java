package com.espotify.main;

import com.espotify.modelo.Cancion;
import com.espotify.modelo.Playlist;
import com.espotify.utilidades.Utilidades;

public class Test {
	public static void main(String[] args) {
		

		Playlist p1 = new Playlist();
		p1.setLikes(50);
		p1.setNombre("Reggeaton");

		Cancion c1 = new Cancion();
		c1.setId(6);
		c1.setTitulo("China");
		c1.setArtista("Anuel AA");
		c1.setDuracion(420);
		c1.setReproducciones(5000000);
		c1.getPlaylists().add(p1);

		UtilsCancion.almacenaCancion(c1);
		Utilidades.getSessionFactory().close();
	}
}