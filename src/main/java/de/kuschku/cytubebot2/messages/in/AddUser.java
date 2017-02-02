package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import de.kuschku.cytubebot2.messages.elements.UserElement;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "addUser", direction = CytubeEvent.Direction.IN)
public class AddUser {
    private UserElement element;

    @JsonCreator
    public AddUser(UserElement element) {
        this.element = element;
    }

    @JsonValue
    public UserElement getElement() {
        return element;
    }

    public void setElement(UserElement element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("element", element)
                .toString();
    }
}
