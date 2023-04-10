package uz.pdp.mapstruct.enums;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeekDayToHaftaMapper {
    WeekDayToHaftaMapper WEEK_DAY_TO_HAFTA_MAPPER = Mappers.getMapper(WeekDayToHaftaMapper.class);

    @ValueMapping(target = "MONDAY", source = "DUSHANBA")
    @ValueMapping(target = "TUESDAY", source = "SESHANBA")
    @ValueMapping(target = "FRIDAY", source = "JUMA")
    WeekDays from(Hafta hafta);

    /*@ValueMapping(source = "MONDAY", target = "DUSHANBA")
    @ValueMapping(source = "TUESDAY", target = "SESHANBA")
    @ValueMapping(source = "FRIDAY", target = "JUMA")*/
    @InheritInverseConfiguration
    Hafta to(WeekDays weekDays);
}
