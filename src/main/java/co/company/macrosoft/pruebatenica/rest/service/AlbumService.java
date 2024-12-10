package co.company.macrosoft.pruebatenica.rest.service;

import co.company.macrosoft.pruebatenica.rest.entity.Album;
import co.company.macrosoft.pruebatenica.rest.repository.AlbumRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    /**
     * Guarda un nuevo álbum en la base de datos.
     * @param album el álbum a guardar.
     * @return el álbum guardado.
     */
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    /**
     * Obtiene todos los álbumes de la base de datos.
     * @return una lista de álbumes.
     */
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    /**
     * Obtiene un álbum por su ID.
     * @param id el ID del álbum.
     * @return el álbum correspondiente.
     * @throws EntityNotFoundException si no se encuentra el álbum.
     */
    public Album getAlbumById(long id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("El álbum con el ID " + id + " no existe."));
    }

    /**
     * Actualiza un álbum existente.
     * @param id el ID del álbum a actualizar.
     * @param nuevo el álbum con los nuevos datos.
     * @return el álbum actualizado.
     * @throws EntityNotFoundException si no se encuentra el álbum.
     */
    public Album updateAlbum(long id, Album nuevo) {
        Album albumExistente = albumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("El álbum con el ID " + id + " no existe."));

        // Actualizar los campos
        albumExistente.setName(nuevo.getName());
        albumExistente.setCover(nuevo.getCover());
        albumExistente.setDescription(nuevo.getDescription());
        albumExistente.setReleaseDate(nuevo.getReleaseDate());
        albumExistente.setGenre(nuevo.getGenre());
        albumExistente.setRecordLabel(nuevo.getRecordLabel());

        // Guardar los cambios
        return albumRepository.save(albumExistente);
    }

    /**
     * Elimina un álbum por su ID.
     * @param id el ID del álbum a eliminar.
     * @return el álbum eliminado.
     * @throws EntityNotFoundException si no se encuentra el álbum.
     */
    public Album deleteAlbum(long id) {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("El álbum con el ID " + id + " no existe."));

        albumRepository.delete(album);
        return album;
    }
}
