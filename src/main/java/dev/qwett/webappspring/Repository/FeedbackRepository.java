package dev.qwett.webappspring.Repository;

import dev.qwett.webappspring.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
