package com.Music.repository;

import com.Music.model.Genre;
import com.Music.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISongRepo extends JpaRepository<Song, Long> {

//    List<Song> findBySongNameAndGenre(String name , String genre);

    List<Song> findBySongName(String name);

    List<Song> findBySongNameAndGenre(String songName, Genre genre);

    List<Song> findByGenre(Genre genre);

//    List<Song> findByGenre(String genre);
}