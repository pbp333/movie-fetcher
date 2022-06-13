package com.moviefetcher.application;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Movie {

    private final String poster;
    private final boolean adult;
    private final String overview;
    private final LocalDateTime releaseDate;
    private final List<Integer> genres = new ArrayList<>();
    private final String originalTitle;
    private final String originalLanguage;
    private final String title;
    private final BigDecimal popularity;
    private final int voteCount;
    private final BigDecimal voteAverage;

    private Movie(Builder builder) {
        this.poster = builder.poster;
        this.adult = builder.adult;
        this.overview = builder.overview;
        this.releaseDate = builder.releaseDate;
        this.genres.addAll(builder.genres);
        this.originalTitle = builder.originalTitle;
        this.originalLanguage = builder.originalLanguage;
        this.title = builder.title;
        this.popularity = builder.popularity;
        this.voteCount = builder.voteCount;
        this.voteAverage = builder.voteAverage;
    }

    public String getPoster() {
        return poster;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public List<Integer> getGenres() {
        return genres;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPopularity() {
        return popularity;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public BigDecimal getVoteAverage() {
        return voteAverage;
    }


    public static final class Builder {
        private String poster;
        private boolean adult;
        private String overview;
        private LocalDateTime releaseDate;
        private List<Integer> genres = new ArrayList<>();
        private String originalTitle;
        private String originalLanguage;
        private String title;
        private BigDecimal popularity;
        private int voteCount;
        private BigDecimal voteAverage;

        private Builder() {
        }

        public static Builder with() {
            return new Builder();
        }

        public Builder poster(String poster) {
            this.poster = poster;
            return this;
        }

        public Builder adult(boolean adult) {
            this.adult = adult;
            return this;
        }

        public Builder overview(String overview) {
            this.overview = overview;
            return this;
        }

        public Builder releaseDate(LocalDateTime releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder genres(List<Integer> genres) {
            this.genres = genres;
            return this;
        }

        public Builder originalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
            return this;
        }

        public Builder originalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder popularity(BigDecimal popularity) {
            this.popularity = popularity;
            return this;
        }

        public Builder voteCount(int voteCount) {
            this.voteCount = voteCount;
            return this;
        }

        public Builder voteAverage(BigDecimal voteAverage) {
            this.voteAverage = voteAverage;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}
