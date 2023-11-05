package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.ReservasServ;
import uniandes.edu.co.proyecto.repositorio.ReservaServicioRepository;

import java.util.Collection;

public class ReservasServicioController {

    @Autowired
    private ReservaServicioRepository reservaServicioRepository;

    @GetMapping("/reservas_servicio")
    public String reservasServicio(Model model) {
        Collection<ReservasServ> reservasServicio = reservaServicioRepository.darReservasServicio();
        model.addAttribute("ReservasServ", reservasServicio);
        return "reservas_servicio"; // Este es un placeholder
    }

    @GetMapping("/reservas_servicio/new")
    public String reservasServicioForm(Model model) {
        model.addAttribute("reservaServicio", new ReservasServ());
        return "Reserva de Servicio nueva"; // Placeholder
    }

    @PostMapping("/reservas_servicio/new/save")
    public String reservaServicioGuardar(@ModelAttribute ReservasServ reservaServicio) {
        // Lógica para guardar la reserva de servicio en la base de datos
        return "redirect/reservas_servicio";
    }

    @GetMapping("/reservas_servicio/{id}/edit")
    public String reservaServicioEditarForm(@PathVariable("id") int id, Model model) {
        ReservasServ reservaServicio = reservaServicioRepository.darReservaServicio(id);
        if (reservaServicio != null) {
            model.addAttribute("reservaServicio", reservaServicio);
            return "Reserva de Servicio editada";
        } else {
            return "redirect:/reservas_servicio";
        }
    }

    @PostMapping("/reservas_servicio/{id}/edit/save")
    public String reservaServicioEditarGuardar(@PathVariable("id") int id, @ModelAttribute ReservasServ reservaServicio) {
        // Lógica para actualizar la reserva de servicio en la base de datos
        return "redirect/reservas_servicio";
    }

    @PostMapping("/reservas_servicio/{id}/delete")
    public String reservaServicioEliminar(@PathVariable("id") int id) {
        // Lógica para eliminar la reserva de servicio de la base de datos
        return "redirect:/reservas_servicio";
    }
}
