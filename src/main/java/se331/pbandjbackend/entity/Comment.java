package se331.pbandjbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import se331.pbandjbackend.security.user.User;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;

    @ManyToOne
    User author;
    String message;

    @ManyToOne
    Country country;
}
