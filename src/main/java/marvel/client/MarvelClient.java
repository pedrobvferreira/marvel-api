package marvel.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import marvel.model.MarvelResponse;
import marvel.model.ResultsResponse;

@FeignClient(name = "marvel", url = "${url.marvel}/v1/public")
public interface MarvelClient {

    @GetMapping("/comics")
    public MarvelResponse getAllComics(
            @RequestParam(value = "ts") Long timeStamp,
            @RequestParam(value = "apikey") String publicKey,
            @RequestParam(value = "hash") String hashMD5);

    @GetMapping("/characters")
    public MarvelResponse getAllCharacters(
            @RequestParam(value = "ts") Long timeStamp,
            @RequestParam(value = "apikey") String publicKey,
            @RequestParam(value = "hash") String hashMD5);

    @GetMapping("/characters/{characterId}")
    public ResultsResponse getCharacterId(
            @PathVariable Long characterId,
            @RequestParam(value = "apikey") String publicKey,
            @RequestParam(value = "hash") String hashMD5);
}
