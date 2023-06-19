package com.max.post.entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "public", name = "announcement")
public class AnnouncementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "announcement_seq")
    @SequenceGenerator(name = "announcement_seq", sequenceName = "announcement_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "author")
    private String author;

    @Column(name = "text")
    private String text;

    @Column(name = "votes")
    private Integer votes;

    @Column(name = "email")
    private String email;

}
