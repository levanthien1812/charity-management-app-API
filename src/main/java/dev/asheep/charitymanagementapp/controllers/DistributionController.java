package dev.asheep.charitymanagementapp.controllers;

import com.google.api.client.json.Json;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.asheep.charitymanagementapp.models.Distribution;
import dev.asheep.charitymanagementapp.models.DistributionList;
import dev.asheep.charitymanagementapp.models.Receiver;
import dev.asheep.charitymanagementapp.models.Response;
import dev.asheep.charitymanagementapp.service.DistributionService;
import dev.asheep.charitymanagementapp.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@CrossOrigin
@RequestMapping("/api/distribution")
public class DistributionController {

    @PostMapping("")
    public ResponseEntity<Response> createReceiver(@RequestBody DistributionList distributionReq){
        return null;
    }
}
