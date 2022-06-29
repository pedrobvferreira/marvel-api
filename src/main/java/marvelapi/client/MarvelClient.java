package marvelapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import marvelapi.model.DataResponse;
import marvelapi.model.ResultsResponse;

@FeignClient(name = "marvel", url = "${url.marvel}/v1/public")
public interface MarvelClient {

    @GetMapping("/characters")
    public DataResponse getAllCharacters(@RequestParam(value = "apikey") String publicKey, @RequestParam(value = "hash") String hashMD5);

    @GetMapping("/characters/{characterId}")
    public ResultsResponse getCharacterId(@PathVariable Long characterId, @RequestParam(value = "apikey") String publicKey,
            @RequestParam(value = "hash") String hashMD5);
}
