package guestbook.controller;

import guestbook.model.GuestEntry;
import guestbook.repository.GuestbookRepository;
import guestbook.service.GuestbookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestbookController {

    private GuestbookService service;

    public GuestbookController(GuestbookService service) {
        this.service = service;
    }

    @GetMapping
    public List<GuestEntry> getAllGuests() {
        return service.getAllGuests();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GuestEntry addGuestbookEntry(@RequestBody GuestEntry entry) {
        return service.addGuestbookEntry(entry);
    }

}
