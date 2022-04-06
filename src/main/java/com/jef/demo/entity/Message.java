package com.jef.demo.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "message")
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    private Long id;

    private String text;

}
