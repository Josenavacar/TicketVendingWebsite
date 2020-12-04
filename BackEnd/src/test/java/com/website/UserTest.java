package com.website;

import com.website.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserTest {
    User testUser = new User();

    @Test
    public void validateFanUserName() {
        testUser.setUsername("TheTester");
        assertThat(testUser.getUsername().equals("TheTester"));
    }

    @Test
    public void validateFanEmail() {
        testUser.setEmail("thetester@gmail.com");
        assertThat(testUser.getEmail().equals("thetester@gmail.com"));
    }

    @Test
    public void validateFanPassword() {
        testUser.setPassword("1234");
        assertThat(testUser.getPassword().equals("1234"));
    }
}
