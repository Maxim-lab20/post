package com.max.announcements.service.impl;

import com.max.announcements.dto.AnnouncementDTO;
import com.max.announcements.entity.AnnouncementEntity;
import com.max.announcements.exception.AnnouncementNotFoundException;
import com.max.announcements.repository.AnnouncementRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AnnouncementServiceImplTest {

    @InjectMocks
    AnnouncementServiceImpl announcementServiceImpl;

    @Mock
    AnnouncementRepository announcementRepository;

    @Test
    void getAnnouncementByIdWithSuccess() {
        //GIVEN
        Integer id = 1;
        String author = "max";

        AnnouncementEntity announcementEntity = new AnnouncementEntity();
        announcementEntity.setId(id);
        announcementEntity.setAuthor(author);

        AnnouncementDTO expected = AnnouncementDTO.builder()
                .id(id)
                .author(author)
                .build();

        when(announcementRepository.findById(id))
                .thenReturn(Optional.of(announcementEntity));

        //WHEN
        AnnouncementDTO actual = announcementServiceImpl.getAnnouncementById(id);

        //THEN
        assertThat(actual)
                .usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void getAnnouncementByIdThrowsAnnouncementNotFoundException() {
        //GIVEN
        Integer id = 1;
        when(announcementRepository.findById(id))
                .thenReturn(Optional.empty());

        //WHEN + THEN
        assertThrows(AnnouncementNotFoundException.class,
                () -> announcementServiceImpl.getAnnouncementById(id));
    }

}