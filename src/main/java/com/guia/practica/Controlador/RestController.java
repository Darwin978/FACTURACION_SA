package com.guia.practica.Controlador;

import com.guia.practica.DTO.FacturaDTO;
import com.guia.practica.Modelos.*;
import com.guia.practica.Repositorios.*;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@OpenAPIDefinition(
        info = @Info(
                title = "Facturación API",
                version = "1.0",
                description = "EJERCICIO PRACTICO FACTURACIÓN",
                contact = @Contact(name = "DGONZALEZ", url = "https://codmind.com", email = "gdarwin75@gmail.com"),
                license = @License(name = "LICENSE", url = "LICENSE URL")
        ),
        servers = @Server(url = "http://localhost:8080")
)
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private CompetenciaRepository competenciaRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private RolxCompetenciaRepository rolxCompetenciaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private ClasificacionRepository clasificacionRepository;
    @Autowired
    private ItemFacturaRepository itemFacturaRepository;
    @Autowired
    private TipoPagoRepository tipoPagoRepository;
    @Autowired
    private FacturaRepository facturaRepository;

    @GetMapping("/users")
    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/tipos_pago")
    public List<TipoPago> getAllTipoPago() {
        return tipoPagoRepository.findAll();
    }
    @GetMapping("/clasificacion")
    public List<Clasificacion> getAllClasificacion() {
        return clasificacionRepository.findAll();
    }
    @GetMapping("/competencia")
    public List<Competencia> getAllCompetencia() {
        return competenciaRepository.findAll();
    }
    @GetMapping("/facturas")
    public List<Factura> getAllFacturas() {
        return facturaRepository.findAll();
    }
    @GetMapping("/items_facturas")
    public List<ItemFactura> getAllItemsFacturas() {
        return itemFacturaRepository.findAll();
    }
    @GetMapping("/personas")
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }
    @GetMapping("/producto")
    public List<Producto> getAllProdcutos() {
        return productoRepository.findAll();
    }
    @GetMapping("/proveedores")
    public List<Proveedores> getAllProveedores() {
        return proveedorRepository.findAll();
    }
    @GetMapping("/roles")
    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

    @Autowired
    private FacturaControler facturaControler;
    @PostMapping("/save_factura")
    public Object ItemFac(@RequestBody FacturaDTO facturaDto){
        return facturaControler.createFactura(facturaDto);
    }

    @PutMapping("/update_factura")
    public Object updteFactura(@RequestBody FacturaDTO facturaDto){
        return facturaControler.updateFactutra(facturaDto);
    }

    @DeleteMapping("/delete_factura")
    public Object delete(@RequestBody Integer idfactura){
        return facturaControler.deleteFactura(idfactura);
    }

    @PostMapping("/save_user")
    public Usuario saveUser(@RequestBody  Usuario usuario){
        return usuarioRepository.save(usuario);
    }


}
