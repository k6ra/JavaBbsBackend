package com.javabbsbackend.domain.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
    }

    @Test
    @Transactional
    @Rollback
    public void testFind() {
        jdbcTemplate.update("DELETE FROM USER");
        jdbcTemplate.update("INSERT INTO USER VALUES(1, 'testuser', 'password')");

        List<UserModel> findUser = userService.find(1);

        assertEquals(1, findUser.size());
        assertEquals(1, findUser.get(0).getId());
        assertEquals("testuser", findUser.get(0).getLoginName());
        assertEquals("password", findUser.get(0).getPassword());
    }

    @Test
    @Transactional
    @Rollback
    public void testEntry() {
        jdbcTemplate.update("DELETE FROM USER");

        UserModel entryUser = new UserModel();
        entryUser.setId(1);
        entryUser.setLoginName("testuser");
        entryUser.setPassword("password");
        userService.entry(entryUser);

        List<UserModel> findUser = userService.find(entryUser.getId());

        assertEquals(1, findUser.size());
        assertEquals(entryUser.getId(), findUser.get(0).getId());
        assertEquals(entryUser.getLoginName(), findUser.get(0).getLoginName());
        assertEquals(entryUser.getPassword(), findUser.get(0).getPassword());
    }

    @Test
    @Transactional
    @Rollback
    public void testUpdate() {
        jdbcTemplate.update("DELETE FROM USER");
        jdbcTemplate.update("INSERT INTO USER VALUES(1, 'testuser', 'password')");

        UserModel updateUser = new UserModel();
        updateUser.setId(1);
        updateUser.setLoginName("testuser_update");
        updateUser.setPassword("password_update");
        userService.update(updateUser);

        List<UserModel> findUser = userService.find(updateUser.getId());

        assertEquals(1, findUser.size());
        assertEquals(updateUser.getId(), findUser.get(0).getId());
        assertEquals(updateUser.getLoginName(), findUser.get(0).getLoginName());
        assertEquals(updateUser.getPassword(), findUser.get(0).getPassword());
    }

    @Test
    @Transactional
    @Rollback
    public void testDelete() {
        jdbcTemplate.update("DELETE FROM USER");
        jdbcTemplate.update("INSERT INTO USER VALUES(1, 'testuser', 'password')");

        UserModel deleteUser = new UserModel();
        deleteUser.setId(1);
        deleteUser.setLoginName("testuser");
        deleteUser.setPassword("password");
        userService.delete(deleteUser);

        List<UserModel> findUser = userService.find(deleteUser.getId());

        assertEquals(0, findUser.size());
    }
}
