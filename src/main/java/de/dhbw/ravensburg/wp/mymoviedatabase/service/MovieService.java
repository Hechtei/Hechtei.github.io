package de.dhbw.ravensburg.wp.mymoviedatabase.service;

import de.dhbw.ravensburg.wp.mymoviedatabase.dto.MovieDTO;
import de.dhbw.ravensburg.wp.mymoviedatabase.model.Movie;

import java.util.List;

public interface MovieService {
    List<MovieDTO> getAllMovies();
    MovieDTO getMovieById(long id);
    void removeMovieById(long id);
    MovieDTO addMovie(MovieDTO movie);
    MovieDTO updateMovie(MovieDTO movie);
}
