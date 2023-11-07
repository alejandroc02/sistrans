package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Tipohab;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;

public class HabitacionesController {


    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping("/habitaciones")
    public String habitaciones(Model model){
        model.addAttribute("Habitaciones", habitacionRepository.darHabitaciones());
        return "habitacion"; // este es un place holder


    }

    @GetMapping("/habitaciones/new")
    public String habitacionesFrom(Model model){
        model.addAttribute("habitaciones", new Habitacion());
        return "Habitacion nueva";//placeholder creo 
    }
    
    @PostMapping("/habitaciones/new/save")
    public String habitacionGuardar(@ModelAttribute Habitacion habitacion){
        habitacionRepository.insertarHabitacion(habitacion.getId(), habitacion.getCapacidad(),habitacion.getCosto(), habitacion.getTipohab_tipo());
        return"rederict/habitaciones";
    }

    @GetMapping("/habitaciones/{id}/edit")
    public String habitacionEditarForm(@PathVariable("id") Integer id,Model model){
        Habitacion habitacion= habitacionRepository.darHabitacion(id);
        if(habitacion != null){
            model.addAttribute("habitacion", habitacion);
            return "Habitacioneditada";
        }else{
            return "redirect:/habitaciones";
        }
    }

    @PostMapping("/habitaciones/{id}/edit/save")
    public String habitacionEditarGuardar(@PathVariable("id") Integer id,@ModelAttribute Habitacion habitacion){

        habitacionRepository.actualizarHabitacion(id,habitacion.getCapacidad(), habitacion.getCosto(),habitacion.getTipohab_tipo());
        return "redirect/habitaciones";
    }

    @PostMapping("/habitaciones/{id}/delete")
    public String habitacionEliminar(@PathVariable("id") Integer id){
        habitacionRepository.eliminarHabitacion(id);
        return "redirect:/habitaciones";
    }

    //gettipohab

}
