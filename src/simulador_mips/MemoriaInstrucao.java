/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_mips;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 17111168
 */
public class MemoriaInstrucao {
    
    List<String> instruc = new ArrayList<>();
    List<String> dados = new ArrayList<>();
    
    public MemoriaInstrucao(String path){
        try {
            BufferedReader buff = new BufferedReader(new FileReader(path));
            String linha = "";
            boolean aux = true;
            while(true){
                linha = buff.readLine();
                
                if(linha != null){
                    if(linha.equals(".text")){
                        aux = true;
                        continue;
                    }
                    if(linha.equals(".data")){
                        aux = false;
                        continue;
                    }
                }else{
                    break;
                }
                
                if(aux){
                    instruc.add(linha);
                }else{
                    dados.add(linha);
                }
            }
            buff.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MemoriaInstrucao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MemoriaInstrucao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void print(){
        for(int i=0; i < instruc.size(); i++){
            System.out.println("Instrucao "+i+" - "+instruc.get(i));
        }
        
        for(int j=0; j < dados.size(); j++){
            System.out.println("Dado "+j+" - "+dados.get(j));
        }
            
    }
}
