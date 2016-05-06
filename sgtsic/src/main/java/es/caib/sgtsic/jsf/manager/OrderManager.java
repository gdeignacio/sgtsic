package es.caib.sgtsic.jsf.manager;

import com.google.common.collect.Maps;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.Map;
import org.primefaces.model.SortOrder;

@ManagedBean(name="orderManagerBack")
@ViewScoped
public class OrderManager implements Serializable {

    protected static Log log = LogFactory.getLog(OrderManager.class);

    /* ORDERS */
    private Map<String, SortOrder> sortOrdersMarca = Maps.newHashMapWithExpectedSize(1);
    private Map<String, SortOrder> sortOrdersProveedor = Maps.newHashMapWithExpectedSize(1);
    private Map<String, SortOrder> sortOrdersProducto = Maps.newHashMapWithExpectedSize(1);
    private Map<String, SortOrder> sortOrdersReferencia = Maps.newHashMapWithExpectedSize(1);
    private Map<String, SortOrder> sortOrdersUsuario = Maps.newHashMapWithExpectedSize(1);
    private Map<String, SortOrder> sortOrdersSolicitud = Maps.newHashMapWithExpectedSize(1);
    private Map<String, SortOrder> sortOrdersPedido = Maps.newHashMapWithExpectedSize(1);
    private Map<String, SortOrder> sortOrdersStock = Maps.newHashMapWithExpectedSize(1);
    private Map<String, SortOrder> sortOrdersContrato = Maps.newHashMapWithExpectedSize(1);
    private Map<String, SortOrder> sortOrdersFactura = Maps.newHashMapWithExpectedSize(1);
    private Map<String, SortOrder> sortOrdersFacturaPedido = Maps.newHashMapWithExpectedSize(1);
    private String sortPropertyMarca;
    private String sortPropertyProveedor;
    private String sortPropertyProducto;
    private String sortPropertyReferencia;
    private String sortPropertyUsuario;
    private String sortPropertySolicitud;
    private String sortPropertyPedido;
    private String sortPropertyStock;
    private String sortPropertyContrato;
    private String sortPropertyFactura;
    private String sortPropertyFacturaPedido;

