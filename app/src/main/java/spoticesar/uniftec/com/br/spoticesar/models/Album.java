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

    @JsonProperty("duration")
    private int duracao;

    @JsonProperty("nb_tracks")
    private int numeroMusicas;

    @JsonProperty("fans")
    private int numeroFans;

    @JsonProperty("tracks")
    private MusicaResponse musicaResponse;

    @Override
    public String getImageUrl() {
        return imagem;
    }

    public Album() {
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nArtista: " + this.artista.getNome();
    }

    public MusicaResponse getMusicaResponse() {
        return musicaResponse;
    }

    public void setMusicaResponse(MusicaResponse musicaResponse) {
        this.musicaResponse = musicaResponse;
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

    public int getDuracao() {
        return duracao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getNumeroMusicas() {
        return numeroMusicas;
    }

    public void setNumeroMusicas(int numeroMusicas) {
        this.numeroMusicas = numeroMusicas;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getNumeroFans() {
        return numeroFans;
    }

    public void setNumeroFans(int numeroFans) {
        this.numeroFans = numeroFans;
    }
}