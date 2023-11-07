package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.proyecto.modelo.RFC3Result;
import uniandes.edu.co.proyecto.repositorio.RFC3Repository;

import java.util.Collection;

@Controller
public class RFC3Controller {

    @Autowired
    private RFC3Repository rfc3Repository;

    @GetMapping("/rfc3")
    public String rfc3(Model model) {
        long tiempoInicio = System.nanoTime();
        Collection<RFC3Result> rta = rfc3Repository.darRespuesta();
        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("Costo", rta);

        return "rfc3";
    }
}
