package dev.asheep.charitymanagementapp.controllers;

import dev.asheep.charitymanagementapp.models.TransferFrom;
import dev.asheep.charitymanagementapp.service.TransferFromService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/transfer-from")
public class TransferFromController {
    @Autowired
    private TransferFromService transferFromService;
    @PostMapping
    public ResponseEntity<?> add (@RequestBody TransferFrom transferFrom) {
        TransferFrom newTransferFrom = transferFromService.createTransferFrom(transferFrom);
        return ResponseEntity.ok(newTransferFrom);
    }
}
