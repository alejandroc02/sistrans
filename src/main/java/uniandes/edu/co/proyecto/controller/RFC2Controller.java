package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.RFC2Result;
import uniandes.edu.co.proyecto.repositorio.RFC2Repository;

import java.util.Collection;

@Controller
public class RFC2Controller {

    @Autowired
    private RFC2Repository rfc2Repository;

    @GetMapping("/rfc2")
    public String rfc2(@RequestParam("fecha_inicial") String fechaInicial, @RequestParam("fecha_final") String fechaFinal, Model model) {
        long tiempoInicio = System.nanoTime();
        Collection<RFC2Result> rta = rfc2Repository.darRespuesta(fechaInicial, fechaFinal);
        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("Costo", rta);

        return "rfc2";
    }
}
