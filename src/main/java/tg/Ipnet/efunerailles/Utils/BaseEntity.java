package tg.Ipnet.efunerailles.Utils;


import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;


@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    private void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
