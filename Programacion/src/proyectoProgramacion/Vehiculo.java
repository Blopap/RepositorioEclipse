package proyectoProgramacion;

import java.util.Vector;

import javax.swing.JOptionPane;

import rutinas.Rutinas;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class Vehiculo {
	private int IdVehiculo;
	private String Duenyo;
	private String Marca;
	private String Modelo;
	private String Color;
	private String FechaFabricacion;
	
	/**
	 * @param idVehiculo
	 * @param duenyo
	 * @param marca
	 * @param modelo
	 * @param color
	 * @param fechaFabricacion
	 */
	public Vehiculo(int idVehiculo, String duenyo, String marca, String modelo,
			String color, String fechaFabricacion) {
		this.setIdVehiculo(idVehiculo);
		this.setDuenyo(duenyo);
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setColor(color);
		this.setFechaFabricacion(fechaFabricacion);
	}
	
	public int getIdVehiculo() {
		return IdVehiculo;
	}
	public void setIdVehiculo(int idVehiculo) {
		IdVehiculo = idVehiculo;
	}
	public String getDuenyo() {
		return Duenyo;
	}
	public void setDuenyo(String duenyo) {
		Duenyo = duenyo;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getFechaFabricacion() {
		return FechaFabricacion;
	}
	public void setFechaFabricacion(String fechaFabricacion) {
		FechaFabricacion = fechaFabricacion;
	}
	
	public Vector<Object> transformaVehiculo()
	//Introduce los datos del vehiculo actual en un vector
	//Devuelve dicho vector
	{
		Vector<Object> aux = new Vector<Object>();
		
		aux.add(this.getIdVehiculo());
		aux.add(this.getDuenyo());
		aux.add(this.getMarca());
		aux.add(this.getModelo());
		aux.add(this.getColor());
		aux.add(this.getFechaFabricacion());
		
		return aux;
	}
	
	public boolean insertarEnPosicion(int i,String texto)
	//Inserta el dato "texto" en la posicion de la clase i.
	{
		boolean estado=false;
		
		if(i!=0)
		{
			if(i==1)
			{
				if(GestorDatos.existeDniCliente(texto))
				{
					this.setDuenyo(texto);
					estado=true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "El dni introducido no existe, introduzca otro");
				}
			}
			else if(i==2)
			{
				this.setMarca(texto);
				estado=true;
			}
			else if(i==3)
			{
				this.setModelo(texto);
				estado=true;
			}
			else if(i==4)
			{
				this.setColor(texto);
				estado=true;
			}
			else
			{
				this.setFechaFabricacion(texto);
			}
		}
			
		return estado;
	}
}
