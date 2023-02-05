package net.ddns.mrsaloed.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {

    private Config config;

    @Autowired
    HelloController(Config config) {
        this.config = config;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello, from application " + config.getName();
    }

}
