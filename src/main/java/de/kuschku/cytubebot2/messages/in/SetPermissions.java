package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

import java.util.Map;

@CytubeEvent(name = "setPermissions", direction = CytubeEvent.Direction.IN)
public class SetPermissions {
    private Map<String, Number> permissions;

    @JsonCreator
    public SetPermissions(Map<String, Number> permissions) {
        this.permissions = permissions;
    }

    @JsonValue
    public Map<String, Number> getPermissions() {
        return permissions;
    }

    public void setPermissions(Map<String, Number> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("permissions", permissions)
                .toString();
    }
}
