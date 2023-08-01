package tpSpringBoot.TPQuiz.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idU;

    @Column(length = 150)
    private String nom;

    @Column(length = 150)
    private String prenom;
    
    @Column(length = 150)
    private String pseudo;

    @Column(length = 150)
    private String mdp;
}
