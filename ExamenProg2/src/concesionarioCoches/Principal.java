package concesionarioCoches;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import rutinas.Rutinas;

public class Principal {

	
	public static void main(String[] args) {
		
		Modelos modelos = new Modelos();
		Concesionarios concesionarios = new Concesionarios();
		
		
		try {
			
			//Abriendo los ficheros y cargando los datos.
			File fichA = new File("Modelos.obj");
			File fichB = new File("Concesionarios.obj");
			
			if(fichA.exists() && fichB.exists())
			{
				ObjectInputStream inputModelos = new ObjectInputStream(new FileInputStream("Modelos.obj"));
				modelos= (Modelos) inputModelos.readObject();
				
				ObjectInputStream inputConcesionarios = new ObjectInputStream(new FileInputStream("Concesionarios.obj"));
				concesionarios= (Concesionarios) inputConcesionarios.readObject();
			}
			else
			{
				System.out.println("Algun fichero no existe. Se creara uno nuevo.");
			}
			
			int posPrincipal=menu();
			
			while(posPrincipal!=0)
			{
				switch(posPrincipal)
				{
				case 0://Salir del programa
					break;
				case 1://Añadir modelo
					modelos.altaModelo();
					break;
				case 2://Añadir concesionario
					concesionarios.altaConcesionario();
					break;
				case 3://Añadir modelo a concesionario
					concesionarios.AnyadirModeloConcesionario(modelos);					
					break;
				case 4: //Ventas por concesionario
					System.out.println(concesionarios.ventasPorConcesionario());
					break;
				case 5: //Ventas por modelo
					System.out.println(concesionarios.ventasPorModelo(modelos));
					break;
				case 6: //Mostrar modelos
					System.out.println(modelos.toString());
					break;
				case 7: //Mostrar concesionarios
					System.out.println(concesionarios.toString());
					break;
				}
				posPrincipal=menu();
			}
			
			
			
			
			
			
			
			
			
			//Guarda datos en los archivos.
			ObjectOutputStream outputModelos= new ObjectOutputStream(new FileOutputStream("Modelos.obj"));
			ObjectOutputStream outputConcesionarios= new ObjectOutputStream(new FileOutputStream("Concesionarios.obj"));
			
			outputModelos.writeObject(modelos);
			outputConcesionarios.writeObject(concesionarios);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//FIN MAIN
	
	public static int menu()
	{
		int i=7;//Numero de opciones opciones+1
		
		System.out.println("Menu Principal\n");
		System.out.println("0. Salir");
		System.out.println("1. Añadir modelo (Proceso 2)");
		System.out.println("2. Añadir concesionario (Proceso 3)");
		System.out.println("3. Añadir modelo a concesionario (Proceso 4)");
		System.out.println("4. Ventas por concesionario (Proceso 5)");
		System.out.println("5. Ventas por modelo (Proceso 6)");
		System.out.println("6. Mostrar modelos");
		System.out.println("7. Mostrar concesionarios");
		
		return Rutinas.leeEntero("Introduzca la posicion a la que deseea ir", 0, i);//Comprobar el numero de opciones
	}

}