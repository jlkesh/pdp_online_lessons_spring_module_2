package annotations.reading;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ImmutableCard {
    private final Integer id;
    private final String pan;
    private final String expiry;

    @JsonCreator
    public ImmutableCard(
            @JsonProperty("card_id") Integer id,
            @JsonProperty("card_pan") String pan,
            @JsonProperty("card_expiry") String expiry) {
        this.id = id;
        this.pan = pan;
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return "ImmutableCard{" +
                "id=" + id +
                ", pan='" + pan + '\'' +
                ", expiry='" + expiry + '\'' +
                '}';
    }
}
