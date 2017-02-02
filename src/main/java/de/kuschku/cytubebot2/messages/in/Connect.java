package de.kuschku.cytubebot2.messages.in;

import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "connect", direction = CytubeEvent.Direction.IN)
public class Connect {
    @Override
    public String toString() {
        return new ToStringCreator(this)
                .toString();
    }
}
