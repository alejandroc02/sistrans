package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.RFC4Result;
import uniandes.edu.co.proyecto.repositorio.RFC4Repository;

import java.util.Collection;
/* 
 * MOSTRAR LOS SERVICIOS QUE CUMPLEN CON CIERTA CARACTERÍSTICA
 */
@Controller
public class RFC4Controller {

    @Autowired
    private RFC4Repository rfc4Repository;

    @GetMapping("/rfc4")
    public String rfc4(
            @RequestParam("costo_minimo") Double costoMinimo,
            @RequestParam("costo_maximo") Double costoMaximo,
            @RequestParam("fecha_inicial") String fechaInicial,
            @RequestParam("fecha_final") String fechaFinal,
            @RequestParam("tipo_servicio") String tipoServicio,
            Model model) {
        long tiempoInicio = System.nanoTime();
        Collection<RFC4Result> rta = rfc4Repository.darServicioCiertaCaracteristica(costoMinimo, costoMaximo, fechaInicial, fechaFinal, tipoServicio);
        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("Costo", rta);

        return "rfc4";
    }
}
