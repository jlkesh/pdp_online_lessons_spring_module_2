package uz.pdp.mapstruct.employee;

import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);


    @MapMapping(keyTargetType = String.class, valueTargetType = String.class)
    Employee fromMap(Map<String, String> params);

    @MapMapping(keyTargetType = String.class, valueTargetType = Object.class)
    Employee fromMap2(Map<String, Object> params);

    default String fromObjectToString(Object o) {
        return String.valueOf(o);
    }
}
