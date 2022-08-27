package reader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PDF {

    public List<String> leitorPdf() {

        List<String> arraypdf = new ArrayList<>();

        //verifica arquivos no diretorio expecifico
        File diretorio = new File("C:\\Users\\tulha\\Documents\\Diretório de PDF");

        //faça em todos oos arquivos
        for (File file : diretorio.listFiles()) {
            //mostra no console os arquivos devido ao getName
            //System.out.println(file.getName().replaceAll(".pdf",""));

            arraypdf.add(file.getName().replaceAll(".pdf", ""));
        }
        return arraypdf;
    }

}
