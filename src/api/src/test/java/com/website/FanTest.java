package com.website;

import com.website.model.Fan;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FanTest {
    Fan newFan = new Fan("John Doe","1234","JohnDoe@gmail.com");

    @Test
    public void validateFanUserName() {
        assertThat(newFan.getUserName().equals("John Doe"));
    }

    @Test
    public void validateFanPassword() {
        assertThat(newFan.getPassword().equals("1234"));
    }

    @Test
    public void validateFanEmail() {
        assertThat(newFan.getUserName().equals("JohnDoe@gmail.com"));
    }

}
