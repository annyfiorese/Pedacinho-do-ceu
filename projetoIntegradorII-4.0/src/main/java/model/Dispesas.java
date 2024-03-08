package model;

/**
 *
 * @author ANNY FIORESE
 */
public class Dispesas {

    private int id;
    private String tipoDePagamento;
    private String data;
    private String valor;
    private String descricao;

    public Dispesas() {
    }

    public Dispesas(int id, String tipoDePagamento, String data, String valor, String descricao) {
        this.id = id;
        this.tipoDePagamento = tipoDePagamento;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDePagamento() {
        return tipoDePagamento;
    }

    public void setTipoDePagamento(String tipoDePagamento) {
        this.tipoDePagamento = tipoDePagamento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toCsv() {
        System.out.println("LOG: Convertendo dados para CSV");
        return this.id + ";" + this.valor + ";" + this.data + ";" + this.tipoDePagamento + ";" + this.descricao + ";";

    }

}
