package spoticesar.uniftec.com.br.spoticesar.models;

import spoticesar.uniftec.com.br.spoticesar.generics.GenericEntity;

public class Artista
        extends GenericEntity {

    private String nome;

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
