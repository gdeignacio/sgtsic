package es.caib.sgtsic.jsf.manager;


import es.caib.sgtsic.util.Strings;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.Locale;
import org.primefaces.model.filter.FilterConstraint;


@ManagedBean(name="filterManagerBack")
@ViewScoped
public class FilterManager implements Serializable {

    protected static Log log = LogFactory.getLog(FilterManager.class);

    /* FILTERS */
    public String valorFiltroMarcaNombre="";

    public String valorFiltroProveedorNombre="";
    public String valorFiltroProveedorCif="";
    public String valorFiltroProveedorDireccion="";
    public String valorFiltroProveedorTelefonoEmpresa="";
    public String valorFiltroProveedorEmailEmpresa="";
    public String valorFiltroProveedorNumCliente="";

    public String valorFiltroProductoNombre="";
    public String valorFiltroProductoDescripcion="";
    public String valorFiltroProductoCodigoInterno="";
    public String valorFiltroProductoArea="";
    public String valorFiltroProductoGrupo="";
    public String valorFiltroProductoUbicacion="";

    public String valorFiltroUsuarioNombre="";
    public String valorFiltroUsuarioApellido1="";
    public String valorFiltroUsuarioApellido2="";
    public String valorFiltroUsuarioNif="";
    public String valorFiltroUsuarioEmail="";
    public String valorFiltroUsuarioUsuarioCaib="";

    public String valorFiltroSolicitudProducto="";
    public String valorFiltroSolicitudReferencia="";
    public String valorFiltroSolicitudCodigoInterno="";
    public String valorFiltroSolicitudUnidades="";
    public String valorFiltroSolicitudProveedor="";
    public String valorFiltroSolicitudMarca="";
    public String valorFiltroSolicitudNumEnvases="";

    public String valorFiltroPedidoNumero="";
    public String valorFiltroPedidoContrato="";
    public String valorFiltroPedidoProveedor="";
    public String valorFiltroPedidoEstado="";
    public String valorFiltroPedidoEstadoFactura="";

    public String valorFiltroReferencia="";
    public String valorFiltroReferenciaCodigoInterno="";
    public String valorFiltroReferenciaProducto="";
    public String valorFiltroReferenciaProveedor="";
    public String valorFiltroReferenciaMarca="";

    public String valorFiltroStockLoteInterno="";
    public String valorFiltroStockProducto="";
    public String valorFiltroStockReferencia="";
    public String valorFiltroStockCodigoInterno="";
    public String valorFiltroStockUnidades="";
    public String valorFiltroStockPedido="";
    public String valorFiltroStockLoteExterno="";
    public String valorFiltroStockProveedor="";

    public String valorFiltroContratoNumero="";
    public String valorFiltroContratoLote="";
    public String valorFiltroContratoProveedor="";
    public String valorFiltroContratoImporte="";
    public String valorFiltroContratoImporteDisponible="";

    public String valorFiltroFacturaNumero="";
    public String valorFiltroFacturaImporte="";
    public String valorFiltroFacturaFecha="";
    public String valorFiltroFacturaNumeroContrato="";
    public String valorFiltroFacturaProveedor="";

    public String valorFiltroFacturaPedidoNumeroPedido="";

    @PostConstruct
    public void initManager() {
    }

    // CONSTRUCTOR ------
    public FilterManager(){
    }

    
    
