package marvel.service;

import marvel.model.ComicApiResponse;
import org.springframework.stereotype.Service;

@Service
public interface ComicService
{
	ComicApiResponse getComics();
}
