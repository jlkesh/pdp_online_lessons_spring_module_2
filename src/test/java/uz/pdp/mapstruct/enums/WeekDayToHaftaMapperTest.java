package uz.pdp.mapstruct.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static uz.pdp.mapstruct.enums.WeekDayToHaftaMapper.WEEK_DAY_TO_HAFTA_MAPPER;

class WeekDayToHaftaMapperTest {

    @Test
    void from() {
        System.out.println("WEEK_DAY_TO_HAFTA_MAPPER.from(Hafta.JUMA) = " + WEEK_DAY_TO_HAFTA_MAPPER.from(Hafta.JUMA));
        System.out.println("WEEK_DAY_TO_HAFTA_MAPPER.from(Hafta.JUMA) = " + WEEK_DAY_TO_HAFTA_MAPPER.from(Hafta.DUSHANBA));

    }

    @Test
    void to() {
        System.out.println(WEEK_DAY_TO_HAFTA_MAPPER.to(WeekDays.FRIDAY));
    }
}