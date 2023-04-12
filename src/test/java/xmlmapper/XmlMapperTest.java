package xmlmapper;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import objectmapper.Post;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

public class XmlMapperTest {

    @Test
    void sampleCodeTest() throws Exception {

        Post post = new Post();
        post.setUserId(1);
        post.setId(1);
        post.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        post.setBody("quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto");
        post.setDate(new Date());
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new FileOutputStream("data/xml_output.xml"), post);
    }

    @Test
    void fromXmlToObject() throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        Post post = xmlMapper.readValue(new FileInputStream("data/xml_output.xml"), Post.class);
        System.out.println(post);
    }


    @Test
    void listToXML() throws Exception {

        Post post = new Post();
        post.setUserId(1);
        post.setId(1);
        post.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        post.setBody("quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto");
        post.setDate(new Date());
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new FileOutputStream("data/xml_output.xml"), List.of(post, post, post));
    }

}