    @PostConstruct
    public void initManager() {
        sortOrdersMarca.put("nombre", SortOrder.UNSORTED);

        sortOrdersProveedor.put("nombre", SortOrder.UNSORTED);
        sortOrdersProveedor.put("cif", SortOrder.UNSORTED);
        sortOrdersProveedor.put("direccion", SortOrder.UNSORTED);
        sortOrdersProveedor.put("telefonoEmpresa", SortOrder.UNSORTED);
        sortOrdersProveedor.put("emailEmpresa", SortOrder.UNSORTED);
        sortOrdersProveedor.put("numCliente", SortOrder.UNSORTED);

        sortOrdersProducto.put("nombre", SortOrder.UNSORTED);
        sortOrdersProducto.put("descripcion", SortOrder.UNSORTED);
        sortOrdersProducto.put("codigoInterno", SortOrder.UNSORTED);
        sortOrdersProducto.put("area", SortOrder.UNSORTED);
        sortOrdersProducto.put("grupo", SortOrder.UNSORTED);
        sortOrdersProducto.put("ubicacion", SortOrder.UNSORTED);

        sortOrdersUsuario.put("nombre", SortOrder.UNSORTED);
        sortOrdersUsuario.put("apellido1", SortOrder.UNSORTED);
        sortOrdersUsuario.put("apellido2", SortOrder.UNSORTED);
        sortOrdersUsuario.put("nif", SortOrder.UNSORTED);
        sortOrdersUsuario.put("email", SortOrder.UNSORTED);
        sortOrdersUsuario.put("usuarioCaib", SortOrder.UNSORTED);

        sortOrdersSolicitud.put("producto", SortOrder.UNSORTED);
        sortOrdersSolicitud.put("referencia", SortOrder.UNSORTED);
        sortOrdersSolicitud.put("codigoInterno", SortOrder.UNSORTED);
        sortOrdersSolicitud.put("usuario", SortOrder.UNSORTED);
        sortOrdersSolicitud.put("fecha", SortOrder.UNSORTED);
        sortOrdersSolicitud.put("unidades", SortOrder.UNSORTED);
        sortOrdersSolicitud.put("presentacion", SortOrder.UNSORTED);
        sortOrdersSolicitud.put("proveedor", SortOrder.UNSORTED);
        sortOrdersSolicitud.put("marca", SortOrder.UNSORTED);

        sortOrdersPedido.put("numeroPedido", SortOrder.UNSORTED);
        sortOrdersPedido.put("contrato", SortOrder.UNSORTED);
        sortOrdersPedido.put("proveedor", SortOrder.UNSORTED);
        sortOrdersPedido.put("estado", SortOrder.UNSORTED);
        sortOrdersPedido.put("estadoFactura", SortOrder.UNSORTED);
        sortOrdersPedido.put("usuarioAlta", SortOrder.UNSORTED);
        sortOrdersPedido.put("fechaAlta", SortOrder.UNSORTED);
        sortOrdersPedido.put("usuarioValida", SortOrder.UNSORTED);
        sortOrdersPedido.put("fechaValidaPedido", SortOrder.UNSORTED);
        sortOrdersPedido.put("usuarioCertifica", SortOrder.UNSORTED);
        sortOrdersPedido.put("fechaCertificaPedido", SortOrder.UNSORTED);
        sortOrdersPedido.put("fechaJefeDepartamento", SortOrder.UNSORTED);
        sortOrdersPedido.put("fechaUac", SortOrder.UNSORTED);
        sortOrdersPedido.put("fechaEnvioProveedor", SortOrder.UNSORTED);
        sortOrdersPedido.put("fechaEnvioUge", SortOrder.UNSORTED);
        sortOrdersPedido.put("precioTotalSinIva", SortOrder.UNSORTED);
        sortOrdersPedido.put("precioTotalConIva", SortOrder.UNSORTED);
        sortOrdersPedido.put("portesSinIva", SortOrder.UNSORTED);
        sortOrdersPedido.put("portesConIva", SortOrder.UNSORTED);

        sortOrdersReferencia.put("referencia", SortOrder.UNSORTED);
        sortOrdersReferencia.put("codigoInterno", SortOrder.UNSORTED);
        sortOrdersReferencia.put("producto", SortOrder.UNSORTED);
        sortOrdersReferencia.put("proveedor", SortOrder.UNSORTED);
        sortOrdersReferencia.put("marca", SortOrder.UNSORTED);

        sortOrdersStock.put("loteInterno", SortOrder.UNSORTED);
        sortOrdersStock.put("producto", SortOrder.UNSORTED);
        sortOrdersStock.put("referencia", SortOrder.UNSORTED);
        sortOrdersStock.put("codigoInterno", SortOrder.UNSORTED);
        sortOrdersStock.put("proveedor", SortOrder.UNSORTED);
        sortOrdersStock.put("precioEnvase", SortOrder.UNSORTED);
        sortOrdersStock.put("unidades", SortOrder.UNSORTED);
        sortOrdersStock.put("numPedidoNormalizado", SortOrder.UNSORTED);
        sortOrdersStock.put("fechaEntrada", SortOrder.UNSORTED);
        sortOrdersStock.put("receptor", SortOrder.UNSORTED);
        sortOrdersStock.put("loteExterno", SortOrder.UNSORTED);
        sortOrdersStock.put("caducidad", SortOrder.UNSORTED);
        sortOrdersStock.put("fechaAceptacion", SortOrder.UNSORTED);
        sortOrdersStock.put("fechaApertura", SortOrder.UNSORTED);
        sortOrdersStock.put("fechaBaja", SortOrder.UNSORTED);

        sortOrdersContrato.put("numeroContrato", SortOrder.UNSORTED);
        sortOrdersContrato.put("lote", SortOrder.UNSORTED);
        sortOrdersContrato.put("proveedor", SortOrder.UNSORTED);
        sortOrdersContrato.put("fechaAutorizacion", SortOrder.UNSORTED);
        sortOrdersContrato.put("fechaFinal", SortOrder.UNSORTED);
        sortOrdersContrato.put("importe", SortOrder.UNSORTED);
        sortOrdersContrato.put("importeDisponible", SortOrder.UNSORTED);

        sortOrdersContrato.put("numeroFactura", SortOrder.UNSORTED);
        sortOrdersContrato.put("importe", SortOrder.UNSORTED);
        sortOrdersContrato.put("fecha", SortOrder.UNSORTED);
        sortOrdersContrato.put("numContrato", SortOrder.UNSORTED);
        sortOrdersContrato.put("proveedor", SortOrder.UNSORTED);
        sortOrdersContrato.put("isla", SortOrder.UNSORTED);

        sortOrdersFacturaPedido.put("numeroPedido", SortOrder.UNSORTED);
        sortOrdersFacturaPedido.put("importe", SortOrder.UNSORTED);
        sortOrdersFacturaPedido.put("fechaJefeDepartamento", SortOrder.UNSORTED);
        sortOrdersFacturaPedido.put("fechaUac", SortOrder.UNSORTED);
        sortOrdersFacturaPedido.put("fechaEnvio", SortOrder.UNSORTED);
        sortOrdersFacturaPedido.put("precioSinIva", SortOrder.UNSORTED);
        sortOrdersFacturaPedido.put("precioConIva", SortOrder.UNSORTED);

    }

