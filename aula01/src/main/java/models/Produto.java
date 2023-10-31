package models;

public class Produto {
    private Integer id;
    private String nome;
    private Double valor;

    public Produto () {}
    public Produto (Integer id, String nome, Double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public Double getValor() {
        return this.valor;
    }

}
