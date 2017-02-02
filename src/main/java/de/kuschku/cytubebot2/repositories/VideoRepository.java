package de.kuschku.cytubebot2.repositories;

import de.kuschku.cytubebot2.models.Video;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video, Long> {
}
