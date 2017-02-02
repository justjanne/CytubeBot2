package de.kuschku.cytubebot2.messages;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CytubeEvent {
    String name();
    Direction direction();

    enum Direction {
        IN, OUT
    }
}
