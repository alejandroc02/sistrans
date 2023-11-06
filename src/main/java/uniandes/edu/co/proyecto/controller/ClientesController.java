package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Clientes;
import uniandes.edu.co.proyecto.repositorio.ClientesRepository;

public class ClientesController {

    @Autowired
    private ClientesRepository clientesRepository;

    @GetMapping("/clientes")
    public String clientes(Model model) {
        model.addAttribute("Clientes", clientesRepository.darClientes());
        return "clientes"; // Este es un placeholder
    }

    @GetMapping("/clientes/new")
    public String clienteForm(Model model) {
        model.addAttribute("cliente", new Clientes());
        return "Cliente nuevo"; // Placeholder
    }

    @PostMapping("/clientes/new/save")
    public String clienteGuardar(@ModelAttribute Clientes cliente) {
        clientesRepository.insertarCliente(cliente.getNum_documento(), cliente.getNum_documento(), cliente.getNombre(), cliente.getCorreo());
        return "redirect/clientes";
    }

    @GetMapping("/clientes/{numDocumento}/edit")
    public String clienteEditarForm(@PathVariable("numDocumento") int numDocumento, Model model) {
        Clientes cliente = clientesRepository.darClientePorNumDocumento(numDocumento);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "Cliente editado";
        } else {
            return "redirect:/clientes";
        }
    }

    @PostMapping("/clientes/{numDocumento}/edit/save")
    public String clienteEditarGuardar(@PathVariable("numDocumento") int numDocumento, @ModelAttribute Clientes cliente) {
        clientesRepository.actualizarCliente(numDocumento, cliente.getNombre(), cliente.getCorreo());
        return "redirect/clientes";
    }

    @PostMapping("/clientes/{numDocumento}/delete")
    public String clienteEliminar(@PathVariable("numDocumento") int numDocumento) {
        clientesRepository.eliminarClientePorNumDocumento(numDocumento);
        return "redirect:/clientes";
    }
}
