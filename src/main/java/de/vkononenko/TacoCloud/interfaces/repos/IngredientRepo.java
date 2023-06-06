package de.vkononenko.TacoCloud.interfaces.repos;

import de.vkononenko.TacoCloud.models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepo extends CrudRepository<Ingredient, Long> {
    @Override
    <S extends Ingredient> S save(S entity);

    @Override
    <S extends Ingredient> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Iterable<Ingredient> findAll();
}
