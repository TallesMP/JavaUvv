/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alunolab10
 */
public class Municipio {
    String matricula;
    

    Map<String,Imovel> map;

    public Municipio() {
        map = new HashMap<>();
    }
    
    void adicionarImovel(String matricula, String nome, double imposto, int meses_atraso) {
        Imovel imovel = new Imovel(nome, imposto, meses_atraso);
        map.put(matricula, imovel);
    }
   
    double calcularMulta(String mat) {
        
        Imovel ir = map.get(mat);
        
        if (ir.meses_atraso >= 0 && ir.meses_atraso <= 5) {
            ir.multa = ir.imposto * 1;
        }
        else if (ir.meses_atraso >= 6 && ir.meses_atraso <= 8) {
            ir.multa = ir.imposto * 2.3;
        }
        else if (ir.meses_atraso >= 9 && ir.meses_atraso <= 10) {
            ir.multa = ir.imposto * 3;
        }
        else if (ir.meses_atraso >= 11 && ir.meses_atraso <= 12) {
            ir.multa = ir.imposto * 5.4;
        }
        else if (ir.meses_atraso > 12) {
           ir.multa = ir.imposto * 10;
        }
        else {
            System.out.println("Numero invalido, digite novamente.");
            return -1;
        }
        return ir.multa;
    }

    void adicionarMulta(String mat, double multa) {
        Imovel ir = map.get(mat);
        ir.multa = multa;
    }

}

