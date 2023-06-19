package com.example.tunisiecamp.services;

import com.example.tunisiecamp.entites.Complaint;
import com.example.tunisiecamp.entites.Feedback;
import com.example.tunisiecamp.entites.Forum;
import com.example.tunisiecamp.repositories.ComplaintRepository;
import com.example.tunisiecamp.repositories.FeedbackRepository;
import com.example.tunisiecamp.repositories.ForumRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class ComplaintServiceImpl implements ComplaintService{
    ComplaintRepository complaintRepository;
    ForumRepository forumRepository;
    @Override
    public List<Complaint> retrieveAllComplaints(){
        return (List<Complaint>) complaintRepository.findAll();
    }

    @Override
    public  Complaint addComplaint(Complaint e) {
            e.setDate(new Date());
            return complaintRepository.save(e);
    }

    @Override
    public Complaint updateComplaint(Complaint complaint, Long idComplaint) {
        Complaint complaint1 = complaintRepository.findById(idComplaint).get();
        complaint1.setMessage(complaint.getMessage());
        return complaintRepository.save(complaint1);
    }

    @Override
    public Complaint retrieveComplaint(Long idComplaint) {
        return complaintRepository.findById(idComplaint).get();
    }

    @Override
    public void deleteComplaint(Long idComplaint) {

        complaintRepository.deleteById(idComplaint);

    }


}
