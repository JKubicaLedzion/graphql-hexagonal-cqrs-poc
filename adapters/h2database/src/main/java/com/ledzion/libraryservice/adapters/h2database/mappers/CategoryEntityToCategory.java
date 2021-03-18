package com.ledzion.libraryservice.adapters.h2database.mappers;

import com.ledzion.libraryservice.adapters.h2database.model.CategoryEntity;
import com.ledzion.libraryservice.api.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryEntityToCategory {

    CategoryEntityToCategory INSTANCE = Mappers.getMapper(CategoryEntityToCategory.class);

    CategoryEntity categoryToCategoryEntity(Category category);

    Category categoryEntityToCategory(CategoryEntity categoryEntity);
}
