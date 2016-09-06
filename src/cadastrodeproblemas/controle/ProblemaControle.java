package cadastrodeproblemas.controle;

import cadastrodeproblemas.modelo.Problema;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Douglas
 * @date 03/09/2016
 */
public class ProblemaControle {

    public static void receberCadastroProblema(String descricao, Date data) {
        Problema prob = new Problema();
        prob.setDescricao(descricao);
        prob.setData(data);
        prob.setSituacao(false);
        prob.salvar();
    }
    
    public static ArrayList<Problema> obterListaProblemas(){
        return Problema.obterLista();
    }

    public static void resolverProblema(int index) throws IndexOutOfBoundsException {
        Problema prob = Problema.obterLista().get(index);
        prob.setSituacao(true);
    }
    
    
}
