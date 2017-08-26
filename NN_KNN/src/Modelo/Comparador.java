
package Modelo;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import persintencia.Amostra;
import persintencia.Teste;

public class Comparador {
    private ArrayList<Base> classes;
    private ArrayList<Padrao> padroes;
    private int k = 0;
    private boolean mudou = false;
    
    public Comparador(){
        try {
            this.classes = Teste.loadBaseTeste();
            this.padroes = Amostra.loadAmostras();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Ocurreu um erro insperado: " + ex);
        }
    }
    public Comparador( int k){
        if(k > 0){
            this.k = k;
          try {
            this.classes = Teste.loadBaseDados();
            this.padroes = Amostra.loadAmostras();
            } catch (FileNotFoundException ex) {
               JOptionPane.showMessageDialog(null,"Ocurreu um erro insperado: " + ex);
            }  
        }
    }
    
    public String reconhecer(){
        int acerto = 0, falha = 0;
        if(this.k > 0) classificarKNN();
        else classificar();
            for(int i = 0; i < padroes.size(); i++){
                //System.out.println(padroes.get(i).getClasse());
                if(padroes.get(i).getClasse().compareTo(padroes.get(i).getGabarito()) == 0){
                    acerto++;
                }else{
                    falha++;
                }
            }
        String knn = this.k > 0 ? "K visinhos " + this.k + "\n" : "";
        DecimalFormat quatroCasas = new DecimalFormat("#.0000");
        float perc = (acerto * 100) / padroes.size();
        return "Resultado:\n" + knn + "Pardrões avaliados " + padroes.size() + 
            "\nAcertos " + acerto +"\nFalhas " + falha + "\n" +
            quatroCasas.format(perc)+ "% de acerto.\n";
    }
    
    private void classificar(){
        Padrao p;
        Base b;
        double[] distancia = new double[classes.size()];
        for(int i = 0; i < padroes.size(); i++){
            p = padroes.get(i);
            for(int j = 0;j < classes.size(); j++){
               b = classes.get(j);
               distancia[j] = calcular(p.getValores(), b.getValores());
            }
            padroes.get(i).setClasse(classes.get(atribuirClassificacao(distancia)).getNome());
        }
    }
    private void classificarKNN(){
        Padrao p;
        Base b;
        Double[] distancia = new Double[this.k];
        String[] distanciaClasse = new String[this.k];
        for(int i = 0; i < padroes.size(); i++){
            p = padroes.get(i);
            for(int j = 0;j < classes.size(); j++){
               b = classes.get(j);
               Double valor = calcular(p.getValores(), b.getValores());
               int n = percorre(distancia, valor);
               if(this.mudou){
                  distancia[n] = valor;
                  distanciaClasse[n] = classes.get(j).getNome(); 
               }
              if(j == 100){
                int r =  1+1;
              } 
            }
            padroes.get(i).setClasse(atribuirClassificacao(distanciaClasse));
            distancia = new Double[this.k];
            distanciaClasse = new String[this.k];
        }
    }
    
    private int percorre(Double[] vet,double val){
        this.mudou = false;
        for(int i = 0; i < vet.length; i++){
            if(vet[i] == null){
                this.mudou = true;
                return i;
            }
        }
        Double maior = vet[0];
        int n = 0;
        for(int i = 0; i < vet.length; i++){
            for(int j = i + 1; j < vet.length; j++){
                if(maior > vet[j]){
                    maior = vet[j];
                    n = j;
                }
            }
        }
        this.mudou = val < maior;
        return n;
    }
    
    private double calcular(float[] pad, float[] base ){
        double dist = 0;
        for(int i = 0; i < pad.length; i++){
          dist += Math.pow((base[i]-pad[i]), 2);
        }
        dist = Math.sqrt(dist);
        return dist;
    }
    
    private int atribuirClassificacao(double[] dist){
        double menor = dist[0];
        int n = 0;
        for(int i = 0; i < dist.length; i++){
            for(int j = i + 1; j < dist.length; j++){
                if(menor > dist[j]){
                    menor = dist[j];
                    n = j;
                }
            }
        }
        return n;
    }
     private String atribuirClassificacao(String[] dist){
        int[] cont = new int[k];
        for(int i = 0; i < dist.length; i++){ 
            for(int j = i + 1; j < dist.length; j++){
                if(dist[i].compareTo(dist[j])== 0) cont[i]++;
            }
        }
        int maior = cont[0];
        int n = 0;
        for(int i = 0; i < cont.length; i++){
            for(int j = i + 1; j < cont.length; j++){
                if(maior > cont[j]){
                    this.mudou = true;
                    maior = cont[j];
                    n = j;
                }
            }
        }
        return dist[n];
    }
}
