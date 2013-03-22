//package artistasObras.AOGv2Nofunciona;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.Vector;
//import rutinas.Rutinas;
//import rutinas.RutinasAOG;
//
//public class PrincipalAOG {
//	
//	static Vector<Grupo> gruposold=new Vector<Grupo>();
//	static Vector<Artista> artistasold=new Vector<Artista>();
//	static Vector<Obra> obrasold=new Vector<Obra>();
//	static final double comisionesSgae=0;
//	
//	
//	static VectorArtistas artistas;
//	static VectorObras obras;
//	static VectorGrupos grupos;
//	
//	
//	public static void main(String[] args) {
//		
//		try {
//			File fichA= new File("Artistas.obj");
//			File fichO= new File("Obras.obj");
//			File fichG= new File("Grupos.obj");
//			
//			
//			if(fichA.exists() && fichO.exists() && fichG.exists())
//			{
//				if(fichA.exists())
//				{
//					ObjectInputStream inputArticulos = new ObjectInputStream(new FileInputStream("Artistas.obj"));
//					//artistasold= (Vector<Artista>) inputArticulos.readObject();
//					artistas = (VectorArtistas) inputArticulos.readObject();
//				}
//				if(fichO.exists())
//				{
//					ObjectInputStream inputObras = new ObjectInputStream(new FileInputStream("Obras.obj"));
//					//obrasold= (Vector<Obra>) inputObras.readObject();
//					obras = (VectorObras) inputObras.readObject();
//				}
//				if(fichG.exists())
//				{
//					ObjectInputStream inputGrupos = new ObjectInputStream(new FileInputStream("Grupos.obj"));
//					//gruposold= (Vector<Grupo>) inputGrupos.readObject();
//					grupos = (VectorGrupos) inputGrupos.readObject();
//				}
//			}
//			else
//			{
//				System.out.println("Algun fichero no existe, se creara uno nuevo.");
//			}
//			
//		
//		
//		
//		int posPrincipal=menuPrincipal();
//		int posArtistas=0;
//		int posObras=0;
//		int posGrupos=0;
//		
//		while(posPrincipal!=0)
//		{
//			switch(posPrincipal)
//			{
//			case 0://Salir del programa
//				break;
//			case 1://Switch artistas
//				posArtistas=menuArtistas();
//				while(posArtistas!=0)
//				{
//					switch(posArtistas)
//					{
//					case 0://Volver
//						break;
//					case 1://Mostrar Artistas
//						
//						System.out.println(artistas.toString());
//						
//						break;
//					case 2://Añadir Artista
//						Artista aux= RutinasAOG.leerArtista();
//						
//						while(artistas.comprobarId(aux.getIdArtista()))
//						{
//							aux.setIdArtista(Rutinas.leeString("El identificador existe, introduzca otro: "));
//						}
//						
//						artistas.anyadirArtista(aux);
//						
//						break;
//					case 3://Eliminar Artista
//						if(!artistas.vacio())
//						{
//							String id=Rutinas.leeString("Introduzca Identificador del Artista");
//							
//							while(!artistas.comprobarId(id))
//							{
//								id=Rutinas.leeString("No existe el identificador: "+id+" Por favor introduzca otro.");
//							}
//							
//							if(RutinasAOG.deseaEliminar("Artista "+id))
//							{
//								Artista a=artistas.obtenerArtista(id);
//								artistas.eliminarArtista(a);
//								grupos.eliminarArtistasGrupos(a);
//								
//							}
//							else System.out.println("No se ha eliminado "+id);
//						}
//						else System.out.println("No hay artistas para eliminar");
//						
//						break;
//					}
//					posArtistas=menuArtistas();
//				}
//				break;
//			case 2://Switch obras
//				posObras=menuObras();
//				while(posObras!=0)
//				{
//					switch(posObras)
//					{
//					case 0://Volver
//						break;
//					case 1://Mostrar Obra
//						System.out.println(obras.toString());
//						break;
//					case 2://Añadir Obra
//						Obra aux= RutinasAOG.leerObra();
//						
//						while(obras.comprobarIdO(aux.getIdObra()))
//						{
//							aux.setIdObra(Rutinas.leeString("El identificador existe, introduzca otro: "));
//						}
//						
//						obras.anyadirObra(aux);
//						break;
//					case 3://Eliminar Obra
//						if(!obras.vacio())
//						{
//						
//							String id=Rutinas.leeString("Introduzca Identificador de la Obra");
//							
//							while(!obras.comprobarIdO(id))
//							{
//								id=Rutinas.leeString("No existe el identificador: "+id+" Por favor introduzca otro.");
//							}
//							
//							if(RutinasAOG.deseaEliminar("Obra "+id))
//							{
//								Obra o=obras.obtenerObra(id);
//								obras.eliminarObra(o);
//								grupos.eliminarObraGrupos(o);
//								
//							}
//							else System.out.println("No se ha eliminado "+id);
//						}
//						else System.out.println("No hay obras para eliminar");
//						
//						break;
//					}
//					posObras=menuObras();
//				}
//				break;
//			case 3://Switch Grupos
//				String idArtista,idObra,idGrupo;
//				Artista aaux;
//				Obra oaux;
//				Grupo gaux;
//				boolean encontrado;
//				int pos;
//				
//				posGrupos=menuGrupos();
//				while(posGrupos!=0)
//				{
//					switch(posGrupos)
//					{
//					case 0://Volver
//						break;
//					case 1://Mostrar grupos
//						System.out.println(grupos.toString());
//						break;
//					case 2://Crear Grupo
//						gaux=RutinasAOG.leerGrupo();
//						
//						while(grupos.comprobarId(gaux.getIdGrupo()))
//						{
//							gaux.setIdGrupo(Rutinas.leeString("El identificador existe, introduzca otro: "));
//						}
//						
//						grupos.anyadirGrupo(gaux);
//						
//						
//						break;
//					case 3://Eliminar Grupo
//						if(!grupos.vacio())//Si el vector grupos esta vacio no entra
//						{							
//							idGrupo=RutinasAOG.leerIdGrupo("Introduzca Identificador del grupo");
//							
//							while(!grupos.comprobarId(idGrupo))
//							{
//								idGrupo=Rutinas.leeString("No existe el identificador: "+idGrupo+" Por favor introduzca otro.");
//							}
//							
//							gaux = grupos.obtenerGrupo(idGrupo);
//							
//							grupos.eliminarGrupo(gaux);
//						}
//						else System.out.println("No hay grupos para eliminar.");
//						
//						
//						break;
//					case 4://Añadir artista
//						if(!grupos.vacio())//Si el vector grupos esta vacio no entra
//						{
//							System.out.println(artistas.listarIds());
//							
//							idArtista=RutinasAOG.leerIdArtista("Introduzca el identificador del artista que desea introducir: ");
//							
//							aaux=artistas.obtenerArtista(idArtista);
//							
//							System.out.println(grupos.listarIds());
//							
//							idGrupo=RutinasAOG.leerIdGrupo("Introduzca el identificador del grupo al que desea introducir "+idArtista+": ");
//							
//							grupos.obtenerGrupo(idGrupo).anyadirArtista(aaux);
//							grupos.obtenerGrupo(idGrupo).porcentajesDefecto();
//						}
//						else System.out.println("No hay grupos disponibles.");
//						
//						break;
//					case 5://Añadir obra
//						if(!grupos.vacio())//Si el vector grupos esta vacio no entra
//						{
//							System.out.println(obras.listarIds());
//							
//							idObra=RutinasAOG.leerIdObra("Introduzca el identificador de la obra que desea introducir: ");
//													
//							oaux=obras.obtenerObra(idObra);
//							
//							System.out.println(grupos.listarIds());
//							
//							idGrupo=RutinasAOG.leerIdGrupo("Introduzca el identificador del grupo al que desea introducir "+idObra+": ");
//							
//							grupos.obtenerGrupo(idGrupo).anyadirObra(oaux);
//						}
//						else System.out.println("No hay grupos disponibles.");
//						
//						break;
//					case 6://Eliminar artista
//						if(!grupos.vacio())//Si el vector grupos esta vacio no entra
//						{
//							System.out.println(grupos.listarIds());
//							
//							idGrupo=RutinasAOG.leerIdGrupo("Introduzca el identificador del grupo al que desea borrar un artista: ");
//							
//							gaux=grupos.obtenerGrupo(idGrupo);
//							
//							if(!gaux.tieneArtistas())//Si el grupo no tiene artistas no entra.
//							{
//								gaux.listarIdsArtistas();
//								
//								idArtista=RutinasAOG.leerIdArtista("Introduzca el identificador del artista que desea eliminar: ");
//								
//								aaux= artistas.obtenerArtista(idArtista);
//								
//								gaux.eliminarArtista(aaux);
//								if(!gaux.tieneArtistas())//Si no quedan artistas, no entra.
//								{
//									gaux.porcentajesDefecto();
//								}
//							}
//							else System.out.println("No hay artistas para eliminar en el grupo "+gaux.getIdGrupo());
//						}
//						else System.out.println("No hay grupos disponibles.");
//						
//						break;
//					case 7://Eliminar obra //Continuar cambiando aqui.!!!!!
////						if(!gruposold.isEmpty())//Si el vector grupos esta vacio no entra
////						{
////							mostrarIdG();
////							
////							id=RutinasAOG.leerIdGrupo("Introduzca el identificador del grupo al que desea borrar un artista: ");
////							
////							pos=buscaIdEnGrupo(id);//Busca la posicion del grupo en el vector
////							
////							if(!gruposold.get(pos).getObras().isEmpty())//Si el grupo no tiene obras, no entra.
////							{
////								gruposold.get(pos).mostrarIdsObras();
////								
////								id=RutinasAOG.leerIdObra("Introduzca el identificador de la obra que desea eliminar: ");
////								
////								oaux= obtenerObra(id);
////								
////								gruposold.get(pos).eliminarObra(oaux);
////							}
////							else System.out.println("No hay obras para eliminar en el grupo "+gruposold.get(pos).getIdGrupo());
////						}
////						else System.out.println("No hay grupos disponibles.");
//						break;
//					case 8://Fijar porcentajes de comisiones
////						if(!gruposold.isEmpty())//Si el vector grupos esta vacio no entra
////						{
////							mostrarIdG();
////							
////							id=RutinasAOG.leerIdGrupo("Introduzca el identificador del grupo: ");
////							
////							pos=buscaIdEnGrupo(id);//Busca la posicion del grupo en el vector
////							
////							if(!gruposold.get(pos).getArtistas().isEmpty())//Si en el grupo no hay artistas, no entra.
////							{
////								gruposold.get(pos).leerPorcentajes();
////							}
////							else System.out.println("No hay artistas disponibles para el grupo "+gruposold.get(pos).getIdGrupo());
////						}
////						else System.out.println("No hay grupos disponibles.");
////						
//						break;
//					}
//					posGrupos=menuGrupos();
//				}
//				break;
//			}
//			posPrincipal=menuPrincipal();
//		}
//		System.out.println("FIN DE LA EJECUCION");
//		
//		
//		//Guarda datos en los archivos.
//		ObjectOutputStream outputArtistas= new ObjectOutputStream(new FileOutputStream("Artistas.obj"));
//		ObjectOutputStream outputObras= new ObjectOutputStream(new FileOutputStream("Obras.obj"));
//		ObjectOutputStream outputGrupos= new ObjectOutputStream(new FileOutputStream("Grupos.obj"));
//		
//		outputArtistas.writeObject(artistasold);
//		outputObras.writeObject(obrasold);
//		outputGrupos.writeObject(gruposold);
//		
//	} catch (FileNotFoundException e) {
//		e.printStackTrace();
//	} catch (IOException e) {
//		e.printStackTrace();
//	} catch (ClassNotFoundException e) {
//		e.printStackTrace();
//	}
//
//	}
//		
//	
//	
//	
//	public static int menuPrincipal()
//	{
//		int i=3;//Numero de opciones opciones+1
//		
//		System.out.println("Menu Principal\n");
//		System.out.println("0. Salir");
//		System.out.println("1. Gestion Artistas");
//		System.out.println("2. Gestion Obras");
//		System.out.println("3. Gestion Grupos");
//		
//		return Rutinas.leeEntero("Introduzca la posicion a la que deseea ir", 0, i);//Comprobar el numero de opciones
//	}
//	public static int menuArtistas()
//	{
//		int i=3;//Numero de opciones opciones+1
//		
//		System.out.println("Menu Artistas\n");
//		System.out.println("0. Volver");
//		System.out.println("1. Mostrar artistas");
//		System.out.println("2. Añadir artista");
//		System.out.println("3. Eliminar artista");
//		
//		return Rutinas.leeEntero("Introduzca la posicion a la que deseea ir", 0, i);//Comprobar el numero de opciones
//	}
//	public static int menuObras()
//	{
//		int i=3;//Numero de opciones opciones
//		
//		System.out.println("Menu Obras\n");
//		System.out.println("0. Volver");
//		System.out.println("1. Mostrar obras");
//		System.out.println("2. Añadir obra");
//		System.out.println("3. Eliminar obra");
//		
//		return Rutinas.leeEntero("Introduzca la posicion a la que deseea ir", 0, i);//Comprobar el numero de opciones
//	}
//	public static int menuGrupos()
//	{
//		int i=8;//Numero de opciones opciones
//		
//		System.out.println("Menu Grupos\n");
//		System.out.println("0. Volver");
//		System.out.println("1. Mostrar grupos");
//		System.out.println("2. Crear grupo");
//		System.out.println("3. Eliminar grupo");
//		System.out.println("4. Añadir artista");
//		System.out.println("5. Añadir obra");
//		System.out.println("6. Eliminar artista");
//		System.out.println("7. Eliminar obra");
//		System.out.println("8. Fijar porcentajes de comisiones");
//		
//		return Rutinas.leeEntero("Introduzca la posicion a la que deseea ir", 0, i);//Comprobar el numero de opciones
//		
//	}
//	
//	public static boolean comprobarIdG(String Id)
//	{
//		for (int i=0;i<gruposold.size();i++)
//		{
//			if(gruposold.get(i).getIdGrupo().equals(Id))//Comprueba que el Id del grupos se encuentre en el vector grupos
//			{
//				return true;//Devuelve true si el grupo se encuentra en el vector.
//			}
//		}
//		
//		return false;
//	}
//	public static boolean comprobarIdA(String Id)
//	{
//		for (int i=0;i<artistasold.size();i++)
//		{
//			if(artistasold.get(i).getIdArtista().equals(Id))//Comprueba que el Id del artista se encuentre en el vector artistas
//			{
//				return true;//Devuelve true si el artista se encuentra en el vector.
//			}
//		}
//		
//		return false;
//	}
//	public static boolean comprobarIdO(String Id)
//	{
//		for(int i=0;i<obrasold.size();i++)
//		{
//			if(obrasold.get(i).getIdObra().equals(Id))//Comprueba que el Id de la obra este en el vector obras.
//			{
//				return true;//Devuelve true si la obra se encuentra en el vector.
//			}
//		}
//		
//		return false;
//	}
//	
//	public static Artista obtenerArtista(String id)
//	{
//		boolean encontrado=false;
//		int pos=0;
//		
//		while(!encontrado && pos<artistasold.size())
//		{
//			if(artistasold.get(pos).getIdArtista().equals(id))//Busca la posicion del elemento cuya identificador sea id.
//			{
//				encontrado=true;
//				pos--;
//			}
//			pos++;
//		}
//		return artistasold.get(pos);
//	}
//	public static Obra obtenerObra(String id)
//	{
//		boolean encontrado=false;
//		int pos=0;
//		
//		while(!encontrado && pos<obrasold.size())
//		{
//			if(obrasold.get(pos).getIdObra().equals(id))//Busca la posicion del elemento cuya identificador sea id.
//			{
//				encontrado=true;
//				pos--;
//			}
//			pos++;
//		}
//		return obrasold.get(pos);
//	}
//	public static Grupo obtenerGrupo(String id)
//	{
//		boolean encontrado=false;
//		int pos=0;
//		
//		while(!encontrado && pos<gruposold.size())
//		{
//			if(gruposold.get(pos).getIdGrupo().equals(id))//Busca la posicion del elemento cuya identificador sea id.
//			{
//				encontrado=true;
//				pos--;
//			}
//			pos++;
//		}
//		return gruposold.get(pos);
//	}
//	
//	
//	public static void mostrarVector(Vector<?> v)
//	{
//		for( int i=0;i<v.size();i++) //Muestra el vector
//		{
//			System.out.println(v.get(i).toString());
//		}
//	}
//	public static void mostrarIdA()//Muestra los identificadores de los artistas.
//	{
//		for(int i=0;i<artistasold.size();i++)
//		{
//			System.out.print(artistasold.get(i).getIdArtista()+" ");
//		}
//		System.out.println("\n");
//	}
//	public static void mostrarIdO()//Muestra los identificadores de las obras.
//	{
//		for(int i=0;i<obrasold.size();i++)
//		{
//			System.out.print(obrasold.get(i).getIdObra()+" ");
//		}
//		System.out.println("\n");
//	}
//	public static void mostrarIdG()//Muestra los identificadores de los grupos
//	{
//		for(int i=0;i<gruposold.size();i++)
//		{
//			System.out.print(gruposold.get(i).getIdGrupo()+" ");
//		}
//		System.out.println("\n");
//	}
//	
//	
//	public static void eliminarObra(Obra o)//Elimina la obra del vector obras
//	{
//		boolean encontrado=false;
//		int pos=0;
//		
//		while(!encontrado && pos<obrasold.size())//Busca en el vector el identificador de la obra. Si no lo encuentra llegara hasta el final del vector
//		{
//			if(obrasold.get(pos).equals(o))
//			{
//				encontrado=true;
//				pos--;
//			}
//			pos++;
//		}
//		
//		if(encontrado)
//		{
//			System.out.println("Obra: "+o.getIdObra()+" eliminada");
//			obrasold.remove(pos);
//		}
//		else System.out.println("Obra: "+o.getIdObra()+" no encontrada.");
//	}
//	public static void eliminarObrasGrupos(Obra o)//Elimina la obra del grupo
//	{
//		for( int i=0;i<gruposold.size();i++)
//		{
//			if(gruposold.get(i).estaObra(o))
//			{
//				gruposold.get(i).eliminarObra(o);
//			}
//		}
//	}
//	
//	public static void eliminarArtista(Artista a)//Elimina el artista del vector artistas
//	{
//		boolean encontrado=false;
//		int pos=0;
//		
//		while(!encontrado && pos<artistasold.size())//Busca en el vector el identificador de la obra. Si no lo encuentra llegara hasta el final del vector
//		{
//			if(artistasold.get(pos).equals(a))
//			{
//				encontrado=true;
//				pos--;
//			}
//			pos++;
//		}
//		
//		if(encontrado)
//		{
//			artistasold.remove(pos);
//			System.out.println("Artista: "+a.getIdArtista()+" eliminado");
//			
//		}
//		else System.out.println("Artista: "+a.getIdArtista()+" no encontrado.");
//	}
//	public static void eliminarArtistasGrupos(Artista a) //Elimina el artista del grupo
//	{
//		for( int i=0;i<gruposold.size();i++)
//		{
//			if(gruposold.get(i).estaArtista(a))
//			{
//				gruposold.get(i).eliminarArtista(a);
//			}
//		}
//	}
//
//	public static int buscaIdEnGrupo(String id)//Busca la posicion del grupo en el vector
//	{
//		int pos=0;
//		boolean encontrado=false;
//		while(!encontrado)
//		{
//			if(gruposold.get(pos).getIdGrupo().equals(id))
//			{
//				encontrado=true;
//				pos--;
//			}
//			pos++;
//		}
//		return pos;
//	}
//}
