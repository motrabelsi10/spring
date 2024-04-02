package tn.esprit.espritgather.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.espritgather.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
