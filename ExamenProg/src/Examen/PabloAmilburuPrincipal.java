
//Pablo Amilburu Fontecha
//Examen Programacion 10-12-2012

package Examen;

import rutinas.Rutinas;

public class PabloAmilburuPrincipal {
	static double total = 0;
	static Ordenador aorde[] = new Ordenador[10];
	static int indi = 0;

	public static void main(String[] args) {
		
		
		
//		pide(new Portatil());
//		pide(new Ordenador());
//		
//		pide(new Netbook());
//		pide(new Netbook());
//		pide(new Netbook());
		
		
		
		
		aorde[indi]=new Ordenador("HP",2000,new Procesador(123,"Intel"));
		indi++;
		aorde[indi]=new Portatil("Asus",300,3,new Procesador(123,"Intel"));
		indi++;
		aorde[indi]=new Netbook("Thosiba",400,1,6,new Procesador(123,"Intel"));
		indi++;		
		aorde[indi]=new Netbook("Asus",1000,2,12,new Procesador(123,"Intel"));
		indi++;
		aorde[indi]=new Ordenador("HP",1000,new Procesador(123,"Intel"));
		indi++;
		aorde[indi]=new Netbook("HP",600,1,10,new Procesador(1234,"AMD"));
		indi++;
		aorde[indi]=new Netbook("Thosiba",1200,3,15,new Procesador(123,"Intel"));
		indi++;
		
		
		
		//muestra();
		
		listadoNetbook(11);
		
		
		
//		String tipo = "";
//		String opcion = "";
//		System.out.println("OPCIONES");
//		System.out.println("1-Comprar producto");
//		System.out.println("2-Vender producto");
//		System.out.println("3-Mostrar ganancias del dia");
//		System.out.println("4-Mostrar inventario");
//		System.out.println("5-Mostrar productos de más caro a más barato");
//		System.out.println("6-Productos perecederos que caducan antes de 10 días");
//		System.out.println("0-Terminar");
//
//		do {
//			opcion = Rutinas.leeString("Seleccione una opcion: ");
//			switch (opcion.substring(0, 1)) {
//			case "1":
//				tipo = Rutinas.leeString("Que tipo...  ");
//				switch (tipo.toUpperCase().substring(0, 1)) {
//				case "S":
//					aorde[indi] = new Ordenador();
//					pide(aorde[indi]);
//					break;
//				case "P":
//					aorde[indi] = new Portatil();
//					pide(aorde[indi]);
//					break;
//				case "N":
//					aorde[indi] = new Netbook();
//					pide(aorde[indi]);
//					break;
//				default:
//					System.out.println("Error en tipo " + tipo);
//				}
//				break;
//			case "2":
//				break;
//			case "3":
//				break;
//			case "4":
//				muestra();
//			case "5":
//				break;
//			case "6":
//				break;
//			case "7":
//				break;
//			default:
//				System.out.println("Error en opcion " );
//			}
//		} while (!tipo.equals("0"));

	}
	
	//Codigo Modificado/añadido por Pablo Amilburu Fontecha
	public static void pide(Ordenador orde) {
		orde.datos();
		aorde[indi]=orde;
		indi++;
	}
	
	public static void listadoNetbook(int tam)
	{
		
		Netbook NetOrd[]=new Netbook[10];
		int indice=0;
		for(int i=0;i<indi;i++)
		{
			if(aorde[i].getClass().equals(Netbook.class))
			{
				NetOrd[indice]=(Netbook) aorde[i];
				indice++;
			}
		}
		
		for(int i=0;i<indice;i++)
		{
			if(NetOrd[i].get_pantalla()<11)
			{
				System.out.println(NetOrd[i].toString());
			}
		}
	}
	//Fin Codigo modificado

	public static void muestra() {
		
		
		for (int i = 0; i < indi; i++) {
			System.out.println(aorde[i].getClass() + "\t" + aorde[i].toString());
			total += aorde[i].mostrarprecio();
			//System.out.println(((Netbook) aorde[i]).pontegafas());//Me da excepcion de ClassCast
		}
		System.out.println("El total es.. " + total);
	}
	
	
}
