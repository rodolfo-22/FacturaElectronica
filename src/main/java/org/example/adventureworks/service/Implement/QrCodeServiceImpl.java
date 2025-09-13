package org.example.adventureworks.service.Implement;

import lombok.AllArgsConstructor;
import org.example.adventureworks.models.dto.Request.qrcode.QrCodeCreateRequest;
import org.example.adventureworks.models.dto.Request.qrcode.QrCodeUpdateRequest;
import org.example.adventureworks.models.dto.Response.qrcode.QrcodeResponse;
import org.example.adventureworks.repository.QrCodeRepository;
import org.example.adventureworks.service.QrCodeService;
import org.example.adventureworks.utils.mappers.QrCodeMappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QrCodeServiceImpl implements QrCodeService {

    private final QrCodeRepository qrCodeRepository;

    @Override
    public QrcodeResponse generateQrCode(QrCodeCreateRequest qrInfomation) {

        if (qrCodeRepository.findByCode(qrInfomation.getCode()).isPresent()) {
            throw new RuntimeException("El código QR ya existe");
        }

        return QrCodeMappers.ToDto(
                qrCodeRepository.save(
                        QrCodeMappers.ToEntityCreate(qrInfomation)
                )
        );

    }

    @Override
    public QrcodeResponse findByCode(String code) {

        return QrCodeMappers.ToDto(
                qrCodeRepository.findByCode(code).orElseThrow(() -> new RuntimeException("Codigo QR no encontrado"))
        );
    }

    //Lo evalua por id
    @Override
    public QrcodeResponse QrCodeUpdate(QrCodeUpdateRequest informationCode) {

        if (qrCodeRepository.findByCode(informationCode.getCode()) == null)
            throw new RuntimeException("El codigo QR no existe");

        return QrCodeMappers.ToDto(qrCodeRepository.save(QrCodeMappers.ToEntityUpdate(informationCode)));
    }

    @Override
    public String delete(String code) {
        if (qrCodeRepository.findByCode(code) == null) throw new RuntimeException("El codigo QR no existe");
        qrCodeRepository.deleteByCode(code);
        return "Codigo QR eliminado correctamente";
    }

    @Override
    public List<QrcodeResponse> getAll() {
        return QrCodeMappers.ToDTOList(qrCodeRepository.findAll());
    }
}
