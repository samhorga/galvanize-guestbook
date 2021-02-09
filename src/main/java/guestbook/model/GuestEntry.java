package guestbook.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class GuestEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String guestName;
    private String comment;

    public Long getId() {
        return id;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getComment() {
        return comment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public GuestEntry() {
    }

    public GuestEntry(String guestName, String comment) {
        this.guestName = guestName;
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GuestEntry)) return false;
        GuestEntry that = (GuestEntry) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(guestName, that.guestName) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guestName, comment);
    }
}
