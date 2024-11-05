package jose.org.demobizum.Controladores;

import jose.org.demobizum.Servicios.BizumService;
import jose.org.demobizum.Servicios.ContactosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class BizumController {

    private final BizumService bizumService;
    private final ContactosService contactosService;

    @GetMapping("/bizum/enviar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("saldo", bizumService.getSaldo());
        model.addAttribute("listaContactos", contactosService.findAll());
        return "bizum"; // nombre de la plantilla Thymeleaf para mostrar el formulario
    }

    @PostMapping("/bizum/enviar")
    public String enviarBizum(@RequestParam double monto, @RequestParam String concepto, @RequestParam String nombre, Model model) {
        //String nombreContacto = numeroTelefono;
        String resultado = bizumService.enviarDinero(monto, concepto, nombre);  // Envía el dinero y recibe el mensaje
        model.addAttribute("mensaje", resultado);  // Mensaje sobre el resultado de la transacción
        model.addAttribute("saldo", bizumService.getSaldo());  // Actualiza el saldo restante
        model.addAttribute("transacciones", bizumService.getTransacciones());  // Pasa la lista de transacciones
        return "resultado";  // Redirige a la vista resultado
    }

    @GetMapping("/bizum/operaciones")
    public String mostrarOperaciones(Model model) {
        model.addAttribute("saldo", bizumService.getSaldo());  // Actualiza el saldo restante
        model.addAttribute("transacciones", bizumService.getTransacciones());  // Pasa la lista de transacciones
        return "operaciones"; // nombre de la plantilla Thymeleaf para mostrar el formulario
    }
}

