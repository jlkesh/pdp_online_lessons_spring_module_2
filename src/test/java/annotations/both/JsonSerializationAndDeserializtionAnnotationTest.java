package annotations.both;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class JsonSerializationAndDeserializtionAnnotationTest {


    @Test
    void jsonIgnoreTest() throws JsonProcessingException {
        Address address = new Address("Tashkent", "Amir Temur");
        User user = new User(
                "998908115224",
                "javohir",
                "123",
                "ADMIN",
                address);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(user));
    }


}
