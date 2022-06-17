package com.moviefetcher.infrastructure.tmdb;

import com.moviefetcher.infrastructure.tmdb.json.TmdbGenreResponse;
import com.moviefetcher.infrastructure.tmdb.json.TmdbTrending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TmdbClientImpl implements TmdbClient {

    private final String BASE_URL = "https://api.themoviedb.org/3";
    private final String TRENDING_WEEK_URL = "/trending/movie/week";
    private final String GENRES_URL = "/genre/movie/list";

    private final String API_KEY_PLACEHOLDER = "?api_key=";
    private final String apiKeyQueryParam;

    private HttpHeaders headers;

    @Autowired
    public TmdbClientImpl(@Value("${tmdb.api.key}") String apiKey) {
        this.apiKeyQueryParam = API_KEY_PLACEHOLDER + apiKey;
    }


    @Override
    public TmdbTrending fetchTrendingByWeek() {

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForEntity(BASE_URL + TRENDING_WEEK_URL + apiKeyQueryParam, TmdbTrending.class)
                .getBody();

    }

    @Override
    public TmdbGenreResponse getGenres() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForEntity(BASE_URL + GENRES_URL + apiKeyQueryParam, TmdbGenreResponse.class)
                .getBody();
    }

}
