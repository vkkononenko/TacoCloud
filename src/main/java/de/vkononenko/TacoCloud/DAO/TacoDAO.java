package de.vkononenko.TacoCloud.DAO;

import de.vkononenko.TacoCloud.interfaces.repos.TacoRepo;
import de.vkononenko.TacoCloud.models.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class TacoDAO {

    private TacoRepo tacoRepo;

    @Autowired
    public TacoDAO(TacoRepo tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

    public List<Taco> findAll() {
        return tacoRepo == null ? Collections.emptyList() : (List<Taco>) tacoRepo.findAll();
    }

    public Optional<Taco> findById(Long id) {
        return tacoRepo == null ? Optional.empty() : tacoRepo.findById(id);
    }

    public void save(Taco taco) {
        tacoRepo.save(taco);
    }
}
