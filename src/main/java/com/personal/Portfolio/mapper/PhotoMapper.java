package com.personal.portfolio.mapper;


import com.personal.portfolio.dto.model.PhotoDTO;
import com.personal.portfolio.model.Photo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhotoMapper {

    PhotoDTO photoToPhotoDTO(Photo photo);

    Photo photoDTOToPhoto(PhotoDTO photoDTO);
}
