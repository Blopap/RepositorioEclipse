//Contar todas las letras de la frase


package Tema3;

public class Ej3Mod {
	public static int contar(String cadena, char car)
	{
		int cont=0;
		
		for(int i=0;i<cadena.length();i++)
		{
			if(cadena.charAt(i)==car)
			{
				cont++;
			}
		}
		return cont;
	}
	
	public static void main(String[] args) {
		String cadena;
		int num,l;
		
		cadena="Mañana es sabado sabadete y voy a irme a tomar unas copillas por los barrios bajos de Logroño";
		
		cadena=cadena.toUpperCase();
		
		for(int i=65;i<=90;i++)
		{
			num=contar(cadena,(char) i);
			if(num>0)
			{
				l=i+32;
				System.out.println("La letra "+(char)l+" aparece en el texto "+num+" veces");
			}
		}
		
		
		
		
		
	}
}
