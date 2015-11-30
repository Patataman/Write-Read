package files;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Read {
	
	/**
	 * Método que lee un archivo.
	 * @param path: String de la ruta del archivo.
	 * 				La ruta tiene como origen la carpeta Ficheros.
	 * @return BufferedReader del archivo que se quiere leer.
	 * @throws IOException
	 */
	public static BufferedReader lectura(String path) {	
		try {
			Charset charset = Charset.forName("UTF-8");
			Path p = Paths.get(path);
			BufferedReader read = Files.newBufferedReader(p, charset);
			return read;
		} catch (IOException e) {
			System.out.println(e);
			return null;
		}
	}
}
