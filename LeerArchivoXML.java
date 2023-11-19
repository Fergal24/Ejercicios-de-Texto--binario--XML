import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

public class LeerArchivoXML {

    public static void main(String[] args) {

        try {
            File archivo = new File("concesionario.xml");

            // Creo un DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivo);

            doc.getDocumentElement().normalize();

            // Obtengo la raíz del documento
            Element root = doc.getDocumentElement();

            // Obtengo la lista de nodos 'coche'
            NodeList nodeList = root.getElementsByTagName("coche");

            // Itero sobre la lista de nodos 'coche'
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoCoche = (Element) node;

                    // Obtengo los elementos dentro de 'coche'
                    String matricula = elementoCoche.getElementsByTagName("matricula").item(0).getTextContent();
                    String marca = elementoCoche.getElementsByTagName("marca").item(0).getTextContent();
                    String precio = elementoCoche.getElementsByTagName("precio").item(0).getTextContent();

                    // Imprimo la información del coche
                    System.out.println("Matricula: " + matricula);
                    System.out.println("Marca: " + marca);
                    System.out.println("Precio: " + precio);
                    System.out.println("-----");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


