package annotations.reading;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Card {
    private Integer id;
    private String pan;
    private Date expiry;
    private Boolean enabled;
    private Map<String, String> params = new HashMap<>();

    public Integer getId() {
        return id;
    }

    @JsonAnySetter
    public void setParams(String key, String value) {
        params.put(key, value);
    }

    @JsonSetter("card_id")
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPan() {
        return pan;
    }

    @JsonSetter("card_pan")
    public void setPan(String pan) {
        this.pan = pan;
    }

    public Date getExpiry() {
        return expiry;
    }

    @JsonSetter("card_expiry")
    @JsonDeserialize(using = CustomDateDeserilizer.class)
    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", pan='" + pan + '\'' +
                ", expiry='" + expiry + '\'' +
                ", enabled=" + enabled +
                ", params=" + params +
                '}';
    }
}
