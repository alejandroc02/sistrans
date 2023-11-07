package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.proyecto.modelo.RFC12Result;
import uniandes.edu.co.proyecto.repositorio.RFC12Repository;

import java.util.Collection;

@Controller
public class RFC12Controller {

    @Autowired
    private RFC12Repository rfc12Repository;

    @GetMapping("/rfc12/consultar-clientes-con-gastos-elevados")
    public String consultarClientesConGastosElevados(Model model) {
        long tiempoInicio = System.nanoTime();
        Collection<RFC12Result> rta = rfc12Repository.consultarClientesConGastosElevados();
        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("Resultados", rta);

        return "rfc12-consultar-clientes-con-gastos-elevados";
    }
}
