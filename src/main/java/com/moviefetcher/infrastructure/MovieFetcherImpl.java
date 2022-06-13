package com.moviefetcher.infrastructure;

import com.moviefetcher.application.Movie;
import com.moviefetcher.application.MovieFetcher;
import com.moviefetcher.infrastructure.tmdb.TmdbClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MovieFetcherImpl implements MovieFetcher {

    private final TmdbClient tmdbClient;

    @Autowired
    public MovieFetcherImpl(TmdbClient tmdbClient) {
        this.tmdbClient = tmdbClient;
    }

    @Override
    public List<Movie> fetchMovies(int numberOfMovies) {
        return null;
    }
}
