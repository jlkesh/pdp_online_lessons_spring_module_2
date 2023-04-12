package annotations.reading;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateDeserilizer extends JsonDeserializer<Date> {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        String valueAsString = p.getValueAsString();
        try {
            return dateFormat.parse(valueAsString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
