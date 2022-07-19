package mx.com.gm.HolaMundoThymeleaf.HolaMundoThymeleaf;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import mx.com.gm.HolaMundoThymeleaf.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;

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

        var persona2 = new Persona();
        persona2.setNombre("Fernanda");
        persona2.setApellido("Madrigal");
        persona2.setEmail("fernanda.madrigal@hotmail.com");
        persona2.setTelefono("013 224 4567");

        //List<Persona> personas = new ArrayList();
        //personas.add(persona);
        //personas.add(persona2);

        //var personas = new ArrayList();
        //personas.add(persona2);
        //personas.add(persona);

        var personas= Arrays.asList(persona, persona2);

        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);

        return "index";
    }
}
