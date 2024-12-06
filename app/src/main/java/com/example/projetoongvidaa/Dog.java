package com.example.projetoongvidaa;

public class Dog {
    private String nome;
    private String descricao;
    private int idade;
    private String imageUrl;
    private String raca;

    public Dog() {
        // Construtor vazio necessário para o Firestore
    }

    public Dog(String nome, String descricao, int idade, String imageUrl, String raca) {
        this.nome = nome;
        this.descricao = descricao;
        this.idade = idade;
        this.imageUrl = imageUrl;
        this.raca = raca;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }
}
