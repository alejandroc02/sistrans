package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.proyecto.modelo.RFC11Result;
import uniandes.edu.co.proyecto.repositorio.RFC11Repository;

import java.util.Collection;

@Controller
public class RFC11Controller {

    @Autowired
    private RFC11Repository rfc11Repository;

    @GetMapping("/rfc11/consultar-funcionamiento")
    public String consultarFuncionamiento(Model model) {
        long tiempoInicio = System.nanoTime();
        Collection<RFC11Result> rta = rfc11Repository.consultarFuncionamiento();
        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("Resultados", rta);

        return "rfc11-consultar-funcionamiento";
    }
}
