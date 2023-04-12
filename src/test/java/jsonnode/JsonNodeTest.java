package jsonnode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Map;

public class JsonNodeTest {


    @Test
    void sampleCodeTest() throws Exception {
        String jsonSTRING = """
                {
                  "id": 1,
                  "name": "Leanne Graham",
                  "username": "Bret",
                  "email": "Sincere@april.biz",
                  "married": true,
                  "address": {
                    "street": "Kulas Light",
                    "suite": "Apt. 556",
                    "city": "Gwenborough",
                    "zipcode": "92998-3874",
                    "geo": {
                      "lat": "-37.3159",
                      "lng": "81.1496"
                    }
                  },
                  "phone": "1-770-736-8031 x56442",
                  "website": "hildegard.org",
                  "company": {
                    "name": "Romaguera-Crona",
                    "catchPhrase": "Multi-layered client-server neural-net",
                    "bs": "harness real-time e-markets"
                  },
                  "languages": ["Java", "Python", "Groovy"]
                }""";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonSTRING);
        JsonNode usernameJsonNode = rootNode.get("username");
        System.out.println(usernameJsonNode.asText("Javohir"));
        System.out.println(rootNode.get("married").asBoolean());
        JsonNode address = rootNode.get("address");
        JsonNode geo = address.get("geo");
        System.out.println(geo.get("lat").asDouble());
        System.out.println(address.get("street").asText());

        double lat = rootNode.at("/address/geo/lat").asDouble();
        System.out.println("lat = " + lat);
    }

    @Test
    void traverseRootTest() throws Exception {
        String jsonSTRING = """
                {
                  "id": 1,
                  "name": "Leanne Graham",
                  "username": "Bret",
                  "email": "Sincere@april.biz",
                  "married": true,
                  "address": {
                    "street": "Kulas Light",
                    "suite": "Apt. 556",
                    "city": "Gwenborough",
                    "zipcode": "92998-3874",
                    "geo": {
                      "lat": "-37.3159",
                      "lng": "81.1496"
                    }
                  },
                  "phone": "1-770-736-8031 x56442",
                  "website": "hildegard.org",
                  "company": {
                    "name": "Romaguera-Crona",
                    "catchPhrase": "Multi-layered client-server neural-net",
                    "bs": "harness real-time e-markets"
                  },
                  "languages": ["Java", "Python", "Groovy"]
                }""";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonSTRING);
        traverse(rootNode);
    }

    void traverse(JsonNode rootNode) {
        if (rootNode.isObject()) {
            Iterator<String> fieldNames = rootNode.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                JsonNode jsonNode = rootNode.get(fieldName);
                traverse(jsonNode);
            }
        } else if (rootNode.isArray()) {
            for (JsonNode jsonNode : rootNode) {
                traverse(jsonNode);
            }
        } else {
            System.out.println(rootNode.asText());
        }
    }
}
