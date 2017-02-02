package de.kuschku.cytubebot2.messages.elements;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.core.style.ToStringCreator;

public class UserElement {
    @JsonProperty("name")
    private String name;

    @JsonProperty("rank")
    private double rank;

    @JsonProperty("meta")
    private Meta meta;

    @JsonProperty("profile")
    private Profile profile;

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

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("name", name)
                .append("rank", rank)
                .append("meta", meta)
                .append("profile", profile)
                .toString();
    }

    public static class Meta {
        @JsonProperty("afk")
        private boolean afk;

        @JsonProperty("muted")
        private boolean muted;

        @JsonProperty("smuted")
        private boolean smuted;

        public boolean isAfk() {
            return afk;
        }

        public void setAfk(boolean afk) {
            this.afk = afk;
        }

        public boolean isMuted() {
            return muted;
        }

        public void setMuted(boolean muted) {
            this.muted = muted;
        }

        public boolean isSmuted() {
            return smuted;
        }

        public void setSmuted(boolean smuted) {
            this.smuted = smuted;
        }

        @Override
        public String toString() {
            return new ToStringCreator(this)
                    .append("afk", afk)
                    .append("muted", muted)
                    .append("smuted", smuted)
                    .toString();
        }
    }

    public static class Profile {
        @JsonProperty("image")
        private String image;

        @JsonProperty("text")
        private String text;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return new ToStringCreator(this)
                    .append("image", image)
                    .append("text", text)
                    .toString();
        }
    }
}
