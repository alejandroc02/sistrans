package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.proyecto.modelo.RFC7Result;
import uniandes.edu.co.proyecto.repositorio.RFC7Repository;

import java.util.Collection;

@Controller
public class RFC7Controller {

    @Autowired
    private RFC7Repository rfc7Repository;

    @GetMapping("/rfc7/buenos-clientes")
    public String buenosClientes(Model model) {
        long tiempoInicio = System.nanoTime();
        Collection<RFC7Result> rta = rfc7Repository.encontrarBuenosClientes();
        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("Resultados", rta);

        return "rfc7-buenos-clientes";
    }
}
