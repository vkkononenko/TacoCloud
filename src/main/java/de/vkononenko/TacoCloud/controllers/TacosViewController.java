package de.vkononenko.TacoCloud.controllers;

import de.vkononenko.TacoCloud.models.Ingredient;
import de.vkononenko.TacoCloud.models.Taco;
import de.vkononenko.TacoCloud.DAO.TacoDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/checkTacos")
public class TacosViewController {

    private TacoDAO tacoDAO;

    @Autowired
    public TacosViewController(TacoDAO tacoDAO) {
        this.tacoDAO = tacoDAO;
    }

    @GetMapping
    public String onLoad(Model model) {
        model.addAttribute("tacosList", tacoDAO.findAll());
        return "/checkTacos";
    }

    @ModelAttribute("taco")
    public Taco Taco() {
        return new Taco();
    }

    @ModelAttribute("ingredient")
    public Ingredient Ingredient() {
        return new Ingredient();
    }
}
