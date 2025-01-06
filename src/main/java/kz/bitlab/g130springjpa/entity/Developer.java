package kz.bitlab.g130springjpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DEVELOPERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FULL_NAME", columnDefinition = "VARCHAR(150)")
    private String fullName;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "AGE")
    private Integer age;
}