    public FilterConstraint getFiltroContieneSinAcentos() {
        return new FilterConstraint() {

            @Override
            public boolean applies(Object value, Object filter, Locale locale) {
                
                String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase(locale);
                
                String vacia = org.primefaces.util.Constants.EMPTY_STRING;
                
                if (filterText == null || org.primefaces.util.Constants.EMPTY_STRING.equals(filterText)){
                    return true;
                }
                
                if (value == null){
                    return false;
                }
                
                
                
                String valor = Strings.quitarAcentos(value.toString().toLowerCase(locale));
                String filtro = Strings.quitarAcentos(filter.toString().toLowerCase(locale));
                
                return valor.contains(filtro);
            
            }           
        };
    }
    
    
   
    
    /*
    
    public Filter<Marca> getFiltroMarcaNombre() {

        return new Filter<GlaMarca>() {
            @Override
            public boolean accept(GlaMarca currentMarca) {

                if(valorFiltroMarcaNombre!=null) {
                    if (valorFiltroMarcaNombre.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentMarca.getNombre()!=null) {
                    String original = StringUtil.quitarAcentos(currentMarca.getNombre().toLowerCase());
                    String filtro =  StringUtil.quitarAcentos(valorFiltroMarcaNombre.toLowerCase());

                    if (original.contains(filtro)) {
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        };
    }

    public Filter<GlaProveedor> getFiltroProveedorNombre() {
        return new Filter<GlaProveedor>() {
            @Override
            public boolean accept(GlaProveedor currentProveedor) {

                if(valorFiltroProveedorNombre!=null) {
                    if (valorFiltroProveedorNombre.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentProveedor.getNombre()!=null) {
                    String original = StringUtil.quitarAcentos(currentProveedor.getNombre().toLowerCase());
                    String filtro =  StringUtil.quitarAcentos(valorFiltroProveedorNombre.toLowerCase());

                    if (original.contains(filtro)) {
                        return true;
                    }else {
                        return false;
                    } }else {
                    return false;
                }
            }
        };
    }

    public Filter<GlaProducto> getFiltroProductoNombre() {
        return new Filter<GlaProducto>() {
            @Override
            public boolean accept(GlaProducto currentProducto) {

                if(valorFiltroProductoNombre!=null) {
                    if (valorFiltroProductoNombre.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentProducto.getNombre()!=null) {
                    String original = StringUtil.quitarAcentos(currentProducto.getNombre().toLowerCase());
                    String filtro =  StringUtil.quitarAcentos(valorFiltroProductoNombre.toLowerCase());

                    if (original.contains(filtro)) {
                        return true;
                    }else {
                        return false;
                    } }else {
                    return false;
                }
            }
        };
    }

    public Filter<GlaProducto> getFiltroProductoDescripcion() {
        return new Filter<GlaProducto>() {
            @Override
            public boolean accept(GlaProducto currentProducto) {

                if(valorFiltroProductoDescripcion!=null) {
                    if (valorFiltroProductoDescripcion.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentProducto.getDescripcion()!=null) {
                    String original = StringUtil.quitarAcentos(currentProducto.getDescripcion().toLowerCase());
                    String filtro =  StringUtil.quitarAcentos(valorFiltroProductoDescripcion.toLowerCase());

                    if (original.contains(filtro)) {
                        return true;
                    }else {
                        return false;
                    } }else {
                    return false;
                }
            }
        };
    }

    public Filter<GlaProducto> getFiltroProductoArea() {
        return new Filter<GlaProducto>() {
            @Override
            public boolean accept(GlaProducto currentProducto) {

                if(valorFiltroProductoArea!=null) {
                    if (valorFiltroProductoArea.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentProducto.getArea()!=null) {
                    String original = StringUtil.quitarAcentos(currentProducto.getArea().getNombre().toLowerCase());
                    String filtro =  StringUtil.quitarAcentos(valorFiltroProductoArea.toLowerCase());

                    if (original.contains(filtro)) {
                        return true;
                    }else {
                        return false;
                    } }else {
                    return false;
                }
            }
        };
    }

    public Filter<GlaProducto> getFiltroProductoGrupo() {
        return new Filter<GlaProducto>() {
            @Override
            public boolean accept(GlaProducto currentProducto) {

                if(valorFiltroProductoGrupo!=null) {
                    if (valorFiltroProductoGrupo.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentProducto.getGrupo()!=null) {
                    String original = StringUtil.quitarAcentos(currentProducto.getGrupo().getNombre().toLowerCase());
                    String filtro =  StringUtil.quitarAcentos(valorFiltroProductoGrupo.toLowerCase());

                    if (original.contains(filtro)) {
                        return true;
                    }else {
                        return false;
                    } }else {
                    return false;
                }
            }
        };
    }

    public Filter<GlaUsuario> getFiltroUsuarioNombre() {

        return new Filter<GlaUsuario>() {
            @Override
            public boolean accept(GlaUsuario currentUsuario) {

                if(valorFiltroUsuarioNombre!=null) {
                    if (valorFiltroUsuarioNombre.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentUsuario.getNombre()!=null) {
                    String original = StringUtil.quitarAcentos(currentUsuario.getNombre().toLowerCase());
                    String filtro =  StringUtil.quitarAcentos(valorFiltroUsuarioNombre.toLowerCase());

                    if (original.contains(filtro)) {
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        };
    }

    public Filter<GlaUsuario> getFiltroUsuarioApellido1() {

        return new Filter<GlaUsuario>() {
            @Override
            public boolean accept(GlaUsuario currentUsuario) {

                if(valorFiltroUsuarioApellido1!=null) {
                    if (valorFiltroUsuarioApellido1.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentUsuario.getApellido1()!=null) {
                    String original = StringUtil.quitarAcentos(currentUsuario.getApellido1().toLowerCase());
                    String filtro =  StringUtil.quitarAcentos(valorFiltroUsuarioApellido1.toLowerCase());

                    if (original.contains(filtro)) {
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        };
    }

    public Filter<GlaUsuario> getFiltroUsuarioApellido2() {

        return new Filter<GlaUsuario>() {
            @Override
            public boolean accept(GlaUsuario currentUsuario) {

                if(valorFiltroUsuarioApellido2!=null) {
                    if (valorFiltroUsuarioApellido2.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentUsuario.getApellido2()!=null) {
                    String original = StringUtil.quitarAcentos(currentUsuario.getApellido2().toLowerCase());
                    String filtro =  StringUtil.quitarAcentos(valorFiltroUsuarioApellido2.toLowerCase());

                    if (original.contains(filtro)) {
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        };
    }

    public Filter<GlaPedidoReferencia> getFiltroSolicitudProducto() {

        return new Filter<GlaPedidoReferencia>() {
            @Override
            public boolean accept(GlaPedidoReferencia currentSolicitud) {

                if(valorFiltroSolicitudProducto!=null) {
                    if (valorFiltroSolicitudProducto.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentSolicitud.getReferencia()!=null) {
                    if(currentSolicitud.getReferencia().getProducto()!=null) {
                        String original = StringUtil.quitarAcentos(currentSolicitud.getReferencia().getProducto().getNombre().toLowerCase());
                        String filtro =  StringUtil.quitarAcentos(valorFiltroSolicitudProducto.toLowerCase());

                        if (original.contains(filtro)) {
                            return true;
                        }else {
                            return false;
                        }
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        };
    }

    public Filter<GlaPedidoReferencia> getFiltroSolicitudReferencia() {
        return new Filter<GlaPedidoReferencia>() {
            @Override
            public boolean accept(GlaPedidoReferencia currentSolicitud) {

                if(valorFiltroSolicitudReferencia!=null) {
                    if (valorFiltroSolicitudReferencia.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentSolicitud.getReferencia()!=null) {
                    String original = StringUtil.quitarAcentos(currentSolicitud.getReferencia().getNombre().toLowerCase());
                    String filtro =  StringUtil.quitarAcentos(valorFiltroSolicitudReferencia.toLowerCase());

                    if (original.contains(filtro)) {
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        };
    }


    public Filter<GlaPedidoReferencia> getFiltroSolicitudProveedor() {
        return new Filter<GlaPedidoReferencia>() {
            @Override
            public boolean accept(GlaPedidoReferencia currentSolicitud) {

                if(valorFiltroSolicitudProveedor!=null) {
                    if (valorFiltroSolicitudProveedor.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentSolicitud.getReferencia()!=null) {
                    if(currentSolicitud.getReferencia().getProveedor()!=null) {
                        String original = StringUtil.quitarAcentos(currentSolicitud.getReferencia().getProveedor().getNombre().toLowerCase());
                        String filtro =  StringUtil.quitarAcentos(valorFiltroSolicitudProveedor.toLowerCase());

                        if (original.contains(filtro)) {
                            return true;
                        }else {
                            return false;
                        }
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        };
    }

    public Filter<GlaPedidoReferencia> getFiltroSolicitudMarca() {
        return new Filter<GlaPedidoReferencia>() {
            @Override
            public boolean accept(GlaPedidoReferencia currentSolicitud) {

                if(valorFiltroSolicitudMarca!=null) {
                    if (valorFiltroSolicitudMarca.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentSolicitud.getReferencia()!=null) {
                    if(currentSolicitud.getReferencia().getMarca()!=null) {
                        String original = StringUtil.quitarAcentos(currentSolicitud.getReferencia().getMarca().getNombre().toLowerCase());
                        String filtro =  StringUtil.quitarAcentos(valorFiltroSolicitudMarca.toLowerCase());

                        if (original.contains(filtro)) {
                            return true;
                        }else {
                            return false;
                        }
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        };
    }

    public Filter<GlaPedido> getFiltroPedidoProveedor() {
        return new Filter<GlaPedido>() {
            @Override
            public boolean accept(GlaPedido currentPedido) {

                if(valorFiltroPedidoProveedor!=null) {
                    if (valorFiltroPedidoProveedor.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentPedido.getProveedor()!=null) {
                    String original = StringUtil.quitarAcentos(currentPedido.getProveedor().getNombre().toLowerCase());
                    String filtro =  StringUtil.quitarAcentos(valorFiltroPedidoProveedor.toLowerCase());

                    if (original.contains(filtro)) {
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        };
    }

    public Filter<GlaReferencia> getFiltroReferenciaProducto() {

        return new Filter<GlaReferencia>() {
            @Override
            public boolean accept(GlaReferencia currentReferencia) {

                if(valorFiltroReferenciaProducto!=null) {
                    if (valorFiltroReferenciaProducto.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentReferencia!=null) {
                    if(currentReferencia.getProducto()!=null) {
                        String original = StringUtil.quitarAcentos(currentReferencia.getProducto().getNombre().toLowerCase());
                        String filtro =  StringUtil.quitarAcentos(valorFiltroReferenciaProducto.toLowerCase());

                        if (original.contains(filtro)) {
                            return true;
                        }else {
                            return false;
                        }
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        };
    }

    public Filter<GlaReferencia> getFiltroReferenciaProveedor() {
        return new Filter<GlaReferencia>() {
            @Override
            public boolean accept(GlaReferencia currentReferencia) {

                if(valorFiltroReferenciaProveedor!=null) {
                    if (valorFiltroReferenciaProveedor.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentReferencia!=null) {
                    if(currentReferencia.getProveedor()!=null) {
                        String original = StringUtil.quitarAcentos(currentReferencia.getProveedor().getNombre().toLowerCase());
                        String filtro =  StringUtil.quitarAcentos(valorFiltroReferenciaProveedor.toLowerCase());

                        if (original.contains(filtro)) {
                            return true;
                        }else {
                            return false;
                        }
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        };
    }

    public Filter<GlaReferencia> getFiltroReferenciaMarca() {
        return new Filter<GlaReferencia>() {
            @Override
            public boolean accept(GlaReferencia currentReferencia) {

                if(valorFiltroReferenciaMarca!=null) {
                    if (valorFiltroReferenciaMarca.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentReferencia!=null) {
                    if(currentReferencia.getMarca()!=null) {
                        String original = StringUtil.quitarAcentos(currentReferencia.getMarca().getNombre().toLowerCase());
                        String filtro =  StringUtil.quitarAcentos(valorFiltroReferenciaMarca.toLowerCase());

                        if (original.contains(filtro)) {
                            return true;
                        }else {
                            return false;
                        }
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        };
    }

    public Filter<GlaStock> getFiltroStockProducto() {
        return new Filter<GlaStock>() {
            @Override
            public boolean accept(GlaStock currentStock) {

                if(valorFiltroStockProducto!=null) {
                    if (valorFiltroStockProducto.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentStock.getProducto()!=null) {
                    String original = StringUtil.quitarAcentos(currentStock.getProducto().getNombre().toLowerCase());
                    String filtro =  StringUtil.quitarAcentos(valorFiltroStockProducto.toLowerCase());
                    if (original.contains(filtro)) {
                        return true;
                    }else {
                        return false;
                    } }else {
                    return false;
                }
            }
        };
    }

    public Filter<GlaStock> getFiltroStockProveedor() {
        return new Filter<GlaStock>() {
            @Override
            public boolean accept(GlaStock currentStock) {

                if(valorFiltroStockProveedor!=null) {
                    if (valorFiltroStockProveedor.length()==0) {
                        return true;
                    }
                } else {
                    return true;
                }
                if(currentStock.getProducto()!=null) {
                    String original = StringUtil.quitarAcentos(currentStock.getReferencia().getProveedor().getNombre().toLowerCase());
                    String filtro =  StringUtil.quitarAcentos(valorFiltroStockProveedor.toLowerCase());
                    if (original.contains(filtro)) {
                        return true;
                    }else {
                        return false;
                    } }else {
                    return false;
                }
            }
        };
    }
    

    */
    
    
    public String getValorFiltroProductoGrupo() {
        return valorFiltroProductoGrupo;
    }

