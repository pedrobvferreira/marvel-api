package marvelapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import marvelapi.client.MarvelClient;
import marvelapi.model.DataResponse;
import marvelapi.model.ResultsResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.codec.digest.DigestUtils;

@Service
@AllArgsConstructor
public class MarvelService {

    private static final String PUBLIC_KEY = "03d7e08405ab5e1fbcd9653c52042840";
    private static final String PRIVATE_KEY = "14ac8edb1cf2de3daa1f470e92a7f43fd3888cc4";

    @Autowired
    private MarvelClient client;

    public List<Long> getAllCharactersId() {

        return getAllCharacters().getResults().stream().map(ResultsResponse::getId).collect(Collectors.toList());
    }

    public DataResponse getAllCharacters() {

        return client.getAllCharacters(PUBLIC_KEY, buildHash());
    }

    public ResultsResponse getCharacterId(Long idCharacter) {

        return client.getCharacterId(idCharacter, PUBLIC_KEY, buildHash());
    }

    private String buildHash() {

        return DigestUtils.md5Hex(PRIVATE_KEY + PUBLIC_KEY);
    }

}
