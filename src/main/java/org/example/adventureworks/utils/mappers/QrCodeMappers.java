package org.example.adventureworks.utils.mappers;

import org.example.adventureworks.models.dto.Request.qrcode.QrCodeCreateRequest;
import org.example.adventureworks.models.dto.Request.qrcode.QrCodeUpdateRequest;
import org.example.adventureworks.models.dto.Response.qrcode.QrcodeResponse;
import org.example.adventureworks.models.entities.QrCode;

import java.security.PublicKey;
import java.util.List;

public class QrCodeMappers {

    public static QrCode ToEntityCreate(QrCodeCreateRequest qrCodeCreateRequest) {
        return QrCode.builder()
                .time(qrCodeCreateRequest.getTime())
                .active(qrCodeCreateRequest.getActive())
                .code(qrCodeCreateRequest.getCode())
                .build();
    }
    public  static QrcodeResponse ToDto(QrCode qrCode) {
        return QrcodeResponse.builder()
                .id(qrCode.getId())
                .time(qrCode.getTime())
                .active(qrCode.isActive())
                .code(qrCode.getCode())
                .build();
    }
    public  static QrCode ToEntityUpdate(QrCodeUpdateRequest qrCodeReques) {
        return QrCode.builder()
                .id(qrCodeReques.getId())
                .time(qrCodeReques.getTime())
                .active(qrCodeReques.isActive()) //al ser boolean se usa isActive
                .code(qrCodeReques.getCode())
                .build();
    }

    public static List<QrcodeResponse> ToDTOList(List<QrCode> allQRCodes) {
        return allQRCodes.stream().map(QrCodeMappers::ToDto).toList();
    }
}
