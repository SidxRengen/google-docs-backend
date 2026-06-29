package com.siddharth.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private User owner;

    private String title;

    @Lob
    @Column(name = "content")
    @Basic(fetch = FetchType.EAGER)
    private byte[] content;

    @OneToMany(mappedBy = "doc")
    private List<UserDoc> sharedWith;

}

