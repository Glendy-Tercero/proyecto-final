package view;

import gestorfinanzapersonal.Sesion;
import controller.CuentaController;
import controller.DeudaController;
import controller.PresupuestoController;
import controller.TransaccionController;
import controller.UsuarioController;
import model.UsuarioModel;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import sound.Sound;

public class NuevoRegistro extends javax.swing.JFrame {

    int moverX, moverY, x, y;
    
    private UsuarioController controladorUsu;
    private PresupuestoController controladorPres;
    private CuentaController controladorCue;
    private TransaccionController controladorTra;
    private DeudaController controladorDeu;
    private Image icono;

    public void SetVistaSesion(UsuarioController ControllerUsuario) {
    initComponents();
    controladorUsu= ControllerUsuario;
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
    controladorDeu= ControllerDeuda;
    }
    
    NuevoRegistro (UsuarioController ControllerUsuario, PresupuestoController ControllerPresupuesto, CuentaController ControllerCuenta, TransaccionController ControllerTransaccion, DeudaController ControllerDeuda) {
        initComponents();
        controladorUsu = ControllerUsuario;
        controladorPres = ControllerPresupuesto;
        controladorCue = ControllerCuenta;
        controladorTra = ControllerTransaccion;
        controladorDeu = ControllerDeuda;
        Sound.playSound("src/sound/change.wav");
        mostrarUsuario();
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
        String letra = usuario.getNombre().substring(0, 1);
        LabUsuario.setText(letra);
        }
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
        PanelPresupuesto = new javax.swing.JPanel();
        LabTituloCuenta1 = new javax.swing.JLabel();
        TxtMontoPresupuesto = new javax.swing.JTextField();
        LabMontoP = new javax.swing.JLabel();
        LabFechaFinal = new javax.swing.JLabel();
        TxtFechaFinal = new javax.swing.JTextField();
        LabFechaInicial = new javax.swing.JLabel();
        TxtFechaInicial = new javax.swing.JTextField();
        BtnLimpiarPresupuesto = new javax.swing.JButton();
        BtnGuardarPresupuesto = new javax.swing.JButton();
        PanelCuenta = new javax.swing.JPanel();
        LabTituloCuenta = new javax.swing.JLabel();
        TxtNombreCuenta = new javax.swing.JTextField();
        LabNombreC = new javax.swing.JLabel();
        LabSaldoC = new javax.swing.JLabel();
        TxtSaldoCuenta = new javax.swing.JTextField();
        LabTipoC = new javax.swing.JLabel();
        TxtTipoCuenta = new javax.swing.JTextField();
        BtnLimpiarCuenta = new javax.swing.JButton();
        BtnGuardarCuenta = new javax.swing.JButton();
        PanelTransaccion = new javax.swing.JPanel();
        LabTituloTransaccion = new javax.swing.JLabel();
        LabCategoriaT = new javax.swing.JLabel();
        LabFecha = new javax.swing.JLabel();
        TxtFechaTran = new javax.swing.JTextField();
        LabMontoT = new javax.swing.JLabel();
        TxtMontoTran = new javax.swing.JTextField();
        LabDescripcionT = new javax.swing.JLabel();
        TxtDescripcionTran = new javax.swing.JTextField();
        LabTipo = new javax.swing.JLabel();
        BoxCategoria = new javax.swing.JComboBox<>();
        BtnGuardarTran = new javax.swing.JButton();
        BtnLimpiarTran = new javax.swing.JButton();
        BoxTipo = new javax.swing.JComboBox<>();
        PanelDeuda = new javax.swing.JPanel();
        LabTituloDeuda = new javax.swing.JLabel();
        LabDescripcionD = new javax.swing.JLabel();
        TxtDescripDeuda = new javax.swing.JTextField();
        LabInteresD = new javax.swing.JLabel();
        TxtInteresDeuda = new javax.swing.JTextField();
        TxtPlazoDeuda = new javax.swing.JTextField();
        LabPlazoD = new javax.swing.JLabel();
        LabMontoD = new javax.swing.JLabel();
        TxtMontoDeuda = new javax.swing.JTextField();
        BtnLimpiarDeuda = new javax.swing.JButton();
        BtnGuardarDeuda = new javax.swing.JButton();

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
                .addGroup(PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LabNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelFondo.add(PanelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 40));

        PanelMenu.setBackground(new java.awt.Color(227, 120, 145));

