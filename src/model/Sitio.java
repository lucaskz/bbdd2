package model;

import java.util.ArrayList;
import java.util.Collection;

/**Modela al sitio, permite el registro de usuarios y la creación de un catálogo.*/

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

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

}
