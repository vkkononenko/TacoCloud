package de.vkononenko.TacoCloud.web;

import de.vkononenko.TacoCloud.DAO.TacoDAO;
import de.vkononenko.TacoCloud.models.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/web/tacos/", produces = "application/json")
@CrossOrigin(origins = "http://tacocloud:8080")
public class TacoRest {

    private TacoDAO tacoDAO;

    @Autowired
    public TacoRest(TacoDAO tacoDAO) {
        this.tacoDAO = tacoDAO;
    }

    @GetMapping
    public Taco getTacoById(@RequestParam(name = "id") Long id) {
        return tacoDAO.findById(id).orElse(null);
    }
}
