
package persintencia;

import Modelo.Base;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Teste {
    private Teste(){}
    
    public static ArrayList<Base> loadBaseTeste() throws FileNotFoundException{
        /**
          * Retona um ArrayList para testes NN
          */
        FileReader arquivo;
        String so = System.getProperty("os.name").substring(0,System.getProperty("os.name").indexOf(" "));
        if(so.compareTo("Windows") ==0 ){
            arquivo = new FileReader(".\\dados\\classes.txt");
        }else{
            arquivo = new FileReader("./dados/classes.txt");
        }
        String linha = "";
        Base b = new Base();
        String[] vetorLinha;
        String[] attr = null;
        Scanner leitor = new Scanner (arquivo);
        ArrayList<Base> baseDados = new ArrayList<>();       
        while(leitor.hasNextLine()){
            linha = leitor.nextLine();
            vetorLinha = linha.split(",");
            if(vetorLinha[0].compareTo("nome") == 0){               
                attr = new String[vetorLinha.length - 1];
                for(int i = 0, j = 1; i < attr.length; i++, j++){
                    attr[i] = vetorLinha[j];
                }
                b.setAtributos(attr);
            }else{
                b.setNome(vetorLinha[0]);
                float[] iattr = new float[vetorLinha.length - 1];
                for(int i = 0, j = 1; i < iattr.length; i++, j++){
                    iattr[i] = Float.parseFloat(vetorLinha[j]);
                }
                b.setValores(iattr);  
            }
            if(b.getNome() != null){
               baseDados.add(b);
                b = new Base();
                b.setAtributos(attr);
            }
        }
        leitor.close();
        return baseDados;
    }
    
    public static ArrayList<Base> loadBaseDados() throws FileNotFoundException{
         /**
          * Retona um ArrayList para testes KNN
          */
         FileReader arquivo;
        String so = System.getProperty("os.name").substring(0,System.getProperty("os.name").indexOf(" "));
        if(so.compareTo("Windows") ==0 ){
           arquivo = new FileReader(".\\dados\\baseDeDados.txt");
        }else{
            arquivo = new FileReader("./dados/baseDeDados.txt");
        }
        String linha = "";
        Base b = new Base();
        String[] vetorLinha;
        String[] attr = null;
        String nome = "";
        Scanner leitor = new Scanner (arquivo);
        ArrayList<Base> baseDados = new ArrayList<>();       
        while(leitor.hasNextLine()){
            linha = leitor.nextLine();
            vetorLinha = linha.split(",");
            if(vetorLinha[0].compareTo("Classe") == 0){               
                nome = vetorLinha[1];
                linha = leitor.nextLine();
                vetorLinha = linha.split(",");
                attr = new String[vetorLinha.length - 1];
                for(int i = 0, j = 1; i < attr.length; i++, j++){
                    attr[i] = vetorLinha[j];
                }
            }else{
                b.setNome(nome);
                b.setAtributos(attr);
                float[] iattr = new float[vetorLinha.length];
                for(int i = 0; i < iattr.length; i++){
                    iattr[i] = Float.parseFloat(vetorLinha[i]);
                }
                b.setValores(iattr);  
            }
            if(b.getNome() != null){
               baseDados.add(b);
                b = new Base();
            }
        }
        leitor.close();
        return baseDados;
    }
     
    public static void salvarCentroide(){
        
        
    }
}
