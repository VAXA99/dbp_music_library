package com.dbp_music_library.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "date_of_release")
    private LocalDate dateOfRelease;

    @ManyToOne
    private Musician musician;

    @ManyToOne
    private Band band;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Genre genre;

    @Column(name = "sound_time")
    private Float soundTime;

    @OneToMany(mappedBy = "song", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<RadioOrder> radioOrders;

    @OneToMany(mappedBy = "song", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<SongCover> songCovers;
}
