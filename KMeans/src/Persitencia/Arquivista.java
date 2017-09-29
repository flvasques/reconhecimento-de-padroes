
package Persitencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import modelo.Elemento;

public class Arquivista {
    private String nomeArquivo;
    private boolean teste;
    private final NumberFormat formatarFloat = new DecimalFormat("0.0000"); 
    
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
            JOptionPane.showMessageDialog(null, "ARQUIVO NÃO ENCONTRADO", "Classificador", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public void salvarClasse(ArrayList<Elemento> lista, Elemento media, Float[] moda, float[] mediana, String nome){
        try {
            BufferedWriter arquivo = new BufferedWriter (new FileWriter(new File(nome),true));
            arquivo.newLine();
            arquivo.write("Itens:;" + lista.size());
            arquivo.newLine();
            arquivo.write("Media: ;");
            for(int i = 0; i < media.getValores().length; i++){
                arquivo.write(formatarFloat.format(media.getValores()[i]) + ";");
            }
            arquivo.newLine();
            arquivo.write("Moda: ;");
            for(int i = 0; i < moda.length; i++){
                arquivo.write(moda[i] != null ? formatarFloat.format(moda[i]) + ";" : "N/A ;");
            }
            arquivo.newLine();
            arquivo.write("Mediana:;");
            for(int i = 0; i < moda.length; i++){
                arquivo.write(formatarFloat.format(mediana[i]) + ";");
            }
            arquivo.newLine();
            arquivo.newLine();
            for(int i = 0; i < lista.size(); i++){
                arquivo.write(">;");
                for(int j = 0; j < lista.get(i).getValores().length; j++){
                    arquivo.write((lista.get(i).getValores()[j]) + ";");
                }
                if(this.teste)arquivo.write(lista.get(i).getGabarito());
                arquivo.newLine();
            }
            arquivo.flush();
            arquivo.close();
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "FALHA INESPERADA AO ESCREVER O ARQUIVO\n" + ex.toString(), "Classificador", JOptionPane.ERROR_MESSAGE);
        }
    }
}
