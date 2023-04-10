package uz.pdp.mapstruct.person;

import lombok.*;

@ToString
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class PersonDTO {
    private String name;
    private Integer age;
}
