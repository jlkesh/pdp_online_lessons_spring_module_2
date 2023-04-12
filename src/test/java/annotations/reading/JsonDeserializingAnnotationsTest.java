package annotations.reading;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

public class JsonDeserializingAnnotationsTest {

    @Test
    void jsonSetterAndJsonAnySetterTest() throws Exception {
        String jsonDATA = """
                {
                    "card_id": 1,
                    "card_pan": "8600909234429081",
                    "card_expiry": "03/26",
                    "card_holder": "Elmurodov Javohir",
                    "card_token": "%s",
                    "time" : "%s"
                }""".formatted(UUID.randomUUID(), LocalDateTime.now());

        ObjectMapper mapper = new ObjectMapper();
        // mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Card card = mapper.readValue(jsonDATA, Card.class);
        System.out.println(card);
    }

    @Test
    void jsonCreatorTest() throws Exception {
        String jsonDATA = """
                {
                    "card_id": 1,
                    "card_pan": "8600909234429081",
                    "card_expiry": "03/26"
                }""";

        ObjectMapper mapper = new ObjectMapper();
        ImmutableCard card = mapper.readValue(jsonDATA, ImmutableCard.class);
        System.out.println(card);
    }

    @Test
    void jsonDeserializeTest() throws Exception {
        String jsonDATA = """
                {
                    "card_id": 1,
                    "card_pan": "8600909234429081",
                    "card_expiry": "03/03/2026",
                    "enabled": 0
                }""";

        ObjectMapper mapper = new ObjectMapper();
        Card card = mapper.readValue(jsonDATA, Card.class);
        System.out.println(card);
    }

}
