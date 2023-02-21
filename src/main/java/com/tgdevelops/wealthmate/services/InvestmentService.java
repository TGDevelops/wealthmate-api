package com.tgdevelops.wealthmate.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.tgdevelops.wealthmate.config.FirebaseConfig;
import com.tgdevelops.wealthmate.models.Investment;
import com.tgdevelops.wealthmate.repositories.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class InvestmentService {
    private static final Logger log = LogManager.getLogger(InvestmentService.class);

    @Autowired
    private Repository repository;

    public String addInvestment(Investment investment) throws ExecutionException, InterruptedException {
        return repository.createInvestment(investment);
    }


    public String deleteInvestment(String uuid) {
        return repository.deleteInvestment(uuid);
    }

    public String updateInvestment(Investment investment, String uuid){
        return repository.updateInvestment(investment, uuid);
    }
}
