package org.example.adventureworks.controllers;

import jakarta.validation.Valid;
import org.example.adventureworks.models.dto.Request.qrcode.QrCodeCreateRequest;
import org.example.adventureworks.models.dto.Response.GeneralResponse;
import org.example.adventureworks.models.dto.Response.qrcode.QrcodeResponse;
import org.example.adventureworks.models.dto.Request.qrcode.QrCodeUpdateRequest;
import org.example.adventureworks.service.QrCodeService;
import org.example.adventureworks.utils.ResponseBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qrcodes")
public class QrCodeController {
    @Autowired
    private QrCodeService qrCodeService;

    @PostMapping("/generate")
    public ResponseEntity<GeneralResponse> generateQRCode(@Valid @RequestBody QrCodeCreateRequest qrCodeCreateRequest){
        QrcodeResponse qrCode = qrCodeService.generateQrCode(qrCodeCreateRequest);
        return ResponseBuilderUtil.buildResponse("Codigo QR se generado correctamente", HttpStatus.CREATED,qrCodeCreateRequest);
    }
    @GetMapping("/find-by-code/{code}")
    public ResponseEntity<GeneralResponse> findByCode(@PathVariable String code){
        QrcodeResponse qrCode = qrCodeService.findByCode(code);
        return ResponseBuilderUtil.buildResponse("Codigo QR encontrado", HttpStatus.OK, qrCode);
    }
    @PutMapping("/updateQr")
    public ResponseEntity<GeneralResponse> updateQrInformation(@Valid @RequestBody QrCodeUpdateRequest qrCodeUpdateRequest){
        QrcodeResponse updatedQrCode = qrCodeService.QrCodeUpdate(qrCodeUpdateRequest);
        return ResponseBuilderUtil.buildResponse("Codigo QR actualizado correctamente", HttpStatus.OK, updatedQrCode);
    }
    @DeleteMapping("/delete/{code}")
    public ResponseEntity<GeneralResponse> deleteQRCode(@PathVariable String code){
        String message = qrCodeService.delete(code);
        return ResponseBuilderUtil.buildResponse(message, HttpStatus.OK, null);
    }
    @GetMapping("/all-qrcodes")
    public ResponseEntity<GeneralResponse> getAllQRCodes(){
        return ResponseBuilderUtil.buildResponse("Lista de Codigos QR", HttpStatus.OK, qrCodeService.getAll() );
    }
}
