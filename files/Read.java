package files;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Read {
	

	public static int lecturaLn(String path, int lineas) {	
		try {
			Charset charset = Charset.forName("UTF-8");
			Path p = Paths.get(path);
			BufferedReader read = Files.newBufferedReader(p, charset);
			String line = "";
			while ((line = read.readLine()) != null && lineas != 0) {
				System.out.println(line);
				lineas--;
			}
			read.close();
			return 0;
		} catch (IOException e) {
			System.out.println(e);
			return -1;
		}
	}
	

	public static int lecturaByte(String path, int letras) {	
		try {
			Charset charset = Charset.forName("UTF-8");
			Path p = Paths.get(path);
			BufferedReader read = Files.newBufferedReader(p, charset);
			int letra;
			while ((letra = read.read()) != -1 && letras != 0) {
				char c = (char) letra;
				System.out.print(c+", ");
				letras--;
			}
			System.out.println();
			read.close();
			return 0;
		} catch (IOException e) {
			System.out.println(e);
			return -1;
		}
	}
}
