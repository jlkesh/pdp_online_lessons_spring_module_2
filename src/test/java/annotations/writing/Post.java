package annotations.writing;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSerialize(using = PostJsonSerializer.class)
@JsonPropertyOrder(value = {"post_title", "post_body", "post_creator_id", "post_published_date", "post_id"})
public class Post {
    private int id;
    private int userId;
    private String title;
    private String body;
    private Date date;
    private String field = """
                    {"field1" : "Some Data"}
                """;

    // id
    @JsonGetter("post_id")
    public int getId() {
        return id;
    }

    // id
    public void setId(int id) {
        this.id = id;
    }

    @JsonGetter("post_creator_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonGetter("post_title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonGetter("post_body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    // @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonGetter("post_published_date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @JsonRawValue
    public String getField() {
        return field;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", date=" + date +
                '}';
    }

   /* @JsonValue
    @JsonRawValue
    public String data(){
        return """
                {"title" : "%s"}""".formatted(title);
    }*/
}
