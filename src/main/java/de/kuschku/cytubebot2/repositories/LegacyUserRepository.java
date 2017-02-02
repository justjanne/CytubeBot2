package de.kuschku.cytubebot2.repositories;

import de.kuschku.cytubebot2.models.LegacyUser;
import org.springframework.data.repository.CrudRepository;

public interface LegacyUserRepository extends CrudRepository<LegacyUser, Long> {
}
