package proyectoTema6;

import java.util.Date;

import rutinas.Rutinas;

public class Principal {

	public static void main(String[] args) {
		
		
		
		//Producto arrayProd []= new Producto[10];
		
		
		Producto p1= nuevoproducto();
		
		System.out.println(p1.toString());
	
	}
	
	public static int Menu()
	{
		int i;
		
		System.out.println("Que desea hacer?");
		System.out.println("1. Comprar Producto");
		System.out.println("2. Vender Producto");
		System.out.println("3. Mostrar Beneficio");
		System.out.println("4. Mostrar Inventario");
		System.out.println("5. Mostrar Productos por precio caro/barato");
		System.out.println("6. Mostrar Productos perecederos que caducan en 10 dias");
		System.out.println("0. Para salir");
		i=Rutinas.leeEntero("Introduzca un numero",0,6);
		
		return i;
	}
	
	public static Producto nuevoproducto()
	{
		Producto prod;
		
		System.out.println("Que tipo de producto quiere comprar?");
		
		
		int i=Rutinas.leeEntero("1. Producto no perecedero \n 2. Producto perecedero",1,2);
		
		String p1=Rutinas.leeString("Introduzca descripcion");
		String p2=Rutinas.leeString("Introduzca codigo");
		double p3=Rutinas.leeDouble("Introduzca precio de coste");
		double p4=Rutinas.leeDouble("Introduzca precio de venta");
		
		if(i==1)
		{
			prod=new Producto(p1,p2,p3,p4);
		}
		else
		{
			Date p5=Rutinas.leeFecha("Introduzca una fecha");
			
			prod=new ProductoPerecedero(p1,p2,p3,p4,p5);
		}
		
		
		return prod;
	}
	
	
	

}
