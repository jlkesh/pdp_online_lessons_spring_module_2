package jsongenerator;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.junit.jupiter.api.Test;

import java.io.File;

public class JsonGeneratorTest {


    @Test
    void sampleCodeTest() throws Exception {

        JsonFactory jsonFactory = new JsonFactory();
        JsonGenerator generator = jsonFactory.createGenerator(new File("data/output.json"), JsonEncoding.UTF8);

        generator.writeStartObject();

        generator.writeStringField("first_name", "John");
        generator.writeStringField("last_name", "Doe");
        generator.writeNumberField("age", 45);

        generator.writeArrayFieldStart("posts");

        generator.writeStartObject();

        generator.writeNumberField("id", 1);
        generator.writeNumberField("userId", 1);
        generator.writeStringField("title", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        generator.writeStringField("body", "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");

        generator.writeEndObject();


        generator.writeStartObject();

        generator.writeNumberField("id", 2);
        generator.writeNumberField("userId", 1);
        generator.writeStringField("title", "qui est esse");
        generator.writeStringField("body", "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla");

        generator.writeEndObject();

        generator.writeEndArray();

        generator.writeArrayFieldStart("programmingLanguages");
        generator.writeString("Java");
        generator.writeString("Scala");
        generator.writeString("Kotlin");
        generator.writeString("Groovy");
        generator.writeString("Go");
        generator.writeEndArray();

        generator.writeEndObject();


        generator.flush();

    }
}
