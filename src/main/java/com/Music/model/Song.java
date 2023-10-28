package com.Music.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;

    @Column(nullable = false)
    @NotBlank(message = "SongName can't be blank")
    private String songName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genre genre;

    @Column(nullable = false)
    private Double duration;

    @Column(nullable = false)
    @NotBlank(message = "Song Artist can't be blank")
    private String artist;

    @Column(nullable = false)
    @NotBlank(message = "Song Link can't be blank")
    private String songLink;
}
