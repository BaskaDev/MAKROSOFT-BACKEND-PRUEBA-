package co.company.macrosoft.pruebatenica.rest.repository;

import co.company.macrosoft.pruebatenica.rest.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository  extends JpaRepository<Album, Long> {

    Album findAlbumById(Long id);
}
