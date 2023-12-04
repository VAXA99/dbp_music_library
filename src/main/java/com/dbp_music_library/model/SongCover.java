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
public class SongCover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sound_time")
    private Float soundTime;

    @Column(name = "date_of_release")
    private LocalDate dateOfRelease;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Song song;

    @ManyToOne
    private Musician musician;

    @ManyToOne
    private Band band;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "album_song",
            joinColumns = @JoinColumn(name = "song_cover_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id"))
    private List<Band> tags = new ArrayList<>();

}
