package de.vkononenko.TacoCloud.interfaces.repos;

import de.vkononenko.TacoCloud.models.Taco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepo extends CrudRepository<Taco, Long> {
    @Override
    <S extends Taco> S save(S entity);
}
