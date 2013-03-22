package EjerciciosVarios;

public class TablaMultiplicar {

	public static void main(String[] args) {

		int tabla[][]=new int[9][11];
		
		for(int i=0;i<tabla.length;i++)
		{
			for (int k=0;k<tabla[0].length;i++)
			{
				tabla[i][k]=(i+1)*k;
				System.out.print(tabla[i][k]+" ");
			}
			System.out.println();
			
		}
		
	}

}
