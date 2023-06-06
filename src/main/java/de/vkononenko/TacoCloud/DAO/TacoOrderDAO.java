package de.vkononenko.TacoCloud.DAO;

import de.vkononenko.TacoCloud.interfaces.repos.OrderRepo;
import de.vkononenko.TacoCloud.models.TacoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TacoOrderDAO {

    private OrderRepo orderRepo;

    @Autowired
    public TacoOrderDAO(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public void save(TacoOrder order) {
        orderRepo.save(order);
    }
}
