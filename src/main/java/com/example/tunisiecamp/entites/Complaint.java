package com.example.tunisiecamp.entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Complaint.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor



@Table(name = "complaint")
public class Complaint  implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "objet")
    private String objet;

    @Column(name = "message")
    private String message;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "reponse")
    private String reponse;


    @Column(name = "id_user")
    private Long id_user;

    @Column(name = "id_admin")
    private Long id_admin;




}
