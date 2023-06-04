package dev.asheep.charitymanagementapp.controllers;

import dev.asheep.charitymanagementapp.models.Receiver;
import dev.asheep.charitymanagementapp.models.ReceiverType;
import dev.asheep.charitymanagementapp.models.Response;
import dev.asheep.charitymanagementapp.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping("/api/receiver")
public class ReceiverController {
    @Autowired
    private ReceiverService receiverService;

    @PostMapping("")
    public ResponseEntity<Response> createReceiver(@RequestBody Receiver reqReceiver){
        try {
            // Kiem tra trung lap thong tin: theo phoneNumber / docID
            if(receiverService.findByDocId(reqReceiver.getDocId()).size() > 0 || receiverService.findByPhone(reqReceiver.getPhone()).size() > 0 ){
                throw new Exception("Receiver with DocID and PhoneNumber already existed!");
            }
            Receiver newReceiver = receiverService.createReceiver(reqReceiver);
            return ResponseEntity.status(HttpStatus.OK).body(new Response("success", "Create new receiver successfully", ""));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("failed", e.getMessage(), ""));
        }

    }

    @GetMapping("/types")
    public ResponseEntity<Response> getAllReceiverType(){
        try {
            List<ReceiverType> receiverTypeList = receiverService.getAllReceiverType();
            return ResponseEntity.status(HttpStatus.OK).body(new Response("success", "Get all receiver type successfully", receiverTypeList));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("failed", e.getMessage(), ""));
        }

    }

    @GetMapping("")
    //http://localhost:8080/api/receiver?page=0&size=10&sort=id,desc
    public ResponseEntity<Response> getAllReceiver(Pageable pageable){
        try{
            List<Receiver> page = receiverService.getAllReceivers();
            return ResponseEntity.status(HttpStatus.OK).body(new Response("success", "Get all receiver successfully", page));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("failed", e.getMessage(), ""));
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<Response> getById(@PathVariable Integer id){
        Optional<Receiver> receiver = receiverService.getById(id);
        return receiver.isPresent()?
                ResponseEntity.status(HttpStatus.OK).body(new Response("successfully","Query Receiver By ID successfully", receiver)) :
                ResponseEntity.status(HttpStatus.OK).body(new Response("failed","Query Receiver By ID failed", ""));

    }

    @PutMapping("/{id}")
    ResponseEntity<Response> upsertReceiver(@PathVariable Integer id, @RequestBody Receiver updateReceiver){
        Receiver update = receiverService.getById(id)
                .map(receiver -> {
                    return receiverService.updateReceiver(receiver, updateReceiver);
                }).orElseGet(()->{
                    return null;
                });
        return update != null ? ResponseEntity.status(HttpStatus.OK).body(new Response("successfull", "Receiver updated successfully", update)) :
                ResponseEntity.status(HttpStatus.OK).body(new Response("failed", "Receiver not found", ""));

    }

}
