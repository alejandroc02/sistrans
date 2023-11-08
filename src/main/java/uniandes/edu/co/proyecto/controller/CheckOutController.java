package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.CheckOuts;
import uniandes.edu.co.proyecto.repositorio.CheckOutRepository;

@Controller
public class CheckOutController {

    @Autowired
    private CheckOutRepository checkOutRepository;

    @GetMapping("/checkouts")
    public String checkOuts(Model model) {
        model.addAttribute("CheckOuts", checkOutRepository.darCheckOuts());
        return "checkout"; // Este es un placeholder
    }

    @GetMapping("/checkouts/new")
    public String checkOutForm(Model model) {
        model.addAttribute("checkout", new CheckOuts());
        return "CheckOut nueva"; // Placeholder
    }

    @PostMapping("/checkouts/new/save")
    public String checkOutGuardar(@ModelAttribute CheckOuts checkout) {
        checkOutRepository.insertarCheckOut( checkout.getPk().getReservas_id(),checkout.getPk().getHabitacion_id(), checkout.getFecha_salida());
        //No es clientes, es con el ID de la habitacion
        return "redirect/checkouts";
    }

    @GetMapping("/checkouts/{reservasId}/edit")
    public String checkOutEditarForm(@PathVariable("reservasId") int reservasId, Model model) {
        CheckOuts checkout = checkOutRepository.darCheckOutPorReserva(reservasId);
        if (checkout != null) {
            model.addAttribute("checkout", checkout);
            return "CheckOut editada";
        } else {
            return "redirect:/checkouts";
        }
    }

    @PostMapping("/checkouts/{reservasId}/edit/save")
    public String checkOutEditarGuardar(@PathVariable("reservasId") int reservasId, @ModelAttribute CheckOuts checkout) {
        checkOutRepository.actualizarFechaSalida(reservasId, checkout.getFecha_salida());
        return "redirect/checkouts";
    }

    @PostMapping("/checkouts/{reservasId}/delete")
    public String checkOutEliminar(@PathVariable("reservasId") int reservasId) {
        checkOutRepository.eliminarCheckOutPorReserva(reservasId);
        return "redirect:/checkouts";
    }
}
