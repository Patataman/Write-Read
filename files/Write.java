package files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;

public class Write {

	/**
	 * Método que escribe en un archivo desde el final.
	 * @param path: ruta donde se localiza el archivo
	 * 				La ruta tiene como origen la carpeta Ficheros.
	 * @param texto: texto a escribir
	 * @return 0 -> Correcto; 1 -> Error
	 * @throws IOException
	 */
	public static int write(String path, String texto) {
		try {
			Path p = Paths.get(path);
			Charset charset = Charset.forName("UTF-8");
			//Como no queremos que lo resetee (TRUNCATE) hay que ponerle APPEND
			BufferedWriter writer = Files.newBufferedWriter(p, charset,
															StandardOpenOption.APPEND);
			writer.write(texto, 0, texto.length());
			//Importante cerrar el escritor, ya que si no, no escribe
			writer.close();
			return 0;
		} catch (IOException e) {
			System.out.println(e);
			return 1;
		}
	}
	
	/**
	 * Método que crea un archivo nuevo,
	 * si ya existía lo resetea y escribe en él
	 * @param path: ruta donde se localiza el archivo
	 * @param texto: texto a escribir
	 * @return 0 -> Correcto; 1 -> Error
	 * @throws IOException
	 */
	public static int createANDwrite(String path, String texto) {
		try {
			Path p = Paths.get(path);
			Charset charset = Charset.forName("UTF-8");
			//Por defecto trae CREATE y TRUNCATE
			BufferedWriter writer = Files.newBufferedWriter(p, charset);
			writer.write(texto, 0, texto.length());
			//Importante cerrar el escritor, ya que si no, no escribe
			writer.close();
			return 0;
		} catch (IOException e) {
			System.out.println(e);
			return 1;
		}
	}
}
