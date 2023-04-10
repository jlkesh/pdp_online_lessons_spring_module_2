package uz.pdp.springboot.springboot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private String fullName;
    private Integer age;
}
