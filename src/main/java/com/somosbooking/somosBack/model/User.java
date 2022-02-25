package com.somosbooking.somosBack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	private String nombre;
	private String correo;
	private String contrase�a;
	private String telefono;
	private UserType tipo;
	
	
	public User(Long id, String nombre, String correo, String contrase�a, String telefono, UserType tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.contrase�a = contrase�a;
		this.telefono = telefono;
		this.tipo = tipo;
	}
	
	public User() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContrase�a() {
		return contrase�a;
	}


	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public UserType getTipo() {
		return tipo;
	}


	public void setTipo(UserType tipo) {
		this.tipo = tipo;
	}
   
	
	
	
	
}
