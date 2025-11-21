package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.entity.Participant;
import se331.lab.repository.ParticipantRepository;
import se331.lab.util.LabMapper;
import org.springframework.data.domain.PageRequest;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ParticipantController {
    final ParticipantRepository participantRepository;

    @GetMapping({"participant","participants"})
    public ResponseEntity<?> getParticipants(@RequestParam(value = "_limit", required = false) Integer perPage,
                                             @RequestParam(value = "_page", required = false) Integer page){
        perPage = perPage == null || perPage < 1 ? 10 : perPage;
        page = page == null || page < 1 ? 1 : page;
        Page<Participant> pageOutput = participantRepository.findAll(PageRequest.of(page - 1, perPage));
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getParticipantDTO(pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }

    @GetMapping({"participant/{id}","participants/{id}"})
    public ResponseEntity<?> getParticipant(@PathVariable("id") Long id) {
        Participant output = participantRepository.findById(id).orElse(null);
        if (output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getParticipantDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
}