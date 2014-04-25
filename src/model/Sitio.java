package model;

import java.util.ArrayList;
import java.util.Collection;

public class Sitio {

	private Long oId;
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

	public void registrarUsuario(Usuario usuario) {

		this.usuarios.add(usuario);

	}

	public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}

}
