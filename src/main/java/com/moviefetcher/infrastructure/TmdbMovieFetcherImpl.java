package com.moviefetcher.infrastructure;

import com.moviefetcher.application.Movie;
import com.moviefetcher.application.MovieFetcher;
import com.moviefetcher.infrastructure.tmdb.TmdbClient;
import com.moviefetcher.infrastructure.tmdb.json.TmdbMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TmdbMovieFetcherImpl implements MovieFetcher {

    private final TmdbClient tmdbClient;

    @Autowired
    public TmdbMovieFetcherImpl(TmdbClient tmdbClient) {
        this.tmdbClient = tmdbClient;
    }

    @Override
    public List<Movie> fetchMoviesByWeek() {
        return tmdbClient.fetchTrendingByWeek().getResults().stream().map(this::toMovie).collect(Collectors.toList());
    }

    private Movie toMovie(TmdbMovie tmdbMovie) {
        Movie.Builder builder = Movie.Builder.with();

        builder.posterPath(tmdbMovie.getPosterPath());
        builder.adult(tmdbMovie.isAdult());
        builder.overview(tmdbMovie.getOverview());
        builder.releaseDate(LocalDate.parse(tmdbMovie.getReleaseDate()));
        builder.genres(toGenreName(tmdbMovie.getGenres()));
        builder.originalTitle(tmdbMovie.getOriginalTitle());
        builder.originalLanguage(tmdbMovie.getOriginalLanguage());
        builder.title(tmdbMovie.getTitle());
        builder.popularity(tmdbMovie.getPopularity());
        builder.voteCount(tmdbMovie.getVoteCount());
        builder.voteAverage(tmdbMovie.getVoteAverage());

        return builder.build();
    }

    private List<String> toGenreName(List<Integer> ids) {

        Map<Integer, String> genreByIds = new HashMap<>();

        tmdbClient.getGenres().getGenres().stream().forEach(genre -> genreByIds.put(genre.getId(), genre.getName()));

        return ids.stream().map(id -> genreByIds.get(id)).collect(Collectors.toList());
    }
}
