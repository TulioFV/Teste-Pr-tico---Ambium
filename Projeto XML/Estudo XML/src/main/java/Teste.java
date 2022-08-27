
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Teste {
    public static void main(String[] args) {
        try{

            String valor = "AMBIUM SUSTENTABILIDADE DIGITAL";
            String tel = "(16) 3329-3196";
            String end = "AV. PRESIDENTE VARGAS";
            String comp = "SALA 2403";
            String arquivo = "C:\\Users\\tulha\\Documents\\filexml.xml";

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();

            DocumentBuilder dc = dbf.newDocumentBuilder();

            Document d = dc.newDocument();

            //elemento raiz do XML

            Element raiz = d.createElement("Posts");
            d.appendChild(raiz);


            //elemento post

            Element post = d.createElement("post");
            raiz.appendChild(post);

            //definindo o atributo do post
            Attr attr = d.createAttribute("id");
            long currentTimeStamp = System.currentTimeMillis();
            attr.setValue("_"+currentTimeStamp);
            post.setAttributeNode(attr);

            //definindo o valor da postagem na tag text
            Element textoRecebido = d.createElement("Razao");
            textoRecebido.appendChild(d.createTextNode(valor));
            post.appendChild(textoRecebido);


            //alteracao tulio
            Element textoRecebido2 = d.createElement("Telefone");
            textoRecebido2.appendChild(d.createTextNode(tel));
            post.appendChild(textoRecebido2);

            //alteracao tulio
            Element textoRecebido3 = d.createElement("Endereco");
            textoRecebido3.appendChild(d.createTextNode(end));
            post.appendChild(textoRecebido3);

            //alteracao tulio
            Element textoRecebido4 = d.createElement("Complemento");
            textoRecebido4.appendChild(d.createTextNode(comp));
            post.appendChild(textoRecebido4);

            //construcao do XML
            TransformerFactory tf = TransformerFactory.newInstance();

            Transformer t = tf.newTransformer();

            DOMSource domSource = new DOMSource(d);

            StreamResult streamResult = new StreamResult(new File(arquivo));

            //juntar o conteudo ao arquivo criado
            t.transform(domSource,streamResult);
            System.out.println("Criado");


        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Diretorio "+System.getProperty("user.dir"));
        }

    }
}
