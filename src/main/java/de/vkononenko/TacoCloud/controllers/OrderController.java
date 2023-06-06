package de.vkononenko.TacoCloud.controllers;

import de.vkononenko.TacoCloud.models.TacoOrder;
import de.vkononenko.TacoCloud.DAO.TacoDAO;
import de.vkononenko.TacoCloud.DAO.TacoOrderDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/completeOrder")
public class OrderController {

    private TacoDAO tacoDAO;

    private TacoOrderDAO tacoOrderDAO;

    @Autowired
    public OrderController(TacoDAO tacoDAO, TacoOrderDAO tacoOrderDAO) {
        this.tacoDAO = tacoDAO;
        this.tacoOrderDAO = tacoOrderDAO;
    }

    @GetMapping
    public String onLoad(Model model) {
        model.addAttribute("tacosList", tacoDAO.findAll());
        return "/completeOrder";
    }

    @PostMapping
    @Transactional
    public String proceedOrder(@Valid TacoOrder order, Errors errors, Model model) {
        if(!errors.hasErrors()) {
            tacoOrderDAO.save(order);
        }
        return "/completeOrder";
    }

    @ModelAttribute("order")
    public TacoOrder TacoOrder() {
        return new TacoOrder();
    }
}
