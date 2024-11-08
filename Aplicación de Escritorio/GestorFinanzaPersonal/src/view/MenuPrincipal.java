package view;

import gestorfinanzapersonal.Sesion;
import controller.CuentaController;
import controller.DeudaController;
import controller.PresupuestoController;
import controller.TransaccionController;
import controller.UsuarioController;
import model.CuentaModel;
import model.DeudaModel;
import model.PresupuestoModel;
import model.TransaccionModel;
import model.UsuarioModel;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import sound.Sound;

public class MenuPrincipal extends javax.swing.JFrame {

    int moverX, moverY, x, y;
        
    private UsuarioController controladorUsu;
    private PresupuestoController controladorPres;
    private CuentaController controladorCue;
    private TransaccionController controladorTra;
    private DeudaController controladorDeu;
    private Image icono;


    public void SetVistaSesion(UsuarioController ControllerUsuario) {
    initComponents();
    controladorUsu = ControllerUsuario;
    }
    public void SetVistaSesion(PresupuestoController ControllerPresupuesto) {
    initComponents();
    controladorPres = ControllerPresupuesto;
    }
    public void SetVistaSesion(CuentaController ControllerCuenta) {
    initComponents();
    controladorCue = ControllerCuenta;
    }
    public void SetVistaSesion(TransaccionController ControllerTransaccion) {
    initComponents();
    controladorTra = ControllerTransaccion;
    }
    public void SetVistaSesion(DeudaController ControllerDeuda) {
    initComponents();
    controladorDeu = ControllerDeuda;
    }
    
    MenuPrincipal(UsuarioController ControllerUsuario, PresupuestoController ControllerPresupuesto, CuentaController ControllerCuenta, TransaccionController ControllerTransaccion, DeudaController ControllerDeuda) {
        initComponents();
        controladorUsu = ControllerUsuario;
        controladorPres = ControllerPresupuesto;
        controladorCue = ControllerCuenta;
        controladorTra = ControllerTransaccion;
        controladorDeu = ControllerDeuda;
        Sound.playSound("src/sound/change.wav");
        mostrarUsuario();
        Tablas();
        IdTablas();
        obtenerPresupuesto();
        obtenerCuenta();
        obtenerTransaccion();
        obtenerDeuda();
        seleccionarPresupuesto();
        seleccionarCuenta();
        seleccionarTransaccion();
        seleccionarDeuda();
        actualizarTabla();
        imagenes();
    }   
    
    @Override
    public Image getIconImage() {
       if (icono == null) {
        icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/icono.png"));
    }
    return icono;
    }
    
    public ImageIcon ajustarImagen(String rutaImagen, int ancho, int alto) {
    ImageIcon icono = new ImageIcon(getClass().getResource(rutaImagen));
    Image imagen = icono.getImage();
    Image imagenRedimensionada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
    return new ImageIcon(imagenRedimensionada);
}
    
    public void imagenes() {
        LabAgregar.setIcon(ajustarImagen("/icon/boton_agregar.png", 50, 50));
        LabCuenta.setIcon(ajustarImagen("/icon/cuenta_bancaria.png", 38, 38));
        LabTransaccion.setIcon(ajustarImagen("/icon/transaccion.png", 38, 38));
        LabDeuda.setIcon(ajustarImagen("/icon/deuda.png", 38, 38));
        LabSalir.setIcon(ajustarImagen("/icon/salir.png", 38, 38));
        LabPresupuesto.setIcon(ajustarImagen("/icon/presupuesto.png", 38, 38));
    }
   
    public void mostrarUsuario() {
    UsuarioController controladorUsu = new UsuarioController();
    UsuarioModel usuario = controladorUsu.obtenerUsuario();   
    if (usuario != null) {
        LabNombre.setText(usuario.getNombre());
        LabBienvenido.setText("¡Bienvenido(a) " + usuario.getNombre() + "!");
        String letra = usuario.getNombre().substring(0, 1);
        LabUsuario.setText(letra);
        }
    }
    
    private void Tablas() {
        DefaultTableCellRenderer encabezado = new DefaultTableCellRenderer() {
        @Override
        public void setValue(Object value) {
        setBackground(new Color(128, 109, 183));
        setForeground(Color.white);
        setHorizontalAlignment(CENTER);
        Font fuenteNegrita = new Font("Arial", Font.BOLD, 12);
        setFont(fuenteNegrita);
        super.setValue(value);
        }
        };
        
        TablaPresupuesto.getTableHeader().setDefaultRenderer(encabezado);
        TablaPresupuesto.setRowHeight(25);
        
        TablaCuenta.getTableHeader().setDefaultRenderer(encabezado);
        TablaCuenta.setRowHeight(25);
        
        TablaTransaccion.getTableHeader().setDefaultRenderer(encabezado);
        TablaTransaccion.setRowHeight(25);
        
        TablaDeuda.getTableHeader().setDefaultRenderer(encabezado);
        TablaDeuda.setRowHeight(25);
    }
  
    private void IdTablas() {
    TablaPresupuesto.getColumnModel().getColumn(0).setMinWidth(0);
    TablaPresupuesto.getColumnModel().getColumn(0).setMaxWidth(0);
    TablaPresupuesto.getColumnModel().getColumn(0).setWidth(0);
    TxtIdPresupuesto.setVisible(false);
    PanelModificarP.setVisible(false);
        
    TablaCuenta.getColumnModel().getColumn(0).setMinWidth(0);
    TablaCuenta.getColumnModel().getColumn(0).setMaxWidth(0);
    TablaCuenta.getColumnModel().getColumn(0).setWidth(0);
    TxtIdCuenta.setVisible(false);
    PanelModificarC.setVisible(false);
    
    TablaTransaccion.getColumnModel().getColumn(0).setMinWidth(0);
    TablaTransaccion.getColumnModel().getColumn(0).setMaxWidth(0);
    TablaTransaccion.getColumnModel().getColumn(0).setWidth(0);
    TxtIdTransaccion.setVisible(false);
    PanelModificarT.setVisible(false);
        
    TablaDeuda.getColumnModel().getColumn(0).setMinWidth(0);
    TablaDeuda.getColumnModel().getColumn(0).setMaxWidth(0);
    TablaDeuda.getColumnModel().getColumn(0).setWidth(0);
    TxtIdDeuda.setVisible(false);
    PanelModificarD.setVisible(false);
    }
       
    private void obtenerPresupuesto() {
    DefaultTableModel tablaPresupuesto = (DefaultTableModel) TablaPresupuesto.getModel();
    int idUsuario = Sesion.getInstancia().getIdUsuario();
    List<PresupuestoModel> presupuestos = controladorPres.obtenerPresupuesto(idUsuario);
    tablaPresupuesto.setRowCount(0);
    for (PresupuestoModel presupuesto : presupuestos) {
        Object[] fila = { presupuesto.getIdPresupuesto(), presupuesto.getMonto(), presupuesto.getFechaInicio(), presupuesto.getFechaFin() };
        tablaPresupuesto.addRow(fila);
    }
}
    
    private void obtenerCuenta() {
    DefaultTableModel tablaCuenta = (DefaultTableModel) TablaCuenta.getModel();
        int idUsuario = Sesion.getInstancia().getIdUsuario();
        List<CuentaModel> cuentas = controladorCue.obtenerCuenta(idUsuario);
         tablaCuenta.setRowCount(0);
        for (CuentaModel cuenta : cuentas) {
            Object[] fila = { cuenta.getIdCuenta(), cuenta.getNombre(), cuenta.getTipo(), cuenta.getSaldo() };
             tablaCuenta.addRow(fila);
        }
    }

    private void obtenerTransaccion() {
    DefaultTableModel tablaTransaccion = (DefaultTableModel) TablaTransaccion.getModel();
    int idUsuario = Sesion.getInstancia().getIdUsuario();
    List<TransaccionModel> transacciones = controladorTra.obtenerTransaccion(idUsuario);
    tablaTransaccion.setRowCount(0);
    for (TransaccionModel transaccion : transacciones) {
        String nombreCategoria = controladorTra.obtenerNombreCategoria(transaccion.getIdCategoria());
        Object[] fila = { transaccion.getIdTransaccion(), nombreCategoria, transaccion.getFecha(), transaccion.getMonto(), transaccion.getDescripcion(), transaccion.getTipo() };
        tablaTransaccion.addRow(fila);
    }
}

