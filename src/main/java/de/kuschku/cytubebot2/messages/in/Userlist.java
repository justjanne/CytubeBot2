package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import de.kuschku.cytubebot2.messages.elements.UserElement;
import org.springframework.core.style.ToStringCreator;

import java.util.List;

@CytubeEvent(name = "userlist", direction = CytubeEvent.Direction.IN)
public class Userlist {
    private List<UserElement> elements;

    @JsonCreator
    public Userlist(List<UserElement> elements) {
        this.elements = elements;
    }

    @JsonValue
    public List<UserElement> getElements() {
        return elements;
    }

    public void setElements(List<UserElement> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("elements", elements)
                .toString();
    }
}
