package marvel.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import marvel.model.ResultsResponse;
import marvel.service.MarvelService;

@AllArgsConstructor
@RestController
@RequestMapping("/marvel")
public class MarvelController {

    @Autowired
    private MarvelService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/characters")
    public List<Long> findAllCharactersId() {

        return service.getAllCharactersId();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/characters/{characterId}")
    public ResultsResponse getCharacterId(@PathVariable Long characterId) {

        return service.getCharacterId(characterId);
    }
}
