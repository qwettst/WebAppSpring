package dev.qwett.service.impl;

import dev.qwett.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
