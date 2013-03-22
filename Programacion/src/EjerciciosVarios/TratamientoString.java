package EjerciciosVarios;

import java.util.Scanner;

public class TratamientoString {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String frase;
		
		System.out.println("Introduzca una frase para tratar: ");
		frase=sc.nextLine();
		
		//Leer una frase con un numero de caracteres impar.
		while(frase.length()%2==0)
		{
			frase=sc.next();
		}
		
		//Mostrar su longitud
		System.out.println("La longitud de la frase es: "+frase.length());
		
		//Mostrar el caracter central
		System.out.println("El caracter central de la frase es: "+ frase.charAt(frase.length()/2));
		
		//Decir si es palindroma
		boolean palindroma=true;
		for(int i=0;i<frase.length()/2;i++)
		{
			if(frase.charAt(i)!=frase.charAt(frase.length()-i-1))
			{
				palindroma=false;
			}
		}
		if(palindroma)
		{
			System.out.println("La frase es palindroma");
		}
		else
		{
			System.out.println("La frase NO es palindroma");
		}
		
		//Mostrar los tres ultimos caracteres
		System.out.println("Los ultimos tres caracteres son: "+frase.substring(frase.length()-3));
		
		//Crear una nueva frase intercambiando caracteres
		String frase2="";
		int i=0;
		int y=frase.length()-1;
		
		while(i<y)
		{
			frase2=frase2+frase.charAt(i)+frase.charAt(y);
			i++;
			y--;
		}
		frase2=frase2+frase.charAt(frase.length()/2);
		System.out.println("Frase intercambiada: "+frase2);
		
		//Mostrar cuantas mayusculas y minusculas hay
		
		String letra;
		
		int mayus,minus;
		mayus=0;
		minus=0;
		for (i=0;i<frase.length();i++)
		{
			letra=frase.charAt(i)+"";
			letra=letra.toUpperCase();
			if(frase.charAt(i)==letra.charAt(0))
			{
				mayus++;
			}
			else
			{
				minus++;
			}
		}
		System.out.println("Letras mayusculas: "+mayus);
		System.out.println("Letras minusculas: "+minus);
		
		
		
		
		
		
		
		
		
		

	}

}
