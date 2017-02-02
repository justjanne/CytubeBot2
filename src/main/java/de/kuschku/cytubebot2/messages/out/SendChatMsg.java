package de.kuschku.cytubebot2.messages.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "chatMsg", direction = CytubeEvent.Direction.OUT)
public class SendChatMsg {
    @JsonProperty("msg")
    public final String msg;

    public SendChatMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("msg", msg)
                .toString();
    }
}
