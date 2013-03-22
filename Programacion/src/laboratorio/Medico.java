package laboratorio;

import rutinas.*;

public class Medico {
	private int codigo;
	private String nombre;
	
	
	public Medico(int codigo, String nombre) {
		setCodigo(codigo);
		setNombre(nombre);
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		while(codigo/1000000 == 0)
		{
			codigo=Rutinas.leeEntero("Codigo no cumple formato, introduzca nuevo codigo");
		}
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		while(nombre.length() > 40 && nombre.length() < 1)
		{
			nombre=Rutinas.leeString("Nombre no cumple formato, introduzca un nuevo nombre");
		}
		this.nombre = nombre;
	}
	
	
}
