package com.guia.practica.Controlador;

import com.guia.practica.Modelos.*;
import com.guia.practica.Repositorios.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneralControler {
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
    @Autowired
    private RolxUsuarioRepository rolxUsuarioRepository;

    @PostConstruct
    public void loadData() {
        Competencia post = new Competencia(1,"POST", "Capacidad de crear datos.");
        Competencia put = new Competencia(2, "PUT", "Edicion de datos ");
        Competencia read = new Competencia(3, "GET", "Listar de datos ");
        Competencia delete = new Competencia(4, "DELETE", "Eliminar de datos");


        competenciaRepository.save(post);
        competenciaRepository.save(put);
        competenciaRepository.save(read);
        competenciaRepository.save(delete);

        Rol admin = new Rol(1, "admin", true);
        Rol visualizador = new Rol(2, "visor", true);
        Rol auditor = new Rol(3, "auditor", false);

        rolRepository.save(admin);
        rolRepository.save(visualizador);
        rolRepository.save(auditor);

        RolxCompetencia competenciaPost = new RolxCompetencia(1, admin, post);
        RolxCompetencia competenciaPut = new RolxCompetencia(2, admin, put);
        RolxCompetencia competenciaGet = new RolxCompetencia(3, admin, read);
        RolxCompetencia competenciaDelete = new RolxCompetencia(4, admin, delete);
        RolxCompetencia competenciaLector = new RolxCompetencia(5, visualizador, read);
        RolxCompetencia competenciaAuditor = new RolxCompetencia(6, auditor, read);

        rolxCompetenciaRepository.save(competenciaPost);
        rolxCompetenciaRepository.save(competenciaPut);
        rolxCompetenciaRepository.save(competenciaGet);
        rolxCompetenciaRepository.save(competenciaDelete);
        rolxCompetenciaRepository.save(competenciaLector);
        rolxCompetenciaRepository.save(competenciaAuditor);

        Persona persona = new Persona(1, "Darwin", "González", "0105975031", "0939054932", "gdarwin75@gmail.com");

        personaRepository.save(persona);
        List<Rol> rolList = new ArrayList<>();
        rolList.add(admin);
        rolList.add(visualizador);
        rolList.add(auditor);
        Usuario usuarioAdmin = new Usuario(1, "darwin978", "1234", persona);

        usuarioRepository.save(usuarioAdmin);

        RolxUsuario rolxUsuario = new RolxUsuario(1, usuarioAdmin, admin);
        rolxUsuarioRepository.save(rolxUsuario);

        Proveedores proveedores = new Proveedores(1, "0105975031001", "072485441", "Ecuador", "proveedor1@gmail.com", "USD");
        proveedorRepository.save(proveedores);

        Clasificacion lacteos = new Clasificacion(1, "LACTEOS");
        Clasificacion carnicos = new Clasificacion(2, "CARNICOS");
        Clasificacion varios = new Clasificacion(3, "VARIOS");

        clasificacionRepository.save(lacteos);
        clasificacionRepository.save(carnicos);
        clasificacionRepository.save(varios);

        TipoPago efectivo = new TipoPago(1, "EFECTIVO", "PAGO EN EFECTIVO");
        TipoPago cheque = new TipoPago(2, "CHEQUE", "PAGO CON CHEQUE");
        TipoPago transferencia = new TipoPago(3, "TRANSFERENCIA", "PAGO CON USO DEL SISTEMA BANCARIO");

        tipoPagoRepository.save(efectivo);
        tipoPagoRepository.save(cheque);
        tipoPagoRepository.save(transferencia);

        Producto leche = new Producto(1, 10, 10, "LITRO", false, proveedores, lacteos);
        Producto cafe = new Producto(2, 5, 6, "LIBRAS", true, proveedores, varios);
        Producto huevos = new Producto(3, 50, 0.12, "UNIDADES", false, proveedores, varios);

        productoRepository.save(leche);
        productoRepository.save(cafe);
        productoRepository.save(huevos);
    }
}
