package laboratorio;

import rutinas.Rutinas;

public class Paciente {
	private String nif;
	private String nombre;
	private String direccion;
	
	public Paciente(String nif, String nombre, String direccion) {
		setNif(nif);
		setNombre(nombre);
		setDireccion(direccion);
	}
	
	public String getNif() {
		return nif;
	}


	public void setNif(String nif) {
		
		while(!comprobarNif(nif))
		{
			nif=Rutinas.leeString("Nif no cumple formato, introduzca un nuevo nif");
		}
		this.nif = nif;
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


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		while(direccion.length() > 40 && direccion.length() < 1)
		{
			direccion=Rutinas.leeString("Direccion no cumple formato, introduzca una nueva direccion");
		}
		this.direccion = direccion;
	}
	
	private boolean comprobarNif(String nif)
	{
		String nums;
		String letra;
		boolean correcto=true;
		if(nif.length()>=9)
		{
			nums=nif.substring(0,8);
			letra=nif.substring(8);
			
			if(letra.length()==1 && Character.isLetter(letra.charAt(0)))
			{
				for(int i=0;i<8;i++)
				{
					if(correcto && !Character.isDigit(nums.charAt(i)))
					{
						correcto=false;
					}
				}
			}
			else correcto=false;
		}
		return correcto;
	}
}
