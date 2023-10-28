package com.Music.dto;

import com.Music.model.Song;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayListOutput {
    @NotBlank(message = "PlayList name can't be blank")
    private String playListName;

    @OneToMany
    private List<Song> songs;
}
