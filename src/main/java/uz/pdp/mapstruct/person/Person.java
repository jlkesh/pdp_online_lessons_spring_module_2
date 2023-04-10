package uz.pdp.mapstruct.person;

import lombok.*;

@ToString
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class Person {
    private String fullName;
    private String age;

    private String personAddressCity;
    private String personAddressApartment;

    private String personPassportSerial;
    private String personPassportNumber;
}
