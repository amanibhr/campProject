package com.example.tunisiecamp.services;

import com.example.tunisiecamp.entites.Complaint;
import com.example.tunisiecamp.entites.Forum;

import java.util.List;

public interface ComplaintService {
    List<Complaint> retrieveAllComplaints();

    Complaint addComplaint(Complaint f);

    Complaint updateComplaint(Complaint complaint, Long idComplaint);

    Complaint retrieveComplaint (Long idComplaint);

    void deleteComplaint(Long idComplaint);
}