    public void setValorFiltroProductoGrupo(String valorFiltroProductoGrupo) {
        this.valorFiltroProductoGrupo = valorFiltroProductoGrupo;
    }

    public String getValorFiltroMarcaNombre() {
        return valorFiltroMarcaNombre;
    }

    public void setValorFiltroMarcaNombre(String valorFiltroMarcaNombre) {
        this.valorFiltroMarcaNombre = valorFiltroMarcaNombre;
    }

    public String getValorFiltroProveedorNombre() {
        return valorFiltroProveedorNombre;
    }

    public void setValorFiltroProveedorNombre(String valorFiltroProveedorNombre) {
        this.valorFiltroProveedorNombre = valorFiltroProveedorNombre;
    }

    public String getValorFiltroProveedorCif() {
        return valorFiltroProveedorCif;
    }

    public void setValorFiltroProveedorCif(String valorFiltroProveedorCif) {
        this.valorFiltroProveedorCif = valorFiltroProveedorCif;
    }

    public String getValorFiltroProveedorDireccion() {
        return valorFiltroProveedorDireccion;
    }

    public void setValorFiltroProveedorDireccion(String valorFiltroProveedorDireccion) {
        this.valorFiltroProveedorDireccion = valorFiltroProveedorDireccion;
    }

    public String getValorFiltroProveedorTelefonoEmpresa() {
        return valorFiltroProveedorTelefonoEmpresa;
    }

