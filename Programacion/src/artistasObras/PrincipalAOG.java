package artistasObras;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import rutinas.Rutinas;
import rutinas.RutinasAOG;

public class PrincipalAOG {
	
	static Vector<Grupo> grupos=new Vector<Grupo>();
	static Vector<Artista> artistas=new Vector<Artista>();
	static Vector<Obra> obras=new Vector<Obra>();
	static final double comisionesSgae=0;
	
	//Test para el ejercicio de Entornos en Git
	
	public static void main(String[] args) {
		
//		Artista a1= new Artista("0001A2","Pepito",1000);
//		Artista a2= new Artista("0001A3","Potete");
//		Artista a3= new Artista("0001A4","Nomnomnom");
//		
//		Obra o1=new Obra("001232A","PEPITIN");
//		Obra o2=new Obra("001232B","Parrampam");
//		Obra o3=new Obra("001232C","Ratata");
//		
//		Vector<Artista> v1=new Vector<Artista>();
//		v1.add(a1);
//		v1.add(a2);
//		v1.add(a3);
//		
//		Vector<Obra> v2=new Vector<Obra>();
//		
//		v2.add(o1);
//		v2.add(o2);
//		v2.add(o3);
//		
//		Grupo g=new Grupo("00001","Lospas",v1,v2);
//		
//		System.out.println(g.toString());
		
		try {
			File fichA= new File("Artistas.obj");
			File fichO= new File("Obras.obj");
			File fichG= new File("Grupos.obj");
			
			
			if(fichA.exists() && fichO.exists() && fichG.exists())
			{
				if(fichA.exists())
				{
					ObjectInputStream inputArticulos = new ObjectInputStream(new FileInputStream("Artistas.obj"));
					artistas= (Vector<Artista>) inputArticulos.readObject();
				}
				if(fichO.exists())
				{
					ObjectInputStream inputObras = new ObjectInputStream(new FileInputStream("Obras.obj"));
					obras= (Vector<Obra>) inputObras.readObject();
				}
				if(fichG.exists())
				{
					ObjectInputStream inputGrupos = new ObjectInputStream(new FileInputStream("Grupos.obj"));
					grupos= (Vector<Grupo>) inputGrupos.readObject();
				}
			}
			else
			{
				System.out.println("Algun fichero no existe, se creara uno nuevo.");
			}
			
		
		
		
		int posPrincipal=menuPrincipal();
		int posArtistas=0;
		int posObras=0;
		int posGrupos=0;
		
		while(posPrincipal!=0)
		{
			switch(posPrincipal)
			{
			case 0://Salir del programa
				break;
			case 1://Switch artistas
				posArtistas=menuArtistas();
				while(posArtistas!=0)
				{
					switch(posArtistas)
					{
					case 0://Volver
						break;
					case 1://Mostrar Artistas
						mostrarVector(artistas);
						
						break;
					case 2://Añadir Artista
						Artista aux= RutinasAOG.leerArtista();
						
						while(comprobarIdA(aux.getIdArtista()))
						{
							aux.setIdArtista(Rutinas.leeString("El identificador existe, introduzca otro: "));
						}
						
						artistas.add(aux);
						
						break;
					case 3://Eliminar Artista
						if(!artistas.isEmpty())
						{
							String id=Rutinas.leeString("Introduzca Identificador del Artista");
							
							if(comprobarIdA(id))
							{
								if(RutinasAOG.deseaEliminar("Artista "+id))
								{
								Artista a=obtenerArtista(id);
								eliminarArtista(a);
								eliminarArtistasGrupos(a);
								}
								else System.out.println("No se ha eliminado "+id);
							}System.out.println("No existe "+id);
						}
						else System.out.println("No hay artistas para eliminar");
						
						break;
					}
					posArtistas=menuArtistas();
				}
				break;
			case 2://Switch obras
				posObras=menuObras();
				while(posObras!=0)
				{
					switch(posObras)
					{
					case 0://Volver
						break;
					case 1://Mostrar Obra
						mostrarVector(obras);
						break;
					case 2://Añadir Obra
						Obra aux= RutinasAOG.leerObra();
						
						while(comprobarIdO(aux.getIdObra()))
						{
							aux.setIdObra(Rutinas.leeString("El identificador existe, introduzca otro: "));
						}
						
						obras.add(aux);
						break;
					case 3://Eliminar Obra
						if(!obras.isEmpty())
						{
						
							String id=Rutinas.leeString("Introduzca Identificador de la Obra");
							
							if(comprobarIdO(id))
							{
								if(RutinasAOG.deseaEliminar("Obra "+id))
								{
									Obra o=obtenerObra(id);
									eliminarObra(o);
									eliminarObrasGrupos(o);
								}
								else System.out.println("No se ha eliminado "+id);
							}
							else System.out.print("No existe "+id);
							
						}
						else System.out.println("No hay obras para eliminar");
						
						break;
					}
					posObras=menuObras();
				}
				break;
			case 3://Switch Grupos
				String idA;
				String idO;
				String idG;
				Artista aaux;
				Obra oaux;
				Grupo gaux;
				int pos;
				
				posGrupos=menuGrupos();
				while(posGrupos!=0)
				{
					switch(posGrupos)
					{
					case 0://Volver
						break;
					case 1://Mostrar grupos
						mostrarVector(grupos);
						break;
					case 2://Crear Grupo
						Grupo aux=RutinasAOG.leerGrupo();
						
						while(comprobarIdG(aux.getIdGrupo()))
						{
							aux.setIdGrupo(Rutinas.leeString("El identificador existe, introduzca otro: "));
						}
						
						grupos.add(aux);
						
						
						break;
					case 3://Eliminar Grupo
						if(!grupos.isEmpty())//Si el vector grupos esta vacio no entra
						{							
							idG=RutinasAOG.leerIdGrupo("Introduzca Identificador del grupo");
							pos=0;
							
							pos=buscaIdEnGrupo(idG);//Busca la posicion del grupo en el vector
							
							if(comprobarIdG(idG))
							{
								if(RutinasAOG.deseaEliminar(idG))
								{
									grupos.remove(pos);
									System.out.println("Grupo: "+idG+" eliminado");
								}else System.out.println("No se ha eliminado "+idG);
							}
							else System.out.print("No existe "+idG);
						}
						else System.out.println("No hay grupos para eliminar.");
						
						
						break;
					case 4://Añadir artista
						if(!grupos.isEmpty())//Si el vector grupos esta vacio no entra
						{
							mostrarIdA();
							
							idA=RutinasAOG.leerIdArtista("Introduzca el identificador del artista que desea introducir: ");
							
							aaux=obtenerArtista(idA);
							
							mostrarIdG();
							
							idG=RutinasAOG.leerIdGrupo("Introduzca el identificador del grupo al que desea introducir "+idA+": ");
							
							pos=buscaIdEnGrupo(idG);//Busca la posicion del grupo en el vector
							
							if(!grupos.get(pos).estaArtista(aaux))
							{
								grupos.get(pos).anyadirArtista(aaux);
								grupos.get(pos).porcentajesDefecto();
							}
							else System.out.println("El artista "+idA+" ya existe en el grupo "+ idG);
						}
						else System.out.println("No hay grupos disponibles.");
						
						break;
					case 5://Añadir obra
						if(!grupos.isEmpty())//Si el vector grupos esta vacio no entra
						{
							mostrarIdO();
							
							idO=RutinasAOG.leerIdObra("Introduzca el identificador de la obra que desea introducir: ");
													
							oaux=obtenerObra(idO);
							
							mostrarIdG();
							
							idG=RutinasAOG.leerIdGrupo("Introduzca el identificador del grupo al que desea introducir "+idO+": ");
							
							pos=buscaIdEnGrupo(idG);
							
							if(!grupos.get(pos).estaObra(oaux))
							{
								grupos.get(pos).anyadirObra(oaux);
							}
							else System.out.println("La obra "+idO+" ya existe en el grupo "+ idG);
						}
						else System.out.println("No hay grupos disponibles.");
						
						break;
					case 6://Eliminar artista
						if(!grupos.isEmpty())//Si el vector grupos esta vacio no entra
						{
							mostrarIdG();
							
							idG=RutinasAOG.leerIdGrupo("Introduzca el identificador del grupo al que desea borrar un artista: ");
							
							pos=buscaIdEnGrupo(idG);//Busca la posicion del grupo en el vector
							
							if(!grupos.get(pos).getArtistas().isEmpty())//Si el grupo no tiene artistas no entra.
							{
								grupos.get(pos).mostrarIdsArtistas();
								
								idA=RutinasAOG.leerIdArtista("Introduzca el identificador del artista que desea eliminar: ");
								
								aaux= obtenerArtista(idA);
								
								grupos.get(pos).eliminarArtista(aaux);
								if(!grupos.get(pos).getArtistas().isEmpty())//Si no quedan artistas, no entra.
								{
								grupos.get(pos).porcentajesDefecto();
								}
							}
							else System.out.println("No hay artistas para eliminar en el grupo "+grupos.get(pos).getIdGrupo());
						}
						else System.out.println("No hay grupos disponibles.");
						
						break;
					case 7://Eliminar obra
						if(!grupos.isEmpty())//Si el vector grupos esta vacio no entra
						{
							mostrarIdG();
							
							idG=RutinasAOG.leerIdGrupo("Introduzca el identificador del grupo al que desea borrar un artista: ");
							
							pos=buscaIdEnGrupo(idG);//Busca la posicion del grupo en el vector
							
							if(!grupos.get(pos).getObras().isEmpty())//Si el grupo no tiene obras, no entra.
							{
								grupos.get(pos).mostrarIdsObras();
								
								idO=RutinasAOG.leerIdObra("Introduzca el identificador de la obra que desea eliminar: ");
								
								oaux= obtenerObra(idO);
								
								grupos.get(pos).eliminarObra(oaux);
							}
							else System.out.println("No hay obras para eliminar en el grupo "+grupos.get(pos).getIdGrupo());
						}
						else System.out.println("No hay grupos disponibles.");
						break;
					case 8://Fijar porcentajes de comisiones
						if(!grupos.isEmpty())//Si el vector grupos esta vacio no entra
						{
							mostrarIdG();
							
							idG=RutinasAOG.leerIdGrupo("Introduzca el identificador del grupo: ");
							
							pos=buscaIdEnGrupo(idG);//Busca la posicion del grupo en el vector
							
							if(!grupos.get(pos).getArtistas().isEmpty())//Si en el grupo no hay artistas, no entra.
							{
								grupos.get(pos).leerPorcentajes();
							}
							else System.out.println("No hay artistas disponibles para el grupo "+grupos.get(pos).getIdGrupo());
						}
						else System.out.println("No hay grupos disponibles.");
						
						break;
					}
					
					posGrupos=menuGrupos();
				}
				break;
			case 4:
				int posAdmn;
				
				posAdmn=menuAdministrar();
				
				while(posAdmn!=0)
				{
					switch(posAdmn)
					{
						case 0:
							break;
						case 1:
							if(!obras.isEmpty())
							{
								mostrarIdO();
								idO=RutinasAOG.leerIdObra("Introduzca el identificador de la obra");
								if(comprobarIdO(idO))
								{
									int cantidad=Rutinas.leeEntero("Introduzca la cantidad de reproducciones de la obra: "+idO, 0, 999999999);
							
									beneficiosObra(idO,cantidad);
								}
								else System.out.print("No existe "+idO);
							}
							else System.out.println("No hay obras disponibles");
							break;
					}
					posAdmn=menuAdministrar();
				}
				break;
				
			}
			posPrincipal=menuPrincipal();
		}
		System.out.println("FIN DE LA EJECUCION");
		
		
		//Guarda datos en los archivos.
		ObjectOutputStream outputArtistas= new ObjectOutputStream(new FileOutputStream("Artistas.obj"));
		ObjectOutputStream outputObras= new ObjectOutputStream(new FileOutputStream("Obras.obj"));
		ObjectOutputStream outputGrupos= new ObjectOutputStream(new FileOutputStream("Grupos.obj"));
		
		outputArtistas.writeObject(artistas);
		outputObras.writeObject(obras);
		outputGrupos.writeObject(grupos);
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}

	}
		
	
	
	
	public static int menuPrincipal()
	{
		int i=4;//Numero de opciones opciones+1
		
		System.out.println("Menu Principal\n");
		System.out.println("0. Salir");
		System.out.println("1. Gestion Artistas");
		System.out.println("2. Gestion Obras");
		System.out.println("3. Gestion Grupos");
		System.out.println("4. Administrar");
		
		return Rutinas.leeEntero("Introduzca la posicion a la que deseea ir", 0, i);//Comprobar el numero de opciones
	}
	public static int menuArtistas()
	{
		int i=3;//Numero de opciones opciones+1
		
		System.out.println("Menu Artistas\n");
		System.out.println("0. Volver");
		System.out.println("1. Mostrar artistas");
		System.out.println("2. Añadir artista");
		System.out.println("3. Eliminar artista");
		
		return Rutinas.leeEntero("Introduzca la posicion a la que deseea ir", 0, i);//Comprobar el numero de opciones
	}
	public static int menuObras()
	{
		int i=3;//Numero de opciones opciones
		
		System.out.println("Menu Obras\n");
		System.out.println("0. Volver");
		System.out.println("1. Mostrar obras");
		System.out.println("2. Añadir obra");
		System.out.println("3. Eliminar obra");
		
		return Rutinas.leeEntero("Introduzca la posicion a la que deseea ir", 0, i);//Comprobar el numero de opciones
	}
	public static int menuGrupos()
	{
		int i=8;//Numero de opciones opciones
		
		System.out.println("Menu Grupos\n");
		System.out.println("0. Volver");
		System.out.println("1. Mostrar grupos");
		System.out.println("2. Crear grupo");
		System.out.println("3. Eliminar grupo");
		System.out.println("4. Añadir artista");
		System.out.println("5. Añadir obra");
		System.out.println("6. Eliminar artista");
		System.out.println("7. Eliminar obra");
		System.out.println("8. Fijar porcentajes de comisiones");
		
		return Rutinas.leeEntero("Introduzca la posicion a la que deseea ir", 0, i);//Comprobar el numero de opciones
		
	}
	public static int menuAdministrar()
	{
		int i=1;//Numero de opciones opciones
		
		System.out.println("Menu Administracion\n");
		System.out.println("0. Volver");
		System.out.println("1. Beneficios obras");
		
		return Rutinas.leeEntero("Introduzca la posicion a la que deseea ir", 0, i);//Comprobar el numero de opciones
		
	}
	
