package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import de.kuschku.cytubebot2.messages.elements.MediaElement;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "changeMedia", direction = CytubeEvent.Direction.IN)
public class ChangeMedia {
    private MediaElement element;

    @JsonCreator
    public ChangeMedia(MediaElement element) {
        this.element = element;
    }

    @JsonValue
    public MediaElement getElement() {
        return element;
    }

    public void setElement(MediaElement element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("element", element)
                .toString();
    }
}
