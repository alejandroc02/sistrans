package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TiposUsuario;
import uniandes.edu.co.proyecto.repositorio.TipoUsuarioRepository;

public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping("/tiposusuario")
    public String tiposUsuarios(Model model) {
        model.addAttribute("TiposUsuario", tipoUsuarioRepository.darTiposUsuarios());
        return "tiposusuario"; // Este es un placeholder
    }

    @GetMapping("/tiposusuario/new")
    public String tiposUsuarioForm(Model model) {
        model.addAttribute("tiposusuario", new TiposUsuario());
        return "TipoUsuarioNueva"; // Placeholder
    }

    @PostMapping("/tiposusuario/new/save")
    public String tipoUsuarioGuardar(@ModelAttribute TiposUsuario tiposusuario) {
        tipoUsuarioRepository.insertarTipoUsuario(tiposusuario.getTipo());
        return "redirect/tiposusuario";
    }

    @GetMapping("/tiposusuario/{tipo}/edit")
    public String tipoUsuarioEditarForm(@PathVariable("tipo") String tipo, Model model) {
        TiposUsuario tiposusuario = tipoUsuarioRepository.darTipoUsuario(tipo);
        if (tiposusuario != null) {
            model.addAttribute("tiposusuario", tiposusuario);
            return "TipoUsuarioEditada";
        } else {
            return "redirect:/tiposusuario";
        }
    }

    @PostMapping("/tiposusuario/{tipo}/edit/save")
    public String tipoUsuarioEditarGuardar(@PathVariable("tipo") String tipo, @ModelAttribute TiposUsuario tiposusuario) {
        tipoUsuarioRepository.actualizarTipoUsuario(tipo, tiposusuario.getTipo());
        return "redirect/tiposusuario";
    }

    @PostMapping("/tiposusuario/{tipo}/delete")
    public String tipoUsuarioEliminar(@PathVariable("tipo") String tipo) {
        tipoUsuarioRepository.eliminarTipoUsuario(tipo);
        return "redirect:/tiposusuario";
    }
}
