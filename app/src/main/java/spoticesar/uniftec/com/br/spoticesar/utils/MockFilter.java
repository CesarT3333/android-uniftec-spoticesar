package spoticesar.uniftec.com.br.spoticesar.utils;

import java.util.ArrayList;
import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.constants.Mock;
import spoticesar.uniftec.com.br.spoticesar.models.Musica;

public class MockFilter {

    public static List<Musica> getMusicasDoAlbum(final Integer idAlbum) {

        List<Musica> musicasFiltradas = new ArrayList<>();

        List<Musica> mockMusicas = Mock.mockMusicas;

        for (Musica m : mockMusicas)
            if (m.getAlbum().getId() == idAlbum)
                musicasFiltradas.add(m);

        return musicasFiltradas;

    }

}
