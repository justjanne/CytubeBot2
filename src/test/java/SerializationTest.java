import com.fasterxml.jackson.databind.ObjectMapper;
import de.kuschku.cytubebot2.messages.in.ChatMsg;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class SerializationTest {
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testChatMsg() throws IOException {
        objectMapper.readValue("{\"msg\":\"/warmhug \",\"meta\":{},\"time\":1486045313748,\"username\":\"Sylra\"}",
                ChatMsg.class);
    }
}
