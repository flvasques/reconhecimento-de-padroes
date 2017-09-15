
package Persitencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Elemento;

public class Arquivista {
    private String nomeArquivo;
    private String nomeSaida = "Classe.txt";
    private boolean teste;
    
    private Arquivista(){}
    
    public Arquivista (String n, boolean t){
        this.nomeArquivo = n;
        this.teste = t;
    }
    
    public ArrayList<Elemento> carregar(){
        ArrayList<Elemento> lista = new ArrayList<>();
        Elemento el;
        String[] vetorLinha;
        String linha;
        float[] attr;
        try {
            FileReader arquivo = new FileReader(this.nomeArquivo);
            Scanner leitor = new Scanner (arquivo);
             while(leitor.hasNextLine()){
                el = new Elemento();
                linha = leitor.nextLine();
                vetorLinha = linha.split(",");
                attr = new float[vetorLinha.length - 1];
                for(int i = 0, j = 1; i < attr.length; i++){
                    attr[i] = Float.parseFloat(vetorLinha[i]);
                }
                el.setValores(attr);
                if(teste) el.setGabarito(vetorLinha[vetorLinha.length - 1]);
                lista.add(el);
             }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return lista;
    }
    
    public void salvarClasse(ArrayList<Elemento> lista){
        try {
            BufferedWriter arquivo = new BufferedWriter (new FileWriter(new File(nomeSaida),true));
            arquivo.newLine();
            arquivo.write("itens:" + lista.size());
            arquivo.newLine();
            arquivo.newLine();
            for(int i = 0; i < lista.size(); i++){
                for(int j = 0; j < lista.get(i).getValores().length; j++){
                    arquivo.write(((int)lista.get(i).getValores()[j]) + ",");
                }
                arquivo.write(lista.get(i).getGabarito());
                arquivo.newLine();
            }
            arquivo.flush();
            arquivo.close();
            
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
