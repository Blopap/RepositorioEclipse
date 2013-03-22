package concesionarioSwing;

import java.util.ArrayList;
import java.util.Scanner;

import rutinas.Rutinas;

public class ModelosAntiguo implements java.io.Serializable {
	private ArrayList<Modelo> listadoModelos;

	public ModelosAntiguo()
	{
		this.setListadoModelos(new ArrayList<Modelo>());
	}
	
	public ModelosAntiguo(ArrayList<Modelo> listadoModelos) {
		this.setListadoModelos(listadoModelos);
	}

	public ArrayList<Modelo> getListadoModelos() {
		return this.listadoModelos;
	}

	public void setListadoModelos(ArrayList<Modelo> listadoModelos) {
		this.listadoModelos = listadoModelos;
	}
	
	//Introducir nuevo modelo
	public void altaModelo()
	{
		int codigo;
		String desc;
		float pvp;
		float descuento;
		
		System.out.println("Nuevo modelo.\n");
		codigo=Rutinas.leeEntero("Introduzca el codigo del modelo", 0); //Lee un codigo positivo
		
		while(comprobarCodigoM(codigo))//Comprueba que el codigo no existe
		{
			codigo=Rutinas.leeEntero("El codigo de modelo existe, introduzca otro", 0); //Lee un codigo positivo
		}
		
		desc=Rutinas.leeString("Introduzca la descripcion del modelo");//Lee descripcion
		
		pvp = Rutinas.leeFloat("Introduzca el precio Base");//Lee pvp
		
		if(Rutinas.leeBooleano("Desea añadir un modelo con promocion?"))//Pregunta si se desea crear un modelo con promocion
		{
			descuento=Rutinas.leeFloat("Introduzca el descuento en porcentaje(%)");//Lee el descuento
			
			listadoModelos.add(new ModeloPromocionado(codigo, desc, pvp, descuento));
		}
		else listadoModelos.add(new Modelo(codigo,desc,pvp));//Lo añade al arraylist
	}
	
	
	//comprobar si el codigo de modelo ya existe
	public boolean comprobarCodigoM(int codigo)//Dev true si existe, false en caso contrario
	{
		boolean esta=false;
		
		int tam=this.listadoModelos.size();
		
		for(int i=0;i<tam;i++)
		{
			if(listadoModelos.get(i).getCodigoModelo() == codigo)
			{				
				esta=true;
			}
		}
		
		return esta;
	}
	
	public String toString()
	{
		String cadena="";
		int tam=listadoModelos.size();
		
		for(int i=0;i<tam;i++)
		{
			cadena+=listadoModelos.get(i).toString()+"\n";
		}
		
		return cadena;
	}
	
	public String mostrarModelo(int codigo)//Muestra el modelo cuyo codigo es "codigo"
	{
		String cadena="";
		int tam=listadoModelos.size();
		
		for(int i=0;i<tam;i++)
		{
			if(listadoModelos.get(i).getCodigoModelo() == codigo)
			{
				cadena="Modelo: "+listadoModelos.get(i).toString()+"\n";
			}
		}
		
		return cadena;
	}
	
	public String listaCodigosM()
	{
		String cadena="Lista codigos Modelos: ";
		int tam=listadoModelos.size();
		
		for(int i=0;i<tam;i++)
		{
			cadena+=listadoModelos.get(i).getCodigoModelo()+"  ";
		}
		
		return cadena;
	}
	
	public Modelo devuelveModelo(int codigo)//Devuelve el modelo cuyo codigo es "codigo"
	{
		Modelo mod=new Modelo();
		
		int i=0;
		while(listadoModelos.get(i).getCodigoModelo()!=codigo)
		{
			mod=listadoModelos.get(i);
			i++;
		}
		
		return mod;
	}

}
