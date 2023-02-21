package com.tgdevelops.wealthmate.controllers;

import com.tgdevelops.wealthmate.models.Investment;
import com.tgdevelops.wealthmate.services.InvestmentService;
import com.tgdevelops.wealthmate.template.ResponseTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/investments")
public class InvestmentController {
    private static final Logger log = LogManager.getLogger(InvestmentController.class);
    @Autowired
    private final InvestmentService investmentService;
    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }
    @PostMapping(value="/add",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<ResponseTemplate> createInvestment(@RequestBody Investment investmentPayload,
                                              @RequestHeader("Authorization") String authToken) throws ExecutionException, InterruptedException {

        String response = investmentService.addInvestment(investmentPayload);
        return new ResponseEntity<>(getResponseTemplate(response), HttpStatus.CREATED);
    }

    @DeleteMapping(value="/delete",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<ResponseTemplate> deleteInvestment(@RequestParam(value="id") String uuid,
                                                             @RequestHeader("Authorization") String authToken) throws ExecutionException, InterruptedException {

        String response = investmentService.deleteInvestment(uuid);
        return new ResponseEntity<>(getResponseTemplate(response), HttpStatus.CREATED);
    }

    @PostMapping(value="/update",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<ResponseTemplate> updateInvestment(@RequestParam(value="id") String uuid,
                                                             @RequestBody Investment investment,
                                                             @RequestHeader("Authorization") String authToken) throws ExecutionException, InterruptedException {

        String response = investmentService.deleteInvestment(uuid);
        return new ResponseEntity<>(getResponseTemplate(response), HttpStatus.CREATED);
    }

    private boolean isValidAuthToken(String authToken) {
        // TODO: Implement authentication token validation
        return true;
    }

    private ResponseTemplate getResponseTemplate(String response){
        ResponseTemplate responseTemplate;
        if(!response.contains("error")){
            responseTemplate = new ResponseTemplate("Success",response);
        }else{
            responseTemplate = new ResponseTemplate("Failed", response);
        }
        return  responseTemplate;
    }
}


