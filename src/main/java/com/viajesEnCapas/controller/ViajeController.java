package com.viajesEnCapas.controller;

import negocio.Viajes;
import negocio.model.Viaje;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/viajes")
public class ViajeController {

    Viajes viajes = new Viajes();

    @GetMapping("")
    public List<Viaje> viajes() throws SQLException {
        return viajes.findAllViajes();
    }

    @GetMapping("/viajesLike")
    public List<Viaje> viajesLike() throws SQLException {
        return viajes.findAllViajesLike();
    }

    @GetMapping("/viajesUsuario/{email_us}")
    public List<Viaje> viajesUsuario(@PathVariable String email_us) throws SQLException {
        return viajes.findAllViajesUsuario(email_us);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create/{email_us}")
    public void create(@PathVariable String email_us ,@RequestBody Viaje viaje){
        System.out.println("nombre: " +viaje.getNombreViaje() + ", descrip: " + viaje.getDescripViaje() + ", fecha: " + viaje.getFechaViaje() + ", valor: " + viaje.getValorTotalViaje());

        try {
            viajes.saveViaje(viaje, email_us);
        } catch (ParseException e) {
            System.out.println(e);
        }
    }

    @PutMapping("/actualizar/{id}")
    public void update(@PathVariable int id, @RequestBody Viaje viaje){
        System.out.println("nombre: " +viaje.getNombreViaje() + ", descrip: " + viaje.getDescripViaje() + ", fecha: " + viaje.getFechaViaje() + ", valor: " + viaje.getValorTotalViaje());
        viajes.updateViaje(id,viaje);
    }

    @PutMapping("/viajeLike/{id}/{isGuardado}")
    public void viajeLike(@PathVariable int id, @PathVariable boolean isGuardado){
        System.out.println("id: " + id +"- bool: "+isGuardado);
        viajes.likeViaje(id, isGuardado);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable int id){
        viajes.deleteViaje(id);
    }
}
