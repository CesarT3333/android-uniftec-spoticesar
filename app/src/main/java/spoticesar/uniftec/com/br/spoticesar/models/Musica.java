package spoticesar.uniftec.com.br.spoticesar.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Calendar;

import spoticesar.uniftec.com.br.spoticesar.generics.GenericEntity;

public class Musica
        extends GenericEntity {

    @JsonProperty("title")
    private String nome;

    @JsonProperty("album")
    private Album album = new Album();

    @JsonProperty("artist")
    private Artista artista = new Artista();

    @JsonProperty("duration")
    private long duracao;

    @JsonProperty("release_date")
    private String dataLancamento;

    public Musica() {

    }

    @Override
    public String toString() {
        return "Nome: "
                + this.nome
                + "\nArtista: "
                + this.artista.getNome()
                + "\nDuração: " + this.getDuracao()+" seg."
                + "\nAlbum: "
                + this.album.getNome();
    }

    @Override
    public String getImageUrl() {
        return this.album.getImageUrl();
    }
//
//    public Musica(String nome, Artista artista, Album album) {
//        this.nome = nome;
//        this.artista = artista;
//    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public long getDuracao() {
        return duracao;
    }

    public void setDuracao(long duracao) {
        this.duracao = duracao;
    }
}
//
//class AlbumRerorno {
//
//    @JsonProperty("cover_small")
//    private String imagem;
//
//    @JsonProperty("title")
//    private String title;
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getImageUrl() {
//        return this.imagem;
//    }
//
//    public String getImagem() {
//        return imagem;
//    }
//
//    public void setImagem(String imagem) {
//        this.imagem = imagem;
//    }
//}
