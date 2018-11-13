package spoticesar.uniftec.com.br.spoticesar.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import spoticesar.uniftec.com.br.spoticesar.generics.GenericEntity;

public class Artista
        extends GenericEntity {

    @JsonProperty("name")
    private String nome;

    public Artista() {
    }

    public Artista(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome;
    }

}
