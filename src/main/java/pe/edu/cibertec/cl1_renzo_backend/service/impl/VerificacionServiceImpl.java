package pe.edu.cibertec.cl1_renzo_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.cl1_renzo_backend.dto.BuscarRequestDTO;
import pe.edu.cibertec.cl1_renzo_backend.service.VerificacionService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@Service
public class VerificacionServiceImpl implements VerificacionService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] validarVehiculo(BuscarRequestDTO buscarRequestDTO) throws IOException{

        String[] datosVehiculo = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (buscarRequestDTO.placa().equals(datos[1])) {
                    datosVehiculo = new String[5];
                    datosVehiculo[0] = datos[2]; // Marca
                    datosVehiculo[1] = datos[3]; // Modelo
                    datosVehiculo[2] = datos[4]; // Asientos
                    datosVehiculo[3] = datos[5]; // Costo
                    datosVehiculo[4] = datos[6]; // Color
                }
            }
        } catch (IOException e) {
            datosVehiculo = null;
            throw new IOException(e);
        }

        return datosVehiculo;
    }

}
