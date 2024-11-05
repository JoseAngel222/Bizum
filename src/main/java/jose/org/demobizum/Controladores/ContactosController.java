package jose.org.demobizum.Controladores;

import jose.org.demobizum.Entidades.Bizum;
import jose.org.demobizum.Entidades.Contactos;
import jose.org.demobizum.Servicios.BizumService;
import jose.org.demobizum.Servicios.ContactosService;
import jose.org.demobizum.Servicios.I18nService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
@Slf4j
@RequiredArgsConstructor
@Controller
public class ContactosController {
    private final BizumService bizumService;
    private final ContactosService contactosService;
    private final I18nService i18nService;

    @GetMapping("bizum/contactos")
    public String listado(Model model) {
        model.addAttribute( "fechaHoy", LocalDate.now());
        model.addAttribute("listaContactos", contactosService.findAll());
        model.addAttribute("saldo", bizumService.getSaldo());
        return "contactos";
    }

    @GetMapping("bizum/nuevo")
    public String nuevo(Model model) {
        log.info("Abriendo formulario de nuevo contacto");
        model.addAttribute("contacto", Contactos.builder().build());
        model.addAttribute("modoEdicion", false);
        return "formulario";
    }

    @PostMapping("bizum/nuevo")
    public String nuevo(@ModelAttribute("contacto") Contactos nuevoContacto) {
        contactosService.add(nuevoContacto);
        return "redirect:/bizum/contactos";
    }

}
