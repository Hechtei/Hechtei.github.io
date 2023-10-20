package de.dhbw.ravensburg.wp.mymoviedatabase.service;

import de.dhbw.ravensburg.wp.mymoviedatabase.dto.MovieDTO;
import de.dhbw.ravensburg.wp.mymoviedatabase.mapper.MovieMapper;
import de.dhbw.ravensburg.wp.mymoviedatabase.model.Movie;
import de.dhbw.ravensburg.wp.mymoviedatabase.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;
    private MovieMapper movieMapper;

    public MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper){
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDTO> getAllMovies(){
        return this.movieMapper.moviesToMovieDTOs(this.movieRepository.findAll());
    }

    @Override
    public MovieDTO getMovieById(long id){
        return this.movieMapper.movieToMovieDTO(this.movieRepository.findById(id).get());
    }

    @Override
    public void removeMovieById(long id){
        this.movieRepository.deleteById(id);
    }

    @Override
    public MovieDTO addMovie(MovieDTO new_movie){
        Movie tmp = this.movieMapper.movieDTOToMovie(new_movie);
        return this.movieMapper.movieToMovieDTO(this.movieRepository.save(tmp));
    }

    @Override
    public MovieDTO updateMovie(MovieDTO updated_movie){
        if(movieRepository.existsById(updated_movie.getId())){
            Movie tmp = this.movieMapper.movieDTOToMovie(updated_movie);
            return this.movieMapper.movieToMovieDTO(this.movieRepository.save(tmp));
        }else{
            throw new EntityNotFoundException("MovieId does not exist");
        }
    }

}
