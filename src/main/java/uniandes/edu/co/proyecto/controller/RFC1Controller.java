package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.proyecto.modelo.RFC1Result;
import uniandes.edu.co.proyecto.repositorio.RFC1Repository;
/* 
RFC1 - MOSTRAR EL DINERO RECOLECTADO POR SERVICIOS EN CADA 
HABITACIÓN EN EL ÚLTIMO AÑO CORRIDO. 
*/
@Controller
public class RFC1Controller {

    @Autowired
    private RFC1Repository rfc1Repository;

    @GetMapping("/rfc1")   
    public String rfc1(Model model) {
        long tiempoInicio = System.nanoTime();
        Collection<RFC1Result> rta = rfc1Repository.dineroServiciosHabitacionUltimoAño();
        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("Costo", rta);

        return "rfc1";
    }
}
