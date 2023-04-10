package uz.pdp.springboot.springboot;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Getter
@Setter
@ConfigurationProperties(prefix = "example")
public class PersonProperties {
    private List<String> languages;
    private List<String> languages2;
    private Person person; // example.person
    private List<Person> people; // example.people[0]

}
