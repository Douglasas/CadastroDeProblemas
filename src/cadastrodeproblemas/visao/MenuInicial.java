package cadastrodeproblemas.visao;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Douglas
 * @date 03/09/2016
 */
public class MenuInicial {
    
    public static void exibirMenuInicial(){
        Scanner in = new Scanner(System.in);
        String opc;
        do {
            System.out.println("==== MENU PRINCIPAL ====");
            System.out.println("Digite V para visualizar os problemas reportados.");
            System.out.println("Digite R para reportar um novo problema.");
            System.out.println("Digite 0 para sair do programa.");
            System.out.print("\nOpção:\n>> ");
            OUTER:
            do {
                opc = in.nextLine();
                opc = opc.toUpperCase();
                switch (opc) {
                    case "V":
                        ProblemaVisao.exibirListaProblemas();
                        break OUTER;
                    case "R":
                        ProblemaVisao.exibirCadastroProblema();
                        break OUTER;
                    case "0":
                        break OUTER;
                    case "":
                        System.out.print(">> ");
                        break;
                    default:
                        System.out.print("Opcao invalida, digite novamente:\n>> ");
                        break;
                }
            } while (true);
        } while ( !opc.equals("0") );
    }
}
