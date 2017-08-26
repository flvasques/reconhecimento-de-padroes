package persintencia;

import Modelo.Padrao;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Amostra {
   private Amostra(){} 
   
   public static ArrayList<Padrao>loadAmostras() throws FileNotFoundException{
      ArrayList<Padrao> itens = new ArrayList<>();
      String linha = "";
      String[] vetorLinha;
      Padrao p;
      FileReader arquivo;
        String so = System.getProperty("os.name").substring(0,System.getProperty("os.name").indexOf(" "));
        if(so.compareTo("Windows") == 0 ){
            arquivo = new FileReader(".\\dados\\gabarito.txt");
        }else{
            arquivo = new FileReader("./dados/gabarito.txt");
        }
      
      Scanner leitor = new Scanner (arquivo);
      
      while(leitor.hasNextLine()){
            linha = leitor.nextLine();
            vetorLinha = linha.split(",");
            p = new Padrao();
            float[] iattr = new float[vetorLinha.length - 1];
            for(int i = 0; i < iattr.length; i++){
                    iattr[i] = Float.parseFloat(vetorLinha[i]);
            }
            p.setValores(iattr);
            p.setGabarito(vetorLinha[vetorLinha.length-1]);
            itens.add(p);
      }
      return itens;
   }
}
