/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ANNY FIORESE
 */
public class Recebimento {

    private int id;
    private String nome;
    private String valor;
    private String data;
    private String tipo;

    public Recebimento(int id, String nome, String valor, String data, String tipo) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
    }

    public Recebimento() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String toCsv() {
        System.out.println("LOG: Convertendo dados para CSV");
        return this.id + ";"
                + this.nome + ";"
                + this.valor + ";"
                + this.data + ";"
                + this.tipo + ";";

    }
}
