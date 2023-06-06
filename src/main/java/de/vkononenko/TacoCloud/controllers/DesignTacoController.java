package de.vkononenko.TacoCloud.controllers;

import de.vkononenko.TacoCloud.DAO.IngredientDAO;
import de.vkononenko.TacoCloud.DAO.TacoDAO;
import de.vkononenko.TacoCloud.models.Ingredient;
import de.vkononenko.TacoCloud.models.Taco;
import de.vkononenko.TacoCloud.models.enums.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    private IngredientDAO ingredientDAO;

    private TacoDAO tacoDAO;

    @Autowired
    public DesignTacoController(IngredientDAO ingredientDAO, TacoDAO tacoDAO) {
        this.ingredientDAO = ingredientDAO;
        this.tacoDAO = tacoDAO;
    }

    @GetMapping
    public String onLoad(Model model) {
        List<Ingredient> ingredients = ingredientDAO.findAll();
        for (Type type : Type.values()) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        return "/design";
    }

    @PostMapping
    @Transactional
    public String proceedTaco(@Valid Taco taco, Errors errors) {
        if(!errors.hasErrors()) {
            tacoDAO.save(taco);
        }
        return "/design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream().filter(i -> i.getType() == type).collect(Collectors.toList());
    }

    @ModelAttribute("taco")
    public Taco taco() {
        return new Taco();
    }
}