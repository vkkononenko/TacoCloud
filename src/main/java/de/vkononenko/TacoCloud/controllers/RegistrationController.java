package de.vkononenko.TacoCloud.controllers;

import de.vkononenko.TacoCloud.DAO.SystemUserDAO;
import de.vkononenko.TacoCloud.models.SystemUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegistrationController {

    private SystemUserDAO systemUserDAO;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(SystemUserDAO systemUserDAO, PasswordEncoder passwordEncoder) {
        this.systemUserDAO = systemUserDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String OnLoad() {
        return "/register";
    }

    @PostMapping
    @Transactional
    public String proceedUser(@Valid SystemUser systemUser, Errors errors) {
        if(!errors.hasErrors()) {
            systemUser.setPassword(passwordEncoder.encode(systemUser.getPassword()));
            systemUserDAO.save(systemUser);
        }
        return "/register";
    }

    @ModelAttribute("user")
    public SystemUser SystemUser() {
        return new SystemUser();
    }
}