package de.vkononenko.TacoCloud.utils;

import de.vkononenko.TacoCloud.DAO.SystemUserDAO;
import de.vkononenko.TacoCloud.models.SystemUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@AutoConfigureMockMvc
@SpringBootTest
@Transactional
public class UserUtilTests {

    @Autowired
    private SystemUserDAO systemUserDAO;

    @Test
    @Rollback(false)
    public void generateAndSaveUserTest() {
        SystemUser systemUser = new SystemUser("konich", "password");
        systemUserDAO.save(systemUser);
    }
}
