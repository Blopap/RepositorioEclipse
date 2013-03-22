/*Crear una clase p�blica de nombre EjercicioString3 que contenga 
 * s�lo al m�todo main y mostrar por consola el n�mero de veces 
 * que aparecen las letras a, o y e en la String del ejercicio 
 * anterior. Adem�s, si el n�mero de veces que se repite la a 
 * es superior a 10 debe aparecer el mensaje "Exceso de a", 
 * si el n�mero de veces que se repite la o es superior a 5 
 * debe mostrarse "Exceso de o" y si se repite m�s de 3 veces 
 * la letra e debe mostrarse "Exceso de e"
 */

package Tema3;

public class Ej3 {

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
		int num;
		
		cadena="Ma�ana es sabado sabadete y voy a irme a tomar unas copillas por los barrios bajos de Logro�o";
		
		num=contar(cadena,"a".charAt(0));
		System.out.println("Numero de letras 'a': "+num);
		if(num>=10)
		{
			System.out.println("Exceso de letra a");
		}
		
		num=contar(cadena,"o".charAt(0));
		System.out.println("Numero de letras 'o': "+num);
		if(num>=5)
		{
			System.out.println("Exceso de letra o");
		}
		
		num=contar(cadena,"e".charAt(0));
		System.out.println("Numero de letras 'e': "+num);
		if(num>=3)
		{
			System.out.println("Exceso de letra e");
		}
		
		
		
	}

}