    public String valorOrden(String order){
        switch (order) {
            case "ascending": {
                return "ascendente";
            }
            case "descending": {
                return "descendente";
            }
            default: {
                return "sin_orden";
            }
        }
    }

    public void toggleSortMarca() {
        for (Map.Entry<String, SortOrder> entry : sortOrdersMarca.entrySet()) {
            SortOrder newOrder;
            if (entry.getKey().equals(sortPropertyMarca)) {
                if (entry.getValue() == SortOrder.ASCENDING) {
                    newOrder = SortOrder.DESCENDING;
                } else {
                    newOrder = SortOrder.ASCENDING;
                }
            } else {
                newOrder = SortOrder.UNSORTED;
            }
            entry.setValue(newOrder);
        }
    }

    public void toggleSortProveedor() {
        for (Map.Entry<String, SortOrder> entry : sortOrdersProveedor.entrySet()) {
            SortOrder newOrder;
            if (entry.getKey().equals(sortPropertyProveedor)) {
                if (entry.getValue() == SortOrder.ASCENDING) {
                    newOrder = SortOrder.DESCENDING;
                } else {
                    newOrder = SortOrder.ASCENDING;
                }
            } else {
                newOrder = SortOrder.UNSORTED;
            }
            entry.setValue(newOrder);
        }
    }

    public void toggleSortProducto() {
        for (Map.Entry<String, SortOrder> entry : sortOrdersProducto.entrySet()) {
            SortOrder newOrder;
            if (entry.getKey().equals(sortPropertyProducto)) {
                if (entry.getValue() == SortOrder.ASCENDING) {
                    newOrder = SortOrder.DESCENDING;
                } else {
                    newOrder = SortOrder.ASCENDING;
                }
            } else {
                newOrder = SortOrder.UNSORTED;
            }
            entry.setValue(newOrder);
        }
    }

    public void toggleSortReferencia() {
        for (Map.Entry<String, SortOrder> entry : sortOrdersReferencia.entrySet()) {
            SortOrder newOrder;
            if (entry.getKey().equals(sortPropertyReferencia)) {
                if (entry.getValue() == SortOrder.ASCENDING) {
                    newOrder = SortOrder.DESCENDING;
                } else {
                    newOrder = SortOrder.ASCENDING;
                }
            } else {
                newOrder = SortOrder.UNSORTED;
            }
            entry.setValue(newOrder);
        }
    }

    public void toggleSortUsuario() {
        for (Map.Entry<String, SortOrder> entry : sortOrdersUsuario.entrySet()) {
            SortOrder newOrder;
            if (entry.getKey().equals(sortPropertyUsuario)) {
                if (entry.getValue() == SortOrder.ASCENDING) {
                    newOrder = SortOrder.DESCENDING;
                } else {
                    newOrder = SortOrder.ASCENDING;
                }
            } else {
                newOrder = SortOrder.UNSORTED;
            }
            entry.setValue(newOrder);
        }
    }

    public void toggleSortSolicitud() {
        for (Map.Entry<String, SortOrder> entry : sortOrdersSolicitud.entrySet()) {
            SortOrder newOrder;
            if (entry.getKey().equals(sortPropertySolicitud)) {
                if (entry.getValue() == SortOrder.ASCENDING) {
                    newOrder = SortOrder.DESCENDING;
                } else {
                    newOrder = SortOrder.ASCENDING;
                }
            } else {
                newOrder = SortOrder.UNSORTED;
            }
            entry.setValue(newOrder);
        }
    }

