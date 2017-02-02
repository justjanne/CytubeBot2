package de.kuschku.cytubebot2.services;

import de.kuschku.cytubebot2.models.LegacyUser;
import de.kuschku.cytubebot2.models.Message;
import de.kuschku.cytubebot2.models.User;
import de.kuschku.cytubebot2.repositories.MessageRepository;
import de.kuschku.cytubebot2.utils.OptionalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

import static org.springframework.data.domain.Sort.Direction.ASC;

@Component
@Transactional
public class UserService {
    @Autowired
    MessageRepository messageRepository;

    public long messageTotal(User user) {
        return messageRepository.totalBySender(user) + user.getLegacyUser().map(LegacyUser::getMessageTotal).orElse(0L);
    }

    public long messageCount(User user) {
        return messageRepository.countBySender(user) + user.getLegacyUser().map(LegacyUser::getMessageCount).orElse(0L);
    }

    public Optional<Instant> firstActivity(User user) {
        return OptionalUtils.findFirstPresent(
                user.getLegacyUser().flatMap(LegacyUser::getFirstActivity),
                messageRepository.findFirstBySender(user, new Sort(new Sort.Order(ASC, "timestamp")))
                        .map(Message::getTimestamp)
        );
    }
}
