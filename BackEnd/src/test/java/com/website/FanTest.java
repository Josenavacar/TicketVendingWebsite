package com.website;

import com.website.model.Fan;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FanTest {
    Fan testFan = new Fan();

    @Test
    public void validateFanUserName() {
        testFan.setUsername("TheTester");
        assertThat(testFan.getUsername().equals("TheTester"));
    }

    @Test
    public void validateFanEmail() {
        testFan.setEmail("thetester@gmail.com");
        assertThat(testFan.getEmail().equals("thetester@gmail.com"));
    }

    @Test
    public void validateFanPassword() {
        testFan.setPassword("1234");
        assertThat(testFan.getPassword().equals("1234"));
    }
}
