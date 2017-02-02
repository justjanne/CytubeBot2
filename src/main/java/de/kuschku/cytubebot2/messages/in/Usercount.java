package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "usercount", direction = CytubeEvent.Direction.IN)
public class Usercount {
    private int usercount;

    @JsonCreator
    public Usercount(int usercount) {
        this.usercount = usercount;
    }

    @JsonValue
    public int getUsercount() {
        return usercount;
    }

    public void setUsercount(int usercount) {
        this.usercount = usercount;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("usercount", usercount)
                .toString();
    }
}