    private void obtenerDeuda() {
    DefaultTableModel tablaDeuda = (DefaultTableModel) TablaDeuda.getModel();
    int idUsuario = Sesion.getInstancia().getIdUsuario();
    List<DeudaModel> deudas = controladorDeu.obtenerDeuda(idUsuario);
    tablaDeuda.setRowCount(0);
    for (DeudaModel deuda : deudas) {
        Object[] fila = { deuda.getIdDeuda(), deuda.getDescripcion(), deuda.getMonto(), deuda.getInteres(), deuda.getPlazo() };
        tablaDeuda.addRow(fila);
    }
}
    
private void seleccionarPresupuesto() { 
    TablaPresupuesto.getSelectionModel().addListSelectionListener(event -> {
        if (!event.getValueIsAdjusting() && TablaPresupuesto.getSelectedRow() != -1) {
            Sound.playSound("src/sound/click.wav");
            int selectedRow = TablaPresupuesto.getSelectedRow();
            TxtIdPresupuesto.setText(TablaPresupuesto.getValueAt(selectedRow, 0).toString());
            TxtMontoPresupuesto.setText(TablaPresupuesto.getValueAt(selectedRow, 1).toString());
            TxtFechaInicial.setText(TablaPresupuesto.getValueAt(selectedRow, 2).toString());
            TxtFechaFinal.setText(TablaPresupuesto.getValueAt(selectedRow, 3).toString());
            PanelModificarP.setVisible(true);
        }
    });
}
    
private void seleccionarCuenta() { 
    TablaCuenta.getSelectionModel().addListSelectionListener(event -> {
        if (!event.getValueIsAdjusting() && TablaCuenta.getSelectedRow() != -1) {
            Sound.playSound("src/sound/click.wav");
            int selectedRow = TablaCuenta.getSelectedRow();
            TxtIdCuenta.setText(TablaCuenta.getValueAt(selectedRow, 0).toString());
            TxtNombreCuenta.setText(TablaCuenta.getValueAt(selectedRow, 1).toString());
            TxtTipoCuenta.setText(TablaCuenta.getValueAt(selectedRow, 2).toString());
            TxtSaldoCuenta.setText(TablaCuenta.getValueAt(selectedRow, 3).toString());
            PanelModificarC.setVisible(true);
        }
    });
}

private void seleccionarTransaccion() {
    TablaTransaccion.getSelectionModel().addListSelectionListener(event -> {
        if (!event.getValueIsAdjusting() && TablaTransaccion.getSelectedRow() != -1) {
            Sound.playSound("src/sound/click.wav");
            int selectedRow = TablaTransaccion.getSelectedRow();
            TxtIdTransaccion.setText(TablaTransaccion.getValueAt(selectedRow, 0).toString());
            BoxCategoria.setSelectedItem(TablaTransaccion.getValueAt(selectedRow, 1).toString());
            TxtFechaTran.setText(TablaTransaccion.getValueAt(selectedRow, 2).toString());
            TxtMontoTran.setText(TablaTransaccion.getValueAt(selectedRow, 3).toString());
            TxtDescripcionTran.setText(TablaTransaccion.getValueAt(selectedRow, 4).toString());
            BoxTipo.setSelectedItem(TablaTransaccion.getValueAt(selectedRow, 5).toString());
            PanelModificarT.setVisible(true);
        }
    });
}
    
private void seleccionarDeuda() {
    TablaDeuda.getSelectionModel().addListSelectionListener(event -> {
        if (!event.getValueIsAdjusting() && TablaDeuda.getSelectedRow() != -1) {
            Sound.playSound("src/sound/click.wav");
            int selectedRow = TablaDeuda.getSelectedRow();
            TxtIdDeuda.setText(TablaDeuda.getValueAt(selectedRow, 0).toString());
            TxtDescripDeuda.setText(TablaDeuda.getValueAt(selectedRow, 1).toString());
            TxtMontoDeuda.setText(TablaDeuda.getValueAt(selectedRow, 2).toString());
            TxtInteresDeuda.setText(TablaDeuda.getValueAt(selectedRow, 3).toString());
            TxtPlazoDeuda.setText(TablaDeuda.getValueAt(selectedRow, 4).toString());
            PanelModificarD.setVisible(true);
        }
    });
}

    private void actualizarTabla() {
        DefaultTableModel tablaPresupuesto = (DefaultTableModel) TablaPresupuesto.getModel();
        tablaPresupuesto.setRowCount(0);
        obtenerPresupuesto();
        
        DefaultTableModel tablaTransaccion = (DefaultTableModel) TablaTransaccion.getModel();
        tablaTransaccion.setRowCount(0);
        obtenerTransaccion();     
        
        DefaultTableModel tablaCuenta = (DefaultTableModel) TablaCuenta.getModel();
        tablaCuenta.setRowCount(0);
        obtenerCuenta();
        
        DefaultTableModel tablaDeuda = (DefaultTableModel) TablaDeuda.getModel();
        tablaDeuda.setRowCount(0);
        obtenerDeuda();        
    }
    
