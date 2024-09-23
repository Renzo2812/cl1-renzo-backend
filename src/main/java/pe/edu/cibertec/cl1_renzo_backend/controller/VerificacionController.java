package pe.edu.cibertec.cl1_renzo_backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.cl1_renzo_backend.dto.BuscarRequestDTO;
import pe.edu.cibertec.cl1_renzo_backend.dto.BuscarResponseDTO;
import pe.edu.cibertec.cl1_renzo_backend.service.VerificacionService;

@RestController
@RequestMapping("/verificacion")
public class VerificacionController {

    @Autowired
    VerificacionService verificacionService;

    @PostMapping("/buscar")
    public BuscarResponseDTO buscar (@RequestBody BuscarRequestDTO buscarRequestDTO) {

        try {
            String[] datosVehiculo = verificacionService.validarVehiculo(buscarRequestDTO);
            if(datosVehiculo == null) {
                return new BuscarResponseDTO("1", "Usuario no encontrado", "", "", "", "", "");
            }
            return new BuscarResponseDTO("0", "", datosVehiculo[0], datosVehiculo[1], datosVehiculo[2],
                    datosVehiculo[3], datosVehiculo[4]);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new BuscarResponseDTO("9", "Ha ocurrido un problema", "", "", "", "", "");
        }

    }
}
