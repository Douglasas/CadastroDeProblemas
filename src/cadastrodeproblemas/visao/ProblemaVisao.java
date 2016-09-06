package cadastrodeproblemas.visao;

import cadastrodeproblemas.controle.ProblemaControle;
import cadastrodeproblemas.modelo.Problema;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Douglas
 * @date 03/09/2016
 */
class ProblemaVisao {

    public static void exibirCadastroProblema() {
        
        String descricao;
        Date data;
        
        Scanner in = new Scanner(System.in);
        SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
        formatadorData.setLenient(false);        
        
        System.out.println("=== REPORTE DE NOVO PROBLEMA ===");
        System.out.print("Digite a descricao do problema:\n>> ");
        do {
            descricao = in.nextLine();
            if (descricao.equals(""))
                System.out.print(">> ");
        } while (descricao.equals(""));
        
        System.out.print("\nDigite a data que o problema foi reportado:\n>> ");
        do {
            try {
                data = formatadorData.parse(in.nextLine());
                if (data.after(new Date())){
                    System.out.print("Data nao pode ser futura, digite novamente:\n>> ");
                } else 
                    break;
            } catch (Exception ex) {
                System.out.print("Data invalida, digite novamente:\n>> ");
            }
        } while(true);
        
        ProblemaControle.receberCadastroProblema(descricao, data);
    }
    
    public static void exibirListaProblemas() {
        ArrayList<Problema> lista = ProblemaControle.obterListaProblemas();
        SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
        Scanner in = new Scanner(System.in);
        if (lista.isEmpty()) {
            System.out.println("Nenhum problema reportado.\nPressione ENTER para retornar.");
            in.nextLine();
        } else {
            System.out.println("==== LISTAGEM DE PROBLEMAS REPORTADOS ====");
            System.out.println("CODIGO\tDESCRICAO\tSITUACAO\tDATA");
            int i = 1;
            for (Problema prob : lista) {
                System.out.println(  (i++)
                                    + "\t"
                                    + prob.getDescricao()
                                    + "\t"
                                    + prob.getSituacao()
                                    + "\t"
                                    + formatadorData.format(prob.getData())
                                );
            }

            System.out.println("\nDigite M para retornar ao menu.");
            System.out.println("Digite o codigo do problema para mudar a situacao para resolvido.");
            System.out.print("\nOpcao:\n>> ");
            do {
                String opc = "";
                try {
                    opc = in.nextLine();
                    int escolha = Integer.parseInt(opc);
                    ProblemaControle.resolverProblema(escolha-1);
                    System.out.println("Problema resolvido!");
                    break;
                } catch (IndexOutOfBoundsException e) {
                    System.out.print("Problema nao encontrado, digite novamente:\n>> ");
                } catch (NumberFormatException e){
                    if (opc.toUpperCase().equals("M")){
                        break;
                    } else {
                        if (opc.equals(""))
                            System.out.print(">> ");
                        else
                            System.out.print("Opcao invalida, digite novamente:\n>> ");
                    }
                }
            } while (true);
        }
    }
    
}
