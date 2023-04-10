package uz.pdp.mapstruct.employee;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Employee {
    private String firstName;
    private String lastName;
    private String age;
}
