package com.example.pesaFix.service;

import com.example.pesaFix.dao.GeneralResponse;
import com.example.pesaFix.model.Loan;
import com.example.pesaFix.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    @Autowired
    LoanRepository loanRepository;

    GeneralResponse generalResponse;
    public Loan saveOrUpdate(Loan loan){
        return loanRepository.save(loan);
    }
    public Object getLoanById(Long id){
        generalResponse= new GeneralResponse();
        try{
       return loanRepository.findById(id).get();
        }catch (Exception e){
            generalResponse.status="Failed";
            generalResponse.description="Loan not found";
            return generalResponse;
        }

    }
    public List<Loan> findAll(){

        return loanRepository.findAll();

    }

    public Object deleteById(Long id){
        generalResponse= new GeneralResponse();

        try{
            loanRepository.deleteById(id);
            generalResponse.status="Success";
            generalResponse.description="Loan deleted successfully";

        }catch (Exception e){

            generalResponse.status="Failed";
            generalResponse.description="Loan could not be found";

        }

   return generalResponse;
    }
}