    public void toggleSortPedido() {
        for (Map.Entry<String, SortOrder> entry : sortOrdersPedido.entrySet()) {
            SortOrder newOrder;
            if (entry.getKey().equals(sortPropertyPedido)) {
                if (entry.getValue() == SortOrder.ASCENDING) {
                    newOrder = SortOrder.DESCENDING;
                } else {
                    newOrder = SortOrder.ASCENDING;
                }
            } else {
                newOrder = SortOrder.UNSORTED;
            }
            entry.setValue(newOrder);
        }
    }

    public void toggleSortStock() {
        for (Map.Entry<String, SortOrder> entry : sortOrdersStock.entrySet()) {
            SortOrder newOrder;
            if (entry.getKey().equals(sortPropertyStock)) {
                if (entry.getValue() == SortOrder.ASCENDING) {
                    newOrder = SortOrder.DESCENDING;
                } else {
                    newOrder = SortOrder.ASCENDING;
                }
            } else {
                newOrder = SortOrder.UNSORTED;
            }
            entry.setValue(newOrder);
        }
    }

    public void toggleSortContrato() {
        for (Map.Entry<String, SortOrder> entry : sortOrdersContrato.entrySet()) {
            SortOrder newOrder;
            if (entry.getKey().equals(sortPropertyContrato)) {
                if (entry.getValue() == SortOrder.ASCENDING) {
                    newOrder = SortOrder.DESCENDING;
                } else {
                    newOrder = SortOrder.ASCENDING;
                }
            } else {
                newOrder = SortOrder.UNSORTED;
            }
            entry.setValue(newOrder);
        }
    }

    public void toggleSortFactura() {
        for (Map.Entry<String, SortOrder> entry : sortOrdersFactura.entrySet()) {
            SortOrder newOrder;
            if (entry.getKey().equals(sortPropertyFactura)) {
                if (entry.getValue() == SortOrder.ASCENDING) {
                    newOrder = SortOrder.DESCENDING;
                } else {
                    newOrder = SortOrder.ASCENDING;
                }
            } else {
                newOrder = SortOrder.UNSORTED;
            }
            entry.setValue(newOrder);
        }
    }

    public void toggleSortFacturaPedido() {
        for (Map.Entry<String, SortOrder> entry : sortOrdersFacturaPedido.entrySet()) {
            SortOrder newOrder;
            if (entry.getKey().equals(sortPropertyFacturaPedido)) {
                if (entry.getValue() == SortOrder.ASCENDING) {
                    newOrder = SortOrder.DESCENDING;
                } else {
                    newOrder = SortOrder.ASCENDING;
                }
            } else {
                newOrder = SortOrder.UNSORTED;
            }
            entry.setValue(newOrder);
        }
    }

    // CONSTRUCTOR ------
    public OrderManager(){
    }

    /*** GET SET ***/
    public Map<String, SortOrder> getSortOrdersMarca() {
        return sortOrdersMarca;
    }

    public void setSortOrdersMarca(Map<String, SortOrder> sortOrdersMarca) {
        this.sortOrdersMarca = sortOrdersMarca;
    }

    public String getSortPropertyMarca() {
        return sortPropertyMarca;
    }

    public void setSortPropertyMarca(String sortPropertyMarca) {
        this.sortPropertyMarca = sortPropertyMarca;
    }

    public String getSortPropertyProveedor() {
        return sortPropertyProveedor;
    }

    public void setSortPropertyProveedor(String sortPropertyProveedor) {
        this.sortPropertyProveedor = sortPropertyProveedor;
    }

    public Map<String, SortOrder> getSortOrdersProveedor() {
        return sortOrdersProveedor;
    }

    public void setSortOrdersProveedor(Map<String, SortOrder> sortOrdersProveedor) {
        this.sortOrdersProveedor = sortOrdersProveedor;
    }

    public Map<String, SortOrder> getSortOrdersProducto() {
        return sortOrdersProducto;
    }

    public void setSortOrdersProducto(Map<String, SortOrder> sortOrdersProducto) {
        this.sortOrdersProducto = sortOrdersProducto;
    }

