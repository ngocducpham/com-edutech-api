package com.edutech.api.storage.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = TablePrefix.PREFIX_TABLE+"new")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class New extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @NotNull
    private String title;

    @ManyToOne
    private Account author;

    @NotNull
    private String content;

    public New(String title, Account author) {
        this.title = title;
        this.author = author;
    }
}
