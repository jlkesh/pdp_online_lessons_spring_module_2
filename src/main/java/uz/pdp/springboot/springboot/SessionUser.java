package uz.pdp.springboot.springboot;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SessionUser {

    public Long getId() {
        return new Random().nextLong(10, 20);
    }

}
