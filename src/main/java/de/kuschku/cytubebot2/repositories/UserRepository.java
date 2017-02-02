package de.kuschku.cytubebot2.repositories;

import de.kuschku.cytubebot2.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByName(String name);

    List<User> findByRank(int rank);

    List<User> findByAward(int award);
}
