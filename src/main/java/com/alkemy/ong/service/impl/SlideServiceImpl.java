package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.SlideDtoGet;
import com.alkemy.ong.mapper.SlideMapper;
import java.util.List;
import java.util.stream.Collectors;
import com.alkemy.ong.dto.SlideDto;
import com.alkemy.ong.model.Organization;
import com.alkemy.ong.model.Slide;
import javax.persistence.EntityNotFoundException;
import com.alkemy.ong.repository.SlideRepository;
import com.alkemy.ong.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlideServiceImpl implements SlideService {

    @Autowired
    SlideRepository slideRepository;

    @Autowired
	SlideMapper slideMapper;

    @Override
    public List<SlideDto> getAllSlides() {
    
        List<Slide> slides = slideRepository.findAll();
        
        return slides.stream().map(slide -> new SlideDto(slide.getImageUrl(), slide.getSlideOrder()))
                .collect(Collectors.toList());
    }
    
    @Override
	  public SlideDtoGet getSlide(Long id) {
		
		  Slide slide=slideRepository.getById(id);
	
    return slideMapper.toSlideDtoGet(slide);
		
	}

    @Override
    public void deleteSlide(Long id) throws EntityNotFoundException {
        if (slideRepository.existsById(id)) {
            slideRepository.deleteById(id);

        } else {
            throw new EntityNotFoundException("Slide does not exist");
        }

    }

	@Override
	public List<SlideDtoGet> getAllSlidesByOrganization(Organization org) {
		
		List<Slide> slides=slideRepository.findAllByOrganizationId(org);
		
		return slideMapper.toSlideDtoGetList(slides);
	}
}
