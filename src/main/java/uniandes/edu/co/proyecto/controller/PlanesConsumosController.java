package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Consumos;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Servicios;
import uniandes.edu.co.proyecto.repositorio.ConsumosRepository;


@Controller
public class PlanesConsumosController {

    @Autowired
    private ConsumosRepository consumosRepository;

    @GetMapping("/consumos")
    public String consumos(Model model) {
        model.addAttribute("Consumos", consumosRepository.darConsumos());
        return "consumos"; // Este es un placeholder
    }

    @GetMapping("/consumos/new")
    public String consumoForm(Model model) {
        model.addAttribute("consumo", new Consumos());
        return "Consumo nuevo"; // Placeholder
    }

   @PostMapping("/consumos/new/save")
   public String consumoGuardar(@ModelAttribute Consumos consumo) {
       consumosRepository.insertarConsumo(consumo.getPk().getHabitacion_id(), consumo.getPk().getServicios_tipo(), consumo.getDescripcion(), consumo.getCosto());//tipos
      return "redirect/consumos";
   }
//
    @GetMapping("/consumos/{habitacionId}/{serviciosTipo}/edit")
    public String consumoEditarForm(@PathVariable("habitacionId") Habitacion habitacionId, @PathVariable("serviciosTipo") Servicios serviciosTipo, Model model) {
        Consumos consumo = consumosRepository.darConsumoPorHabitacionYServicio(habitacionId.getId(), serviciosTipo.getTipo());
        if (consumo != null) {
            model.addAttribute("consumo", consumo);
            return "Consumo editado";
        } else {
            return "redirect:/consumos";
        }
    }

    @PostMapping("/consumos/{habitacionId}/{serviciosTipo}/edit/save")
    public String consumoEditarGuardar(@PathVariable("habitacionId") Habitacion habitacionId, @PathVariable("serviciosTipo") Servicios serviciosTipo, @ModelAttribute Consumos consumo) {
        consumosRepository.actualizarConsumo(habitacionId.getId(), serviciosTipo.getTipo(), consumo.getDescripcion(), consumo.getCosto());
        return "redirect/consumos";
    }

    @PostMapping("/consumos/{habitacionId}/{serviciosTipo}/delete")
    public String consumoEliminar(@PathVariable("habitacionId") Habitacion habitacionId, @PathVariable("serviciosTipo") Servicios serviciosTipo) {
        consumosRepository.eliminarConsumo(habitacionId.getId(), serviciosTipo.getTipo());
        return "redirect:/consumos";
    }
}
