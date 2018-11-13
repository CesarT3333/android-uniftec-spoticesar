package spoticesar.uniftec.com.br.spoticesar.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.generics.GenericEntity;

public class Album
        extends GenericEntity {

    private Integer id;

    private List<Musica> musicas = new ArrayList<>();

    @JsonProperty("title")
    private String nome;

    @JsonProperty("artist")
    private Artista artista = new Artista();

    @JsonProperty("cover_small")
    private String imagem;

    @Override
    public String getImageUrl() {
        return imagem;
    }

    public Album() {
    }

    public Album(Integer id, String nome, Artista artista) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}