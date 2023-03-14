package examen.modelo;

import java.util.Date;

public class Materia {
	
	private int id;
	private String nombre;
	private int idNivel;
	private String codigo;
	private String url;
	private int matricula;
	private Date fechaInicio;
	
	/**
	 * 
	 */
	public Materia() {
		super();
	}

	/**
	 * @param id
	 * @param nombre
	 * @param idNivel
	 * @param codigo
	 * @param url
	 * @param matricula
	 * @param fechaInicio
	 */
	public Materia(int id, String nombre, int idNivel, String codigo, String url, int matricula, Date fechaInicio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idNivel = idNivel;
		this.codigo = codigo;
		this.url = url;
		this.matricula = matricula;
		this.fechaInicio = fechaInicio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(int idNivel) {
		this.idNivel = idNivel;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Override
	public String toString() {
		return nombre;
	}

}
