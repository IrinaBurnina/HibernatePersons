package ir.bu.hibernatepersons.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class ControllerWebSecurity {

    @Secured("ROLE_READ")
    @GetMapping("/read")
    public String read() {
        return "READ";
    }

    @RolesAllowed("WRITE")
    @GetMapping("/write")
    public String write() {
        return "write!";
    }

    @Secured("ROLE_DELETE")
    @GetMapping("/delete")
    public String delete() {
        return "Delete___";
    }

    @GetMapping("/read-only")
    @PreAuthorize("'Ivan' == authentication.principal.username")
    public String onlyIvanCanRead() {
        return "only Ivan can read";
    }

    @GetMapping("/hello")
    @PreAuthorize("hasRole('WRITE')or hasRole('DELETE')")
    public String hello() {
        return "Hello from secure app, user with role WRITE or DELETE!";
    }

    @GetMapping("/hello-VIP")
    @PostAuthorize("returnObject.contains(authentication.principal.username)")
    public String helloVIP() {
        String name = "Maxim";
        return "Hello, " + name;
    }

    @GetMapping("/usernameInQuery")
    @PreAuthorize("#name ==authentication.name")
    public String nameInQuery(@RequestParam(name = "name") String name) {
        return name;
    }
}
