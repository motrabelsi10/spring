package tn.esprit.espritgather.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.espritgather.entity.Volunteer;

public interface VolunteerRepository  extends JpaRepository<Volunteer,Long> {
}
