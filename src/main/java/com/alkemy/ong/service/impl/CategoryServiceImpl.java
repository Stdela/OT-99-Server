package com.alkemy.ong.service.impl;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alkemy.ong.dto.CategoryDto;
import com.alkemy.ong.dto.CategoryDtoGetAll;
import com.alkemy.ong.exception.DataAlreadyExistException;
import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.mapper.CategoryMapper;
import com.alkemy.ong.model.Category;
import com.alkemy.ong.repository.CategoryRepository;
import com.alkemy.ong.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CategoryMapper categoryMapper;
	
	@Override
	public List<CategoryDtoGetAll> getAllCategories() {
		
		List<Category> categories=categoryRepository.findAll();
		
		return categoryMapper.toCategoryDtoGetAllList(categories);
	}
	
	@Override
    public Category save(CategoryDto categoryDto) throws DataAlreadyExistException {

        if ((categoryRepository.findByName(categoryDto.getName()).isPresent())) {
            throw new DataAlreadyExistException("Wrong!, Name already Exist.");
            }
        Category category = categoryMapper.dtoToEntity(categoryDto);
        category.setCreationDate(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());

        return categoryRepository.save(category);
    }


	@Override
	public Category getCategoryById(long id) throws NotFoundException {
			return categoryRepository.findById(id)
			.orElseThrow(() -> new NotFoundException("Wrong!, Category doesn't exist."));
	}



}
