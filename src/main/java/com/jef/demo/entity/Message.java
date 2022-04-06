package com.jef.demo.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

}