    public void setValorFiltroProveedorTelefonoEmpresa(String valorFiltroProveedorTelefonoEmpresa) {
        this.valorFiltroProveedorTelefonoEmpresa = valorFiltroProveedorTelefonoEmpresa;
    }

    public String getValorFiltroProveedorEmailEmpresa() {
        return valorFiltroProveedorEmailEmpresa;
    }

    public void setValorFiltroProveedorEmailEmpresa(String valorFiltroProveedorEmailEmpresa) {
        this.valorFiltroProveedorEmailEmpresa = valorFiltroProveedorEmailEmpresa;
    }

    public String getValorFiltroProveedorNumCliente() {
        return valorFiltroProveedorNumCliente;
    }

    public void setValorFiltroProveedorNumCliente(String valorFiltroProveedorNumCliente) {
        this.valorFiltroProveedorNumCliente = valorFiltroProveedorNumCliente;
    }

    public String getValorFiltroProductoNombre() {
        return valorFiltroProductoNombre;
    }

    public void setValorFiltroProductoNombre(String valorFiltroProductoNombre) {
        this.valorFiltroProductoNombre = valorFiltroProductoNombre;
    }

    public String getValorFiltroProductoDescripcion() {
        return valorFiltroProductoDescripcion;
    }

    public void setValorFiltroProductoDescripcion(String valorFiltroProductoDescripcion) {
        this.valorFiltroProductoDescripcion = valorFiltroProductoDescripcion;
    }

