package de.kuschku.cytubebot2.repositories;

import de.kuschku.cytubebot2.models.VideoQueueEvent;
import org.springframework.data.repository.CrudRepository;

public interface VideoQueueEventRepository extends CrudRepository<VideoQueueEvent, Long> {
}
