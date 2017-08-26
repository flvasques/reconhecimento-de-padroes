
package Modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import persintencia.Teste;

public class Centroide {
    private ArrayList<Base> centros;
    private ArrayList<Base> classes;
    private ArrayList<Padrao> padroes;
    
    
    private void setClasses(){
        try {
            classes = Teste.loadBaseDados();
        } catch (FileNotFoundException ex) {
             JOptionPane.showMessageDialog(null,"Ocurreu um erro insperado: " + ex);
        }
    }
    private void gerarCentros(){
        this.centros = new ArrayList<>();
        Base b = new Base();
        for(int i = 0; i < classes.size(); i++){
            
        }
    }
}
