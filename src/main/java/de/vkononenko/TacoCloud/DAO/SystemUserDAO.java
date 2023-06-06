package de.vkononenko.TacoCloud.DAO;

import de.vkononenko.TacoCloud.interfaces.repos.SystemUserRepo;
import de.vkononenko.TacoCloud.models.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class SystemUserDAO {

    private SystemUserRepo systemUserRepo;

    @Autowired
    public SystemUserDAO(SystemUserRepo systemUserRepo) {
        this.systemUserRepo = systemUserRepo;
    }

    public SystemUser findByLogin(String login) {
        return systemUserRepo.findByLogin(login).orElse(null);
    }

    public List<SystemUser> findAll() {
        return systemUserRepo == null ? Collections.emptyList() : (List<SystemUser>) systemUserRepo.findAll();
    }

    public void save(SystemUser systemUser) {
        systemUserRepo.save(systemUser);
    }
}