    public void limpiarCampos() {
        Sound.playSound("src/sound/click.wav");
        this.TxtMontoPresupuesto.setText("");
        this.TxtFechaInicial.setText("");
        this.TxtFechaFinal.setText("");
        
        this.TxtNombreCuenta.setText("");
        this.TxtTipoCuenta.setText("");
        this.TxtSaldoCuenta.setText("");  
        
        this.TxtDescripcionTran.setText("");
        this.TxtFechaTran.setText("");
        this.TxtMontoTran.setText("");
        BoxTipo.setSelectedIndex(0);  
        BoxCategoria.setSelectedIndex(0);      
        
        this.TxtDescripDeuda.setText("");
        this.TxtMontoDeuda.setText("");
        this.TxtInteresDeuda.setText("");   
        this.TxtPlazoDeuda.setText("");           
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFondo = new javax.swing.JPanel();
        PanelSuperior = new javax.swing.JPanel();
        LabInicio = new javax.swing.JLabel();
        LabNombre = new javax.swing.JLabel();
        LabUsuario = new swingx.RoundLabel();
        PanelMenu = new javax.swing.JPanel();
        LabPresupuesto = new swingx.RoundLabel();
        LabCuenta = new swingx.RoundLabel();
        LabTransaccion = new swingx.RoundLabel();
        LabDeuda = new swingx.RoundLabel();
        LabSalir = new swingx.RoundLabel();
        PanelVentana = new javax.swing.JPanel();
        PanelInicio = new javax.swing.JPanel();
        LabBienvenido = new javax.swing.JLabel();
        LabMensaje = new javax.swing.JLabel();
        PanelNuevo = new javax.swing.JPanel();
        LabNuevo = new javax.swing.JLabel();
        LabAgregar = new javax.swing.JLabel();
        PanelPresupuesto = new javax.swing.JPanel();
        LabTituloPresupuesto = new javax.swing.JLabel();
        ScrollPresupuesto = new javax.swing.JScrollPane();
        TablaPresupuesto = new javax.swing.JTable();
        PanelModificarP = new swingx.RoundPanel();
        LabMontoP = new javax.swing.JLabel();
        TxtMontoPresupuesto = new javax.swing.JTextField();
        LabFechaInicialP = new javax.swing.JLabel();
        TxtFechaInicial = new javax.swing.JTextField();
        LabFechaFinalP = new javax.swing.JLabel();
        TxtFechaFinal = new javax.swing.JTextField();
        TxtIdPresupuesto = new javax.swing.JTextField();
        BtnModificarPresupuesto = new javax.swing.JButton();
        BtnCancelarPresupuesto = new javax.swing.JButton();
        PanelCuenta = new javax.swing.JPanel();
        LabTituloCuenta = new javax.swing.JLabel();
        ScrollCuenta = new javax.swing.JScrollPane();
        TablaCuenta = new javax.swing.JTable();
        PanelModificarC = new swingx.RoundPanel();
        LabNombreC = new javax.swing.JLabel();
        TxtNombreCuenta = new javax.swing.JTextField();
        LabSaldoC = new javax.swing.JLabel();
        TxtSaldoCuenta = new javax.swing.JTextField();
        TxtIdCuenta = new javax.swing.JTextField();
        TxtTipoCuenta = new javax.swing.JTextField();
        LabTipoC = new javax.swing.JLabel();
        BtnModificarCuenta = new javax.swing.JButton();
        BtnCancelarCuenta = new javax.swing.JButton();
        PanelTransaccion = new javax.swing.JPanel();
        LabTituloTransaccion = new javax.swing.JLabel();
        ScrollTransaccion = new javax.swing.JScrollPane();
        TablaTransaccion = new javax.swing.JTable();
        PanelModificarT = new swingx.RoundPanel();
        BtnModificarTran = new javax.swing.JButton();
        TxtIdTransaccion = new javax.swing.JTextField();
        BoxCategoria = new javax.swing.JComboBox<>();
        LabCategoriaT = new javax.swing.JLabel();
        LabTipoT = new javax.swing.JLabel();
        TxtDescripcionTran = new javax.swing.JTextField();
        LabDescripcionT = new javax.swing.JLabel();
        LabFecha = new javax.swing.JLabel();
        TxtFechaTran = new javax.swing.JTextField();
        TxtMontoTran = new javax.swing.JTextField();
        LabMontoT = new javax.swing.JLabel();
        BtnCancelarTran = new javax.swing.JButton();
        BoxTipo = new javax.swing.JComboBox<>();
        PanelDeuda = new javax.swing.JPanel();
        LabTituloDeuda = new javax.swing.JLabel();
        ScrollDeuda = new javax.swing.JScrollPane();
        TablaDeuda = new javax.swing.JTable();
        PanelModificarD = new swingx.RoundPanel();
        LabDescripcionD = new javax.swing.JLabel();
        TxtDescripDeuda = new javax.swing.JTextField();
        LabInteresD = new javax.swing.JLabel();
        TxtInteresDeuda = new javax.swing.JTextField();
        TxtPlazoDeuda = new javax.swing.JTextField();
        LabPlazoD = new javax.swing.JLabel();
        TxtMontoDeuda = new javax.swing.JTextField();
        LabMontoD = new javax.swing.JLabel();
        BtnModificarDeuda = new javax.swing.JButton();
        TxtIdDeuda = new javax.swing.JTextField();
        BtnCancelarDeuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        PanelFondo.setBackground(new java.awt.Color(254, 221, 185));
        PanelFondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PanelFondoMouseDragged(evt);
            }
        });
        PanelFondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelFondoMousePressed(evt);
            }
        });
        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelSuperior.setBackground(new java.awt.Color(255, 255, 255));
        PanelSuperior.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(228, 55, 68)));
        PanelSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PanelSuperiorMouseDragged(evt);
            }
        });
        PanelSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelSuperiorMousePressed(evt);
            }
        });

        LabInicio.setFont(new java.awt.Font("Bernard MT Condensed", 0, 20)); // NOI18N
        LabInicio.setForeground(new java.awt.Color(84, 70, 82));
        LabInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabInicio.setText("INICIO");
        LabInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabInicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabInicioMouseExited(evt);
            }
        });

        LabNombre.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        LabNombre.setForeground(new java.awt.Color(84, 70, 82));
        LabNombre.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LabNombre.setText("Nombre");
        LabNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabNombreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabNombreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabNombreMouseExited(evt);
            }
        });

        LabUsuario.setBackground(new java.awt.Color(128, 109, 183));
        LabUsuario.setForeground(new java.awt.Color(255, 255, 255));
        LabUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabUsuario.setText("A");
        LabUsuario.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        LabUsuario.setPreferredSize(new java.awt.Dimension(30, 30));
        LabUsuario.setRoundBottomLeft(35);
        LabUsuario.setRoundBottomRight(35);
        LabUsuario.setRoundTopLeft(35);
        LabUsuario.setRoundTopRight(35);
        LabUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabUsuarioMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelSuperiorLayout = new javax.swing.GroupLayout(PanelSuperior);
        PanelSuperior.setLayout(PanelSuperiorLayout);
        PanelSuperiorLayout.setHorizontalGroup(
            PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSuperiorLayout.createSequentialGroup()
                .addComponent(LabInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 828, Short.MAX_VALUE)
                .addComponent(LabNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelSuperiorLayout.setVerticalGroup(
            PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSuperiorLayout.createSequentialGroup()
                .addGroup(PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LabInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LabNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelFondo.add(PanelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 40));

        PanelMenu.setBackground(new java.awt.Color(227, 120, 145));

        LabPresupuesto.setBackground(new java.awt.Color(227, 120, 145));
        LabPresupuesto.setForeground(new java.awt.Color(255, 255, 255));
        LabPresupuesto.setText(" Presupuesto");
        LabPresupuesto.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        LabPresupuesto.setRoundBottomLeft(15);
        LabPresupuesto.setRoundBottomRight(15);
        LabPresupuesto.setRoundTopLeft(15);
        LabPresupuesto.setRoundTopRight(15);
        LabPresupuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabPresupuestoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabPresupuestoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabPresupuestoMouseExited(evt);
            }
        });

        LabCuenta.setBackground(new java.awt.Color(227, 120, 145));
        LabCuenta.setForeground(new java.awt.Color(255, 255, 255));
        LabCuenta.setText(" Cuenta");
        LabCuenta.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        LabCuenta.setRoundBottomLeft(15);
        LabCuenta.setRoundBottomRight(15);
        LabCuenta.setRoundTopLeft(15);
        LabCuenta.setRoundTopRight(15);
        LabCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabCuentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabCuentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabCuentaMouseExited(evt);
            }
        });

        LabTransaccion.setBackground(new java.awt.Color(227, 120, 145));
        LabTransaccion.setForeground(new java.awt.Color(255, 255, 255));
        LabTransaccion.setText(" Transacción");
        LabTransaccion.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        LabTransaccion.setRoundBottomLeft(15);
        LabTransaccion.setRoundBottomRight(15);
        LabTransaccion.setRoundTopLeft(15);
        LabTransaccion.setRoundTopRight(15);
        LabTransaccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabTransaccionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabTransaccionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabTransaccionMouseExited(evt);
            }
        });

        LabDeuda.setBackground(new java.awt.Color(227, 120, 145));
        LabDeuda.setForeground(new java.awt.Color(255, 255, 255));
        LabDeuda.setText(" Deuda");
        LabDeuda.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        LabDeuda.setRoundBottomLeft(15);
        LabDeuda.setRoundBottomRight(15);
        LabDeuda.setRoundTopLeft(15);
        LabDeuda.setRoundTopRight(15);
        LabDeuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabDeudaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabDeudaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabDeudaMouseExited(evt);
            }
        });

        LabSalir.setBackground(new java.awt.Color(227, 120, 145));
        LabSalir.setForeground(new java.awt.Color(255, 255, 255));
        LabSalir.setText(" Salir");
        LabSalir.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        LabSalir.setRoundBottomLeft(15);
        LabSalir.setRoundBottomRight(15);
        LabSalir.setRoundTopLeft(15);
        LabSalir.setRoundTopRight(15);
        LabSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabSalirMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                .addComponent(LabSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234))
        );

        PanelFondo.add(PanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 190, -1));

        PanelVentana.setPreferredSize(new java.awt.Dimension(795, 500));
        PanelVentana.setLayout(new java.awt.CardLayout());

        PanelInicio.setBackground(new java.awt.Color(251, 249, 245));
        PanelInicio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        LabBienvenido.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        LabBienvenido.setForeground(new java.awt.Color(135, 128, 134));
        LabBienvenido.setText("¡Bienvenido Usuario!");

        LabMensaje.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        LabMensaje.setForeground(new java.awt.Color(135, 128, 134));
        LabMensaje.setText("¿Qué deseas hacer hoy?");

        PanelNuevo.setBackground(new java.awt.Color(255, 255, 255));
        PanelNuevo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 109, 183), 2, true));
        PanelNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelNuevoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelNuevoMouseExited(evt);
            }
        });
        PanelNuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabNuevo.setBackground(new java.awt.Color(255, 255, 255));
        LabNuevo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabNuevo.setForeground(new java.awt.Color(128, 109, 183));
        LabNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabNuevo.setText("Nuevo Registro");
        LabNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabNuevoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabNuevoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabNuevoMouseExited(evt);
            }
        });
        PanelNuevo.add(LabNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 150, 50));

        LabAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabAgregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabAgregarMouseExited(evt);
            }
        });
        PanelNuevo.add(LabAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        javax.swing.GroupLayout PanelInicioLayout = new javax.swing.GroupLayout(PanelInicio);
        PanelInicio.setLayout(PanelInicioLayout);
        PanelInicioLayout.setHorizontalGroup(
            PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInicioLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabBienvenido)
                    .addComponent(LabMensaje)
                    .addComponent(PanelNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelInicioLayout.setVerticalGroup(
            PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInicioLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(LabBienvenido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabMensaje)
                .addGap(51, 51, 51)
                .addComponent(PanelNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        PanelVentana.add(PanelInicio, "card2");

        PanelPresupuesto.setBackground(new java.awt.Color(251, 249, 245));
        PanelPresupuesto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        LabTituloPresupuesto.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        LabTituloPresupuesto.setForeground(new java.awt.Color(84, 70, 82));
        LabTituloPresupuesto.setText("Presupuesto");

        ScrollPresupuesto.setBackground(new java.awt.Color(255, 255, 255));
        ScrollPresupuesto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 109, 183), 1, true));

        TablaPresupuesto.setAutoCreateRowSorter(true);
        TablaPresupuesto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TablaPresupuesto.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        TablaPresupuesto.setForeground(new java.awt.Color(84, 70, 82));
        TablaPresupuesto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Monto", "Fecha Inicial", "Fecha Final"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaPresupuesto.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        TablaPresupuesto.setGridColor(new java.awt.Color(204, 204, 204));
        TablaPresupuesto.setIntercellSpacing(new java.awt.Dimension(5, 5));
        TablaPresupuesto.setSelectionBackground(new java.awt.Color(236, 229, 255));
        TablaPresupuesto.setSelectionForeground(new java.awt.Color(128, 109, 183));
        ScrollPresupuesto.setViewportView(TablaPresupuesto);
        if (TablaPresupuesto.getColumnModel().getColumnCount() > 0) {
            TablaPresupuesto.getColumnModel().getColumn(0).setResizable(false);
            TablaPresupuesto.getColumnModel().getColumn(0).setPreferredWidth(5);
            TablaPresupuesto.getColumnModel().getColumn(1).setResizable(false);
            TablaPresupuesto.getColumnModel().getColumn(1).setPreferredWidth(100);
            TablaPresupuesto.getColumnModel().getColumn(2).setResizable(false);
            TablaPresupuesto.getColumnModel().getColumn(2).setPreferredWidth(50);
            TablaPresupuesto.getColumnModel().getColumn(3).setResizable(false);
            TablaPresupuesto.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        PanelModificarP.setBackground(new java.awt.Color(242, 238, 230));
        PanelModificarP.setRoundBottomLeft(10);
        PanelModificarP.setRoundBottomRight(10);
        PanelModificarP.setRoundTopLeft(10);
        PanelModificarP.setRoundTopRight(10);

        LabMontoP.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        LabMontoP.setForeground(new java.awt.Color(128, 109, 183));
        LabMontoP.setText("Monto");

        TxtMontoPresupuesto.setBackground(new java.awt.Color(242, 238, 230));
        TxtMontoPresupuesto.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        TxtMontoPresupuesto.setForeground(new java.awt.Color(84, 70, 82));
        TxtMontoPresupuesto.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        LabFechaInicialP.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        LabFechaInicialP.setForeground(new java.awt.Color(128, 109, 183));
        LabFechaInicialP.setText("Fecha Inicial");

        TxtFechaInicial.setBackground(new java.awt.Color(242, 238, 230));
        TxtFechaInicial.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        TxtFechaInicial.setForeground(new java.awt.Color(84, 70, 82));
        TxtFechaInicial.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        LabFechaFinalP.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        LabFechaFinalP.setForeground(new java.awt.Color(128, 109, 183));
        LabFechaFinalP.setText("Fecha Final");

        TxtFechaFinal.setBackground(new java.awt.Color(242, 238, 230));
        TxtFechaFinal.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        TxtFechaFinal.setForeground(new java.awt.Color(84, 70, 82));
        TxtFechaFinal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        TxtIdPresupuesto.setEditable(false);
        TxtIdPresupuesto.setBackground(new java.awt.Color(242, 238, 230));
        TxtIdPresupuesto.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        TxtIdPresupuesto.setForeground(new java.awt.Color(255, 255, 255));
        TxtIdPresupuesto.setBorder(null);

        BtnModificarPresupuesto.setBackground(new java.awt.Color(255, 207, 134));
        BtnModificarPresupuesto.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BtnModificarPresupuesto.setForeground(new java.awt.Color(255, 255, 255));
        BtnModificarPresupuesto.setText("MODIFICAR");
        BtnModificarPresupuesto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BtnModificarPresupuesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnModificarPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarPresupuestoActionPerformed(evt);
            }
        });

        BtnCancelarPresupuesto.setBackground(new java.awt.Color(255, 207, 134));
        BtnCancelarPresupuesto.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BtnCancelarPresupuesto.setForeground(new java.awt.Color(255, 255, 255));
        BtnCancelarPresupuesto.setText("CANCELAR");
        BtnCancelarPresupuesto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BtnCancelarPresupuesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCancelarPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarPresupuestoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelModificarPLayout = new javax.swing.GroupLayout(PanelModificarP);
        PanelModificarP.setLayout(PanelModificarPLayout);
        PanelModificarPLayout.setHorizontalGroup(
            PanelModificarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarPLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(PanelModificarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LabMontoP)
                        .addComponent(TxtMontoPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LabFechaFinalP)
                    .addComponent(TxtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(PanelModificarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabFechaInicialP)
                    .addGroup(PanelModificarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(TxtFechaInicial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(PanelModificarPLayout.createSequentialGroup()
                            .addComponent(TxtIdPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(BtnCancelarPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22)
                            .addComponent(BtnModificarPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35))
        );
        PanelModificarPLayout.setVerticalGroup(
            PanelModificarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelModificarPLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PanelModificarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelModificarPLayout.createSequentialGroup()
                        .addComponent(LabMontoP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtMontoPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(LabFechaFinalP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(48, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarPLayout.createSequentialGroup()
                        .addComponent(LabFechaInicialP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelModificarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtIdPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelModificarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BtnModificarPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnCancelarPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28))))
        );

        javax.swing.GroupLayout PanelPresupuestoLayout = new javax.swing.GroupLayout(PanelPresupuesto);
        PanelPresupuesto.setLayout(PanelPresupuestoLayout);
        PanelPresupuestoLayout.setHorizontalGroup(
            PanelPresupuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPresupuestoLayout.createSequentialGroup()
                .addGroup(PanelPresupuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPresupuestoLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(PanelPresupuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabTituloPresupuesto)))
                    .addGroup(PanelPresupuestoLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(PanelModificarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        PanelPresupuestoLayout.setVerticalGroup(
            PanelPresupuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPresupuestoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(LabTituloPresupuesto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPresupuesto, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(PanelModificarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        PanelVentana.add(PanelPresupuesto, "card6");

        PanelCuenta.setBackground(new java.awt.Color(251, 249, 245));
        PanelCuenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        LabTituloCuenta.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        LabTituloCuenta.setForeground(new java.awt.Color(84, 70, 82));
        LabTituloCuenta.setText("Cuentas Bancarias");

        ScrollCuenta.setBackground(new java.awt.Color(255, 255, 255));
        ScrollCuenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 109, 183), 1, true));

        TablaCuenta.setAutoCreateRowSorter(true);
        TablaCuenta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TablaCuenta.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        TablaCuenta.setForeground(new java.awt.Color(84, 70, 82));
        TablaCuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Tipo", "Saldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaCuenta.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        TablaCuenta.setGridColor(new java.awt.Color(204, 204, 204));
        TablaCuenta.setIntercellSpacing(new java.awt.Dimension(5, 5));
        TablaCuenta.setSelectionBackground(new java.awt.Color(236, 229, 255));
        TablaCuenta.setSelectionForeground(new java.awt.Color(128, 109, 183));
        ScrollCuenta.setViewportView(TablaCuenta);
        if (TablaCuenta.getColumnModel().getColumnCount() > 0) {
            TablaCuenta.getColumnModel().getColumn(0).setResizable(false);
            TablaCuenta.getColumnModel().getColumn(0).setPreferredWidth(20);
            TablaCuenta.getColumnModel().getColumn(1).setResizable(false);
            TablaCuenta.getColumnModel().getColumn(1).setPreferredWidth(100);
            TablaCuenta.getColumnModel().getColumn(2).setResizable(false);
            TablaCuenta.getColumnModel().getColumn(2).setPreferredWidth(50);
            TablaCuenta.getColumnModel().getColumn(3).setResizable(false);
            TablaCuenta.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        PanelModificarC.setBackground(new java.awt.Color(242, 238, 230));
        PanelModificarC.setRoundBottomLeft(10);
        PanelModificarC.setRoundBottomRight(10);
        PanelModificarC.setRoundTopLeft(10);
        PanelModificarC.setRoundTopRight(10);

        LabNombreC.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        LabNombreC.setForeground(new java.awt.Color(128, 109, 183));
        LabNombreC.setText("Nombre");

        TxtNombreCuenta.setBackground(new java.awt.Color(242, 238, 230));
        TxtNombreCuenta.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        TxtNombreCuenta.setForeground(new java.awt.Color(84, 70, 82));
        TxtNombreCuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        LabSaldoC.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        LabSaldoC.setForeground(new java.awt.Color(128, 109, 183));
        LabSaldoC.setText("Saldo");

        TxtSaldoCuenta.setBackground(new java.awt.Color(242, 238, 230));
        TxtSaldoCuenta.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        TxtSaldoCuenta.setForeground(new java.awt.Color(84, 70, 82));
        TxtSaldoCuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        TxtIdCuenta.setEditable(false);
        TxtIdCuenta.setBackground(new java.awt.Color(242, 238, 230));
        TxtIdCuenta.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        TxtIdCuenta.setForeground(new java.awt.Color(84, 70, 82));
        TxtIdCuenta.setBorder(null);

        TxtTipoCuenta.setBackground(new java.awt.Color(242, 238, 230));
        TxtTipoCuenta.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        TxtTipoCuenta.setForeground(new java.awt.Color(84, 70, 82));
        TxtTipoCuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        LabTipoC.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        LabTipoC.setForeground(new java.awt.Color(128, 109, 183));
        LabTipoC.setText("Tipo");

        BtnModificarCuenta.setBackground(new java.awt.Color(255, 207, 134));
        BtnModificarCuenta.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BtnModificarCuenta.setForeground(new java.awt.Color(255, 255, 255));
        BtnModificarCuenta.setText("MODIFICAR");
        BtnModificarCuenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BtnModificarCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnModificarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarCuentaActionPerformed(evt);
            }
        });

        BtnCancelarCuenta.setBackground(new java.awt.Color(255, 207, 134));
        BtnCancelarCuenta.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BtnCancelarCuenta.setForeground(new java.awt.Color(255, 255, 255));
        BtnCancelarCuenta.setText("CANCELAR");
        BtnCancelarCuenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BtnCancelarCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCancelarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarCuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelModificarCLayout = new javax.swing.GroupLayout(PanelModificarC);
        PanelModificarC.setLayout(PanelModificarCLayout);
        PanelModificarCLayout.setHorizontalGroup(
            PanelModificarCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarCLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(PanelModificarCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelModificarCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(LabSaldoC)
                        .addComponent(TxtNombreCuenta)
                        .addComponent(TxtSaldoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LabNombreC))
                .addGap(48, 48, 48)
                .addGroup(PanelModificarCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelModificarCLayout.createSequentialGroup()
                        .addComponent(TxtIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnCancelarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnModificarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelModificarCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LabTipoC)
                        .addComponent(TxtTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        PanelModificarCLayout.setVerticalGroup(
            PanelModificarCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelModificarCLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(PanelModificarCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelModificarCLayout.createSequentialGroup()
                        .addComponent(LabNombreC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtNombreCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(LabSaldoC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtSaldoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(47, Short.MAX_VALUE))
                    .addGroup(PanelModificarCLayout.createSequentialGroup()
                        .addComponent(LabTipoC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelModificarCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnModificarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnCancelarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))))
        );

        javax.swing.GroupLayout PanelCuentaLayout = new javax.swing.GroupLayout(PanelCuenta);
        PanelCuenta.setLayout(PanelCuentaLayout);
        PanelCuentaLayout.setHorizontalGroup(
            PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCuentaLayout.createSequentialGroup()
                .addGroup(PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCuentaLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabTituloCuenta)))
                    .addGroup(PanelCuentaLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(PanelModificarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        PanelCuentaLayout.setVerticalGroup(
            PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabTituloCuenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(PanelModificarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        PanelVentana.add(PanelCuenta, "card4");

        PanelTransaccion.setBackground(new java.awt.Color(251, 249, 245));
        PanelTransaccion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        LabTituloTransaccion.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        LabTituloTransaccion.setForeground(new java.awt.Color(84, 70, 82));
        LabTituloTransaccion.setText("Transacciones");

        ScrollTransaccion.setBackground(new java.awt.Color(255, 255, 255));
        ScrollTransaccion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 109, 183), 1, true));

        TablaTransaccion.setAutoCreateRowSorter(true);
        TablaTransaccion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TablaTransaccion.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        TablaTransaccion.setForeground(new java.awt.Color(84, 70, 82));
        TablaTransaccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoría", "Fecha", "Monto", "Descripción", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaTransaccion.setGridColor(new java.awt.Color(204, 204, 204));
        TablaTransaccion.setIntercellSpacing(new java.awt.Dimension(5, 5));
        TablaTransaccion.setSelectionBackground(new java.awt.Color(236, 229, 255));
        TablaTransaccion.setSelectionForeground(new java.awt.Color(128, 109, 183));
        ScrollTransaccion.setViewportView(TablaTransaccion);
        if (TablaTransaccion.getColumnModel().getColumnCount() > 0) {
            TablaTransaccion.getColumnModel().getColumn(0).setResizable(false);
            TablaTransaccion.getColumnModel().getColumn(0).setPreferredWidth(5);
            TablaTransaccion.getColumnModel().getColumn(1).setResizable(false);
            TablaTransaccion.getColumnModel().getColumn(1).setPreferredWidth(50);
            TablaTransaccion.getColumnModel().getColumn(2).setResizable(false);
            TablaTransaccion.getColumnModel().getColumn(2).setPreferredWidth(50);
            TablaTransaccion.getColumnModel().getColumn(3).setResizable(false);
            TablaTransaccion.getColumnModel().getColumn(3).setPreferredWidth(50);
            TablaTransaccion.getColumnModel().getColumn(4).setResizable(false);
            TablaTransaccion.getColumnModel().getColumn(4).setPreferredWidth(200);
            TablaTransaccion.getColumnModel().getColumn(5).setResizable(false);
            TablaTransaccion.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        PanelModificarT.setBackground(new java.awt.Color(242, 238, 230));
        PanelModificarT.setRoundBottomLeft(10);
        PanelModificarT.setRoundBottomRight(10);
        PanelModificarT.setRoundTopLeft(10);
        PanelModificarT.setRoundTopRight(10);

        BtnModificarTran.setBackground(new java.awt.Color(255, 207, 134));
        BtnModificarTran.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BtnModificarTran.setForeground(new java.awt.Color(255, 255, 255));
        BtnModificarTran.setText("MODIFICAR");
        BtnModificarTran.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BtnModificarTran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnModificarTran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarTranActionPerformed(evt);
            }
        });

        TxtIdTransaccion.setEditable(false);
        TxtIdTransaccion.setBackground(new java.awt.Color(242, 238, 230));
        TxtIdTransaccion.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        TxtIdTransaccion.setForeground(new java.awt.Color(84, 70, 82));
        TxtIdTransaccion.setBorder(null);

        BoxCategoria.setBackground(new java.awt.Color(242, 238, 230));
        BoxCategoria.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        BoxCategoria.setForeground(new java.awt.Color(84, 70, 82));
        BoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vivienda", "Alimentación", "Transporte", "Salud", "Entretenimiento", "Salario", "Bonificaciones", "Rendimientos", "Ventas", "Regalos", "Otro" }));
        BoxCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(216, 195, 151)));
        BoxCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        LabCategoriaT.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        LabCategoriaT.setForeground(new java.awt.Color(128, 109, 183));
        LabCategoriaT.setText("Categoría");

        LabTipoT.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        LabTipoT.setForeground(new java.awt.Color(128, 109, 183));
        LabTipoT.setText("Tipo");

        TxtDescripcionTran.setBackground(new java.awt.Color(242, 238, 230));
        TxtDescripcionTran.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        TxtDescripcionTran.setForeground(new java.awt.Color(84, 70, 82));
        TxtDescripcionTran.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        LabDescripcionT.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        LabDescripcionT.setForeground(new java.awt.Color(128, 109, 183));
        LabDescripcionT.setText("Descripción");

        LabFecha.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        LabFecha.setForeground(new java.awt.Color(128, 109, 183));
        LabFecha.setText("Fecha");

        TxtFechaTran.setBackground(new java.awt.Color(242, 238, 230));
        TxtFechaTran.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        TxtFechaTran.setForeground(new java.awt.Color(84, 70, 82));
        TxtFechaTran.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        TxtMontoTran.setBackground(new java.awt.Color(242, 238, 230));
        TxtMontoTran.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        TxtMontoTran.setForeground(new java.awt.Color(84, 70, 82));
        TxtMontoTran.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        LabMontoT.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        LabMontoT.setForeground(new java.awt.Color(128, 109, 183));
        LabMontoT.setText("Monto");

        BtnCancelarTran.setBackground(new java.awt.Color(255, 207, 134));
        BtnCancelarTran.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BtnCancelarTran.setForeground(new java.awt.Color(255, 255, 255));
        BtnCancelarTran.setText("CANCELAR");
        BtnCancelarTran.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BtnCancelarTran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCancelarTran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarTranActionPerformed(evt);
            }
        });

        BoxTipo.setBackground(new java.awt.Color(242, 238, 230));
        BoxTipo.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        BoxTipo.setForeground(new java.awt.Color(84, 70, 82));
        BoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasto", "Ingreso" }));
        BoxTipo.setToolTipText("");
        BoxTipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(216, 195, 151)));
        BoxTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout PanelModificarTLayout = new javax.swing.GroupLayout(PanelModificarT);
        PanelModificarT.setLayout(PanelModificarTLayout);
        PanelModificarTLayout.setHorizontalGroup(
            PanelModificarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarTLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TxtIdTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnCancelarTran, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnModificarTran, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarTLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(PanelModificarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabDescripcionT)
                    .addGroup(PanelModificarTLayout.createSequentialGroup()
                        .addGroup(PanelModificarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtFechaTran, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabFecha))
                        .addGap(34, 34, 34)
                        .addGroup(PanelModificarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabMontoT)
                            .addComponent(TxtMontoTran)))
                    .addComponent(TxtDescripcionTran, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(PanelModificarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarTLayout.createSequentialGroup()
                        .addComponent(LabTipoT)
                        .addGap(182, 182, 182))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(BoxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabCategoriaT, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        PanelModificarTLayout.setVerticalGroup(
            PanelModificarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelModificarTLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(PanelModificarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelModificarTLayout.createSequentialGroup()
                        .addComponent(LabTipoT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LabCategoriaT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelModificarTLayout.createSequentialGroup()
                        .addComponent(LabDescripcionT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtDescripcionTran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(PanelModificarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabFecha)
                            .addComponent(LabMontoT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelModificarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtFechaTran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtMontoTran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(PanelModificarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtIdTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCancelarTran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnModificarTran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelTransaccionLayout = new javax.swing.GroupLayout(PanelTransaccion);
        PanelTransaccion.setLayout(PanelTransaccionLayout);
        PanelTransaccionLayout.setHorizontalGroup(
            PanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTransaccionLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(PanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabTituloTransaccion))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTransaccionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelModificarT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        PanelTransaccionLayout.setVerticalGroup(
            PanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTransaccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabTituloTransaccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollTransaccion, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addComponent(PanelModificarT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelVentana.add(PanelTransaccion, "card3");

        PanelDeuda.setBackground(new java.awt.Color(251, 249, 245));
        PanelDeuda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        LabTituloDeuda.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        LabTituloDeuda.setForeground(new java.awt.Color(84, 70, 82));
        LabTituloDeuda.setText("Deudas");

        ScrollDeuda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 109, 183), 1, true));

        TablaDeuda.setAutoCreateRowSorter(true);
        TablaDeuda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TablaDeuda.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        TablaDeuda.setForeground(new java.awt.Color(84, 70, 82));
        TablaDeuda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripción", "Monto", "Interés", "Plazo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaDeuda.setGridColor(new java.awt.Color(204, 204, 204));
        TablaDeuda.setIntercellSpacing(new java.awt.Dimension(5, 5));
        TablaDeuda.setSelectionBackground(new java.awt.Color(236, 229, 255));
        TablaDeuda.setSelectionForeground(new java.awt.Color(128, 109, 183));
        ScrollDeuda.setViewportView(TablaDeuda);
        if (TablaDeuda.getColumnModel().getColumnCount() > 0) {
            TablaDeuda.getColumnModel().getColumn(0).setResizable(false);
            TablaDeuda.getColumnModel().getColumn(0).setPreferredWidth(5);
            TablaDeuda.getColumnModel().getColumn(1).setResizable(false);
            TablaDeuda.getColumnModel().getColumn(1).setPreferredWidth(200);
            TablaDeuda.getColumnModel().getColumn(2).setResizable(false);
            TablaDeuda.getColumnModel().getColumn(2).setPreferredWidth(50);
            TablaDeuda.getColumnModel().getColumn(3).setResizable(false);
            TablaDeuda.getColumnModel().getColumn(3).setPreferredWidth(50);
            TablaDeuda.getColumnModel().getColumn(4).setResizable(false);
            TablaDeuda.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        PanelModificarD.setBackground(new java.awt.Color(242, 238, 230));
        PanelModificarD.setRoundBottomLeft(10);
        PanelModificarD.setRoundBottomRight(10);
        PanelModificarD.setRoundTopLeft(10);
        PanelModificarD.setRoundTopRight(10);

        LabDescripcionD.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        LabDescripcionD.setForeground(new java.awt.Color(128, 109, 183));
        LabDescripcionD.setText("Descripción");

        TxtDescripDeuda.setBackground(new java.awt.Color(242, 238, 230));
        TxtDescripDeuda.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        TxtDescripDeuda.setForeground(new java.awt.Color(84, 70, 82));
        TxtDescripDeuda.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        LabInteresD.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        LabInteresD.setForeground(new java.awt.Color(128, 109, 183));
        LabInteresD.setText("Interés");

        TxtInteresDeuda.setBackground(new java.awt.Color(242, 238, 230));
        TxtInteresDeuda.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        TxtInteresDeuda.setForeground(new java.awt.Color(84, 70, 82));
        TxtInteresDeuda.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        TxtPlazoDeuda.setBackground(new java.awt.Color(242, 238, 230));
        TxtPlazoDeuda.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        TxtPlazoDeuda.setForeground(new java.awt.Color(84, 70, 82));
        TxtPlazoDeuda.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        LabPlazoD.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        LabPlazoD.setForeground(new java.awt.Color(128, 109, 183));
        LabPlazoD.setText("Plazo");

        TxtMontoDeuda.setBackground(new java.awt.Color(242, 238, 230));
        TxtMontoDeuda.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        TxtMontoDeuda.setForeground(new java.awt.Color(84, 70, 82));
        TxtMontoDeuda.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        LabMontoD.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        LabMontoD.setForeground(new java.awt.Color(128, 109, 183));
        LabMontoD.setText("Monto");

        BtnModificarDeuda.setBackground(new java.awt.Color(255, 207, 134));
        BtnModificarDeuda.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BtnModificarDeuda.setForeground(new java.awt.Color(255, 255, 255));
        BtnModificarDeuda.setText("MODIFICAR");
        BtnModificarDeuda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BtnModificarDeuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnModificarDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarDeudaActionPerformed(evt);
            }
        });

        TxtIdDeuda.setEditable(false);
        TxtIdDeuda.setBackground(new java.awt.Color(242, 238, 230));
        TxtIdDeuda.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        TxtIdDeuda.setForeground(new java.awt.Color(84, 70, 82));
        TxtIdDeuda.setBorder(null);

        BtnCancelarDeuda.setBackground(new java.awt.Color(255, 207, 134));
        BtnCancelarDeuda.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BtnCancelarDeuda.setForeground(new java.awt.Color(255, 255, 255));
        BtnCancelarDeuda.setText("CANCELAR");
        BtnCancelarDeuda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BtnCancelarDeuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCancelarDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarDeudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelModificarDLayout = new javax.swing.GroupLayout(PanelModificarD);
        PanelModificarD.setLayout(PanelModificarDLayout);
        PanelModificarDLayout.setHorizontalGroup(
            PanelModificarDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelModificarDLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PanelModificarDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelModificarDLayout.createSequentialGroup()
                        .addComponent(TxtIdDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnCancelarDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnModificarDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelModificarDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelModificarDLayout.createSequentialGroup()
                            .addGroup(PanelModificarDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PanelModificarDLayout.createSequentialGroup()
                                    .addComponent(TxtInteresDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(48, 48, 48))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarDLayout.createSequentialGroup()
                                    .addComponent(LabInteresD)
                                    .addGap(276, 276, 276)))
                            .addGroup(PanelModificarDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TxtPlazoDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LabPlazoD)))
                        .addGroup(PanelModificarDLayout.createSequentialGroup()
                            .addGroup(PanelModificarDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LabDescripcionD)
                                .addComponent(TxtDescripDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(51, 51, 51)
                            .addGroup(PanelModificarDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LabMontoD)
                                .addComponent(TxtMontoDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        PanelModificarDLayout.setVerticalGroup(
            PanelModificarDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelModificarDLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PanelModificarDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabDescripcionD)
                    .addComponent(LabMontoD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelModificarDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtDescripDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtMontoDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelModificarDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabInteresD)
                    .addComponent(LabPlazoD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelModificarDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtInteresDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtPlazoDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelModificarDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnModificarDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtIdDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCancelarDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelDeudaLayout = new javax.swing.GroupLayout(PanelDeuda);
        PanelDeuda.setLayout(PanelDeudaLayout);
        PanelDeudaLayout.setHorizontalGroup(
            PanelDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDeudaLayout.createSequentialGroup()
                .addGroup(PanelDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDeudaLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(PanelDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabTituloDeuda)
                            .addComponent(ScrollDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelDeudaLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(PanelModificarD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        PanelDeudaLayout.setVerticalGroup(
            PanelDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDeudaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabTituloDeuda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollDeuda, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(PanelModificarD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        PanelVentana.add(PanelDeuda, "card5");

        PanelFondo.add(PanelVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 790, 500));
        PanelVentana.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PanelSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSuperiorMousePressed
        moverX = evt.getX();
        moverY = evt.getY();
    }//GEN-LAST:event_PanelSuperiorMousePressed

    private void PanelFondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFondoMousePressed
        moverX = evt.getX();
        moverY = evt.getY();
    }//GEN-LAST:event_PanelFondoMousePressed

    private void PanelFondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFondoMouseDragged
        x = evt.getXOnScreen();
        y = evt.getYOnScreen();
        this.setLocation(x - moverX, y - moverY);                               
    }//GEN-LAST:event_PanelFondoMouseDragged

    private void LabInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabInicioMouseEntered
        LabInicio.setForeground(Color.black);
        Sound.playSound("src/sound/cursor.wav");
    }//GEN-LAST:event_LabInicioMouseEntered

    private void LabInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabInicioMouseExited
        LabInicio.setForeground(new Color(84, 70, 82));
    }//GEN-LAST:event_LabInicioMouseExited

    private void LabInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabInicioMouseClicked
        Sound.playSound("src/sound/click.wav");
        PanelInicio.setVisible(true);
        
        LabPresupuesto.setBackground(new Color(227, 120, 145));
        PanelPresupuesto.setVisible(false);
        
        LabCuenta.setBackground(new Color(227, 120, 145));
        PanelCuenta.setVisible(false);
        
        LabTransaccion.setBackground(new Color(227, 120, 145));
        PanelTransaccion.setVisible(false);
        
        LabDeuda.setBackground(new Color(227, 120, 145));
        PanelDeuda.setVisible(false);
    }//GEN-LAST:event_LabInicioMouseClicked

    private void LabNuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabNuevoMouseEntered
        LabNuevo.setForeground( new Color(197, 205, 250));
        LabAgregar.setIcon(ajustarImagen("/icon/boton_agregar_claro.png", 50, 50));
        PanelNuevo.setBackground(new Color(250, 249, 252));
        PanelNuevo.setBorder(BorderFactory.createLineBorder(new Color(197, 205, 250)));
    }//GEN-LAST:event_LabNuevoMouseEntered

    private void LabNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabNuevoMouseClicked
        NuevoRegistro Nuevo = new NuevoRegistro(controladorUsu, controladorPres, controladorCue, controladorTra, controladorDeu);
        Nuevo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LabNuevoMouseClicked

    private void BtnModificarTranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarTranActionPerformed
    if(!TxtFechaTran.getText().isEmpty() | !TxtMontoTran.getText().isEmpty() | !TxtDescripcionTran.getText().isEmpty()) {
    String fecha, descripcion, tipo, nombre, mensaje;
    int idTransaccion, idCategoria;
    double monto;
    
    controladorTra = new TransaccionController();
    
    int selectedRow = TablaTransaccion.getSelectedRow();
    if (selectedRow != -1) {
        
            idTransaccion = Integer.parseInt(this.TxtIdTransaccion.getText());
            nombre = BoxCategoria.getSelectedItem().toString();
            idCategoria = controladorTra.obtenerIdCategoria(nombre);
            fecha = this.TxtFechaTran.getText();
            monto = Double.parseDouble(this.TxtMontoTran.getText());
            descripcion = this.TxtDescripcionTran.getText();
            tipo = BoxTipo.getSelectedItem().toString();

            mensaje = controladorTra.modificarTransaccion(idTransaccion, idCategoria, fecha, monto, descripcion, tipo);
            JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
            
            PanelModificarT.setVisible(false);
            TablaTransaccion.clearSelection();
            actualizarTabla();
            limpiarCampos();
    } else {
        JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar", "Información", JOptionPane.INFORMATION_MESSAGE); }
    } else {
        Sound.playSound("src/sound/error.wav");
        JOptionPane.showMessageDialog(null, "Complete los campos vacíos.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_BtnModificarTranActionPerformed

    private void BtnModificarDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarDeudaActionPerformed
    if(!TxtDescripDeuda.getText().isEmpty() | !TxtMontoDeuda.getText().isEmpty() | !TxtInteresDeuda.getText().isEmpty() | !TxtPlazoDeuda.getText().isEmpty()) {
    String descripcion, plazo, mensaje;
    int idDeuda;
    double monto, interes;
    
    controladorDeu = new DeudaController();
    
    int selectedRow = TablaDeuda.getSelectedRow();
    if (selectedRow != -1) {
            idDeuda = Integer.parseInt(this.TxtIdDeuda.getText());
            descripcion = this.TxtDescripDeuda.getText();
            monto = Double.parseDouble(this.TxtMontoDeuda.getText());
            interes = Double.parseDouble(this.TxtInteresDeuda.getText());
            plazo = this.TxtPlazoDeuda.getText();

            mensaje = controladorDeu.modificarDeuda(idDeuda, descripcion, monto, interes, plazo);
            JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

            PanelModificarD.setVisible(false);
            TablaDeuda.clearSelection();
            actualizarTabla();
            limpiarCampos();
    } else {
        JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar", "Información", JOptionPane.INFORMATION_MESSAGE); }
    } else {
        Sound.playSound("src/sound/error.wav");
        JOptionPane.showMessageDialog(null, "Complete los campos vacíos.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_BtnModificarDeudaActionPerformed

    private void BtnModificarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarCuentaActionPerformed
    if(!TxtNombreCuenta.getText().isEmpty() | !TxtTipoCuenta.getText().isEmpty() | !TxtSaldoCuenta.getText().isEmpty()) {
    String nombre, tipo, mensaje;
    int idCuenta;
    double saldo;
    
    controladorCue = new CuentaController();
    
    int selectedRow = TablaCuenta.getSelectedRow();
    if (selectedRow != -1) {
            idCuenta = Integer.parseInt(this.TxtIdCuenta.getText());
            nombre = this.TxtNombreCuenta.getText();
            tipo = this.TxtTipoCuenta.getText();
            saldo = Double.parseDouble(this.TxtSaldoCuenta.getText());

            mensaje = controladorCue.modificarCuenta(idCuenta, nombre, tipo, saldo);
            JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

            PanelModificarC.setVisible(false);
            TablaCuenta.clearSelection();
            actualizarTabla();
            limpiarCampos();
    } else {
        JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar", "Información", JOptionPane.INFORMATION_MESSAGE); }
    } else {
        Sound.playSound("src/sound/error.wav");
        JOptionPane.showMessageDialog(null, "Complete los campos vacíos.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_BtnModificarCuentaActionPerformed

    private void PanelSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSuperiorMouseDragged
        x = evt.getXOnScreen();
        y = evt.getYOnScreen();
        this.setLocation(x - moverX, y - moverY); 
    }//GEN-LAST:event_PanelSuperiorMouseDragged

    private void LabAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabAgregarMouseClicked
        NuevoRegistro Nuevo = new NuevoRegistro(controladorUsu, controladorPres, controladorCue, controladorTra, controladorDeu);
        Nuevo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LabAgregarMouseClicked

    private void BtnModificarPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarPresupuestoActionPerformed
    if(!TxtMontoPresupuesto.getText().isEmpty() | !TxtFechaInicial.getText().isEmpty() | !TxtFechaFinal.getText().isEmpty()) {
        String fechaInicio, fechaFin, mensaje;
        double monto;
        int idPresupuesto;

        controladorPres = new PresupuestoController();

        int selectedRow = TablaPresupuesto.getSelectedRow();
        if (selectedRow != -1) {

            idPresupuesto = Integer.parseInt(this.TxtIdPresupuesto.getText());
            monto = Double.parseDouble(this.TxtMontoPresupuesto.getText());
            fechaInicio = this.TxtFechaInicial.getText();
            fechaFin = this.TxtFechaFinal.getText();

            mensaje = controladorPres.modificarPresupuesto(idPresupuesto, monto, fechaInicio, fechaFin);
            JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

            PanelModificarP.setVisible(false);
            TablaPresupuesto.clearSelection();
            actualizarTabla();
            limpiarCampos();
        } else {
        JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar", "Información", JOptionPane.INFORMATION_MESSAGE); } 
        } else {
        Sound.playSound("src/sound/error.wav");
        JOptionPane.showMessageDialog(null, "Complete los campos vacíos.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_BtnModificarPresupuestoActionPerformed

    private void LabPresupuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabPresupuestoMouseClicked
        Sound.playSound("src/sound/click.wav");
        LabPresupuesto.setBackground(new  Color(255, 153, 176));
        PanelPresupuesto.setVisible(true);

        PanelInicio.setVisible(false);
        
        LabTransaccion.setBackground(new Color(227, 120, 145));
        PanelTransaccion.setVisible(false);

        LabCuenta.setBackground(new  Color(227, 120, 145));
        PanelCuenta.setVisible(false);

        LabDeuda.setBackground(new Color(227, 120, 145));
        PanelDeuda.setVisible(false);
    }//GEN-LAST:event_LabPresupuestoMouseClicked

    private void LabCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabCuentaMouseClicked
        Sound.playSound("src/sound/click.wav");
        LabCuenta.setBackground(new Color(255, 153, 176));
        PanelCuenta.setVisible(true);
        
        PanelInicio.setVisible(false);

        LabPresupuesto.setBackground(new Color(227, 120, 145));
        PanelPresupuesto.setVisible(false);

        LabTransaccion.setBackground(new Color(227, 120, 145));
        PanelTransaccion.setVisible(false);

        LabDeuda.setBackground(new Color(227, 120, 145));
        PanelDeuda.setVisible(false);
    }//GEN-LAST:event_LabCuentaMouseClicked

    private void LabTransaccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabTransaccionMouseClicked
        Sound.playSound("src/sound/click.wav");
        LabTransaccion.setBackground(new  Color(255, 153, 176));
        PanelTransaccion.setVisible(true);

        PanelInicio.setVisible(false);
        
        LabPresupuesto.setBackground(new Color(227, 120, 145));
        PanelPresupuesto.setVisible(false);

        LabCuenta.setBackground(new  Color(227, 120, 145));
        PanelCuenta.setVisible(false);

        LabDeuda.setBackground(new Color(227, 120, 145));
        PanelDeuda.setVisible(false);
    }//GEN-LAST:event_LabTransaccionMouseClicked

    private void LabDeudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabDeudaMouseClicked
        Sound.playSound("src/sound/click.wav");
        LabDeuda.setBackground(new Color(255, 153, 176));
        PanelDeuda.setVisible(true);

        PanelInicio.setVisible(false);
        
        LabPresupuesto.setBackground(new Color(227, 120, 145));
        PanelPresupuesto.setVisible(false);

        LabCuenta.setBackground(new Color(227, 120, 145));
        PanelCuenta.setVisible(false);

        LabTransaccion.setBackground(new Color(227, 120, 145));
        PanelTransaccion.setVisible(false);
    }//GEN-LAST:event_LabDeudaMouseClicked

    private void LabSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabSalirMouseClicked
        Sound.playSound("src/sound/change.wav");
        IniciarSesion Sesion = new IniciarSesion();
        Sesion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LabSalirMouseClicked

    private void LabSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabSalirMouseEntered
        LabSalir.setBackground(new Color(228, 55, 68));
        Sound.playSound("src/sound/cursor.wav");
    }//GEN-LAST:event_LabSalirMouseEntered

    private void LabSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabSalirMouseExited
        LabSalir.setBackground(new  Color(227, 120, 145));
    }//GEN-LAST:event_LabSalirMouseExited

    private void LabUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabUsuarioMouseClicked
        UsuarioPerfil Usuario = new UsuarioPerfil(controladorUsu, controladorPres, controladorCue, controladorTra, controladorDeu);
        Usuario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LabUsuarioMouseClicked

    private void LabUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabUsuarioMouseEntered
        LabUsuario.setBackground(new Color(197, 205, 250));
        LabNombre.setForeground(new Color(135, 129, 134));
    }//GEN-LAST:event_LabUsuarioMouseEntered

    private void LabUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabUsuarioMouseExited
        LabUsuario.setBackground(new Color(128, 109, 183));
        LabNombre.setForeground(new Color(84, 70, 82));
    }//GEN-LAST:event_LabUsuarioMouseExited

    private void LabNombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabNombreMouseExited
        LabNombre.setForeground(new Color(84, 70, 82));
        LabUsuario.setBackground(new Color(128, 109, 183));
    }//GEN-LAST:event_LabNombreMouseExited

    private void LabNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabNombreMouseEntered
        LabNombre.setForeground(new Color(135, 129, 134));
        LabUsuario.setBackground(new Color(197, 205, 250));
    }//GEN-LAST:event_LabNombreMouseEntered

    private void LabNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabNombreMouseClicked
        UsuarioPerfil Usuario = new UsuarioPerfil(controladorUsu, controladorPres, controladorCue, controladorTra, controladorDeu);
        Usuario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LabNombreMouseClicked

    private void PanelNuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelNuevoMouseEntered

    }//GEN-LAST:event_PanelNuevoMouseEntered

    private void PanelNuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelNuevoMouseExited
        
    }//GEN-LAST:event_PanelNuevoMouseExited

    private void LabAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabAgregarMouseEntered
        LabNuevo.setForeground( new Color(197, 205, 250));
        LabAgregar.setIcon(ajustarImagen("/icon/boton_agregar_claro.png", 50, 50));
        PanelNuevo.setBackground(new Color(250, 249, 252));
        PanelNuevo.setBorder(BorderFactory.createLineBorder(new Color(197, 205, 250)));
    }//GEN-LAST:event_LabAgregarMouseEntered

    private void LabAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabAgregarMouseExited
        LabNuevo.setForeground( new Color(128, 109, 183));
        LabAgregar.setIcon(ajustarImagen("/icon/boton_agregar.png", 50, 50));
        PanelNuevo.setBackground(Color.white);
        PanelNuevo.setBorder(BorderFactory.createLineBorder(new Color(128, 109, 183)));
    }//GEN-LAST:event_LabAgregarMouseExited

    private void LabNuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabNuevoMouseExited
        LabNuevo.setForeground( new Color(128, 109, 183));
        LabAgregar.setIcon(ajustarImagen("/icon/boton_agregar.png", 50, 50));
        PanelNuevo.setBackground(Color.white);
        PanelNuevo.setBorder(BorderFactory.createLineBorder(new Color(128, 109, 183)));
    }//GEN-LAST:event_LabNuevoMouseExited

    private void LabPresupuestoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabPresupuestoMouseEntered
        if (!LabPresupuesto.getBackground().equals(new Color(255, 153, 176))) {
            LabPresupuesto.setBackground(new Color(223, 93, 123));
        }
    }//GEN-LAST:event_LabPresupuestoMouseEntered

    private void LabPresupuestoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabPresupuestoMouseExited
        if (!LabPresupuesto.getBackground().equals(new Color(255, 153, 176))) {
            LabPresupuesto.setBackground(new Color(227, 120, 145));
        }
    }//GEN-LAST:event_LabPresupuestoMouseExited

    private void LabCuentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabCuentaMouseEntered
        if (!LabCuenta.getBackground().equals(new Color(255, 153, 176))) {
            LabCuenta.setBackground(new Color(223, 93, 123));
        }
    }//GEN-LAST:event_LabCuentaMouseEntered

    private void LabCuentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabCuentaMouseExited
        if (!LabCuenta.getBackground().equals(new Color(255, 153, 176))) {
            LabCuenta.setBackground(new Color(227, 120, 145));
        }
    }//GEN-LAST:event_LabCuentaMouseExited

    private void LabTransaccionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabTransaccionMouseEntered
        if (!LabTransaccion.getBackground().equals(new Color(255, 153, 176))) {
            LabTransaccion.setBackground(new Color(223, 93, 123));
        }
    }//GEN-LAST:event_LabTransaccionMouseEntered

    private void LabTransaccionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabTransaccionMouseExited
        if (!LabTransaccion.getBackground().equals(new Color(255, 153, 176))) {
            LabTransaccion.setBackground(new Color(227, 120, 145));
        }
    }//GEN-LAST:event_LabTransaccionMouseExited

    private void LabDeudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabDeudaMouseEntered
        if (!LabDeuda.getBackground().equals(new Color(255, 153, 176))) {
            LabDeuda.setBackground(new Color(223, 93, 123));
        }
    }//GEN-LAST:event_LabDeudaMouseEntered

    private void LabDeudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabDeudaMouseExited
        if (!LabDeuda.getBackground().equals(new Color(255, 153, 176))) {
            LabDeuda.setBackground(new Color(227, 120, 145));
        }
    }//GEN-LAST:event_LabDeudaMouseExited

    private void BtnCancelarPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarPresupuestoActionPerformed
       PanelModificarP.setVisible(false);
       TablaPresupuesto.clearSelection();
    }//GEN-LAST:event_BtnCancelarPresupuestoActionPerformed

    private void BtnCancelarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarCuentaActionPerformed
        PanelModificarC.setVisible(false);
        TablaCuenta.clearSelection();
    }//GEN-LAST:event_BtnCancelarCuentaActionPerformed

    private void BtnCancelarTranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarTranActionPerformed
        PanelModificarT.setVisible(false);
        TablaTransaccion.clearSelection();
    }//GEN-LAST:event_BtnCancelarTranActionPerformed

    private void BtnCancelarDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarDeudaActionPerformed
        PanelModificarD.setVisible(false);
        TablaDeuda.clearSelection();
    }//GEN-LAST:event_BtnCancelarDeudaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxCategoria;
    private javax.swing.JComboBox<String> BoxTipo;
    private javax.swing.JButton BtnCancelarCuenta;
    private javax.swing.JButton BtnCancelarDeuda;
    private javax.swing.JButton BtnCancelarPresupuesto;
    private javax.swing.JButton BtnCancelarTran;
    private javax.swing.JButton BtnModificarCuenta;
    private javax.swing.JButton BtnModificarDeuda;
    private javax.swing.JButton BtnModificarPresupuesto;
    private javax.swing.JButton BtnModificarTran;
    private javax.swing.JLabel LabAgregar;
    private javax.swing.JLabel LabBienvenido;
    private javax.swing.JLabel LabCategoriaT;
    private swingx.RoundLabel LabCuenta;
    private javax.swing.JLabel LabDescripcionD;
    private javax.swing.JLabel LabDescripcionT;
    private swingx.RoundLabel LabDeuda;
    private javax.swing.JLabel LabFecha;
    private javax.swing.JLabel LabFechaFinalP;
    private javax.swing.JLabel LabFechaInicialP;
    private javax.swing.JLabel LabInicio;
    private javax.swing.JLabel LabInteresD;
    private javax.swing.JLabel LabMensaje;
    private javax.swing.JLabel LabMontoD;
    private javax.swing.JLabel LabMontoP;
    private javax.swing.JLabel LabMontoT;
    private javax.swing.JLabel LabNombre;
    private javax.swing.JLabel LabNombreC;
    private javax.swing.JLabel LabNuevo;
    private javax.swing.JLabel LabPlazoD;
    private swingx.RoundLabel LabPresupuesto;
    private javax.swing.JLabel LabSaldoC;
    private swingx.RoundLabel LabSalir;
    private javax.swing.JLabel LabTipoC;
    private javax.swing.JLabel LabTipoT;
    private javax.swing.JLabel LabTituloCuenta;
    private javax.swing.JLabel LabTituloDeuda;
    private javax.swing.JLabel LabTituloPresupuesto;
    private javax.swing.JLabel LabTituloTransaccion;
    private swingx.RoundLabel LabTransaccion;
    private swingx.RoundLabel LabUsuario;
    private javax.swing.JPanel PanelCuenta;
    private javax.swing.JPanel PanelDeuda;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JPanel PanelInicio;
    private javax.swing.JPanel PanelMenu;
    private swingx.RoundPanel PanelModificarC;
    private swingx.RoundPanel PanelModificarD;
    private swingx.RoundPanel PanelModificarP;
    private swingx.RoundPanel PanelModificarT;
    private javax.swing.JPanel PanelNuevo;
    private javax.swing.JPanel PanelPresupuesto;
    private javax.swing.JPanel PanelSuperior;
    private javax.swing.JPanel PanelTransaccion;
    private javax.swing.JPanel PanelVentana;
    private javax.swing.JScrollPane ScrollCuenta;
    private javax.swing.JScrollPane ScrollDeuda;
    private javax.swing.JScrollPane ScrollPresupuesto;
    private javax.swing.JScrollPane ScrollTransaccion;
    private javax.swing.JTable TablaCuenta;
    private javax.swing.JTable TablaDeuda;
    private javax.swing.JTable TablaPresupuesto;
    private javax.swing.JTable TablaTransaccion;
    private javax.swing.JTextField TxtDescripDeuda;
    private javax.swing.JTextField TxtDescripcionTran;
    private javax.swing.JTextField TxtFechaFinal;
    private javax.swing.JTextField TxtFechaInicial;
    private javax.swing.JTextField TxtFechaTran;
    private javax.swing.JTextField TxtIdCuenta;
    private javax.swing.JTextField TxtIdDeuda;
    private javax.swing.JTextField TxtIdPresupuesto;
    private javax.swing.JTextField TxtIdTransaccion;
    private javax.swing.JTextField TxtInteresDeuda;
    private javax.swing.JTextField TxtMontoDeuda;
    private javax.swing.JTextField TxtMontoPresupuesto;
    private javax.swing.JTextField TxtMontoTran;
    private javax.swing.JTextField TxtNombreCuenta;
    private javax.swing.JTextField TxtPlazoDeuda;
    private javax.swing.JTextField TxtSaldoCuenta;
    private javax.swing.JTextField TxtTipoCuenta;
    // End of variables declaration//GEN-END:variables
}
