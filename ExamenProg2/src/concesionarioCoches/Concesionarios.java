package concesionarioCoches;

import java.util.ArrayList;

import rutinas.Rutinas;

public class Concesionarios implements java.io.Serializable {
	private ArrayList<Concesionario> listaConcesionarios;

	public Concesionarios()
	{
		this.setListaConcesionarios(new ArrayList<Concesionario>());
	}
	
	public Concesionarios(ArrayList<Concesionario> listaConcesionarios) {
		this.setListaConcesionarios(listaConcesionarios);
	}

	public ArrayList<Concesionario> getListaConcesionarios() {
		return this.listaConcesionarios;
	}

	public void setListaConcesionarios(ArrayList<Concesionario> listaConcesionarios) {
		this.listaConcesionarios = listaConcesionarios;
	}
	
	
	public void altaConcesionario()
	{
		int codigo;
		String nombre;
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		ArrayList<Integer> cantidad = new ArrayList<Integer>();
		
		System.out.println("Nuevo concesionario.\n");
		
		codigo=Rutinas.leeEntero("Introduzca el codigo del concesionario", 1, 52); //Lee un codigo entre 1 y 52
		
		while(comprobarCodigoC(codigo))//Comprueba que el codigo no existe
		{
			codigo=Rutinas.leeEntero("El codigo del concesionario existe, introduzca otro", 1, 52); //Lee un codigo entre 1 y 52
		}
		
		nombre=Rutinas.leeString("Introduzca el nombre del concesionario");
		
		this.listaConcesionarios.add(new Concesionario(codigo, nombre, modelos, cantidad));
			
	}
	
	public void anyadirModelo(int codigo,Modelo mod,int cant)//Añade el modelo.
	{
		
		if(comprobarCodigoC(codigo))
		{
			int i=0;
			while(listaConcesionarios.get(i).getCodigoConcesionario() != codigo)
			{
				i++;
			}
			
			listaConcesionarios.get(i).anyadirModelo(mod, cant);
		}
		else System.out.println("Codigo no existe");
	}
	
	//comprobar si el codigo del concesionario ya existe
	public boolean comprobarCodigoC(int codigo)//Dev true si existe, false en caso contrario
	{
		boolean esta=false;
		
		int tam=this.listaConcesionarios.size();
		
		for(int i=0;i<tam;i++)
		{
			if(listaConcesionarios.get(i).getCodigoConcesionario()== codigo)
			{				
				esta=true;
			}
		}
		
		return esta;
	}
	
	public String toString()
	{
		String cadena="";
		int tam=listaConcesionarios.size();
		
		for(int i=0;i<tam;i++)
		{
			cadena=listaConcesionarios.toString()+"\n";
		}
		
		return cadena;
	}
	
	public String listaCodigosC()
	{
		String cadena="Lista codigos concesionarios: ";
		int tam=listaConcesionarios.size();
		
		for(int i=0;i<tam;i++)
		{
			cadena+=listaConcesionarios.get(i).getCodigoConcesionario()+"  ";
		}
		
		return cadena;
	}
	
	public void AnyadirModeloConcesionario(Modelos modelos)
	{
		
		System.out.println(listaCodigosC());
		
		int codigoCon=Rutinas.leeEntero("Introduzca el codigo del concesionario"); //Lee el codigo del concesionario
		
		while(!comprobarCodigoC(codigoCon))//Comprueba que el codigo existe
		{
			codigoCon=Rutinas.leeEntero("El codigo del concesionario no encontrado, introduzca otro");
		}
		
		System.out.println("\n\n Nombre concesionario: "+mostrarNombreConcesionario(codigoCon)+"\n\n");
		
		System.out.println(modelos.listaCodigosM());
		
		int codigoMod=Rutinas.leeEntero("Introduzca el codigo del modelo");//Lee el codigo del modelo
		
		while(!modelos.comprobarCodigoM(codigoMod))//Comprueba que el codigo existe
		{
			codigoMod=Rutinas.leeEntero("El codigo del modelo no encontrado, introduzca otro");//Lee el codigo del modelo
		}
		
		System.out.println("\n\n "+modelos.mostrarModelo(codigoMod)+"\n");
		
		int cantidad = Rutinas.leeEntero("Introduzca el numero de vehiculos vendidos");
		
		Modelo mod= modelos.devuelveModelo(codigoMod);
			
		this.anyadirModelo(codigoCon, mod, cantidad);
		
		
	}
	
	public String mostrarNombreConcesionario(int codigo)
	{
		String cadena="";
		int tam=listaConcesionarios.size();
		
		for (int i=0;i<tam;i++)
		{
			if(listaConcesionarios.get(i).getCodigoConcesionario() == codigo)
			{
				cadena= listaConcesionarios.get(i).getNombre();
			}
		}
		
		return cadena;
	}
	
	
	public String ventasPorConcesionario()
	{
		String cadena="Codigo concesionario     Nombre     Total Ventas modelos no promocionados Total ventas Modelos promocionados\n";
		int tam=listaConcesionarios.size();
		
		for(int i=0;i<tam;i++)
		{
			cadena+=listaConcesionarios.get(i).ventasConcesionario()+"\n";
		}
		return cadena;
	}
	
	public String ventasPorModelo(Modelos modelos)
	{
		String cadena="Codigo Modelo     Descripcion     Total unidades vendidas\n";
		int tamcon=listaConcesionarios.size();
		int cant;
		int codigo;
		ArrayList<Modelo> mod=modelos.getListadoModelos();
		int tammod=mod.size();
		
		for (int i=0;i<tammod;i++)
		{
			cant=0;
			codigo=mod.get(i).getCodigoModelo();
			for(int j=0;j<tamcon;j++)
			{
				cant+=listaConcesionarios.get(i).ventasModelo(codigo);
			}
			cadena+="  "+codigo+"   "+ //Codigo del modelo
						 mod.get(i).getDescripcion()+"      "+//Descripcion del modelo
						 cant+"\n";//Numero de unidades vendidas del modelo
		}
		
		
		return cadena;
	}

}
