package com.tgdevelops.wealthmate.repositories;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.protobuf.Api;
import com.tgdevelops.wealthmate.config.FirebaseConfig;
import com.tgdevelops.wealthmate.models.Investment;
import com.tgdevelops.wealthmate.services.InvestmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@org.springframework.stereotype.Repository
public class Repository {

    private static final Logger log = LogManager.getLogger(InvestmentService.class);

    @Autowired
    private FirebaseConfig firebaseConfig;

    private Firestore firestoreDb;

    @PostConstruct
    public void setFirestoreDb(){
        this.firestoreDb = firebaseConfig.getDb();
    }

    private CollectionReference getInvestmentCollection(){
        return firestoreDb.collection("Investments");
    }

    public String createInvestment(Investment investment) throws ExecutionException, InterruptedException {
        investment.setId(UUID.randomUUID().toString());
        ApiFuture<WriteResult> dbResult =getInvestmentCollection().document(investment.getId()).set(investment);
        return dbResult.get().getUpdateTime().toString();
    }

    public String deleteInvestment(String uuid){
        String resultMessage;
        ApiFuture<WriteResult> result = getInvestmentCollection().document(uuid).delete();
        try {
            resultMessage = result.get().getUpdateTime().toString();
            log.info(result.get().toString());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return resultMessage;
    }

    public String updateInvestment(Investment investment, String uuid) {
        String resultMessage;
        ApiFuture<WriteResult> result =getInvestmentCollection().document(uuid).set(investment, SetOptions.merge());
        try {
            resultMessage = result.get().getUpdateTime().toString();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return resultMessage;
    }
}
