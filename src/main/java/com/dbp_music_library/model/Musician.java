package com.dbp_music_library.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Musician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, name = "date_of_birth")
    private LocalDate dateOfBirth;

    private String bio;

    @ManyToOne
    private Country country;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "band_member",
            joinColumns = @JoinColumn(name = "musician_id"),
            inverseJoinColumns = @JoinColumn(name = "band_id"))
    private List<Band> tags;

    @OneToMany(mappedBy = "musician", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Song> authoredSongs;

    @OneToMany(mappedBy = "musician", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<SongCover> coveredSongs;
}
