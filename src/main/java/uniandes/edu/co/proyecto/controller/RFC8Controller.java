package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.proyecto.modelo.RFC6Result;
import uniandes.edu.co.proyecto.modelo.RFC8Result;
import uniandes.edu.co.proyecto.repositorio.RFC8Repository;

import java.util.Collection;

@Controller
public class RFC8Controller {

    @Autowired
    private RFC8Repository rfc8Repository;

    @GetMapping("/rfc8/servicios-poca-demanda")
    public String serviciosPocaDemanda(Model model) {
        long tiempoInicio = System.nanoTime();
        Collection<RFC8Result> rta = rfc8Repository.encontrarServiciosConPocaDemanda();
        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("Resultados", rta);

        return "rfc8-servicios-poca-demanda";
    }
}
