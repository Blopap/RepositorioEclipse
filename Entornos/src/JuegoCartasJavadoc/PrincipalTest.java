package JuegoCartasJavadoc;

import rutinas.Rutinas;

public class PrincipalTest {
	public static void main(String [] args)
	{
//		Baraja b=new Baraja();
		
				
//		System.out.println(b.numCartas());
//		
//		while(!b.quedanCartas())
//		{
//			System.out.println(b.sacarCarta().muestra());
//		}
		
		Partida p = new Partida(Rutinas.leeEntero("Introduzca el numero de jugadores"),Rutinas.leeEntero("Introduzca el numero de cartas a repartir"));
		
//		p.repartir();
//		p.descartar();
//		
//		p.ganaGrande();
		
//		p.repartir();
//		p.recojer();
		
		p.jugar();
		
	}

}
