import java.io.FileInputStream;
import java.io.IOException;

public class LeerArchivoBinario {
    public static void main(String[] args) {
        String nombreArchivo = "vista_ubicaciones-coordenadas.bin";
        try {
            FileInputStream entrada = new FileInputStream(nombreArchivo);
            int byteLeido;
            while ((byteLeido = entrada.read()) != -1) {
                System.out.println(byteLeido + " ");
            }
            entrada.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
