package spoticesar.uniftec.com.br.spoticesar.models;

import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.generics.GenericEntity;

public class Album
        extends GenericEntity {

    private String nome;

    private List<Musica> musicas;

    private Artista artista;

    public Album(String nome, Artista artista) {
        this.nome = nome;
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nArtista: " + this.artista.getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
