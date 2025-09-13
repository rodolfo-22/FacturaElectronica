package org.example.adventureworks.service;

import org.example.adventureworks.models.dto.Request.qrcode.QrCodeCreateRequest;
import org.example.adventureworks.models.dto.Request.qrcode.QrCodeUpdateRequest;
import org.example.adventureworks.models.dto.Response.qrcode.QrcodeResponse;

import java.util.List;

public interface QrCodeService {
    QrcodeResponse generateQrCode(QrCodeCreateRequest text);
    QrcodeResponse findByCode(String code);
    QrcodeResponse QrCodeUpdate(QrCodeUpdateRequest informationCode);
    String delete(String code);
    List<QrcodeResponse> getAll();
}
