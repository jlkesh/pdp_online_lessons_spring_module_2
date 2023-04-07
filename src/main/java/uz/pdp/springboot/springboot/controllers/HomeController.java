package uz.pdp.springboot.springboot.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String hi() {
        return "Hello";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/manager")
    public String manager() {
        return "/manager";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/user")
    public String user() {
        return "/user";
    }
}
