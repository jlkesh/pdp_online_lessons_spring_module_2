package annotations.writing;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class PostWithoutGetterAndSetters {
    private Map<String, Object> params = new HashMap<>();

    public PostWithoutGetterAndSetters(int id, int userId, String title, String body, Date date) {
        this.params.put("id", id);
        this.params.put("userId", userId);
        this.params.put("title", title);
        this.params.put("body", body);
        this.params.put("date", date);
    }

    @JsonAnyGetter
    public Map<String, Object> getParams() {
        return params;
    }

}
