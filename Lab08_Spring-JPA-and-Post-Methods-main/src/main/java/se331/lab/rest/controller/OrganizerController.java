package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se331.lab.entity.Organizer;
import se331.lab.service.OrganizerService;
import se331.lab.util.LabMapper;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")

public class OrganizerController {
    final OrganizerService organizerService;
    @PostMapping("/organizers")
    public ResponseEntity<?> addOrganizer(@RequestBody Organizer organizer){
        Organizer output = organizerService.save(organizer);
        return ResponseEntity.ok(LabMapper.INSTANCE.getEventOrganizerDto(output));
    }

    @GetMapping("/organizers")
    public ResponseEntity<?> getOrganizers(){
        return ResponseEntity.ok(LabMapper.INSTANCE.getEventOrganizerDto(organizerService.getAllOrganizer()));
    }
}