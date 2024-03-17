package tn.esprit.espritgather.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.espritgather.entity.Event;

public interface EventRepository extends JpaRepository<Event,Long> {
}
