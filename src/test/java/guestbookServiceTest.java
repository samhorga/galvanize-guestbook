import guestbook.model.GuestEntry;
import guestbook.repository.GuestbookRepository;
import guestbook.service.GuestbookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class guestbookServiceTest {

    @Mock
    GuestbookRepository repository;

    @InjectMocks
    GuestbookService service;

    @Test
    public void getAllGuests_returnsListOfGuestEntries() {
        GuestEntry entry1 = new GuestEntry("guest1", "some comment");
        GuestEntry entry2 = new GuestEntry("guest2", "another comment");
        List<GuestEntry> guestEntries = List.of(entry1, entry2);
        when(repository.findAll()).thenReturn(guestEntries);
        List<GuestEntry> result = service.getAllGuests();
        verify(repository, times(1)).findAll();
        assertEquals(guestEntries, result);
    }

    @Test
    public void addGuestbookEntry_callsSaveMethodRepository() {
        GuestEntry entry1 = new GuestEntry("guest1", "some comment");
        when(repository.save(entry1)).thenReturn(entry1);
        GuestEntry result = service.addGuestbookEntry(entry1);
        verify(repository, times(1)).save(entry1);
        assertEquals(entry1, result);
    }



}