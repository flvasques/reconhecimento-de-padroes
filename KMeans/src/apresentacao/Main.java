
package apresentacao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;




public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        new Inicial();
        //new Classificador(5).Classficar();
       /*
        ArrayList<String>texto = new ArrayList<>();
        String linha;
        FileReader arquivo = new FileReader("C:\\Users\\Fernando Vasques\\ReposGiTHub\\baseVocacional.arff");
        Scanner leitor = new Scanner (arquivo);
        while(leitor.hasNextLine()){
            linha = leitor.nextLine();
            texto.add(linha.replace(";", ",").replace("'", ""));
        }
        arquivo.close();
        BufferedWriter escritor = new BufferedWriter (new FileWriter(new File("baseVocacional.arff"),true));
        for(int i = 0; i < texto.size(); i++){
            escritor.write(texto.get(i));
            escritor.newLine();
        }
        escritor.flush();
        escritor.close();
        */
    }  
}
