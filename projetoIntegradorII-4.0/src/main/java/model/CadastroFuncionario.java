package model;

/**
 *
 * @author ANNY FIORESE
 */
public class CadastroFuncionario {

    private int id;
    private String senha;
    private String usuario;
    private String nome;
    private String nascimento;
    private String cpf;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private int numero;
    

    public CadastroFuncionario(String usuario, String senha, String nome, String nascimento, String cpf, String rua, int numero, String bairro, String cidade, String estado, int id) {
        this.id = id;
        this.senha = senha;
        this.usuario = usuario;
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
    }

    public CadastroFuncionario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String toCsv() {
        System.out.println("LOG: Convertendo dados para CSV");
        return this.usuario + ";"
                + this.senha + ";"
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
