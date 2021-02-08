package dev.qwett.webappspring.service.impl;

import dev.qwett.webappspring.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
