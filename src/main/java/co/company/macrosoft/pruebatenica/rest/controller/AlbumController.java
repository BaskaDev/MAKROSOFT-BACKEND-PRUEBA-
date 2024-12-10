package co.company.macrosoft.pruebatenica.rest.controller;

import co.company.macrosoft.pruebatenica.rest.entity.Album;
import co.company.macrosoft.pruebatenica.rest.service.AlbumService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    //TODO: METODO PARA CREAR UN ALBUM
    @PostMapping
    public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
        Album savedAlbum = albumService.saveAlbum(album);
        return new ResponseEntity<>(savedAlbum, HttpStatus.CREATED);
    }

    //TODO: METODO PARA OBTENER TODOS LOS ALBUMS
    @GetMapping
    public ResponseEntity<List<Album>> getAllAlbums() {
        List<Album> albums = albumService.getAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    //TODO: METODO PARA OBTENER ALBUM POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable long id) {
        try {
            Album album = albumService.getAlbumById(id);
            return new ResponseEntity<>(album, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //TODO: METODO PARA ACTUALIZAR ALBUM POR SU ID
    @PutMapping("/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable long id, @RequestBody Album album) {
        try {
            Album updatedAlbum = albumService.updateAlbum(id, album);
            return new ResponseEntity<>(updatedAlbum, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //TODO:METODO PARA ELIMINAR ALBUM POR SU ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable long id) {
        try {
            albumService.deleteAlbum(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
