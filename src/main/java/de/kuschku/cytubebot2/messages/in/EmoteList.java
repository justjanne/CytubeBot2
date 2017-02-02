package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import de.kuschku.cytubebot2.messages.elements.EmoteElement;
import org.springframework.core.style.ToStringCreator;

import java.util.List;

@CytubeEvent(name = "emoteList", direction = CytubeEvent.Direction.IN)
public class EmoteList {
    private List<EmoteElement> elements;

    @JsonCreator
    public EmoteList(List<EmoteElement> elements) {
        this.elements = elements;
    }

    @JsonValue
    public List<EmoteElement> getElements() {
        return elements;
    }

    public void setElements(List<EmoteElement> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("elements", elements)
                .toString();
    }
}
