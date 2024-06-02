package bo.emi.controllers;

import bo.emi.dto.EstudianteDTO;
import bo.emi.service.EstudianteService;
import bo.emi.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/prueba")
    public ModelAndView prueba() {
        return new ModelAndView("estudiante/prueba");
    }

    //Peticion GET
    @GetMapping("/list")
    public ModelAndView getList() {
        return new ModelAndView("estudiante/list");
    }

    // Peticion GET
    @GetMapping("")
    @ResponseBody // Devolucion del resultado en formato JSON
    public List<EstudianteDTO> obtenerEstudiantes() {
        return estudianteService.obtenerEstudiantes();
    }

    @GetMapping("/new")
    public ModelAndView nuevoEstudiante() {
        return new ModelAndView("estudiante/new");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editarEstudiante(@PathVariable Integer id) {
        return new ModelAndView("estudiante/edit", new HashMap<>(){{ put("id", id); }});
    }
    // Peticion GET
    @GetMapping("/{id}")
    @ResponseBody
    public EstudianteDTO obtenerEstudiante(@PathVariable Integer id) {
        return estudianteService.obtenerEstudiante(id);
    }

    // Peticion POST
    @PostMapping("")
    @ResponseBody
    // @RequestBody recibe los datos en formato json
    public Response registrarEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        Response response = new Response("ok");
        estudianteService.registrarEstudiante(estudianteDTO);
        return response;
    }

    // Peticion PUT
    @PutMapping("")
    @ResponseBody
    public Response actualizarEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        Response response = new Response("ok");
        estudianteService.actualizarEstudiante(estudianteDTO);
        return response;
    }

    // Peticion DELETE
    @DeleteMapping("/{id}")
    @ResponseBody
    public Response eliminarEstudiante(@PathVariable Integer id) {
        Response response = new Response("ok");
        estudianteService.eliminarEstudiante(id);
        return response;
    }
}
