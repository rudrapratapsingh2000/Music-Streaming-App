package com.Music.controller;

import com.Music.dto.PlayListOutput;
import com.Music.model.PlayList;
import com.Music.model.Song;
import com.Music.service.PlayListService;
import com.Music.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("playList")
public class PlayListController {

    @Autowired
    TokenService authService;

    @Autowired
    PlayListService playListService;

    @PostMapping()
    public ResponseEntity<String> addPlayList(@RequestBody PlayList playList , String email , String token ){
        HttpStatus status;
        String msg = "";
        if(authService.authenticate(email,token))
        {
            msg =  playListService.addPlayList(token , playList);
            status = HttpStatus.CREATED;
        }
        else
        {
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<String>( msg , status);
    }

    @GetMapping()
    public ResponseEntity<PlayListOutput> getPlayList(@RequestParam String email , @RequestParam String token){
        HttpStatus status;
        PlayListOutput playListOutput = null ;

        if(authService.authenticate(email,token))
        {
            playListOutput =  playListService.getPlayList(token , email );
            status = HttpStatus.OK;
        }
        else
        {
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<PlayListOutput>( playListOutput , status);
    }

    @DeleteMapping()
    public ResponseEntity<String> deletePlayList (@RequestParam String email , @RequestParam String token){
        HttpStatus status;
        String msg = "";
        if(authService.authenticate(email,token))
        {
            msg =  playListService.deletePlayList(token);
            status = HttpStatus.NO_CONTENT;
        }
        else
        {
            msg = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<String>( msg , status);
    }

    @PutMapping("add/{id}")
    public ResponseEntity<String> updatePlayList(@RequestParam String email , @RequestParam String token , @PathVariable Long id) {
        HttpStatus status;
        String msg = "";
        if(authService.authenticate(email,token))
        {
            msg =  playListService.updatePlayList(token , id);
            status = HttpStatus.OK;
        }
        else
        {
            msg = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<String>( msg , status);
    }

    @PutMapping("delete/{id}")
    public ResponseEntity<String> deleteFromPlayList(@RequestParam String email , @RequestParam String token , @PathVariable Long id) {
        HttpStatus status;
        String msg = "";

        if(authService.authenticate(email,token))
        {
            msg =  playListService.deleteFromPlayList(token , id);
            status = HttpStatus.OK;
        }
        else
        {
            msg = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>( msg , status);
    }

    @GetMapping("/pagination")
    public ResponseEntity<List<Song>> getPlayList(@RequestParam String email , @RequestParam String token , @RequestParam(defaultValue = "10") int limit,
                                                  @RequestParam(defaultValue = "0") int offset){
        HttpStatus status;
        List<Song> songList = null ;

        if(authService.authenticate(email,token))
        {
            songList =  playListService.getPaginationSongs(token , email , limit , offset );
            status = HttpStatus.OK;
        }
        else
        {
           status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<List<Song>>( songList , status);
    }
}