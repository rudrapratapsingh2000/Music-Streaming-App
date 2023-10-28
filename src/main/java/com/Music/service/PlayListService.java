package com.Music.service;

import com.Music.dto.PlayListOutput;
import com.Music.model.AuthenticationToken;
import com.Music.model.PlayList;
import com.Music.model.Song;
import com.Music.model.User;
import com.Music.repository.IPlayListRepo;
import com.Music.repository.ISongRepo;
import com.Music.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayListService {

    @Autowired
    TokenService tokenService;

    @Autowired
    IUserRepo userRepo;

    @Autowired
    IPlayListRepo playListRepo;

    @Autowired
    ISongRepo songRepo;


    public String addPlayList(String token, PlayList playList) {
        AuthenticationToken token1 = tokenService.tokenRepo.findFirstByToken(token);
        User user = token1.getUser();
        user.setPlayList(playList);
        userRepo.save(user);
        return "PlayList added successfully";
    }

    public PlayListOutput getPlayList(String token, String email) {
        AuthenticationToken token1 = tokenService.tokenRepo.findFirstByToken(token);
        User user = token1.getUser();
        PlayList playList = user.getPlayList();
        PlayListOutput playListOutput = new PlayListOutput();
        playListOutput.setPlayListName(playList.getPlayListName());
        playListOutput.setSongs(playList.getSongs());
        return playListOutput;
    }

    public String deletePlayList(String token) {
        AuthenticationToken token1 = tokenService.tokenRepo.findFirstByToken(token);
        User user = token1.getUser();

        if(user.getPlayList()==null){
            return "PlayList doesn't exist";
        }
        playListRepo.deleteById(user.getPlayList().getPlayListId());
        user.setPlayList(null);
        userRepo.save(user);
        return "PlayList deleted successfully";
    }

    public String updatePlayList(String token, Long id) {
        AuthenticationToken token1 = tokenService.tokenRepo.findFirstByToken(token);
        User user = token1.getUser();
        List<Song> songList = user.getPlayList().getSongs();

        for(Song song : songList){
            if(song.getSongId()==id){
                return "Song already exists in playList";
            }
        }

        Song song = songRepo.findById(id).get();
        songList.add(song);
        user.getPlayList().setSongs(songList);
        userRepo.save(user);
        return "Song added in playList";
    }

    public String deleteFromPlayList(String token, Long id) {
        AuthenticationToken token1 = tokenService.tokenRepo.findFirstByToken(token);
        User user = token1.getUser();
        List<Song> songList = user.getPlayList().getSongs();


        for(int i=0 ; i<songList.size() ; i++){
            if(songList.get(i).getSongId()==id){
                songList.remove(i);
                user.getPlayList().setSongs(songList);
                userRepo.save(user);
                return "Song deleted in playList";
            }
        }




        return "Song doesnot exist in playList";
    }


    public List<Song> getPaginationSongs(String token, String email, int limit, int offset) {

        AuthenticationToken token1 = tokenService.tokenRepo.findFirstByToken(token);
        User user = token1.getUser();
        PlayList playList = user.getPlayList();
        List<Song> songList = playList.getSongs().subList(offset, Math.min(offset + limit, playList.getSongs().size()));
        return songList;
    }

}