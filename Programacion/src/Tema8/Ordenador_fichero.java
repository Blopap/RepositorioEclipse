
package Tema8;

import java.io.*;
import rutinas.Rutinas;

public class Ordenador_fichero {
	static double total = 0;
	static Ordenador aorde[] = new Ordenador[10];
	static int indi = 0;

	public static void main(String[] args) throws IOException {
		int tipo;
		int opcion;
		do {
			System.out.println("OPCIONES");
			System.out.println("1-Comprar Ordenador");
			System.out.println("2-Salvar Ordenadores");
			System.out.println("3-Restaurar ordenadores");
			System.out.println("4-Mostrar ordenadores");
			System.out.println("0-Terminar");
			opcion = Rutinas.leeEntero("Seleccione una opcion: ");
			switch (opcion) {
			case 1:
				tipo = Rutinas.leeEntero("Que tipo...  \n 1-Ordenador \n 2-Portatil \n 3-Netbook");
				switch (tipo) {
				case 1:
					aorde[indi] = new Ordenador();
					pide(aorde[indi]);
					break;
				case 2:
					aorde[indi] = new Portatil();
					pide(aorde[indi]);
					break;
				case 3:
					aorde[indi] = new Netbook();
					pide(aorde[indi]);
					break;
				default:
					System.out.println("Error en tipo " + tipo);
				}
				break;
			case 2:
				salva();
				break;
			case 3:
				carga();
				break;
			case 4:
				muestra();
				break;
			case 0:
				break;
			default:
				System.out.println("Error en opcion ");
			}
		} while (opcion!=0);

	}

	public static void pide(Ordenador orde) {
		orde.datos();
		indi++;
	}

	public static void muestra() {

		for (int i = 0; i < indi; i++) {
			System.out.println(aorde[i].toString());
			total += aorde[i].mostrarprecio();
		}
		System.out.println("El total es.. " + total);
	}

	
	public static void salva() throws IOException {
		File txt = new File("Ordenador.txt");
		FileWriter fw = new FileWriter(txt);
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < indi; i++) {
			bw.write(aorde[i].toString() + "\n");
		}
		bw.flush();
		bw.close();
		fw.close();

	}
	
	public static void carga() throws IOException {
		File txt = new File("Ordenador.txt");
		FileReader fr = new FileReader(txt);
		BufferedReader br = new BufferedReader(fr);
		String linea = "";
		String[] datos = new String[5];
		linea = br.readLine();
		while (linea != null) {
			datos = linea.split(",");
			if (datos.length==3) {
				aorde[indi] = new Ordenador(datos[1],
						Double.parseDouble(datos[2]));
				indi++;
			} else if (datos.length==4) {
				aorde[indi] = new Portatil(datos[1],
						Double.parseDouble(datos[2]),
						Integer.parseInt(datos[3]));
				indi++;
			} else if (datos.length==5) {
				aorde[indi] = new Netbook(datos[1],
						Double.parseDouble(datos[2]),
						Integer.parseInt(datos[3]),
						Double.parseDouble(datos[4]));
				indi++;
			}
			linea = br.readLine();
		}
		br.close();
		fr.close();
	}
}