package dev.qwett.webappspring.Repository;

import dev.qwett.webappspring.Entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository  extends JpaRepository<Consumer, Integer> {
}
