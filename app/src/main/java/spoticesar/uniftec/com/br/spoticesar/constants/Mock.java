package spoticesar.uniftec.com.br.spoticesar.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.models.Album;
import spoticesar.uniftec.com.br.spoticesar.models.Artista;
import spoticesar.uniftec.com.br.spoticesar.models.Musica;

public class Mock {

    public static final List<Artista> mockArtistas =
            new ArrayList<>(Arrays.asList(
                    new Artista("Artista 1"),
                    new Artista("Artista 2"),
                    new Artista("Artista 3"),
                    new Artista("Artista 4")
            ));

    public static final List<Album> mockAlbuns =
            new ArrayList<>(Arrays.asList(
                    new Album("Album 1", Mock.mockArtistas.get(0)),
                    new Album("Album 2", Mock.mockArtistas.get(3)),
                    new Album("Album 3", Mock.mockArtistas.get(2)),
                    new Album("Album 4", Mock.mockArtistas.get(1))
            ));

    public static final List<Musica> mockMusicas = new ArrayList<>(Arrays.asList(
            new Musica("Musica 1", Calendar.getInstance(),
                    Mock.mockArtistas.get(0), Mock.mockAlbuns.get(2)),

            new Musica("Musica 2", Calendar.getInstance(),
                    Mock.mockArtistas.get(2), Mock.mockAlbuns.get(3)),

            new Musica("Musica 3", Calendar.getInstance(),
                    Mock.mockArtistas.get(1), Mock.mockAlbuns.get(0)),

            new Musica("Musica 4", Calendar.getInstance(),
                    Mock.mockArtistas.get(0), Mock.mockAlbuns.get(1))
    ));

}
