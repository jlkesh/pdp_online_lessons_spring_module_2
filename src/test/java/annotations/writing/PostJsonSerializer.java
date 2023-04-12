package annotations.writing;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PostJsonSerializer extends JsonSerializer<Post> {
    @Override
    public void serialize(Post post, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();

        gen.writeStringField("title", post.getTitle());
        gen.writeStringField("body", post.getBody());
        gen.writeObjectField("date", post.getDate());

        gen.flush();
    }
}
