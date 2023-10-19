/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atividade1;

import java.util.Scanner;

/**
 *
 * @author alunolab10
 */
public class IPTUdeVV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        Municipio vv = new Municipio();
        int opcao = 1;
        int i = 10;
        int j = 10;

        while (opcao != 0) {
            System.out.println("=================================");
            System.out.println("[0] Finalizar Programa\n\n[1] Adicionar Imoveis\n[2] Listar Imoveis");
            opcao = teclado.nextInt();

            if (opcao == 1) {
                System.out.println("=================================");
                System.out.println("Digite o nome do proprietário: ");
                String nome = teclado.next();
                System.out.println("Digite o valor do imposto: ");
                double imposto = teclado.nextDouble();
                System.out.println("Digite os meses de atraso: ");
                int meses_atraso = teclado.nextInt();
                
                String matricula = i + "VV";
                vv.adicionarImovel(matricula, nome, imposto, meses_atraso);
                double multa = vv.calcularMulta(matricula);
                vv.adicionarMulta(matricula, multa);
                i += 10;
            }
            
            else {
                while (vv.map.get(j + "VV") != null) {
                    System.out.println("=================================");
                    System.out.println("Nome do proprietario: "   + vv.map.get(j + "VV").nome);
                    System.out.println("Valor do imposoto:    "   + vv.map.get(j + "VV").imposto);
                    System.out.println("Meses atrasados:      "   + vv.map.get(j + "VV").meses_atraso);
                    System.out.println("MULTA:                R$" + vv.map.get(j + "VV").multa);
                    j+=10;
                }
                j = 10;
            }
        }
        teclado.close();
    }
}
