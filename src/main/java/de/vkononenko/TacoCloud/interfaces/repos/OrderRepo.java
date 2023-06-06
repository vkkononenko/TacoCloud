package de.vkononenko.TacoCloud.interfaces.repos;

import de.vkononenko.TacoCloud.models.TacoOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends CrudRepository<TacoOrder, Long> {

    @Override
    <S extends TacoOrder> S save(S entity);

    @Override
    <S extends TacoOrder> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Iterable<TacoOrder> findAll();
}
