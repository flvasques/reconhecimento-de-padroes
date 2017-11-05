
package modelo;

import Persitencia.Arquivista;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Classificador {
    private ArrayList<Elemento> elementos = new ArrayList<>();
    private ArrayList<Elemento>[] classes;
    private int nClasses;
    private ArrayList<String> nomesSaida;
    private Elemento[] centroides;
    private Elemento[] centroidesAnteriores;
    private Arquivista dao;
    
    private Classificador () { }
    public Classificador (int k) {
       init(k);
    }
    public Classificador (String arquivo, boolean teste){
        dao  = new Arquivista(arquivo, teste);
        elementos = dao.carregar();
    }
    
    public int[] getContagem(){
        int[] ret = {elementos.size(), elementos.get(0).getValores().length};
        return ret;
    }
    
    public void init(int k){
        this.nClasses = k;
        this.centroides = new Elemento[nClasses];
        this.centroidesAnteriores = new Elemento[nClasses];
        this.elementos = this.dao.carregar();
    }
    
    private void iniciar(){
        classes = new ArrayList[this.nClasses];
        for(int i = 0; i <  nClasses; i++){
            classes[i] = new ArrayList<>();
        }
    }
    public void Classficar(){
        gerarCentroides(true);
        separarClasess();
        int j = 1;
        while(!compararCentroides()){
            gerarCentroides(false);
            separarClasess();
            j++;
        }
        
        for ( int i = 0; i < classes.length; i++ ) {
            this.dao.salvarClasse(this.classes[i], this.centroides[i], getMediana(i),"classe_"+i+".csv");
        }
        JOptionPane.showMessageDialog(null, "Classificação finalizada.\n \t Número de interações: " + j, "Classificador", JOptionPane.PLAIN_MESSAGE);
    }
    public void setNome(ArrayList<String> lista){
        nomesSaida = lista;
    }
    
    private void gerarCentroides( boolean novo ){
        if ( novo ) {
            for(int i = 0; i < this.nClasses; i++){
               int t = (int)(Math.random() * elementos.size());
               centroides[i] =  new Elemento();
               centroides[i].setValores(elementos.get(i).getValores());
               //System.out.println(t + " " + elementos.get(i).getGabarito());
            }
        } else {
            Elemento el;
            this.centroidesAnteriores = this.centroides;
            float[] centro;
            for( int i = 0; i < classes.length; i++ ) {
                centro = new float[centroides[i].getValores().length];
                for ( int j = 0; j < classes[i].size(); j++ ) {
                    for ( int p = 0; p < classes[i].get(j).getValores().length; p++ ) {
                        centro[p] += classes[i].get(j).getValores()[p];
                    }
                }
                for ( int c = 0; c < centro.length; c++ ) {
                    centro[c] = (classes[i].size() > 0) ? centro[c] / classes[i].size() : centroides[i].getValores()[c];
                }
                centroides[i].setValores(centro);
            }
        }
        
    }
    
    private void separarClasess(){
        iniciar();
        Elemento c, el;
        float[] distancia = new float[nClasses];
        for(int i = 0; i < elementos.size(); i++){
            el = elementos.get(i);
            for(int j = 0; j < centroides.length; j++){
                c = centroides[j];
                distancia[j] = calcular(c.getValores(), el.getValores());
            }
            classes[menorDistancia(distancia)].add(el);
        }
    }
     
    private float calcular ( float[] pad, float[] base ) {
        float dist = 0;
        for(int i = 0; i < pad.length; i++){
            dist += Math.pow((base[i]-pad[i]), 2);
        }
        dist = (float) Math.sqrt(dist);
        return dist;
    }
    
    private int menorDistancia ( float vet[] ) {
        int menor = 0;
        float n = vet[0];
        for ( int i = 0; i < vet.length; i++ ) {
            for ( int j = i + 1; j < vet.length; j++ ) {
                if ( n > vet[j] ){
                    menor = j;
                    n = vet[j];
                }
            }
        }
        return menor;
    }
    
    private boolean compararCentroides(){
        boolean iguais = true;
        for(int i = 0; i < centroides.length; i++){
            if(centroides[i] != centroidesAnteriores[i]) return false;
        }
        return iguais;
    }
    
   private float[] getMediana(int i){
       float[] retorno;
       float temp, maior;
       int meio = this.classes[i].size() / 2;
       for(int linha = 0; linha < this.classes[i].get(0).getValores().length; linha++){
            maior = this.classes[i].get(linha).getValores()[0];
           for (int coluna = linha + 1; coluna < this.classes[i].size(); coluna++){
                if(maior < this.classes[i].get(coluna).getValores()[linha]){
                    temp = maior;
                    maior = this.classes[i].get(coluna).getValores()[linha];
                    this.classes[i].get(coluna).getValores()[linha] = temp;
                }
            }
        }
        retorno = this.classes[i].get(meio).getValores();
       return retorno;
   } 
    
}