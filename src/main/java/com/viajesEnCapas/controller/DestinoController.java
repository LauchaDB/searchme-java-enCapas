package com.viajesEnCapas.controller;

import negocio.Destinos;
import negocio.model.Destino;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/destinos")
public class DestinoController {

    Destinos destinos = new Destinos();

    @GetMapping("/destinosViaje/{id}")
    public List<Destino> destinosViaje(@PathVariable int id) throws SQLException {
        return destinos.destinosDeUnViaje(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void create(@RequestBody Destino destino){
        destinos.saveDestino(destino);
    }

    @PutMapping("/actualizar/{id}")
    public void update(@PathVariable int id, @RequestBody Destino destino){
        destinos.updateDestino(id, destino);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable int id){
        destinos.deleteDestino(id);

    }
}
