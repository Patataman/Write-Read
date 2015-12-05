package files;
import java.util.Scanner;

import files.Read;
import files.Write;

public class Menu {
	
	public static void main (String [] args) {
		
		//////////////////////////////////////////////////////
		//   Conocer directorio actual                      //
		//final String dir = System.getProperty("user.dir");//
        //System.out.println("current dir = " + dir);       //
        //////////////////////////////////////////////////////
		
		System.out.println("Escoja: \n" +
							" + Leer una linea de un archivo: 1 \n" +
							" + Escribir en un archivo nuevo: 2 \n" +
							" + Escribir en un archivo existente: 3 \n" +
							" + Leer X letras de un archivo: 4");
		
		Scanner sc = new Scanner(System.in);
		int i;
		while (!sc.hasNextInt()) {
			System.out.println("Introduce un número");
			sc.next();
		}
		i = sc.nextInt();
		switch (i) {
			//recupera el archivo e imprime tantas lineas como se pasen por teclado
			case 1:
				//introducimos la ruta del archivo.
				System.out.println("Introduce la ruta del archivo a leer");
				String pathRead;
				while (!sc.hasNext()) {
					System.out.println("Introduce un número");
					sc.next();
				}
		        
				pathRead = sc.next();
				
				//se solicitan las l�neas a leer
				System.out.println("Número de lúneas a leer");
				int lineas;
				while (!sc.hasNextInt()) {
					System.out.println("Introduce un número");
					sc.next();
				}
				lineas = sc.nextInt();
				//se imprimen las lineas
				if (Read.lecturaLn(pathRead, lineas) != 0){
					System.out.println("****Error al leer****");
				} else {
					System.out.println("****Lectura completada****");
				}
				break;
				
			//Crea o resetea un archivo y escribe en él
			case 2:
				//introducimos la ruta del archivo.
				System.out.println("Introduce la ruta donde crear el archivo");
				String pathWrite;
				while (!sc.hasNext()) {
					System.out.println("Introduce un número");
					sc.next();
				}
				pathWrite = sc.next();
				
				System.out.println("Texto a escribir en el archivo");
				String texto = "";
				while (!sc.hasNext()) {
					System.out.println("Introduce un número");
					sc.next();
				}
				boolean fin = false;
				while (fin != true) {
					String aux = sc.next();
					if (aux.compareTo("fin") == 0) {
						fin = true;
					} else {
						texto += aux + " ";
					}
				}
				
				int result = Write.createANDwrite(pathWrite, texto);
				if (result == 0) {
					System.out.println("Escritura con éxito");
				} else {
					System.out.println("Error al escribir");
				}
				break;
			case 3:
				//introducimos la ruta del archivo.
				System.out.println("Introduce la ruta donde esté el archivo");
				String pathWrite2;
				while (!sc.hasNext()) {
					System.out.println("Introduce un número");
					sc.next();
				}
				pathWrite2 = sc.next();
				
				System.out.println("Texto a escribir en el archivo");
				String texto2 = "";
				while (!sc.hasNext()) {
					System.out.println("Introduce un número");
					sc.next();
				}
				boolean fin2 = false;
				while (fin2 != true) {
					String aux = sc.next();
					if (aux.compareTo("fin") == 0) {
						fin2 = true;
					} else {
						texto2 += aux + " ";
					}
				}
				
				int result2 = Write.write(pathWrite2, texto2);
				if (result2 == 0) {
					System.out.println("Escritura con éxito");
				} else {
					System.out.println("Error al escribir");
				}
				break;
				
			case 4:
				//introducimos la ruta del archivo.
				System.out.println("Introduce la ruta del archivo a leer");
				String pathRead4;
				while (!sc.hasNext()) {
					System.out.println("Introduce un número");
					sc.next();
				}
		        
				pathRead4 = sc.next();
				
				//se solicitan las l�neas a leer
				System.out.println("Número de letras a leer");
				int letras;
				while (!sc.hasNextInt()) {
					System.out.println("Introduce un número");
					sc.next();
				}
				letras = sc.nextInt();
				
				//se imprimen las lineas
				if (Read.lecturaByte(pathRead4,letras) != 0) {
					System.out.println("****Error al leer****");
				} else {
					System.out.println("****Lectura completada****");
				}
				break;
				
			default: 
				break;
		}
		sc.close();
	}
}
