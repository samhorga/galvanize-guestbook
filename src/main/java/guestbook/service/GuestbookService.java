package guestbook.service;

import guestbook.model.GuestEntry;
import guestbook.repository.GuestbookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestbookService {

    private GuestbookRepository repository;

    public GuestbookService(GuestbookRepository repository) {
        this.repository = repository;
    }

    public List<GuestEntry> getAllGuests() {
        return repository.findAll();
    }

    public GuestEntry addGuestbookEntry(GuestEntry entryToSave) {
        return repository.save(entryToSave);
    }
}
