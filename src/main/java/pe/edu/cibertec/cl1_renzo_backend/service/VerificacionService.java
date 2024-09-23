package pe.edu.cibertec.cl1_renzo_backend.service;
import pe.edu.cibertec.cl1_renzo_backend.dto.BuscarRequestDTO;
import java.io.IOException;

public interface VerificacionService {

    String[] validarVehiculo(BuscarRequestDTO buscarRequestDTO) throws IOException;

}
