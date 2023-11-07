package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uniandes.edu.co.proyecto.repositorio.RFC5Repository;

import java.util.Collection;

@Controller
public class RFC5Controller {

    @Autowired
    private RFC5Repository rfc5Repository;

    @GetMapping("/rfc5")
    public String rfc5(
            @RequestParam("id_usuario") Integer idUsuario,
            @RequestParam("fecha_inicial") String fechaInicial,
            @RequestParam("fecha_final") String fechaFinal,
            Model model) {
        long tiempoInicio = System.nanoTime();
        Collection<Object[]> rta = rfc5Repository.darRespuesta(idUsuario, fechaInicial, fechaFinal);
        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("Costo", rta);

        return "rfc5";
    }
}
