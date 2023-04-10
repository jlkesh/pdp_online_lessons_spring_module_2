package uz.pdp.mapstruct.person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper PERSON_MAPPER = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "fullName", source = "personDTO.name")
    @Mapping(target = "personAddressCity", source = "addressDTO.city")
    @Mapping(target = "personAddressApartment", source = "addressDTO.apartment")
    @Mapping(target = "personPassportSerial", source = "passportDTO.serial")
    @Mapping(target = "personPassportNumber", source = "passportDTO.number")
    Person toEntity(PersonDTO personDTO, AddressDTO addressDTO, PassportDTO passportDTO);
}
