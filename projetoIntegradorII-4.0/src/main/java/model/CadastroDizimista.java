package model;

/**
 *
 * @author ANNY FIORESE
 */
public class CadastroDizimista {

    private int codigo;
    private String nome;
    private String nascimento;
    private String cpf;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private long numero;

    public CadastroDizimista(int codigo, String nome, String nascimento, String cpf, String rua,long numero, String bairro, String cidade, String estado) {
        this.codigo = codigo;
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
    }

    public CadastroDizimista() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String toCsv() {
        System.out.println("LOG: Convertendo dados para CSV");
        return this.codigo + ";"
                + this.nome + ";"
                + this.nascimento + ";"
                + this.cpf + ";"
                + this.rua + ";"
                + this.numero + ";"
                + this.bairro + ";"
                + this.cidade + ";"
                + this.estado + ";";

    }

}