    public String getValorFiltroProductoCodigoInterno() {
        return valorFiltroProductoCodigoInterno;
    }

    public void setValorFiltroProductoCodigoInterno(String valorFiltroProductoCodigoInterno) {
        this.valorFiltroProductoCodigoInterno = valorFiltroProductoCodigoInterno;
    }

    public String getValorFiltroProductoArea() {
        return valorFiltroProductoArea;
    }

    public void setValorFiltroProductoArea(String valorFiltroProductoArea) {
        this.valorFiltroProductoArea = valorFiltroProductoArea;
    }

    public String getValorFiltroProductoUbicacion() {
        return valorFiltroProductoUbicacion;
    }

    public void setValorFiltroProductoUbicacion(String valorFiltroProductoUbicacion) {
        this.valorFiltroProductoUbicacion = valorFiltroProductoUbicacion;
    }

    public String getValorFiltroUsuarioNombre() {
        return valorFiltroUsuarioNombre;
    }

    public void setValorFiltroUsuarioNombre(String valorFiltroUsuarioNombre) {
        this.valorFiltroUsuarioNombre = valorFiltroUsuarioNombre;
    }

    public String getValorFiltroUsuarioApellido1() {
        return valorFiltroUsuarioApellido1;
    }

    public void setValorFiltroUsuarioApellido1(String valorFiltroUsuarioApellido1) {
        this.valorFiltroUsuarioApellido1 = valorFiltroUsuarioApellido1;
    }

