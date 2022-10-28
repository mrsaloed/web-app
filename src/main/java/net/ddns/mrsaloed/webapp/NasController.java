package net.ddns.mrsaloed.webapp;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Controller
@RequestMapping("/nas")
public class NasController {
    private final static String NAS_IP = "http://rsreu.ru";
    private final RestTemplate restTemplate;
    public NasController (RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    @RequestMapping(method = RequestMethod.GET)
    public void doGet(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String temp = restTemplate.getForObject(NAS_IP, String.class);
        HttpHeaders tempHeader = restTemplate.headForHeaders(NAS_IP);
//        for (Map.Entry<String, String> entry: tempHeader.toSingleValueMap().entrySet()) {
//            response.addHeader(entry.getKey(), entry.getValue());
//        }
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(new String( temp.getBytes(), StandardCharsets.UTF_8));
        response.getWriter().flush();
    }


}
