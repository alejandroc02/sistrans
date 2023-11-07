package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uniandes.edu.co.proyecto.repositorio.RFC10Repository;

import java.util.Collection;

@Controller
public class RFC10Controller {

    @Autowired
    private RFC10Repository rfc10Repository;

    @GetMapping("/rfc10/consultar-consumo-hotel-andes")
    public String consultarConsumoHotelAndes(
            @RequestParam("fecha_inicial") String fechaInicial,
            @RequestParam("fecha_final") String fechaFinal,
            Model model) {
        long tiempoInicio = System.nanoTime();
        Collection<Object[]> rta = rfc10Repository.consultarConsumoHotelAndes(fechaInicial, fechaFinal);
        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("Resultados", rta);

        return "rfc10-consultar-consumo-hotel-andes";
    }
}
