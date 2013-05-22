package proyectoProgramacion;

import java.util.Vector;

public class Operacion {
	
	private int IdOperacion;
	private int Vehiculo;
	private int RevCambio;
	private String Descripcion;
	private String FechaEntrada;
	private String FechaSalida;
	
	/**
	 * @param idOperacion
	 * @param vehiculo
	 * @param revCambio
	 * @param descripcion
	 * @param fechaEntrada
	 * @param fechaSalida
	 */
	public Operacion()
	{
		this.setIdOperacion(0);
		this.setVehiculo(0);
		this.setRevCambio(0);
		this.setDescripcion("");
		this.setFechaEntrada("");
		this.setFechaSalida("");
	}
	
	public Operacion(int idOperacion, int vehiculo, int revCambio,
			String descripcion, String fechaEntrada, String fechaSalida) {
		this.setIdOperacion(idOperacion);
		this.setVehiculo(vehiculo);
		this.setRevCambio(revCambio);
		this.setDescripcion(descripcion);
		this.setFechaEntrada(fechaEntrada);
		this.setFechaSalida(fechaSalida);
	}
	public int getIdOperacion() {
		return IdOperacion;
	}
	public void setIdOperacion(int idOperacion) {
		IdOperacion = idOperacion;
	}
	public int getVehiculo() {
		return Vehiculo;
	}
	public void setVehiculo(int vehiculo) {
		Vehiculo = vehiculo;
	}
	public int getRevCambio() {
		return RevCambio;
	}
	public void setRevCambio(int revCambio) {
		RevCambio = revCambio;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getFechaEntrada() {
		return FechaEntrada;
	}
	public void setFechaEntrada(String fechaEntrada) {
		FechaEntrada = fechaEntrada;
	}
	public String getFechaSalida() {
		return FechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		FechaSalida = fechaSalida;
	}
	
	public int valorRevCambios(boolean aceite,
			boolean filtroAire,boolean filtroCombustible,
			boolean filtroAceite,boolean ruedas,boolean otros)
	//Calcula el valor de los recambios basandose en la siguiente regla.
	// El valor total de los recambios será la suma de los valores seleccionados.
	// Aceite = 1; FiltroAceite = 2; FiltroCombustible = 4;
	// FiltroAceite = 8; Ruedas = 16; Otros = 32;
	// Si no hay nada seleccionado devuelve 0
	// Si esta todo seleccionado devuelve 63.
	{
		int valor = 0;
		if(aceite)
		{
			valor=1;
		}
		if(filtroAire)
		{
			valor+=2;
		}
		if(filtroCombustible)
		{
			valor+=4;
		}
		if(filtroAceite)
		{
			valor+=8;
		}
		if(ruedas)
		{
			valor+=16;
		}
		if(otros)
		{
			valor+=32;
		}
		return valor;
	}
	
	public String RevCambiosValores()
	//Devuelve una cadena con los valores reales de la variable RevCambio
	{
		String cad="";
		int valor = this.getRevCambio();
		
		if(valor/32>0)
		{
			cad="Otros /";
			valor-=32;
		}
		if(valor/16>0)
		{
			cad="Cambio de Neumaticos /"+cad;
			valor-=16;
		}
		if(valor/8>0)
		{
			cad="Filtro de Aceite /"+cad;
			valor-=8;
		}
		if(valor/4>0)
		{
			cad="Filtro de Combustible /"+cad;
			valor-=4;
		}
		if(valor/2>0)
		{
			cad="Filtro de Aire /"+cad;
			valor-=2;
		}
		if(valor>0)
		{
			cad="Cambio de Aceite /"+cad;
		}
		
		cad=cad.substring(0,cad.length()-2);
		
		return cad;
	}
	
	public Vector<Object> transformaOperacion()
	//Introduce los datos de la operacion actual en un vector
	//Devuelve dicho vector
	{
		Vector<Object> aux = new Vector<Object>();
		
		
		
		aux.add(this.getIdOperacion());
		aux.add(this.getVehiculo());
		aux.add(this.RevCambiosValores());
		aux.add(this.getDescripcion());
		aux.add(this.getFechaEntrada());
		aux.add(this.getFechaSalida());
		
		return aux;
	}
}
