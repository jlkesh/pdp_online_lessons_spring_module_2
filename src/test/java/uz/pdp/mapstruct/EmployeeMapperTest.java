package uz.pdp.mapstruct;

import org.junit.jupiter.api.Test;
import uz.pdp.mapstruct.employee.Employee;

import java.util.Map;

import static uz.pdp.mapstruct.employee.EmployeeMapper.EMPLOYEE_MAPPER;

class EmployeeMapperTest {

    @Test
    void fromMap() {
        var params = Map.of(
                "firstName", "Javohir",
                "lastName", "Elmurodov",
                "age", "28"
        );
        Employee employee = EMPLOYEE_MAPPER.fromMap(params);
        System.out.println("employee = " + employee);
    }

    @Test
    void fromMap2() {
        Map<String, Object> params = Map.of(
                "firstName", "Javohir",
                "lastName", "Elmurodov",
                "age", 28
        );
        Employee employee = EMPLOYEE_MAPPER.fromMap2(params);
        System.out.println("employee = " + employee);
    }
}