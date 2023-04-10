package uz.pdp.mapstruct.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static uz.pdp.mapstruct.person.PersonMapper.PERSON_MAPPER;

class PersonMapperTest {

    @Test
    void toEntity() {
        PersonDTO personDTO = new PersonDTO("Elmurodov Javohir", 28);
        AddressDTO addressDTO = new AddressDTO("Tashkent", "Muhbir 1, 47");
        PassportDTO passportDTO = new PassportDTO("AB", "1231212");
        Person person = PERSON_MAPPER.toEntity(personDTO, addressDTO, passportDTO);
        System.out.println(person);
    }
}