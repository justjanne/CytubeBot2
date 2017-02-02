package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "drinkCount", direction = CytubeEvent.Direction.IN)
public class DrinkCount {
    private int drinkCount;

    @JsonCreator
    public DrinkCount(int drinkCount) {
        this.drinkCount = drinkCount;
    }

    @JsonValue
    public int getDrinkCount() {
        return drinkCount;
    }

    public void setDrinkCount(int drinkCount) {
        this.drinkCount = drinkCount;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("drinkCount", drinkCount)
                .toString();
    }
}
