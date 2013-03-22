package proyectoTema6;

import java.util.Date;

public class ProductoPerecedero extends Producto{
	private Date fechaCaducidad;
	
	
	public ProductoPerecedero()
	{
		super();
	}
	
	public ProductoPerecedero(String desc,String cod, double precC, double precV, Date fecha)
	{
		super(desc,cod,precC,precV);
		this.setFechaCaducidad(fecha);
	}
	
	public void setFechaCaducidad(Date fecha)
	{
		this.fechaCaducidad=fecha;
	}
	
	public Date getFechaCaducidad()
	{
		return this.fechaCaducidad;
	}
	
	public String toString()
	{
		return super.toString()+ "Fecha de Caducidad: "+this.fechaCaducidad+"\n";
	}

}
