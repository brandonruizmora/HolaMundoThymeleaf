package mx.com.gm.HolaMundoThymeleaf.HolaMundoThymeleaf;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import mx.com.gm.HolaMundoThymeleaf.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Value("${index.saludo}")
    private String saludo;

    @GetMapping("/")
    public String inicio(Model model) {

        log.info("Ejecutando controlador Spring MVC");

        var mensaje = "Hola Mundo con Thymeleaf";

        var persona = new Persona();
        persona.setNombre("Brandon");
        persona.setApellido("Ruiz");
        persona.setEmail("brandon.ruiz@hotmail.com");
        persona.setTelefono("456 345 4567");

        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("persona", persona);
        
        return "index";
    }
}
