package spoticesar.uniftec.com.br.spoticesar.models;

import java.io.Serializable;
import java.util.Calendar;

import spoticesar.uniftec.com.br.spoticesar.generics.GenericEntity;

public class Musica
        extends GenericEntity {

    private String nome;

    private Calendar duracaoFaixa;

    private Artista artista;

    public Musica(){

    }
    private Album album;

    public Musica(String nome, Calendar duracaoFaixa, Artista artista, Album album) {
        this.nome = nome;
        this.duracaoFaixa = duracaoFaixa;
        this.artista = artista;
        this.album = album;
    }

    @Override
    public String toString() {
        return "Nome: "
                + this.nome
                + "\nArtista: "
                + this.artista.getNome()
                + "\nDuração: 02:30 "
                + "\nAlbum: "
                + this.album.getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDuracaoFaixa() {
        return duracaoFaixa;
    }

    public void setDuracaoFaixa(Calendar duracaoFaixa) {
        this.duracaoFaixa = duracaoFaixa;
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
}
