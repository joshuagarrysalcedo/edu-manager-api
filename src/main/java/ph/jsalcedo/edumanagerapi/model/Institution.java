package ph.cdo.jsalcedo.edumanagerapi.model;

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
            generator = "user_sequence"
    )
    private Long id;

    @OneToOne(mappedBy = "institution")
    private User user;
}
