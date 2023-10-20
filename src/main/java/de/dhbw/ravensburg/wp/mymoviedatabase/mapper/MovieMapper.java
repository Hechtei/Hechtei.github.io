package de.dhbw.ravensburg.wp.mymoviedatabase.mapper;

import de.dhbw.ravensburg.wp.mymoviedatabase.dto.MovieDTO;
import de.dhbw.ravensburg.wp.mymoviedatabase.model.Cast;
import de.dhbw.ravensburg.wp.mymoviedatabase.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = AwardMapper.class)
public interface MovieMapper {

    @Mapping(target = "castIds", source = "involvedCast")
    MovieDTO movieToMovieDTO(Movie movie);
    List<MovieDTO> moviesToMovieDTOs(List<Movie> movies);

    Movie movieDTOToMovie(MovieDTO movieDTO);
    List<Movie> movieDTOsToMovies(List<MovieDTO> movieDTOs);

    default Long map(Cast cast){
        return cast.getId();
    }

}