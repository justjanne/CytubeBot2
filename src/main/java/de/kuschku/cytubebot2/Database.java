package de.kuschku.cytubebot2;

import de.kuschku.cytubebot2.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Database {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LegacyUserRepository legacyUserRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private VideoQueueEventRepository videoQueueEventRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public LegacyUserRepository getLegacyUserRepository() {
        return legacyUserRepository;
    }

    public MessageRepository getMessageRepository() {
        return messageRepository;
    }

    public VideoRepository getVideoRepository() {
        return videoRepository;
    }

    public VideoQueueEventRepository getVideoQueueEventRepository() {
        return videoQueueEventRepository;
    }
}
