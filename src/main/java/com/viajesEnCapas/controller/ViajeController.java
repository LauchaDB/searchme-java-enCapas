package com.viajesEnCapas.controller;

import negocio.Destinos;
import negocio.Viajes;
import negocio.model.Destino;
import negocio.model.Viaje;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
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
            viajes.saveViaje(viaje);
        } catch (ParseException e) {
            System.out.println(e);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createViajeConDestino/{nombreViaje}/{descripcionViaje}/{fechaViaje}/{valorViaje}/{emailUs}")
    public void createViajeConDestino(@PathVariable String nombreViaje, @PathVariable String descripcionViaje, @PathVariable String fechaViaje, @PathVariable double valorViaje, @PathVariable String emailUs, @RequestBody List<Destino> cuerpoPeticion) throws ParseException {

        Viaje viaje = new Viaje();
        Destino destino1 = new Destino();
        Destino destino2 = new Destino();
        Destinos destinos = new Destinos();
        try{
            //creando viaje
            viaje.setNombreViaje(nombreViaje);
            viaje.setDescripViaje(descripcionViaje);
            viaje.setFechaViaje(new Date(2022-10-12));
            viaje.setValorTotalViaje(valorViaje);
            viaje.setIsGuardadoViaje(false);
            viaje.setEmailUs(emailUs);
            viajes.saveViaje(viaje);
            for (Destino destinoDeLaPeticion: cuerpoPeticion) {
                destinos.saveDestinoParaElUltimoViaje(destinoDeLaPeticion);
            }
        }catch(Exception e){
            System.out.println("no se puede perro");
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

    @GetMapping("/probarConstructor")
    public void probarConstructorViajeYDestinos() throws SQLException {
        try{
            Viaje viaje = new Viaje(1);
        }catch(Exception e){
            System.out.println("No existe viaje con ese id");
        }
    }
}