    public String getValorFiltroUsuarioApellido2() {
        return valorFiltroUsuarioApellido2;
    }

    public void setValorFiltroUsuarioApellido2(String valorFiltroUsuarioApellido2) {
        this.valorFiltroUsuarioApellido2 = valorFiltroUsuarioApellido2;
    }

    public String getValorFiltroUsuarioNif() {
        return valorFiltroUsuarioNif;
    }

    public void setValorFiltroUsuarioNif(String valorFiltroUsuarioNif) {
        this.valorFiltroUsuarioNif = valorFiltroUsuarioNif;
    }

    public String getValorFiltroUsuarioEmail() {
        return valorFiltroUsuarioEmail;
    }

    public void setValorFiltroUsuarioEmail(String valorFiltroUsuarioEmail) {
        this.valorFiltroUsuarioEmail = valorFiltroUsuarioEmail;
    }

    public String getValorFiltroUsuarioUsuarioCaib() {
        return valorFiltroUsuarioUsuarioCaib;
    }

    public void setValorFiltroUsuarioUsuarioCaib(String valorFiltroUsuarioUsuarioCaib) {
        this.valorFiltroUsuarioUsuarioCaib = valorFiltroUsuarioUsuarioCaib;
    }

    public String getValorFiltroSolicitudProducto() {
        return valorFiltroSolicitudProducto;
    }

    public void setValorFiltroSolicitudProducto(String valorFiltroSolicitudProducto) {
        this.valorFiltroSolicitudProducto = valorFiltroSolicitudProducto;
    }

    public String getValorFiltroSolicitudReferencia() {
        return valorFiltroSolicitudReferencia;
    }

    public void setValorFiltroSolicitudReferencia(String valorFiltroSolicitudReferencia) {
        this.valorFiltroSolicitudReferencia = valorFiltroSolicitudReferencia;
    }

    public String getValorFiltroSolicitudCodigoInterno() {
        return valorFiltroSolicitudCodigoInterno;
    }

    public void setValorFiltroSolicitudCodigoInterno(String valorFiltroSolicitudCodigoInterno) {
        this.valorFiltroSolicitudCodigoInterno = valorFiltroSolicitudCodigoInterno;
    }

    public String getValorFiltroSolicitudUnidades() {
        return valorFiltroSolicitudUnidades;
    }

    public void setValorFiltroSolicitudUnidades(String valorFiltroSolicitudUnidades) {
        this.valorFiltroSolicitudUnidades = valorFiltroSolicitudUnidades;
    }

    public String getValorFiltroSolicitudProveedor() {
        return valorFiltroSolicitudProveedor;
    }

    public void setValorFiltroSolicitudProveedor(String valorFiltroSolicitudProveedor) {
        this.valorFiltroSolicitudProveedor = valorFiltroSolicitudProveedor;
    }

    public String getValorFiltroSolicitudMarca() {
        return valorFiltroSolicitudMarca;
    }

    public void setValorFiltroSolicitudMarca(String valorFiltroSolicitudMarca) {
        this.valorFiltroSolicitudMarca = valorFiltroSolicitudMarca;
    }

    public String getValorFiltroSolicitudNumEnvases() {
        return valorFiltroSolicitudNumEnvases;
    }

    public void setValorFiltroSolicitudNumEnvases(String valorFiltroSolicitudNumEnvases) {
        this.valorFiltroSolicitudNumEnvases = valorFiltroSolicitudNumEnvases;
    }

