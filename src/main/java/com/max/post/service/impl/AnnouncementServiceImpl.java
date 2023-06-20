package com.max.post.service.impl;

import com.max.post.dto.AnnouncementDTO;
import com.max.post.entity.AnnouncementEntity;
import com.max.post.mapper.AnnouncementMapper;
import com.max.post.repository.AnnouncementRepository;
import com.max.post.service.AnnouncementService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    @Override
    public AnnouncementDTO getAnnouncementById(Integer id) {

        Optional<AnnouncementEntity> announcementEntityOptional = announcementRepository.findById(id);

        if (announcementEntityOptional.isPresent()) {
            AnnouncementEntity announcementEntity = announcementEntityOptional.get();
            AnnouncementDTO announcementDTO = AnnouncementMapper.INSTANCE.toDTO(announcementEntity);
            return announcementDTO;
        }

        return null;
    }

    @Override
    public List<AnnouncementDTO> getFilteredListOfAnnouncements(String author) {
        List<AnnouncementEntity> entityList = announcementRepository.findAllByAuthor(author);
        List<AnnouncementDTO> announcementDTOS = entityList.stream()
                .map(AnnouncementMapper.INSTANCE::toDTO)
                .toList();

        return announcementDTOS;
    }

    /**
     * Everything that we try to save in the database will be rollback as an unexpected error happened.
     */
    @Override
    @Transactional  // try to comment this annotation,
    // and you will see that data will be saved
    // "inside the announcement" table even though an error was thrown
    public AnnouncementDTO createAnnouncement(AnnouncementDTO announcementDTO) {
        AnnouncementEntity announcementEntity = AnnouncementMapper.INSTANCE.toEntity(announcementDTO);
        AnnouncementEntity savedEntity = announcementRepository.save(announcementEntity);
        AnnouncementDTO announcementDTOToBeReturned = AnnouncementMapper.INSTANCE.toDTO(savedEntity);

        //crazy business logic
        AnnouncementEntity dummy = new AnnouncementEntity();
        dummy.setAuthor("dummy");
        dummy.setText("dummy");
        dummy.setVotes(0);
        dummy.setEmail("dummy@email.com");
        announcementRepository.save(dummy);

        // simulate unexpected error
        throw new RuntimeException();
    }

}
