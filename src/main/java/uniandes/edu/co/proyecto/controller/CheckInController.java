package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.CheckIn;
import uniandes.edu.co.proyecto.repositorio.CheckInRepository;



public class CheckInController {

    @Autowired
    private CheckInRepository checkInRepository;

    @GetMapping("/checkins")
    public String checkIns(Model model) {
        model.addAttribute("CheckIns", checkInRepository.darCheckIns());
        return "checkin"; // Este es un place holder
    }

    @GetMapping("/checkins/new")
    public String checkInForm(Model model) {
        model.addAttribute("checkin", new CheckIn());
        return "CheckIn nueva"; // Placeholder
    }

    @PostMapping("/checkins/new/save")
    public String checkInGuardar(@ModelAttribute CheckIn checkin) {
        checkInRepository.insertarCheckIn(checkin.getPk().getReservas_id(), checkin.getPk().getclientesPK(), checkin.getFecha_ingreso()); //arerglar getclientes en modelo
        return "redirect/checkins";
    }

    @GetMapping("/checkins/{reservasId}/edit")
    public String checkInEditarForm(@PathVariable("reservasId") int reservasId, Model model) {
        CheckIn checkin = checkInRepository.darCheckInPorReserva(reservasId);
        if (checkin != null) {
            model.addAttribute("checkin", checkin);
            return "CheckIn editada";
        } else {
            return "redirect:/checkins";
        }
    }

    @PostMapping("/checkins/{reservasId}/edit/save")
    public String checkInEditarGuardar(@PathVariable("reservasId") int reservasId, @ModelAttribute CheckIn checkin) {
        checkInRepository.actualizarFechaIngreso(reservasId, checkin.getFecha_ingreso());
        return "redirect/checkins";
    }

    @PostMapping("/checkins/{reservasId}/delete")
    public String checkInEliminar(@PathVariable("reservasId") int reservasId) {
        checkInRepository.eliminarCheckInPorReserva(reservasId);
        return "redirect:/checkins";
    }
}
