package de.dhbw.ravensburg.wp.mymoviedatabase.service;

import de.dhbw.ravensburg.wp.mymoviedatabase.dto.AwardDTO;
import de.dhbw.ravensburg.wp.mymoviedatabase.mapper.AwardMapper;
import de.dhbw.ravensburg.wp.mymoviedatabase.model.Award;
import de.dhbw.ravensburg.wp.mymoviedatabase.repository.AwardRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AwardServiceImpl implements AwardService {

    private AwardRepository awardRepository;

    private AwardMapper awardMapper;

    public AwardServiceImpl(AwardRepository awardRepository, AwardMapper awardMapper){
        this.awardRepository = awardRepository;
        this.awardMapper = awardMapper;
    }

    @Override
    public List<AwardDTO> getAllAwards(){
        return this.awardMapper.awardsToAwardsDTO(this.awardRepository.findAll());
    }

    @Override
    public AwardDTO getAwardById(long id){
        return this.awardMapper.awardToAwardDTO(this.awardRepository.findById(id).get());
    }

    @Override
    public void removeAwardById(long id){
        this.awardRepository.deleteById(id);
    }

    @Override
    public AwardDTO addAward(AwardDTO new_award){
        Award tmp = this.awardMapper.awardDTOToAward(new_award);
        return this.awardMapper.awardToAwardDTO(this.awardRepository.save(tmp));
    }

    @Override
    public AwardDTO updateAward(AwardDTO updated_award){
        if(awardRepository.existsById(updated_award.getId())) {
            Award tmp = this.awardMapper.awardDTOToAward(updated_award);
            return this.awardMapper.awardToAwardDTO(this.awardRepository.save(tmp));
        }else{
            throw new EntityNotFoundException("MovieId does not exist");
        }
    }




}
