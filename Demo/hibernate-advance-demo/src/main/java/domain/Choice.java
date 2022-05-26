package domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "choice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "choice")
    private String choice;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

}
