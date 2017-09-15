
package modelo;

import Persitencia.Arquivista;
import java.util.ArrayList;
import java.util.Random;

public class Classificador {
    private ArrayList<Elemento> elementos = new ArrayList<>();
    private ArrayList<Elemento>[] classes;
    private int nClasses;
    private String[] nomes;
    private Elemento[] centroides;
    private Arquivista dao = new Arquivista(".\\dados\\conjunto.txt", true);
    
    private Classificador () {}
    public Classificador (int k) {
        this.nClasses = k;
        nomes = new String[nClasses];
        this.centroides = new Elemento[nClasses];
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
        for(int i = 0; i < 3; i++){
            gerarCentroides(false);
            separarClasess();
        }
        //this.dao.salvarClasse(this.classes[0]);
        
        for ( int i = 0; i < classes.length; i++ ) {
            this.dao.salvarClasse(this.classes[i]);
            /*for ( int j = 0; j < classes[i].size(); j++ ) {
                System.out.println(classes[i].get(j).getGabarito());
            }*/
            //System.out.println("modelo.Classificador.Classficar()");
        }
        
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
     
}