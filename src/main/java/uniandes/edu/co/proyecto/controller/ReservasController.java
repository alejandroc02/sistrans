package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Reservas;
import uniandes.edu.co.proyecto.repositorio.ReservasRepository;

@Controller
public class ReservasController {

    @Autowired
    private ReservasRepository reservasRepository;

    @GetMapping("/reservas")
    public String reservas(Model model) {
        model.addAttribute("reservas", reservasRepository.darReservas());
        return "reservas"; // Este es un placeholder
    }

    @GetMapping("/reservas/new")
    public String reservasForm(Model model) {
        model.addAttribute("reserva", new Reservas());
        return "Reserva nueva"; // Placeholder
    }

    @PostMapping("/reservas/new/save")
    public String reservaGuardar(@ModelAttribute Reservas reserva) {
        reservasRepository.insertarReserva(reserva.getId(), reserva.getFecha_inicio(), reserva.getFecha_salida(),
                reserva.getNum_personas(), reserva.getPlanesConsumo_id(), reserva.getUsuariosPK());
        return "redirect/reservas";
    }

    @GetMapping("/reservas/{id}/edit")
    public String reservaEditarForm(@PathVariable("id") int id, Model model) {
        Reservas reserva = reservasRepository.darReserva(id);
        if (reserva != null) {
            model.addAttribute("reserva", reserva);
            return "Reserva editada";
        } else {
            return "redirect:/reservas";
        }
    }

    @PostMapping("/reservas/{id}/edit/save")
    public String reservaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Reservas reserva) {
        reservasRepository.actualizarReserva(id, reserva.getFecha_inicio(), reserva.getFecha_salida(),
                reserva.getNum_personas(), reserva.getPlanesConsumo_id(), reserva.getUsuariosPK());
        return "redirect/reservas";
    }

    @PostMapping("/reservas/{id}/delete")
    public String reservaEliminar(@PathVariable("id") int id) {
        reservasRepository.eliminarReserva(id);
        return "redirect:/reservas";
    }
}
