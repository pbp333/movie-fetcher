package com.moviefetcher.infrastructure.tmdb;

import com.moviefetcher.infrastructure.tmdb.json.TmdbGenreResponse;
import com.moviefetcher.infrastructure.tmdb.json.TmdbTrending;

public interface TmdbClient {

    TmdbTrending fetchTrendingByWeek();

    TmdbGenreResponse getGenres();


}
