package marvel.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import marvel.client.MarvelClient;
import marvel.model.MarvelResponse;
import marvel.model.ResultsResponse;

@Service
@AllArgsConstructor
public class MarvelService {

    private static final String PUBLIC_KEY = "03d7e08405ab5e1fbcd9653c52042840";
    private static final String PRIVATE_KEY = "14ac8edb1cf2de3daa1f470e92a7f43fd3888cc4";

    @Autowired
    private MarvelClient client;

    public List<Long> getAllCharactersId() {

        return getAllCharacters().getData().getResults().stream().map(ResultsResponse::getId).collect(Collectors.toList());
    }

    public MarvelResponse getAllCharacters() {

        Long timeStamp = new Date().getTime();

        return client.getAllCharacters(timeStamp, PUBLIC_KEY, buildHash(timeStamp));
    }

    public MarvelResponse findAllComics() {
        Long timeStamp = new Date().getTime();

        return client.getAllComics(timeStamp, PUBLIC_KEY, buildHash(timeStamp));
    }

    public ResultsResponse getCharacterId(Long idCharacter) {

        Long timeStamp = new Date().getTime();

        return client.getCharacterId(idCharacter, PUBLIC_KEY, buildHash(timeStamp));
    }

    private String buildHash(Long timeStamp) {

        return DigestUtils.md5Hex(timeStamp + PRIVATE_KEY + PUBLIC_KEY);
    }

}
