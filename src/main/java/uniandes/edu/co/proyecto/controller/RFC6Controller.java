package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uniandes.edu.co.proyecto.repositorio.RFC6Repository;

import java.util.Collection;

@Controller
public class RFC6Controller {

    @Autowired
    private RFC6Repository rfc6Repository;

    @GetMapping("/rfc6/mayor-ocupacion")
    public String mayorOcupacion(Model model) {
        long tiempoInicio = System.nanoTime();
        Collection<Object[]> rta = rfc6Repository.obtenerMayorOcupacion();
        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("Resultados", rta);

        return "rfc6-mayor-ocupacion";
    }

    @GetMapping("/rfc6/mayores-ingresos")
    public String mayoresIngresos(Model model) {
        long tiempoInicio = System.nanoTime();
        Collection<Object[]> rta = rfc6Repository.obtenerMayoresIngresos();
        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("Resultados", rta);

        return "rfc6-mayores-ingresos";
    }

    @GetMapping("/rfc6/menor-ocupacion")
    public String menorOcupacion(Model model) {
        long tiempoInicio = System.nanoTime();
        Collection<Object[]> rta = rfc6Repository.obtenerMenorOcupacion();
        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("Resultados", rta);

        return "rfc6-menor-ocupacion";
    }
}
