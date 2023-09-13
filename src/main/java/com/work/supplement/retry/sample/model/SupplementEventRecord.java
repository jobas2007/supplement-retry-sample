package com.work.supplement.retry.sample.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "supplement_id_association")
public class SupplementEventRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String equipInit;

    private String equipNum;

}