	public static boolean comprobarIdG(String Id)
	{
		for (int i=0;i<grupos.size();i++)
		{
			if(grupos.get(i).getIdGrupo().equals(Id))//Comprueba que el Id del grupos se encuentre en el vector grupos
			{
				return true;//Devuelve true si el grupo se encuentra en el vector.
			}
		}
		
		return false;
	}
	public static boolean comprobarIdA(String Id)
	{
		for (int i=0;i<artistas.size();i++)
		{
			if(artistas.get(i).getIdArtista().equals(Id))//Comprueba que el Id del artista se encuentre en el vector artistas
			{
				return true;//Devuelve true si el artista se encuentra en el vector.
			}
		}
		
		return false;
	}
	public static boolean comprobarIdO(String Id)
	{
		for(int i=0;i<obras.size();i++)
		{
			if(obras.get(i).getIdObra().equals(Id))//Comprueba que el Id de la obra este en el vector obras.
			{
				return true;//Devuelve true si la obra se encuentra en el vector.
			}
		}
		
		return false;
	}
	
	public static Artista obtenerArtista(String id)
	{
		boolean encontrado=false;
		int pos=0;
		
		while(!encontrado && pos<artistas.size())
		{
			if(artistas.get(pos).getIdArtista().equals(id))//Busca la posicion del elemento cuya identificador sea id.
			{
				encontrado=true;
				pos--;
			}
			pos++;
		}
		return artistas.get(pos);
	}
	public static Obra obtenerObra(String id)
	{
		boolean encontrado=false;
		int pos=0;
		
		while(!encontrado && pos<obras.size())
		{
			if(obras.get(pos).getIdObra().equals(id))//Busca la posicion del elemento cuya identificador sea id.
			{
				encontrado=true;
				pos--;
			}
			pos++;
		}
		return obras.get(pos);
	}
	public static Grupo obtenerGrupo(String id)
	{
		boolean encontrado=false;
		int pos=0;
		
		while(!encontrado && pos<grupos.size())
		{
			if(grupos.get(pos).getIdGrupo().equals(id))//Busca la posicion del elemento cuya identificador sea id.
			{
				encontrado=true;
				pos--;
			}
			pos++;
		}
		return grupos.get(pos);
	}
	
	
	public static void mostrarVector(Vector<?> v)
	{
		for( int i=0;i<v.size();i++) //Muestra el vector
		{
			System.out.println(v.get(i).toString());
		}
	}
	public static void mostrarIdA()//Muestra los identificadores de los artistas.
	{
		for(int i=0;i<artistas.size();i++)
		{
			System.out.print(artistas.get(i).getIdArtista()+" ");
		}
		System.out.println("\n");
	}
	public static void mostrarIdO()//Muestra los identificadores de las obras.
	{
		for(int i=0;i<obras.size();i++)
		{
			System.out.print(obras.get(i).getIdObra()+" ");
		}
		System.out.println("\n");
	}
	public static void mostrarIdG()//Muestra los identificadores de los grupos
	{
		for(int i=0;i<grupos.size();i++)
		{
			System.out.print(grupos.get(i).getIdGrupo()+" ");
		}
		System.out.println("\n");
	}
	
	
	public static void eliminarObra(Obra o)//Elimina la obra del vector obras
	{
		boolean encontrado=false;
		int pos=0;
		
		while(!encontrado && pos<obras.size())//Busca en el vector el identificador de la obra. Si no lo encuentra llegara hasta el final del vector
		{
			if(obras.get(pos).equals(o))
			{
				encontrado=true;
				pos--;
			}
			pos++;
		}
		
		if(encontrado)
		{
			System.out.println("Obra: "+o.getIdObra()+" eliminada");
			obras.remove(pos);
		}
		else System.out.println("Obra: "+o.getIdObra()+" no encontrada.");
	}
	public static void eliminarObrasGrupos(Obra o)//Elimina la obra del grupo
	{
		for( int i=0;i<grupos.size();i++)
		{
			if(grupos.get(i).estaObra(o))
			{
				grupos.get(i).eliminarObra(o);
			}
		}
	}
	