    public String getSortPropertyProducto() {
        return sortPropertyProducto;
    }

    public void setSortPropertyProducto(String sortPropertyProducto) {
        this.sortPropertyProducto = sortPropertyProducto;
    }

    public Map<String, SortOrder> getSortOrdersUsuario() {
        return sortOrdersUsuario;
    }

    public void setSortOrdersUsuario(Map<String, SortOrder> sortOrdersUsuario) {
        this.sortOrdersUsuario = sortOrdersUsuario;
    }

    public String getSortPropertyUsuario() {
        return sortPropertyUsuario;
    }

    public void setSortPropertyUsuario(String sortPropertyUsuario) {
        this.sortPropertyUsuario = sortPropertyUsuario;
    }

    public String getSortPropertySolicitud() {
        return sortPropertySolicitud;
    }

    public void setSortPropertySolicitud(String sortPropertySolicitud) {
        this.sortPropertySolicitud = sortPropertySolicitud;
    }

    public Map<String, SortOrder> getSortOrdersSolicitud() {
        return sortOrdersSolicitud;
    }

    public void setSortOrdersSolicitud(Map<String, SortOrder> sortOrdersSolicitud) {
        this.sortOrdersSolicitud = sortOrdersSolicitud;
    }

    public Map<String, SortOrder> getSortOrdersPedido() {
        return sortOrdersPedido;
    }

    public void setSortOrdersPedido(Map<String, SortOrder> sortOrdersPedido) {
        this.sortOrdersPedido = sortOrdersPedido;
    }

    public String getSortPropertyPedido() {
        return sortPropertyPedido;
    }

    public void setSortPropertyPedido(String sortPropertyPedido) {
        this.sortPropertyPedido = sortPropertyPedido;
    }

    public Map<String, SortOrder> getSortOrdersReferencia() {
        return sortOrdersReferencia;
    }

    public void setSortOrdersReferencia(Map<String, SortOrder> sortOrdersReferencia) {
        this.sortOrdersReferencia = sortOrdersReferencia;
    }

    public String getSortPropertyReferencia() {
        return sortPropertyReferencia;
    }

    public void setSortPropertyReferencia(String sortPropertyReferencia) {
        this.sortPropertyReferencia = sortPropertyReferencia;
    }

    public Map<String, SortOrder> getSortOrdersStock() {
        return sortOrdersStock;
    }

    public void setSortOrdersStock(Map<String, SortOrder> sortOrdersStock) {
        this.sortOrdersStock = sortOrdersStock;
    }

    public String getSortPropertyStock() {
        return sortPropertyStock;
    }

    public void setSortPropertyStock(String sortPropertyStock) {
        this.sortPropertyStock = sortPropertyStock;
    }

    public Map<String, SortOrder> getSortOrdersContrato() {
        return sortOrdersContrato;
    }

    public void setSortOrdersContrato(Map<String, SortOrder> sortOrdersContrato) {
        this.sortOrdersContrato = sortOrdersContrato;
    }

    public Map<String, SortOrder> getSortOrdersFactura() {
        return sortOrdersFactura;
    }

    public void setSortOrdersFactura(Map<String, SortOrder> sortOrdersFactura) {
        this.sortOrdersFactura = sortOrdersFactura;
    }

    public String getSortPropertyContrato() {
        return sortPropertyContrato;
    }

    public void setSortPropertyContrato(String sortPropertyContrato) {
        this.sortPropertyContrato = sortPropertyContrato;
    }

    public String getSortPropertyFactura() {
        return sortPropertyFactura;
    }

    public void setSortPropertyFactura(String sortPropertyFactura) {
        this.sortPropertyFactura = sortPropertyFactura;
    }

    public Map<String, SortOrder> getSortOrdersFacturaPedido() {
        return sortOrdersFacturaPedido;
    }

    public void setSortOrdersFacturaPedido(Map<String, SortOrder> sortOrdersFacturaPedido) {
        this.sortOrdersFacturaPedido = sortOrdersFacturaPedido;
    }

    public String getSortPropertyFacturaPedido() {
        return sortPropertyFacturaPedido;
    }

    public void setSortPropertyFacturaPedido(String sortPropertyFacturaPedido) {
        this.sortPropertyFacturaPedido = sortPropertyFacturaPedido;
    }
}



