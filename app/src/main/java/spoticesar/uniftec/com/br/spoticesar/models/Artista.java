package spoticesar.uniftec.com.br.spoticesar.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import spoticesar.uniftec.com.br.spoticesar.generics.GenericEntity;

public class Artista
        extends GenericEntity {

    @JsonProperty("name")
    private String nome;

    @JsonProperty("picture_small")
    private String imagem;

    @JsonProperty("nb_fan")
    private long numeroFans;

    @JsonProperty("nb_album")
    private long numeroAlbuns;

    public long getNumeroFans() {
        return numeroFans;
    }

    public void setNumeroFans(long numeroFans) {
        this.numeroFans = numeroFans;
    }

    public long getNumeroAlbuns() {
        return numeroAlbuns;
    }

    public void setNumeroAlbuns(long numeroAlbuns) {
        this.numeroAlbuns = numeroAlbuns;
    }

    @Override
    public String getImageUrl() {
        return imagem;
    }

    public Artista() {
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
