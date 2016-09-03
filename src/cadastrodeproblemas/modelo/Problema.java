package cadastrodeproblemas.modelo;

import cadastrodeproblemas.MeioArmazenamento;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Douglas
 * @date 03/09/2016
 */
public class Problema {
    private String descricao;
    private String situacao;
    private Date data;

    public void salvar() {
        MeioArmazenamento.LISTA_PROBLEMAS.add(this);
    }
    
    public static ArrayList<Problema> obterLista(){
        return MeioArmazenamento.LISTA_PROBLEMAS;
    }
    
    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
