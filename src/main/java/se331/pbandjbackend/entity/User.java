package se331.pbandjbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;

    // Getters and Setters
    @ManyToOne
    Sport sport;
    @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "participant_event_history",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id")
    )
    @Builder.Default
    List<SportList> sport_lists = new ArrayList<>();
}


