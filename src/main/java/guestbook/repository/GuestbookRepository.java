package guestbook.repository;

import guestbook.model.GuestEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestbookRepository extends JpaRepository<GuestEntry, Long> {
}
