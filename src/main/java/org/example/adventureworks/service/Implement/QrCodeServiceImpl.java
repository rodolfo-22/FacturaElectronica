package org.example.adventureworks.service.Implement;

import org.example.adventureworks.models.dto.Request.qrcode.QrCodeCreateRequest;
import org.example.adventureworks.models.dto.Response.qrcode.QrcodeResponse;
import org.example.adventureworks.service.QrCodeService;

import java.util.List;

public class QrCodeServiceImpl implements QrCodeService {
    @Override
    public QrcodeResponse generateQrCode(QrCodeCreateRequest text) {

        return null;
    }

    @Override
    public QrcodeResponse findByCode(String code) {
        return null;
    }

    @Override
    public String delete(String code) {
        return "";
    }

    @Override
    public List<QrcodeResponse> getAll() {
        return List.of();
    }
}
