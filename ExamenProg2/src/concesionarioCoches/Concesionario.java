package concesionarioCoches;

import java.util.ArrayList;

public class Concesionario implements java.io.Serializable{
	private int codigoConcesionario;
	private String nombre;
	private ArrayList<Modelo> listaModelos;
	private ArrayList<Integer> listaCantidad;

	public Concesionario()
	{
	}
	
	public Concesionario(int codigoConcesionario, String nombre, ArrayList<Modelo> listaModelos, ArrayList<Integer> listaCantidad) {
		this.setCodigoConcesionario(codigoConcesionario);
		this.setNombre(nombre);
		this.setListaModelos(listaModelos);
		this.setListaCantidad(listaCantidad);
	}



	public int getCodigoConcesionario() {
		return this.codigoConcesionario;
	}



	public void setCodigoConcesionario(int codigoConcesionario) {
		this.codigoConcesionario = codigoConcesionario;
	}



	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Modelo> getListaModelos() {
		return this.listaModelos;
	}

	public void setListaModelos(ArrayList<Modelo> listaModelos) {
		this.listaModelos = listaModelos;
	}

	public ArrayList<Integer> getListaCantidad() {
		return this.listaCantidad;
	}

	public void setListaCantidad(ArrayList<Integer> listaCantidad) {
		this.listaCantidad = listaCantidad;
	}
	
	public void anyadirModelo(Modelo mod,int cant)
	{
		listaModelos.add(mod);
		listaCantidad.add(cant);
	}
	public String toString()
	{
		String cadena=this.codigoConcesionario+"     "+this.nombre+"\n";
		
		int tam=listaModelos.size();
		
		for(int i=0;i<tam;i++)
		{
			cadena+="  Modelo: "+listaModelos.get(i).getCodigoModelo()+" , "+listaCantidad.get(i)+" unidades\n";
		}
		
		return cadena;
		
	}
	
	public String ventasConcesionario()
	{
		return"   "+this.codigoConcesionario+"       "+this.nombre+"       "
				+numModelosNoProm()+"               "+numModelosProm();
	}
	
	public int numModelosNoProm()//Obtiene la cantidad de vehiculos sin promocion
	{
		int cant=0;
		int tam=listaModelos.size();
		
		Modelo mod= new Modelo();
		
		for(int i=0;i<tam;i++)
		{
			if(listaModelos.get(i).getClass().equals(mod.getClass()))
			{
				cant++;
			}
		}
		
		return cant;
	}
	
	public int numModelosProm()//Obtiene la cantidad de vehiculos con promocion
	{
		int cant=0;
		int tam=listaModelos.size();
		
		ModeloPromocionado mod= new ModeloPromocionado();
		
		for(int i=0;i<tam;i++)
		{
			if(listaModelos.get(i).getClass().equals(mod.getClass()))
			{
				cant++;
			}
		}
		
		return cant;
	}
	
	public int ventasModelo(int codigo)//Ventas del modelo con codigo "codigo"
	{
		int pos=posicionModelo(codigo);
		
		if(pos>=0)
		{
			return listaCantidad.get(pos);
		}
		else return 0;
	}
	
	public int posicionModelo(int codigo)//Comprueba si el modelo esta en el vector y devuelve su posicion o -1 si no esta
	{
		int tam=listaModelos.size();
		
		for(int i=0;i<tam;i++)
		{
			if(listaModelos.get(i).getCodigoModelo()==codigo)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	

}
