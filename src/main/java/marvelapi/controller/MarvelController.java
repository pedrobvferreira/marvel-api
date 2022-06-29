package marvelapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import marvelapi.model.ResultsResponse;
import marvelapi.service.MarvelService;

@AllArgsConstructor
@RestController
@RequestMapping("/marvel")
public class MarvelController {

    @Autowired
    private MarvelService service;

    @GetMapping("/characters")
    public ResponseEntity<List<Long>> findAllCharactersIId() {

        var listCharacterId = service.getAllCharactersId();

        return ResponseEntity.status(HttpStatus.OK).body(listCharacterId);
    }

    @GetMapping("/characters/{characterId}")
    public ResponseEntity<ResultsResponse> getCharacterId(@PathVariable Long characterId) {

        var character = service.getCharacterId(characterId);

        return ResponseEntity.status(HttpStatus.OK).body(character);
    }
}
