package kr.co.ajoutee.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class TodoEntity extends BasicEntity{

    @Id
    @Column(name ="TODO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NonNull
    private String title;


    @Column(updatable = false)
    private Boolean completed;
//    true false

    @Column(updatable = false)
    private LocalDateTime complete_at;

    @Builder
    public TodoEntity(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
        setComplete_at();
    }

    public void setComplete_at() {
        if (this.getCompleted() != null && this.getCompleted()) {
            this.complete_at = LocalDateTime.now();
        } else {
            this.complete_at = null;
        }
    }

    public void update(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
        setComplete_at();
    }


}
