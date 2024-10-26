package se331.pbandjbackend.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.pbandjbackend.entity.*;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    CountryDTO getCountryDto(Country country);
    List<CountryDTO> getCountryDto(List<Country> countries);
    SportDTO getSportDto(Sport sport);
    List<SportDTO> getSportDto(List<Sport> sports);

    CommentDTO getCommentDto(Comment comment);
    List<CommentDTO> getCommentDto(List<Comment> comments);

}
