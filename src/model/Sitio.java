package model;

import java.util.ArrayList;
import java.util.Collection;

public class Sitio {

	private Collection<Usuario> usuarios;
	private Catalogo catalogo;

	public Sitio() {

		this.usuarios = new ArrayList<Usuario>();
		this.catalogo = new Catalogo();

	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void registarUsuario(Usuario usuario) {

		this.usuarios.add(usuario);

	}

}
