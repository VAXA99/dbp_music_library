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
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "date_of_creation", nullable = false)
    private LocalDate dateOfCreation;

    @Column(name = "date_of_break_up")
    private LocalDate dateOfBreakUp;

    private String bio;

    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "band", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Song> authoredSongs;

    @OneToMany(mappedBy = "band", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<SongCover> coveredSongs;


}
