package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "setUserRank", direction = CytubeEvent.Direction.IN)
public class SetUserRank {
    @JsonProperty("name")
    private String name;

    @JsonProperty("rank")
    private double rank;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(Number rank) {
        this.rank = rank.doubleValue();
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("name", name)
                .append("rank", rank)
                .toString();
    }
}
