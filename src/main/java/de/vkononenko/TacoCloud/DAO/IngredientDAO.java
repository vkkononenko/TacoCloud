package de.vkononenko.TacoCloud.DAO;

import de.vkononenko.TacoCloud.interfaces.repos.IngredientRepo;
import de.vkononenko.TacoCloud.models.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class IngredientDAO {

    private IngredientRepo ingredientRepo;

    @Autowired
    public IngredientDAO(IngredientRepo ingredientRepo) {
     this.ingredientRepo = ingredientRepo;
    }

    public List<Ingredient> findAll() {
        return ingredientRepo == null ? Collections.emptyList() : (List<Ingredient>) ingredientRepo.findAll();
    }

}
