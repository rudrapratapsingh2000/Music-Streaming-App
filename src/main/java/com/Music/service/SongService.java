package com.Music.service;

import com.Music.model.AuthenticationToken;
import com.Music.model.Genre;
import com.Music.model.Song;
import com.Music.model.User;
import com.Music.repository.ISongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    @Autowired
    ISongRepo songRepo;

    @Autowired
    TokenService tokenService;

    public String addSong(String token , List<Song> songList ) {
        AuthenticationToken token1 = tokenService.tokenRepo.findFirstByToken(token);
        User user = token1.getUser();
        if(user.getRole().getRoleId()==1){
            songRepo.saveAll(songList);
            return "Songs added successfully";
        }
        return "Not an authorized user";
    }

    public List<Song> getSong(String token, String email, String songName, Genre genre) {
        if(songName!=null && genre!=null){

            return songRepo.findBySongNameAndGenre(songName , genre );
        }else if(songName!=null){
            return songRepo.findBySongName(songName);
        }else if(genre!=null){

            return songRepo.findByGenre(genre);
        }else {
            return songRepo.findAll();
        }
    }

    public String deleteSong(String token,  Long id) {
        AuthenticationToken token1 = tokenService.tokenRepo.findFirstByToken(token);
        User user = token1.getUser();
        if(user.getRole().getRoleId()==1){
            songRepo.deleteById(id);
            return "Songs deleted successfully";
        }
        return "Not an authorized user";
    }

    public String updateSong(String token, Long id , Song song) {
        AuthenticationToken token1 = tokenService.tokenRepo.findFirstByToken(token);
        User user = token1.getUser();
        if(user.getRole().getRoleId()==1){
            Optional<Song> optionalSong = songRepo.findById(id);
            if(optionalSong.isPresent()){
                Song originalSong = optionalSong.get();
                if(song.getSongName()!=null){
                    originalSong.setSongName(song.getSongName());
                }
                if(song.getGenre()!=null){
                    originalSong.setGenre(song.getGenre());
                }
                if(song.getSongLink()!=null){
                    originalSong.setSongLink(song.getSongLink());
                }
                if(song.getArtist()!=null){
                    originalSong.setArtist(song.getArtist());
                }
                if(song.getDuration()!=null){
                    originalSong.setDuration(song.getDuration());
                }
                songRepo.save(originalSong);
                return "Song updated successfully";
            }else{
                return "Song not present";
            }
        }
        return "Not an authorized user";
    }
}