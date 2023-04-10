package uz.pdp.mapstruct.person;

import lombok.*;

@ToString
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class AddressDTO {
    private String city;
    private String apartment;
}
