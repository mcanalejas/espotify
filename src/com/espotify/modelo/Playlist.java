package com.espotify.modelo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "playlist", catalog = "espotify")
public class Playlist implements java.io.Serializable {

	private Integer id;
	private String nombre;
	private Integer likes;
	private Set<Cancion> cancions = new HashSet<Cancion>(0);

	public Playlist() {
	}

	public Playlist(String nombre) {
		this.nombre = nombre;
	}

	public Playlist(String nombre, Integer likes, Set<Cancion> cancions) {
		this.nombre = nombre;
		this.likes = likes;
		this.cancions = cancions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "likes")
	public Integer getLikes() {
		return this.likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "playlist_cancion", catalog = "espotify", joinColumns = {
			@JoinColumn(name = "playlist_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "cancion_id", nullable = false, updatable = false) })
	public Set<Cancion> getCancions() {
		return this.cancions;
	}

	public void setCancions(Set<Cancion> cancions) {
		this.cancions = cancions;
	}

	@Override
	public String toString() {
		return "Playlist [id=" + id + ", nombre=" + nombre + ", likes=" + likes + ", cancions=" + cancions + "]";
	}
}