    public String getValorFiltroPedidoNumero() {
        return valorFiltroPedidoNumero;
    }

    public void setValorFiltroPedidoNumero(String valorFiltroPedidoNumero) {
        this.valorFiltroPedidoNumero = valorFiltroPedidoNumero;
    }

    public String getValorFiltroPedidoContrato() {
        return valorFiltroPedidoContrato;
    }

    public void setValorFiltroPedidoContrato(String valorFiltroPedidoContrato) {
        this.valorFiltroPedidoContrato = valorFiltroPedidoContrato;
    }

    public String getValorFiltroPedidoProveedor() {
        return valorFiltroPedidoProveedor;
    }

    public void setValorFiltroPedidoProveedor(String valorFiltroPedidoProveedor) {
        this.valorFiltroPedidoProveedor = valorFiltroPedidoProveedor;
    }

    public String getValorFiltroPedidoEstado() {
        return valorFiltroPedidoEstado;
    }

    public void setValorFiltroPedidoEstado(String valorFiltroPedidoEstado) {
        this.valorFiltroPedidoEstado = valorFiltroPedidoEstado;
    }

    public String getValorFiltroReferencia() {
        return valorFiltroReferencia;
    }

    public void setValorFiltroReferencia(String valorFiltroReferencia) {
        this.valorFiltroReferencia = valorFiltroReferencia;
    }

    public String getValorFiltroReferenciaCodigoInterno() {
        return valorFiltroReferenciaCodigoInterno;
    }

    public void setValorFiltroReferenciaCodigoInterno(String valorFiltroReferenciaCodigoInterno) {
        this.valorFiltroReferenciaCodigoInterno = valorFiltroReferenciaCodigoInterno;
    }

    public String getValorFiltroReferenciaProducto() {
        return valorFiltroReferenciaProducto;
    }

    public void setValorFiltroReferenciaProducto(String valorFiltroReferenciaProducto) {
        this.valorFiltroReferenciaProducto = valorFiltroReferenciaProducto;
    }

    public String getValorFiltroReferenciaProveedor() {
        return valorFiltroReferenciaProveedor;
    }

    public void setValorFiltroReferenciaProveedor(String valorFiltroReferenciaProveedor) {
        this.valorFiltroReferenciaProveedor = valorFiltroReferenciaProveedor;
    }

    public String getValorFiltroReferenciaMarca() {
        return valorFiltroReferenciaMarca;
    }

    public void setValorFiltroReferenciaMarca(String valorFiltroReferenciaMarca) {
        this.valorFiltroReferenciaMarca = valorFiltroReferenciaMarca;
    }

    public String getValorFiltroStockLoteInterno() {
        return valorFiltroStockLoteInterno;
    }

    public void setValorFiltroStockLoteInterno(String valorFiltroStockLoteInterno) {
        this.valorFiltroStockLoteInterno = valorFiltroStockLoteInterno;
    }

    public String getValorFiltroStockProducto() {
        return valorFiltroStockProducto;
    }

    public void setValorFiltroStockProducto(String valorFiltroStockProducto) {
        this.valorFiltroStockProducto = valorFiltroStockProducto;
    }

    public String getValorFiltroStockReferencia() {
        return valorFiltroStockReferencia;
    }

    public void setValorFiltroStockReferencia(String valorFiltroStockReferencia) {
        this.valorFiltroStockReferencia = valorFiltroStockReferencia;
    }

    public String getValorFiltroStockUnidades() {
        return valorFiltroStockUnidades;
    }

    public void setValorFiltroStockUnidades(String valorFiltroStockUnidades) {
        this.valorFiltroStockUnidades = valorFiltroStockUnidades;
    }

    public String getValorFiltroStockPedido() {
        return valorFiltroStockPedido;
    }

    public void setValorFiltroStockPedido(String valorFiltroStockPedido) {
        this.valorFiltroStockPedido = valorFiltroStockPedido;
    }

    public String getValorFiltroStockLoteExterno() {
        return valorFiltroStockLoteExterno;
    }

    public void setValorFiltroStockLoteExterno(String valorFiltroStockLoteExterno) {
        this.valorFiltroStockLoteExterno = valorFiltroStockLoteExterno;
    }

