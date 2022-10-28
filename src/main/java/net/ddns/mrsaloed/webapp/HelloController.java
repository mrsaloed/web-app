package net.ddns.mrsaloed.webapp;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class HelloController {
    private static final String REDIRECT = "https://192.168.3.150";

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String name) {
        return "Hello, " + name;
    }
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public void method(HttpServletResponse response) {
        try {
            response.sendRedirect(REDIRECT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value = "/forward", method = RequestMethod.GET)
    public RedirectView myMethod (RedirectAttributes attributes) {
        attributes.addFlashAttribute("flashAttribute", "forward");
        attributes.addAttribute("attribute", "forward");
        return new RedirectView(REDIRECT);
    }
}
