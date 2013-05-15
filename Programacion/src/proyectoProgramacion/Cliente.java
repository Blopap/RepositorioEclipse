package proyectoProgramacion;

import java.sql.Date;
import java.util.Vector;

public class Cliente {
	
	private String dni;
	private String nombre;
	private String apellidos;
	private boolean sexo;
	private String direccion;
	private int codigoPostal;
	private String ciudad;
	private Integer telefono;
	private String fechaNacimiento;
	
	/**
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param sexo
	 * @param direccion
	 * @param codigoPostal
	 * @param ciudad
	 * @param telefono
	 * @param fechaNacimiento
	 */
	public Cliente(String dni, String nombre, String apellidos, boolean sexo,
			String direccion, int codigoPostal, String ciudad, Integer telefono,
			String fechaNacimiento) {
		setDni(dni);
		setNombre(nombre);
		setApellidos(apellidos);
		setSexo(sexo);
		setDireccion(direccion);
		setCodigoPostal(codigoPostal);
		setCiudad(ciudad);
		setTelefono(telefono);
		setFechaNacimiento(fechaNacimiento);
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public boolean getSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Vector<Object> trasformaCliente()
	{
		
		Vector<Object> aux=new Vector<Object>();
			
		aux.add(this.getDni());
		aux.add(this.getNombre());
		aux.add(this.getApellidos());
		aux.add(this.getSexo());
		aux.add(this.getDireccion());
		aux.add(this.getCodigoPostal());
		aux.add(this.getCiudad());
		aux.add(this.getTelefono());
		aux.add(this.getFechaNacimiento());
		aux.add(this.getDni());
		
		return aux;
	}
	

}
