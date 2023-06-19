package com.example.tunisiecamp.controllers;

import com.example.tunisiecamp.entites.Complaint;
import com.example.tunisiecamp.services.ComplaintService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Complaint")
public class ComplaintRestController {
    ComplaintService complaintService;
    // http://localhost:8089/kaddem/etudiant/retrieve-all-etudiants
    @GetMapping("/retrieve-all-Complaints")
    public List<Complaint> getComplaints() {
        List<Complaint> listComplaints = complaintService.retrieveAllComplaints();
        return listComplaints;
    }
    // http://localhost:8089/kaddem/etudiant/retrieve-etudiant/8
    @GetMapping("/retrieve-Complaint/{complaintId}")
    public Complaint retrieveComplaint(@PathVariable("complaintId") Long complaintId) {
        return complaintService.retrieveComplaint(complaintId);
    }
    // http://localhost:8089/kaddem/etudiant/add-etudiant
    @PostMapping("/add-Complaint")
    public Complaint addComplaint(@RequestBody Complaint e) {
        Complaint complaint = complaintService.addComplaint(e);
        return complaint;
    }
    // http://localhost:8089/kaddem/etudiant/update-etudiant
    @PutMapping("/update-Complaint/{complaintId}")
    public Complaint updateComplaint(@RequestBody Complaint e, @PathVariable("commentaireId") Long complaintId) {
        return complaintService.updateComplaint(e,complaintId);

    }


    // http://localhost:8089/kaddem/etudiant/delete-etudiant
    @DeleteMapping("/delete-Complaint/{complaintId}")
    public void deleteComplaint(@PathVariable("complaintId") Long complaintId) {
        complaintService.deleteComplaint(complaintId);
    }


}