        LabPresupuesto.setBackground(new java.awt.Color(255, 153, 176));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                .addComponent(LabSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(233, 233, 233))
        );

        PanelFondo.add(PanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 190, -1));

        PanelVentana.setPreferredSize(new java.awt.Dimension(790, 500));
        PanelVentana.setLayout(new java.awt.CardLayout());

        PanelPresupuesto.setBackground(new java.awt.Color(251, 249, 245));
        PanelPresupuesto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        LabTituloCuenta1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        LabTituloCuenta1.setForeground(new java.awt.Color(84, 70, 82));
        LabTituloCuenta1.setText("Nuevo Presupuesto");

        TxtMontoPresupuesto.setBackground(new java.awt.Color(251, 249, 245));
        TxtMontoPresupuesto.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TxtMontoPresupuesto.setForeground(new java.awt.Color(84, 70, 82));
        TxtMontoPresupuesto.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        LabMontoP.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabMontoP.setForeground(new java.awt.Color(128, 109, 183));
        LabMontoP.setText("Monto");

        LabFechaFinal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabFechaFinal.setForeground(new java.awt.Color(128, 109, 183));
        LabFechaFinal.setText("Fecha Final");

        TxtFechaFinal.setBackground(new java.awt.Color(251, 249, 245));
        TxtFechaFinal.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TxtFechaFinal.setForeground(new java.awt.Color(84, 70, 82));
        TxtFechaFinal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        LabFechaInicial.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabFechaInicial.setForeground(new java.awt.Color(128, 109, 183));
        LabFechaInicial.setText("Fecha Inicial");

        TxtFechaInicial.setBackground(new java.awt.Color(251, 249, 245));
        TxtFechaInicial.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TxtFechaInicial.setForeground(new java.awt.Color(84, 70, 82));
        TxtFechaInicial.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        BtnLimpiarPresupuesto.setBackground(new java.awt.Color(255, 207, 134));
        BtnLimpiarPresupuesto.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BtnLimpiarPresupuesto.setForeground(new java.awt.Color(255, 255, 255));
        BtnLimpiarPresupuesto.setText("LIMPIAR");
        BtnLimpiarPresupuesto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BtnLimpiarPresupuesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLimpiarPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarPresupuestoActionPerformed(evt);
            }
        });

        BtnGuardarPresupuesto.setBackground(new java.awt.Color(255, 207, 134));
        BtnGuardarPresupuesto.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BtnGuardarPresupuesto.setForeground(new java.awt.Color(255, 255, 255));
        BtnGuardarPresupuesto.setText("GUARDAR");
        BtnGuardarPresupuesto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BtnGuardarPresupuesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnGuardarPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarPresupuestoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPresupuestoLayout = new javax.swing.GroupLayout(PanelPresupuesto);
        PanelPresupuesto.setLayout(PanelPresupuestoLayout);
        PanelPresupuestoLayout.setHorizontalGroup(
            PanelPresupuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPresupuestoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(PanelPresupuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPresupuestoLayout.createSequentialGroup()
                        .addComponent(LabTituloCuenta1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelPresupuestoLayout.createSequentialGroup()
                        .addGroup(PanelPresupuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPresupuestoLayout.createSequentialGroup()
                                .addGroup(PanelPresupuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabFechaFinal)
                                    .addComponent(TxtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(296, 394, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPresupuestoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(BtnLimpiarPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(BtnGuardarPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPresupuestoLayout.createSequentialGroup()
                                .addGroup(PanelPresupuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabMontoP)
                                    .addComponent(TxtMontoPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelPresupuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabFechaInicial)
                                    .addComponent(TxtFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(34, 34, 34))))
        );
        PanelPresupuestoLayout.setVerticalGroup(
            PanelPresupuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPresupuestoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(LabTituloCuenta1)
                .addGap(58, 58, 58)
                .addGroup(PanelPresupuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPresupuestoLayout.createSequentialGroup()
                        .addComponent(LabFechaInicial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPresupuestoLayout.createSequentialGroup()
                        .addComponent(LabMontoP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtMontoPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addComponent(LabFechaFinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addGroup(PanelPresupuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGuardarPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLimpiarPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        PanelVentana.add(PanelPresupuesto, "card5");

        PanelCuenta.setBackground(new java.awt.Color(251, 249, 245));
        PanelCuenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        LabTituloCuenta.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        LabTituloCuenta.setForeground(new java.awt.Color(84, 70, 82));
        LabTituloCuenta.setText("Nueva Cuenta Bancaria");

        TxtNombreCuenta.setBackground(new java.awt.Color(251, 249, 245));
        TxtNombreCuenta.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TxtNombreCuenta.setForeground(new java.awt.Color(84, 70, 82));
        TxtNombreCuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        LabNombreC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabNombreC.setForeground(new java.awt.Color(128, 109, 183));
        LabNombreC.setText("Nombre");

        LabSaldoC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabSaldoC.setForeground(new java.awt.Color(128, 109, 183));
        LabSaldoC.setText("Saldo");

        TxtSaldoCuenta.setBackground(new java.awt.Color(251, 249, 245));
        TxtSaldoCuenta.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TxtSaldoCuenta.setForeground(new java.awt.Color(84, 70, 82));
        TxtSaldoCuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        LabTipoC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabTipoC.setForeground(new java.awt.Color(128, 109, 183));
        LabTipoC.setText("Tipo");

        TxtTipoCuenta.setBackground(new java.awt.Color(251, 249, 245));
        TxtTipoCuenta.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TxtTipoCuenta.setForeground(new java.awt.Color(84, 70, 82));
        TxtTipoCuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        BtnLimpiarCuenta.setBackground(new java.awt.Color(255, 207, 134));
        BtnLimpiarCuenta.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BtnLimpiarCuenta.setForeground(new java.awt.Color(255, 255, 255));
        BtnLimpiarCuenta.setText("LIMPIAR");
        BtnLimpiarCuenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BtnLimpiarCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLimpiarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarCuentaActionPerformed(evt);
            }
        });

        BtnGuardarCuenta.setBackground(new java.awt.Color(255, 207, 134));
        BtnGuardarCuenta.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BtnGuardarCuenta.setForeground(new java.awt.Color(255, 255, 255));
        BtnGuardarCuenta.setText("GUARDAR");
        BtnGuardarCuenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BtnGuardarCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnGuardarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarCuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCuentaLayout = new javax.swing.GroupLayout(PanelCuenta);
        PanelCuenta.setLayout(PanelCuentaLayout);
        PanelCuentaLayout.setHorizontalGroup(
            PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCuentaLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCuentaLayout.createSequentialGroup()
                        .addComponent(LabTituloCuenta)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelCuentaLayout.createSequentialGroup()
                        .addGroup(PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCuentaLayout.createSequentialGroup()
                                .addGroup(PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabSaldoC)
                                    .addComponent(TxtSaldoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(296, 394, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCuentaLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(BtnLimpiarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(BtnGuardarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCuentaLayout.createSequentialGroup()
                                .addGroup(PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabNombreC)
                                    .addComponent(TxtNombreCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabTipoC)
                                    .addComponent(TxtTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(34, 34, 34))))
        );
        PanelCuentaLayout.setVerticalGroup(
            PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCuentaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(LabTituloCuenta)
                .addGap(58, 58, 58)
                .addGroup(PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCuentaLayout.createSequentialGroup()
                        .addComponent(LabTipoC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCuentaLayout.createSequentialGroup()
                        .addComponent(LabNombreC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtNombreCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addComponent(LabSaldoC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtSaldoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addGroup(PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGuardarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLimpiarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        PanelVentana.add(PanelCuenta, "card5");

        PanelTransaccion.setBackground(new java.awt.Color(251, 249, 245));
        PanelTransaccion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        LabTituloTransaccion.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        LabTituloTransaccion.setForeground(new java.awt.Color(84, 70, 82));
        LabTituloTransaccion.setText("Nueva Transacción");

        LabCategoriaT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabCategoriaT.setForeground(new java.awt.Color(128, 109, 183));
        LabCategoriaT.setText("Categoría");

        LabFecha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabFecha.setForeground(new java.awt.Color(128, 109, 183));
        LabFecha.setText("Fecha");

        TxtFechaTran.setBackground(new java.awt.Color(251, 249, 245));
        TxtFechaTran.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TxtFechaTran.setForeground(new java.awt.Color(84, 70, 82));
        TxtFechaTran.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        LabMontoT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabMontoT.setForeground(new java.awt.Color(128, 109, 183));
        LabMontoT.setText("Monto");

        TxtMontoTran.setBackground(new java.awt.Color(251, 249, 245));
        TxtMontoTran.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TxtMontoTran.setForeground(new java.awt.Color(84, 70, 82));
        TxtMontoTran.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        LabDescripcionT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabDescripcionT.setForeground(new java.awt.Color(128, 109, 183));
        LabDescripcionT.setText("Descripción");

        TxtDescripcionTran.setBackground(new java.awt.Color(251, 249, 245));
        TxtDescripcionTran.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TxtDescripcionTran.setForeground(new java.awt.Color(84, 70, 82));
        TxtDescripcionTran.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        LabTipo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabTipo.setForeground(new java.awt.Color(128, 109, 183));
        LabTipo.setText("Tipo");

        BoxCategoria.setBackground(new java.awt.Color(251, 249, 245));
        BoxCategoria.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        BoxCategoria.setForeground(new java.awt.Color(84, 70, 82));
        BoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vivienda", "Alimentación", "Transporte", "Salud", "Entretenimiento", "Salario", "Bonificaciones", "Rendimientos", "Ventas", "Regalos", "Otro" }));
        BoxCategoria.setToolTipText("");
        BoxCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(216, 195, 151)));
        BoxCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BtnGuardarTran.setBackground(new java.awt.Color(255, 207, 134));
        BtnGuardarTran.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BtnGuardarTran.setForeground(new java.awt.Color(255, 255, 255));
        BtnGuardarTran.setText("GUARDAR");
        BtnGuardarTran.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BtnGuardarTran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnGuardarTran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarTranActionPerformed(evt);
            }
        });

        BtnLimpiarTran.setBackground(new java.awt.Color(255, 207, 134));
        BtnLimpiarTran.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BtnLimpiarTran.setForeground(new java.awt.Color(255, 255, 255));
        BtnLimpiarTran.setText("LIMPIAR");
        BtnLimpiarTran.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BtnLimpiarTran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLimpiarTran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarTranActionPerformed(evt);
            }
        });

        BoxTipo.setBackground(new java.awt.Color(251, 249, 245));
        BoxTipo.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        BoxTipo.setForeground(new java.awt.Color(84, 70, 82));
        BoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasto", "Ingreso" }));
        BoxTipo.setToolTipText("");
        BoxTipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(216, 195, 151)));
        BoxTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout PanelTransaccionLayout = new javax.swing.GroupLayout(PanelTransaccion);
        PanelTransaccion.setLayout(PanelTransaccionLayout);
        PanelTransaccionLayout.setHorizontalGroup(
            PanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTransaccionLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(PanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTransaccionLayout.createSequentialGroup()
                        .addComponent(LabTituloTransaccion)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelTransaccionLayout.createSequentialGroup()
                        .addGroup(PanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelTransaccionLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(BtnLimpiarTran, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(BtnGuardarTran, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTransaccionLayout.createSequentialGroup()
                                .addGroup(PanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabDescripcionT)
                                    .addComponent(TxtDescripcionTran, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addGroup(PanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LabTipo)
                                    .addComponent(LabMontoT)
                                    .addComponent(TxtMontoTran, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                    .addComponent(BoxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(34, 34, 34))
                    .addGroup(PanelTransaccionLayout.createSequentialGroup()
                        .addGroup(PanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabFecha)
                            .addComponent(TxtFechaTran, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabCategoriaT)
                            .addComponent(BoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PanelTransaccionLayout.setVerticalGroup(
            PanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTransaccionLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(LabTituloTransaccion)
                .addGap(35, 35, 35)
                .addGroup(PanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelTransaccionLayout.createSequentialGroup()
                        .addComponent(LabFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtFechaTran, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTransaccionLayout.createSequentialGroup()
                        .addComponent(LabMontoT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtMontoTran, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(PanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelTransaccionLayout.createSequentialGroup()
                        .addComponent(LabDescripcionT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtDescripcionTran, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(LabCategoriaT)
                        .addGap(18, 18, 18)
                        .addComponent(BoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelTransaccionLayout.createSequentialGroup()
                        .addComponent(LabTipo)
                        .addGap(18, 18, 18)
                        .addComponent(BoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158)))
                .addGroup(PanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGuardarTran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLimpiarTran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        PanelVentana.add(PanelTransaccion, "card2");

        PanelDeuda.setBackground(new java.awt.Color(251, 249, 245));
        PanelDeuda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        LabTituloDeuda.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        LabTituloDeuda.setForeground(new java.awt.Color(84, 70, 82));
        LabTituloDeuda.setText("Nueva Deuda");

        LabDescripcionD.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabDescripcionD.setForeground(new java.awt.Color(128, 109, 183));
        LabDescripcionD.setText("Descripción");

        TxtDescripDeuda.setBackground(new java.awt.Color(251, 249, 245));
        TxtDescripDeuda.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TxtDescripDeuda.setForeground(new java.awt.Color(84, 70, 82));
        TxtDescripDeuda.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        LabInteresD.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabInteresD.setForeground(new java.awt.Color(128, 109, 183));
        LabInteresD.setText("Interés");

        TxtInteresDeuda.setBackground(new java.awt.Color(251, 249, 245));
        TxtInteresDeuda.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TxtInteresDeuda.setForeground(new java.awt.Color(84, 70, 82));
        TxtInteresDeuda.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        TxtPlazoDeuda.setBackground(new java.awt.Color(251, 249, 245));
        TxtPlazoDeuda.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TxtPlazoDeuda.setForeground(new java.awt.Color(84, 70, 82));
        TxtPlazoDeuda.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        LabPlazoD.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabPlazoD.setForeground(new java.awt.Color(128, 109, 183));
        LabPlazoD.setText("Plazo");

        LabMontoD.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabMontoD.setForeground(new java.awt.Color(128, 109, 183));
        LabMontoD.setText("Monto");

        TxtMontoDeuda.setBackground(new java.awt.Color(251, 249, 245));
        TxtMontoDeuda.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TxtMontoDeuda.setForeground(new java.awt.Color(84, 70, 82));
        TxtMontoDeuda.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));

        BtnLimpiarDeuda.setBackground(new java.awt.Color(255, 207, 134));
        BtnLimpiarDeuda.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BtnLimpiarDeuda.setForeground(new java.awt.Color(255, 255, 255));
        BtnLimpiarDeuda.setText("LIMPIAR");
        BtnLimpiarDeuda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BtnLimpiarDeuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLimpiarDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarDeudaActionPerformed(evt);
            }
        });

        BtnGuardarDeuda.setBackground(new java.awt.Color(255, 207, 134));
        BtnGuardarDeuda.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BtnGuardarDeuda.setForeground(new java.awt.Color(255, 255, 255));
        BtnGuardarDeuda.setText("GUARDAR");
        BtnGuardarDeuda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BtnGuardarDeuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnGuardarDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarDeudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelDeudaLayout = new javax.swing.GroupLayout(PanelDeuda);
        PanelDeuda.setLayout(PanelDeudaLayout);
        PanelDeudaLayout.setHorizontalGroup(
            PanelDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDeudaLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(PanelDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabInteresD)
                    .addComponent(TxtInteresDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabDescripcionD)
                    .addComponent(TxtDescripDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(PanelDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabPlazoD)
                    .addComponent(TxtPlazoDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabMontoD)
                    .addComponent(TxtMontoDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
            .addGroup(PanelDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelDeudaLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(PanelDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelDeudaLayout.createSequentialGroup()
                            .addComponent(LabTituloDeuda)
                            .addGap(483, 483, 483))
                        .addGroup(PanelDeudaLayout.createSequentialGroup()
                            .addGap(0, 527, Short.MAX_VALUE)
                            .addComponent(BtnLimpiarDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(BtnGuardarDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)))))
        );
        PanelDeudaLayout.setVerticalGroup(
            PanelDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDeudaLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(PanelDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDeudaLayout.createSequentialGroup()
                        .addComponent(LabMontoD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtMontoDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelDeudaLayout.createSequentialGroup()
                        .addComponent(LabDescripcionD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtDescripDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66)
                .addGroup(PanelDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelDeudaLayout.createSequentialGroup()
                        .addComponent(LabInteresD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInteresDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelDeudaLayout.createSequentialGroup()
                        .addComponent(LabPlazoD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtPlazoDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(173, Short.MAX_VALUE))
            .addGroup(PanelDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelDeudaLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(LabTituloDeuda)
                    .addGap(368, 368, 368)
                    .addGroup(PanelDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnGuardarDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnLimpiarDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(25, Short.MAX_VALUE)))
        );

        PanelVentana.add(PanelDeuda, "card4");

        PanelFondo.add(PanelVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 790, 500));

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

     
    private void BtnGuardarTranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarTranActionPerformed
    if(!TxtFechaTran.getText().isEmpty() | !TxtMontoTran.getText().isEmpty() | !TxtDescripcionTran.getText().isEmpty()) {
    String fecha, descripcion, tipo, nombre, mensaje;
    int idUsuario, idCategoria;
    double monto;

    controladorTra = new TransaccionController();

    idUsuario = Sesion.getInstancia().getIdUsuario();
    nombre = BoxCategoria.getSelectedItem().toString();
    idCategoria = controladorTra.obtenerIdCategoria(nombre);
    fecha = this.TxtFechaTran.getText();
    monto = Double.parseDouble(this.TxtMontoTran.getText());
    descripcion = this.TxtDescripcionTran.getText();
    tipo = BoxTipo.getSelectedItem().toString();

    mensaje = controladorTra.InsertarTransaccion(idUsuario, idCategoria, fecha, monto, descripcion, tipo);
    JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

    MenuPrincipal menuPrincipal = new MenuPrincipal(controladorUsu, controladorPres, controladorCue, controladorTra, controladorDeu);
    menuPrincipal.setVisible(true);
    this.setVisible(false);   
    } else {
        Sound.playSound("src/sound/error.wav");
        JOptionPane.showMessageDialog(null, "Complete los campos vacíos.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_BtnGuardarTranActionPerformed

    private void BtnGuardarDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarDeudaActionPerformed
    if(!TxtDescripDeuda.getText().isEmpty() | !TxtMontoDeuda.getText().isEmpty() | !TxtInteresDeuda.getText().isEmpty() | !TxtPlazoDeuda.getText().isEmpty()) {
    String descripcion, plazo, mensaje;
    int idUsuario;
    double monto, interes;

        controladorDeu = new DeudaController();

        idUsuario = Sesion.getInstancia().getIdUsuario();
        descripcion = this.TxtDescripDeuda.getText();
        monto = Double.parseDouble(this.TxtMontoDeuda.getText());
        interes = Double.parseDouble(this.TxtInteresDeuda.getText());   
        plazo = this.TxtPlazoDeuda.getText();   

        mensaje = controladorDeu.InsertarDeuda(idUsuario, descripcion, monto, interes, plazo);
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

    MenuPrincipal menuPrincipal = new MenuPrincipal(controladorUsu, controladorPres, controladorCue, controladorTra, controladorDeu);
    menuPrincipal.setVisible(true);
    this.setVisible(false);   
    } else {
        Sound.playSound("src/sound/error.wav");
        JOptionPane.showMessageDialog(null, "Complete los campos vacíos.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_BtnGuardarDeudaActionPerformed

    private void PanelFondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFondoMousePressed
        moverX = evt.getX();
        moverY = evt.getY();
    }//GEN-LAST:event_PanelFondoMousePressed

    private void PanelFondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFondoMouseDragged
        x = evt.getXOnScreen();
        y = evt.getYOnScreen();
        this.setLocation(x - moverX, y - moverY);
    }//GEN-LAST:event_PanelFondoMouseDragged

    private void BtnLimpiarTranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarTranActionPerformed
        Sound.playSound("src/sound/click.wav");
        this.TxtDescripcionTran.setText("");
        this.TxtFechaTran.setText("");
        this.TxtMontoTran.setText("");
        BoxTipo.setSelectedIndex(0);
        BoxCategoria.setSelectedIndex(0);
    }//GEN-LAST:event_BtnLimpiarTranActionPerformed

    private void LabInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabInicioMouseEntered
        LabInicio.setForeground(Color.black);
        Sound.playSound("src/sound/cursor.wav");
    }//GEN-LAST:event_LabInicioMouseEntered

    private void LabInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabInicioMouseExited
        LabInicio.setForeground(new Color(84, 70, 82));
    }//GEN-LAST:event_LabInicioMouseExited

    private void LabInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabInicioMouseClicked
        MenuPrincipal Menu = new MenuPrincipal(controladorUsu, controladorPres, controladorCue, controladorTra, controladorDeu);
        Menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LabInicioMouseClicked

    private void BtnLimpiarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarCuentaActionPerformed
        Sound.playSound("src/sound/click.wav");
        this.TxtNombreCuenta.setText("");
        this.TxtTipoCuenta.setText("");
        this.TxtSaldoCuenta.setText("");                             
    }//GEN-LAST:event_BtnLimpiarCuentaActionPerformed

    private void BtnGuardarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarCuentaActionPerformed
    if(!TxtNombreCuenta.getText().isEmpty() | !TxtTipoCuenta.getText().isEmpty() | !TxtSaldoCuenta.getText().isEmpty()) {
    String nombre, tipo, mensaje;
    int idUsuario;
    double saldo;

        controladorCue = new CuentaController();

        idUsuario = Sesion.getInstancia().getIdUsuario();
        nombre = this.TxtNombreCuenta.getText();
        tipo = this.TxtTipoCuenta.getText();
        saldo = Double.parseDouble(this.TxtSaldoCuenta.getText());

        mensaje = controladorCue.InsertarCuenta(idUsuario, nombre, tipo, saldo);
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

    MenuPrincipal menuPrincipal = new MenuPrincipal(controladorUsu, controladorPres, controladorCue, controladorTra, controladorDeu);
    menuPrincipal.setVisible(true);
    this.setVisible(false);   
    } else {
        Sound.playSound("src/sound/error.wav");
        JOptionPane.showMessageDialog(null, "Complete los campos vacíos.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_BtnGuardarCuentaActionPerformed

    private void BtnLimpiarDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarDeudaActionPerformed
        Sound.playSound("src/sound/click.wav");
        this.TxtDescripDeuda.setText("");
        this.TxtMontoDeuda.setText("");
        this.TxtInteresDeuda.setText("");   
        this.TxtPlazoDeuda.setText("");   
    }//GEN-LAST:event_BtnLimpiarDeudaActionPerformed

    private void LabNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabNombreMouseClicked
        UsuarioPerfil Usuario = new UsuarioPerfil(controladorUsu, controladorPres, controladorCue, controladorTra, controladorDeu);
        Usuario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LabNombreMouseClicked

    private void BtnLimpiarPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarPresupuestoActionPerformed
        Sound.playSound("src/sound/click.wav");
        this.TxtDescripDeuda.setText("");
        this.TxtMontoDeuda.setText("");
        this.TxtInteresDeuda.setText("");   
        this.TxtPlazoDeuda.setText(""); 
    }//GEN-LAST:event_BtnLimpiarPresupuestoActionPerformed

    private void BtnGuardarPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarPresupuestoActionPerformed
    if(!TxtMontoPresupuesto.getText().isEmpty() | !TxtFechaInicial.getText().isEmpty() | !TxtFechaFinal.getText().isEmpty()) {
        String fechaInicio, fechaFin, mensaje;
        int idUsuario;
        double monto;

            controladorPres = new PresupuestoController();

            idUsuario = Sesion.getInstancia().getIdUsuario();
            monto = Double.parseDouble(this.TxtMontoPresupuesto.getText());
            fechaInicio = this.TxtFechaInicial.getText();
            fechaFin = this.TxtFechaFinal.getText();

        mensaje = controladorPres.insertarPresupuesto(idUsuario, monto, fechaInicio, fechaFin);
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

        MenuPrincipal menuPrincipal = new MenuPrincipal(controladorUsu, controladorPres, controladorCue, controladorTra, controladorDeu);
        menuPrincipal.setVisible(true);
        this.setVisible(false);
        } else {
        Sound.playSound("src/sound/error.wav");
        JOptionPane.showMessageDialog(null, "Complete los campos vacíos.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_BtnGuardarPresupuestoActionPerformed

    private void LabPresupuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabPresupuestoMouseClicked
        Sound.playSound("src/sound/click.wav");
        
        LabPresupuesto.setBackground(new  Color(255, 153, 176));
        PanelPresupuesto.setVisible(true);

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

        LabPresupuesto.setBackground(new Color(227, 120, 145));
        PanelPresupuesto.setVisible(false); 
        
        LabCuenta.setBackground(new Color(227, 120, 145));
        PanelCuenta.setVisible(false);
        
        LabTransaccion.setBackground(new Color(227, 120, 145));
        PanelTransaccion.setVisible(false);
    }//GEN-LAST:event_LabDeudaMouseClicked

    private void LabSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabSalirMouseEntered
        LabSalir.setBackground(new Color(228, 55, 68));
        Sound.playSound("src/sound/cursor.wav");
    }//GEN-LAST:event_LabSalirMouseEntered

    private void LabSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabSalirMouseExited
        LabSalir.setBackground(new  Color(227, 120, 145));
    }//GEN-LAST:event_LabSalirMouseExited

    private void LabSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabSalirMouseClicked
        Sound.playSound("src/sound/change.wav");
        IniciarSesion Sesion = new IniciarSesion();
        Sesion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LabSalirMouseClicked

    private void LabUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabUsuarioMouseClicked
        UsuarioPerfil Usuario = new UsuarioPerfil(controladorUsu, controladorPres, controladorCue, controladorTra, controladorDeu);
        Usuario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LabUsuarioMouseClicked

    private void LabNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabNombreMouseEntered
        if(LabNombre.getForeground().equals(new Color(84, 70, 82)) | LabUsuario.getBackground().equals(new Color(128, 109, 183))) {
        LabNombre.setForeground(new Color(135, 129, 134));
        LabUsuario.setBackground(new Color(197, 205, 250));
        }
    }//GEN-LAST:event_LabNombreMouseEntered

    private void LabNombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabNombreMouseExited
        LabNombre.setForeground(new Color(84, 70, 82));
        LabUsuario.setBackground(new Color(128, 109, 183));
    }//GEN-LAST:event_LabNombreMouseExited

    private void LabUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabUsuarioMouseEntered
        if(LabUsuario.getBackground().equals(new Color(128, 109, 183)) | LabNombre.getForeground().equals(new Color(84, 70, 82)) ) {
        LabUsuario.setBackground(new Color(197, 205, 250));
        LabNombre.setForeground(new Color(135, 129, 134));
        }
    }//GEN-LAST:event_LabUsuarioMouseEntered

    private void LabUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabUsuarioMouseExited
        LabUsuario.setBackground(new Color(128, 109, 183));
        LabNombre.setForeground(new Color(84, 70, 82));
    }//GEN-LAST:event_LabUsuarioMouseExited

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
            java.util.logging.Logger.getLogger(NuevoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxCategoria;
    private javax.swing.JComboBox<String> BoxTipo;
    private javax.swing.JButton BtnGuardarCuenta;
    private javax.swing.JButton BtnGuardarDeuda;
    private javax.swing.JButton BtnGuardarPresupuesto;
    private javax.swing.JButton BtnGuardarTran;
    private javax.swing.JButton BtnLimpiarCuenta;
    private javax.swing.JButton BtnLimpiarDeuda;
    private javax.swing.JButton BtnLimpiarPresupuesto;
    private javax.swing.JButton BtnLimpiarTran;
    private javax.swing.JLabel LabCategoriaT;
    private swingx.RoundLabel LabCuenta;
    private javax.swing.JLabel LabDescripcionD;
    private javax.swing.JLabel LabDescripcionT;
    private swingx.RoundLabel LabDeuda;
    private javax.swing.JLabel LabFecha;
    private javax.swing.JLabel LabFechaFinal;
    private javax.swing.JLabel LabFechaInicial;
    private javax.swing.JLabel LabInicio;
    private javax.swing.JLabel LabInteresD;
    private javax.swing.JLabel LabMontoD;
    private javax.swing.JLabel LabMontoP;
    private javax.swing.JLabel LabMontoT;
    private javax.swing.JLabel LabNombre;
    private javax.swing.JLabel LabNombreC;
    private javax.swing.JLabel LabPlazoD;
    private swingx.RoundLabel LabPresupuesto;
    private javax.swing.JLabel LabSaldoC;
    private swingx.RoundLabel LabSalir;
    private javax.swing.JLabel LabTipo;
    private javax.swing.JLabel LabTipoC;
    private javax.swing.JLabel LabTituloCuenta;
    private javax.swing.JLabel LabTituloCuenta1;
    private javax.swing.JLabel LabTituloDeuda;
    private javax.swing.JLabel LabTituloTransaccion;
    private swingx.RoundLabel LabTransaccion;
    private swingx.RoundLabel LabUsuario;
    private javax.swing.JPanel PanelCuenta;
    private javax.swing.JPanel PanelDeuda;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelPresupuesto;
    private javax.swing.JPanel PanelSuperior;
    private javax.swing.JPanel PanelTransaccion;
    private javax.swing.JPanel PanelVentana;
    private javax.swing.JTextField TxtDescripDeuda;
    private javax.swing.JTextField TxtDescripcionTran;
    private javax.swing.JTextField TxtFechaFinal;
    private javax.swing.JTextField TxtFechaInicial;
    private javax.swing.JTextField TxtFechaTran;
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
