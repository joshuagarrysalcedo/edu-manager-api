package ph.jsalcedo.edumanagerapi.model;

import jakarta.persistence.*;


@Entity
@Table(name = "institution")
public class Institution {
    @Id
    @SequenceGenerator(
            name = "institution_sequence",
            sequenceName = "institution_sequence",
            allocationSize = 100
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "institution_sequence"
    )
    private Long id;

    @OneToOne(mappedBy = "institution", targetEntity = User.class, cascade = CascadeType.ALL)
    private User user;
}
