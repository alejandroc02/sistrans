package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Tipohab;
import uniandes.edu.co.proyecto.repositorio.TipoHabRepository;


@Controller
public class TipoHabController {

    @Autowired
    private TipoHabRepository tipoHabRepository;

    @GetMapping("/tipohab")
    public String tiposHabitacion(Model model) {
        model.addAttribute("Tipohab", tipoHabRepository.darTiposHabitacion());
        return "tipohab"; // Este es un placeholder
    }

    @GetMapping("/tipohab/new")
    public String tiposHabitacionForm(Model model) {
        model.addAttribute("tipohab", new Tipohab());
        return "TipohabNueva"; // Placeholder
    }

    @PostMapping("/tipohab/new/save")
    public String tipoHabitacionGuardar(@ModelAttribute Tipohab tipohab) {
        tipoHabRepository.insertarTipoHabitacion(tipohab.getTipo(), tipohab.getId());
        return "redirect/tipohab";
    }

    @GetMapping("/tipohab/{id}/edit")
    public String tipoHabitacionEditarForm(@PathVariable("id") Integer id, Model model) {
        Tipohab tipohab = tipoHabRepository.darTipoHabitacion(id);
        if (tipohab != null) {
            model.addAttribute("tipohab", tipohab);
            return "TipohabEditada";
        } else {
            return "redirect:/tipohab";
        }
    }

    @PostMapping("/tipohab/{id}/edit/save")
    public String tipoHabitacionEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Tipohab tipohab) {
        tipoHabRepository.actualizarTipoHabitacion(id, tipohab.getTipo());
        return "redirect/tipohab";
    }

    @PostMapping("/tipohab/{id}/delete")
    public String tipoHabitacionEliminar(@PathVariable("id") Integer id) {
        tipoHabRepository.eliminarTipoHabitacion(id);
        return "redirect:/tipohab";
    }
}