	public static void eliminarArtista(Artista a)//Elimina el artista del vector artistas
	{
		boolean encontrado=false;
		int pos=0;
		
		while(!encontrado && pos<artistas.size())//Busca en el vector el identificador de la obra. Si no lo encuentra llegara hasta el final del vector
		{
			if(artistas.get(pos).equals(a))
			{
				encontrado=true;
				pos--;
			}
			pos++;
		}
		
		if(encontrado)
		{
			artistas.remove(pos);
			System.out.println("Artista: "+a.getIdArtista()+" eliminado");
			
		}
		else System.out.println("Artista: "+a.getIdArtista()+" no encontrado.");
	}
	public static void eliminarArtistasGrupos(Artista a) //Elimina el artista del grupo
	{
		for( int i=0;i<grupos.size();i++)
		{
			if(grupos.get(i).estaArtista(a))
			{
				grupos.get(i).eliminarArtista(a);
			}
		}
	}

	public static int buscaIdEnGrupo(String id)//Busca la posicion del grupo en el vector
	{
		int pos=0;
		boolean encontrado=false;
		while(!encontrado)
		{
			if(grupos.get(pos).getIdGrupo().equals(id))
			{
				encontrado=true;
				pos--;
			}
			pos++;
		}
		return pos;
	}
	
	public static void beneficiosObra(String idO,int cantidad)
	{
		for(int i=0;i<grupos.size();i++)
		{
			if(grupos.get(i).estaObra(obtenerObra(idO)))//Para aquellos grupos con la obra idO
			{
				Grupo gaux= grupos.get(i);
				for(int j=0;j<gaux.getArtistas().size();j++)//Para todos los artistas del grupo
				{
					double comisionO=cantidad*gaux.getObras().get(gaux.getObras().indexOf(obtenerObra(idO))).getComision();
					double derechos=((gaux.getPorcentajesArtistas().get(j)/100)*comisionO);
					Artista aaux= gaux.getArtistas().get(j);
					aaux.cobrarDerechos(derechos);
					
					for(int z=0;z<artistas.size();z++)//Para el vector de los artistas
					{
						if(artistas.get(z).getIdArtista().equals(aaux.getIdArtista()))
						{
							artistas.get(z).cobrarDerechos(derechos);
						}
					}
					
					
				}
			}
		}
	}
}
