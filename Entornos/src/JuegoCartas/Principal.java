package JuegoCartas;

public class Principal {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {


		Baraja bar=new Baraja();
		
		
		System.out.println(bar.numCartas());
		
		bar.mostrarBaraja();
		System.out.println();
		System.out.println();
		System.out.println();
		
		bar.barajar();
		
		bar.mostrarBaraja();
		
		System.out.println(bar.numCartas());
		
		System.out.println(bar.sacarCarta().muestra());
		
		
		
		

	}

}