    public String getValorFiltroContratoNumero() {
        return valorFiltroContratoNumero;
    }

    public void setValorFiltroContratoNumero(String valorFiltroContratoNumero) {
        this.valorFiltroContratoNumero = valorFiltroContratoNumero;
    }

    public String getValorFiltroContratoLote() {
        return valorFiltroContratoLote;
    }

    public void setValorFiltroContratoLote(String valorFiltroContratoLote) {
        this.valorFiltroContratoLote = valorFiltroContratoLote;
    }

    public String getValorFiltroContratoProveedor() {
        return valorFiltroContratoProveedor;
    }

    public void setValorFiltroContratoProveedor(String valorFiltroContratoProveedor) {
        this.valorFiltroContratoProveedor = valorFiltroContratoProveedor;
    }

    public String getValorFiltroContratoImporte() {
        return valorFiltroContratoImporte;
    }

    public void setValorFiltroContratoImporte(String valorFiltroContratoImporte) {
        this.valorFiltroContratoImporte = valorFiltroContratoImporte;
    }

    public String getValorFiltroContratoImporteDisponible() {
        return valorFiltroContratoImporteDisponible;
    }

    public void setValorFiltroContratoImporteDisponible(String valorFiltroContratoImporteDisponible) {
        this.valorFiltroContratoImporteDisponible = valorFiltroContratoImporteDisponible;
    }

    public String getValorFiltroFacturaNumero() {
        return valorFiltroFacturaNumero;
    }

    public void setValorFiltroFacturaNumero(String valorFiltroFacturaNumero) {
        this.valorFiltroFacturaNumero = valorFiltroFacturaNumero;
    }

    public String getValorFiltroFacturaImporte() {
        return valorFiltroFacturaImporte;
    }

    public void setValorFiltroFacturaImporte(String valorFiltroFacturaImporte) {
        this.valorFiltroFacturaImporte = valorFiltroFacturaImporte;
    }

    public String getValorFiltroFacturaFecha() {
        return valorFiltroFacturaFecha;
    }

    public void setValorFiltroFacturaFecha(String valorFiltroFacturaFecha) {
        this.valorFiltroFacturaFecha = valorFiltroFacturaFecha;
    }

    public String getValorFiltroFacturaNumeroContrato() {
        return valorFiltroFacturaNumeroContrato;
    }

    public void setValorFiltroFacturaNumeroContrato(String valorFiltroFacturaNumeroContrato) {
        this.valorFiltroFacturaNumeroContrato = valorFiltroFacturaNumeroContrato;
    }

    public String getValorFiltroFacturaProveedor() {
        return valorFiltroFacturaProveedor;
    }

    public void setValorFiltroFacturaProveedor(String valorFiltroFacturaProveedor) {
        this.valorFiltroFacturaProveedor = valorFiltroFacturaProveedor;
    }

    public String getValorFiltroFacturaPedidoNumeroPedido() {
        return valorFiltroFacturaPedidoNumeroPedido;
    }

    public void setValorFiltroFacturaPedidoNumeroPedido(String valorFiltroFacturaPedidoNumeroPedido) {
        this.valorFiltroFacturaPedidoNumeroPedido = valorFiltroFacturaPedidoNumeroPedido;
    }

    public String getValorFiltroPedidoEstadoFactura() {
        return valorFiltroPedidoEstadoFactura;
    }

    public void setValorFiltroPedidoEstadoFactura(String valorFiltroPedidoEstadoFactura) {
        this.valorFiltroPedidoEstadoFactura = valorFiltroPedidoEstadoFactura;
    }

    public String getValorFiltroStockCodigoInterno() {
        return valorFiltroStockCodigoInterno;
    }

    public void setValorFiltroStockCodigoInterno(String valorFiltroStockCodigoInterno) {
        this.valorFiltroStockCodigoInterno = valorFiltroStockCodigoInterno;
    }

    public String getValorFiltroStockProveedor() {
        return valorFiltroStockProveedor;
    }

    public void setValorFiltroStockProveedor(String valorFiltroStockProveedor) {
        this.valorFiltroStockProveedor = valorFiltroStockProveedor;
    }
}




