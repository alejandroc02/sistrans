package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Servicios;
import uniandes.edu.co.proyecto.repositorio.ServiciosRepository;

import java.util.List;

public class ServiciosController {

    @Autowired
    private ServiciosRepository serviciosRepository;

    @GetMapping("/servicios")
    public String servicios(Model model) {
        List<Servicios> servicios = serviciosRepository.findAll();
        model.addAttribute("Servicios", servicios);
        return "servicios"; // Este es un placeholder
    }

    @GetMapping("/servicios/new")
    public String serviciosForm(Model model) {
        model.addAttribute("servicio", new Servicios());
        return "Servicio nuevo"; // Placeholder
    }

    @PostMapping("/servicios/new/save")
    public String servicioGuardar(@ModelAttribute Servicios servicio) {
        serviciosRepository.insertarServicio(servicio.getTipo(), servicio.getDescripcion());
        return "redirect/servicios";
    }

    @GetMapping("/servicios/{tipo}/edit")
    public String servicioEditarForm(@PathVariable("tipo") String tipo, Model model) {
        Servicios servicio = serviciosRepository.findById(tipo).orElse(null);
        if (servicio != null) {
            model.addAttribute("servicio", servicio);
            return "Servicio editado";
        } else {
            return "redirect:/servicios";
        }
    }

    @PostMapping("/servicios/{tipo}/edit/save")
    public String servicioEditarGuardar(@PathVariable("tipo") String tipo, @ModelAttribute Servicios servicio) {
        serviciosRepository.actualizarServicio(tipo, servicio.getDescripcion());
        return "redirect/servicios";
    }

    @PostMapping("/servicios/{tipo}/delete")
    public String servicioEliminar(@PathVariable("tipo") String tipo) {
        serviciosRepository.eliminarServicio(tipo);
        return "redirect:/servicios";
    }
}
