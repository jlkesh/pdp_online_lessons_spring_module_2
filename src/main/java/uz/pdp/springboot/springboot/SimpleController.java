package uz.pdp.springboot.springboot;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class SimpleController {
    private final PersonProperties personProperties;
    @Value("${example.string:'Default Message(Learn Java In PDP)' }")
    private String exampleString;


    @Value("#{${example.numbers}}")
    private Map<String, String> exampleNumbers;

    public SimpleController(PersonProperties personProperties) {
        this.personProperties = personProperties;
    }

    @GetMapping("/exampleString")
    public String exampleString() {
        return exampleString;
    }


    @GetMapping("/exampleLanguages")
    public List<String> exampleLanguages() {
        return personProperties.getLanguages();
    }

    @GetMapping("/exampleLanguages2")
    public List<String> exampleLanguages2() {
        return personProperties.getLanguages2();
    }


    @GetMapping("/exampleNumbers")
    public Map<String, String> exampleNumbers() {
        return exampleNumbers;
    }

    @GetMapping("/person")
    public Person person() {
        return personProperties.getPerson();
    }

    @GetMapping("/people")
    public List<Person> people() {
        return personProperties.getPeople();
    }


}
