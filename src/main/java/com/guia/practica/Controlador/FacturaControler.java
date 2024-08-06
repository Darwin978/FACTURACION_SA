package com.guia.practica.Controlador;

import com.guia.practica.DTO.FacturaDTO;
import com.guia.practica.Modelos.Factura;
import com.guia.practica.Modelos.ItemFactura;
import com.guia.practica.Modelos.Persona;
import com.guia.practica.Modelos.TipoPago;
import com.guia.practica.Repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FacturaControler {
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private TipoPagoRepository tipoPagoRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ItemFacturaRepository itemFacturaRepository;

    public Object createFactura(FacturaDTO facturaDto){
        Factura factura = new Factura();
        factura.setIdFactura(facturaDto.getId_factura());
        factura.setRuc(facturaDto.getRuc());
        factura.setFecha(facturaDto.getFecha());
        factura.setDescuento(facturaDto.getDescuento());
        factura.setTotal(facturaDto.getTotal());

        List<ItemFactura> listItems = new ArrayList<>();
        TipoPago tipoPago = tipoPagoRepository.findByIdTipoPago(facturaDto.getIdTipoPago());
        Persona persona = personaRepository.findByIdPersona(facturaDto.getIdPersona());

        factura.setTipoPago(tipoPago);
        factura.setPersonaFactura(persona);

        facturaRepository.save(factura);
        ItemFactura itemFactura = new ItemFactura();
        facturaDto.getIdItems().forEach(item -> {
            itemFactura.setFactura(factura);
            itemFactura.setPrecio(item.getPrecio());
            itemFactura.setCantidad(item.getCantidad());
            itemFactura.setSubtotal(item.getSubtotal());
            itemFactura.setIdProducto(productoRepository.findByIdProducto(item.getIdProducto()));
            itemFacturaRepository.save(itemFactura);
        });


        return factura;
    }
    public Object updateFactutra (FacturaDTO facturaDto){
        if ( null != facturaRepository.findByIdFactura(facturaDto.getId_factura())) {
            Factura factura = new Factura();
            factura.setIdFactura(facturaDto.getId_factura());
            factura.setRuc(facturaDto.getRuc());
            factura.setFecha(facturaDto.getFecha());
            factura.setDescuento(facturaDto.getDescuento());
            factura.setTotal(facturaDto.getTotal());

            List<ItemFactura> listItems = new ArrayList<>();
            TipoPago tipoPago = tipoPagoRepository.findByIdTipoPago(facturaDto.getIdTipoPago());
            Persona persona = personaRepository.findByIdPersona(facturaDto.getIdPersona());

            factura.setTipoPago(tipoPago);
            factura.setPersonaFactura(persona);

            facturaRepository.save(factura);
            ItemFactura itemFactura = new ItemFactura();
            facturaDto.getIdItems().forEach(item -> {
                itemFactura.setFactura(factura);
                itemFactura.setPrecio(item.getPrecio());
                itemFactura.setCantidad(item.getCantidad());
                itemFactura.setSubtotal(item.getSubtotal());
                itemFactura.setIdProducto(productoRepository.findByIdProducto(item.getIdProducto()));
                itemFacturaRepository.save(itemFactura);
            });


            return factura;
        }else {
            return "La Factura no Existe";
        }
    }

    public Object deleteFactura(Integer idFactura){
        if ( null != facturaRepository.findByIdFactura(idFactura)) {
            Factura factura = facturaRepository.findByIdFactura(idFactura);
            facturaRepository.delete(factura);
            return "Eliminacion correcta";
        }else {
            return "La Factura no Existe";
        }
    }
}
