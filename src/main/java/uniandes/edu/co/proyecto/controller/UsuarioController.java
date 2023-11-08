package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Usuarios;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

import java.util.Collection;


@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        Collection<Usuarios> usuarios = usuarioRepository.findAllUsuarios();
        model.addAttribute("Usuarios", usuarios);
        return "usuarios"; // Este es un placeholder
    }
    
    @GetMapping("/usuarios/new")
    public String usuariosForm(Model model) {
        model.addAttribute("usuario", new Usuarios());
        return "Usuario nuevo"; // Placeholder
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuarios usuario) {
        usuarioRepository.insertUsuario(usuario.getNum_documento(), usuario.getTipo_documento(), usuario.getNombre(), usuario.getCorreo(), usuario.getTiposUsuario_tipo());// todos los atributos son pk ?
        return "redirect/usuarios";
    }

    @GetMapping("/usuarios/{id}/edit")
    public String usuarioEditarForm(@PathVariable("id") Long id, Model model) {
        Usuarios usuario = usuarioRepository.findUsuarioById(id);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "Usuario editado";
        } else {
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/usuarios/{id}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("id") Long id, @ModelAttribute Usuarios usuario) {
        usuarioRepository.updateUsuario(id, usuario.getTipo_documento(), usuario.getNum_documento(), usuario.getNombre(), usuario.getCorreo(), usuario.getTiposUsuario_tipo());
        return "redirect/usuarios";
    }

    @PostMapping("/usuarios/{id}/delete")
    public String usuarioEliminar(@PathVariable("id") Long id) {
        usuarioRepository.deleteUsuario(id);
        return "redirect:/usuarios";
    }
}
