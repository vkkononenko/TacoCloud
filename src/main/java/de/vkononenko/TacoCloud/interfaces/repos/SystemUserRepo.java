package de.vkononenko.TacoCloud.interfaces.repos;

import de.vkononenko.TacoCloud.models.SystemUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemUserRepo extends CrudRepository<SystemUser, Long> {

    Optional<SystemUser> findByLogin(String login);

    @Override
    Iterable<SystemUser> findAll();

    @Override
    <S extends SystemUser> S save(S entity);
}
