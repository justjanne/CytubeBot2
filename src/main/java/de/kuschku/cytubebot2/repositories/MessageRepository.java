package de.kuschku.cytubebot2.repositories;

import de.kuschku.cytubebot2.models.Message;
import de.kuschku.cytubebot2.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findBySender(User sender);

    Page<Message> findBySender(User sender, Pageable pageable);

    long countBySender(User sender);

    @Query("select sum(length(m.content)) from Message m where m.sender = :sender")
    long totalBySender(@Param("sender") User sender);

    Optional<Message> findFirstBySender(User sender, Sort sort);
}
