package view;

import controller.CuentaController;
import controller.DeudaController;
import controller.PresupuestoController;
import controller.TransaccionController;
import controller.UsuarioController;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import sound.Sound;

public class IniciarSesion extends javax.swing.JFrame {

    int moverX, moverY, x, y;
    
    private UsuarioController controladorUsu;
    private PresupuestoController controladorPres;
    private CuentaController controladorCue;
    private TransaccionController controladorTra;
    private DeudaController controladorDeu;
    private int idUsuario;
    private Image icono;

    public IniciarSesion() {
        initComponents();
        curves();
        imagenesEnfoque();
    }

    public void SetVistaSesion(UsuarioController ControllerUsuario, PresupuestoController ControllerPresupuesto, CuentaController ControllerCuenta, TransaccionController ControllerTransaccion, DeudaController ControllerDeuda) {  
        initComponents();
        controladorUsu = ControllerUsuario;
        controladorPres = ControllerPresupuesto;
        controladorCue = ControllerCuenta;
        controladorTra = ControllerTransaccion;
        controladorDeu = ControllerDeuda;
    }
    
    @Override
    public Image getIconImage() {
        if (icono == null) {
        icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/icono.png"));
    }
    return icono;
    }
    
    public void curves(){
        PanelFondo.start();
    }
    
    public ImageIcon ajustarImagen(String rutaImagen, int ancho, int alto) {
    ImageIcon icono = new ImageIcon(getClass().getResource(rutaImagen));
    Image imagen = icono.getImage();
    Image imagenRedimensionada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
    return new ImageIcon(imagenRedimensionada);
    }
   
    public void imagenesEnfoque() {
        LabUsuario.setIcon(ajustarImagen("/icon/usuario_de_perfil.png", 100, 100));
        LabAgregarUsuario.setIcon(ajustarImagen("/icon/agregar_usuario.png", 80, 80));
        SwingUtilities.invokeLater(() -> {
            BotonCerrar.requestFocusInWindow();
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFondo = new swingx.CurvesPanel();
        PanelMenu = new javax.swing.JPanel();
        LabCity = new javax.swing.JLabel();
        LabRegistrarse = new javax.swing.JLabel();
        LabIniciarSesion = new javax.swing.JLabel();
        Separator = new javax.swing.JSeparator();
        BotonCerrar = new javax.swing.JPanel();
        TxtCerrar = new javax.swing.JLabel();
        PanelVentana = new javax.swing.JPanel();
        PanelIniciarSesion = new javax.swing.JPanel();
        TxtEmail = new javax.swing.JTextField();
        LabEmail = new javax.swing.JLabel();
        LabContra = new javax.swing.JLabel();
        BotonEntrar = new javax.swing.JButton();
        LabUsuario = new javax.swing.JLabel();
        TxtContraseña = new javax.swing.JPasswordField();
        PanelRegistrarse = new javax.swing.JPanel();
        TxtNuevoEmail = new javax.swing.JTextField();
        TxtNuevaContra = new javax.swing.JTextField();
        LabNuevoEmail = new javax.swing.JLabel();
        LabNuevaContra = new javax.swing.JLabel();
        LabAgregarUsuario = new javax.swing.JLabel();
        BotonCrear = new javax.swing.JButton();
        LabNuevoNombre = new javax.swing.JLabel();
        TxtNuevoNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

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

        PanelMenu.setBackground(new java.awt.Color(158, 103, 186));
        PanelMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 0, 2, new java.awt.Color(215, 137, 255)));
        PanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabCity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/city_night.jpg"))); // NOI18N
        LabCity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(215, 137, 255)));
        PanelMenu.add(LabCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 320, 330));

        LabRegistrarse.setBackground(new java.awt.Color(251, 249, 245));
        LabRegistrarse.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        LabRegistrarse.setForeground(new java.awt.Color(251, 249, 245));
        LabRegistrarse.setText("REGISTRARSE");
        LabRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabRegistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabRegistrarseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabRegistrarseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabRegistrarseMouseExited(evt);
            }
        });
        PanelMenu.add(LabRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        LabIniciarSesion.setBackground(new java.awt.Color(251, 249, 245));
        LabIniciarSesion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        LabIniciarSesion.setForeground(new java.awt.Color(254, 221, 185));
        LabIniciarSesion.setText("INICIAR SESIÓN");
        LabIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabIniciarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabIniciarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabIniciarSesionMouseExited(evt);
            }
        });
        PanelMenu.add(LabIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        Separator.setForeground(new java.awt.Color(255, 207, 134));
        PanelMenu.add(Separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 230, 10));

        BotonCerrar.setBackground(new java.awt.Color(227, 120, 145));
        BotonCerrar.setToolTipText("");
        BotonCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonCerrar.setOpaque(false);

        TxtCerrar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        TxtCerrar.setForeground(new java.awt.Color(84, 70, 82));
        TxtCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtCerrar.setText("X");
        TxtCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonTxtCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonTxtCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TxtCerrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout BotonCerrarLayout = new javax.swing.GroupLayout(BotonCerrar);
        BotonCerrar.setLayout(BotonCerrarLayout);
        BotonCerrarLayout.setHorizontalGroup(
            BotonCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(BotonCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BotonCerrarLayout.createSequentialGroup()
                    .addComponent(TxtCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        BotonCerrarLayout.setVerticalGroup(
            BotonCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(BotonCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BotonCerrarLayout.createSequentialGroup()
                    .addComponent(TxtCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        PanelVentana.setLayout(new java.awt.CardLayout());

        PanelIniciarSesion.setBackground(new java.awt.Color(251, 249, 245));
        PanelIniciarSesion.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 2, new java.awt.Color(228, 55, 68)), javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED)));
        PanelIniciarSesion.setPreferredSize(new java.awt.Dimension(540, 515));

        TxtEmail.setBackground(new java.awt.Color(251, 249, 245));
        TxtEmail.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TxtEmail.setForeground(new java.awt.Color(204, 204, 204));
        TxtEmail.setText("nombre@example.com");
        TxtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));
        TxtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TxtEmailMousePressed(evt);
            }
        });

        LabEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabEmail.setForeground(new java.awt.Color(128, 109, 183));
        LabEmail.setText("Correo Electrónico");

        LabContra.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabContra.setForeground(new java.awt.Color(128, 109, 183));
        LabContra.setText("Contraseña");

        BotonEntrar.setBackground(new java.awt.Color(255, 207, 134));
        BotonEntrar.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BotonEntrar.setForeground(new java.awt.Color(255, 255, 255));
        BotonEntrar.setText("ENTRAR");
        BotonEntrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BotonEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonEntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonEntrarMouseExited(evt);
            }
        });
        BotonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEntrarActionPerformed(evt);
            }
        });

        TxtContraseña.setBackground(new java.awt.Color(251, 249, 245));
        TxtContraseña.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TxtContraseña.setForeground(new java.awt.Color(204, 204, 204));
        TxtContraseña.setText("**********");
        TxtContraseña.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));
        TxtContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TxtContraseñaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PanelIniciarSesionLayout = new javax.swing.GroupLayout(PanelIniciarSesion);
        PanelIniciarSesion.setLayout(PanelIniciarSesionLayout);
        PanelIniciarSesionLayout.setHorizontalGroup(
            PanelIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIniciarSesionLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(PanelIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LabContra, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabEmail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIniciarSesionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
        );
        PanelIniciarSesionLayout.setVerticalGroup(
            PanelIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIniciarSesionLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(LabUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(LabEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(LabContra)
                .addGap(18, 18, 18)
                .addComponent(TxtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(BotonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        PanelVentana.add(PanelIniciarSesion, "card2");

        PanelRegistrarse.setBackground(new java.awt.Color(251, 249, 245));
        PanelRegistrarse.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 2, new java.awt.Color(228, 55, 68)), javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED)));
        PanelRegistrarse.setPreferredSize(new java.awt.Dimension(570, 523));

        TxtNuevoEmail.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TxtNuevoEmail.setForeground(new java.awt.Color(84, 70, 82));
        TxtNuevoEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 219, 206)));
        TxtNuevoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNuevoEmailActionPerformed(evt);
            }
        });

        TxtNuevaContra.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TxtNuevaContra.setForeground(new java.awt.Color(84, 70, 82));
        TxtNuevaContra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 219, 206)));

        LabNuevoEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabNuevoEmail.setForeground(new java.awt.Color(128, 109, 183));
        LabNuevoEmail.setText("Correo Electrónico");

        LabNuevaContra.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabNuevaContra.setForeground(new java.awt.Color(128, 109, 183));
        LabNuevaContra.setText("Contraseña");

        LabAgregarUsuario.setFont(new java.awt.Font("Bernard MT Condensed", 0, 22)); // NOI18N
        LabAgregarUsuario.setForeground(new java.awt.Color(84, 70, 82));

        BotonCrear.setBackground(new java.awt.Color(255, 207, 134));
        BotonCrear.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BotonCrear.setForeground(new java.awt.Color(255, 255, 255));
        BotonCrear.setText("CREAR");
        BotonCrear.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BotonCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonCrearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonCrearMouseExited(evt);
            }
        });
        BotonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearActionPerformed(evt);
            }
        });

        LabNuevoNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabNuevoNombre.setForeground(new java.awt.Color(128, 109, 183));
        LabNuevoNombre.setText("Nombre de Usuario");

        TxtNuevoNombre.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TxtNuevoNombre.setForeground(new java.awt.Color(84, 70, 82));
        TxtNuevoNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 219, 206)));

        javax.swing.GroupLayout PanelRegistrarseLayout = new javax.swing.GroupLayout(PanelRegistrarse);
        PanelRegistrarse.setLayout(PanelRegistrarseLayout);
        PanelRegistrarseLayout.setHorizontalGroup(
            PanelRegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistrarseLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(PanelRegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BotonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelRegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(LabNuevoNombre)
                        .addComponent(TxtNuevoNombre)
                        .addComponent(LabNuevaContra)
                        .addComponent(LabNuevoEmail)
                        .addComponent(TxtNuevaContra)
                        .addComponent(TxtNuevoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistrarseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabAgregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
        );
        PanelRegistrarseLayout.setVerticalGroup(
            PanelRegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistrarseLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(LabAgregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(LabNuevoNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtNuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabNuevoEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtNuevoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabNuevaContra)
                .addGap(19, 19, 19)
                .addComponent(TxtNuevaContra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(BotonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        PanelVentana.add(PanelRegistrarse, "card3");

        javax.swing.GroupLayout PanelFondoLayout = new javax.swing.GroupLayout(PanelFondo);
        PanelFondo.setLayout(PanelFondoLayout);
        PanelFondoLayout.setHorizontalGroup(
            PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFondoLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(PanelVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(BotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelFondoLayout.setVerticalGroup(
            PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFondoLayout.createSequentialGroup()
                .addComponent(BotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFondoLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelVentana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtCerrarMouseExited
        TxtCerrar.setForeground(new Color(84, 70, 82));
        BotonCerrar.setOpaque(false);
        BotonCerrar.setForeground(new Color(228, 55, 68));
    }//GEN-LAST:event_TxtCerrarMouseExited

    private void BotonTxtCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonTxtCerrarMouseClicked
        Sound.playSound("src/sound/click.wav");
        System.exit(0);
    }//GEN-LAST:event_BotonTxtCerrarMouseClicked

    private void BotonTxtCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonTxtCerrarMouseEntered
        TxtCerrar.setForeground(new Color(251, 249, 245));
        BotonCerrar.setOpaque(true);
        BotonCerrar.setBackground(new Color(228, 55, 68));
        BotonCerrar.setForeground(new Color(227, 120, 145));
        Sound.playSound("src/sound/cursor.wav");
    }//GEN-LAST:event_BotonTxtCerrarMouseEntered

    private void TxtNuevoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNuevoEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNuevoEmailActionPerformed

    private void TxtEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtEmailMousePressed
        if (TxtEmail.getText().equals("nombre@example.com")) {
        TxtEmail.setText("");
        TxtEmail.setForeground(new Color(84, 70, 82));
        }
        if (String.valueOf(TxtContraseña.getPassword()).isEmpty()) {
        TxtContraseña.setText("**********");
        TxtContraseña.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_TxtEmailMousePressed

    private void BotonEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEntrarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonEntrarMouseClicked

    private void BotonEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEntrarMouseEntered
        BotonEntrar.setBackground(new Color(254, 221, 185));
        Sound.playSound("src/sound/cursor.wav");
    }//GEN-LAST:event_BotonEntrarMouseEntered

    private void BotonEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEntrarMouseExited
        BotonEntrar.setBackground(new Color(255, 207, 134));
    }//GEN-LAST:event_BotonEntrarMouseExited

    private void TxtContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtContraseñaMousePressed
    if (String.valueOf(TxtContraseña.getPassword()).equals("**********")) {
        TxtContraseña.setText("");
        TxtContraseña.setForeground(new Color(84, 70, 82));
    }
    if (TxtEmail.getText().isEmpty()) {
        TxtEmail.setText("nombre@example.com");
        TxtEmail.setForeground(new Color(204, 204, 204));
    }
    }//GEN-LAST:event_TxtContraseñaMousePressed

    private void BotonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEntrarActionPerformed
    if(!TxtEmail.getText().equals("nombre@example.com") | !String.valueOf(TxtContraseña.getPassword()).equals("**********")) {
    String email, contraseña, mensaje;
            
    controladorUsu = new UsuarioController();
    
    email = this.TxtEmail.getText();
    contraseña = new String(this.TxtContraseña.getPassword());
    mensaje = controladorUsu.IniciarSesion(email, contraseña);
    
    if (mensaje.equals("Inicio de sesión exitoso")) {
        controladorPres = new PresupuestoController();
        controladorCue = new CuentaController();
        controladorTra = new TransaccionController();
        controladorDeu = new DeudaController();
        MenuPrincipal Menu = new MenuPrincipal(controladorUsu, controladorPres, controladorCue, controladorTra, controladorDeu);
        Menu.setVisible(true);
        this.setVisible(false);
    } else {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE); } 
    } else {
        Sound.playSound("src/sound/error.wav");
        JOptionPane.showMessageDialog(null, "Complete los campos vacíos.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_BotonEntrarActionPerformed

    private void BotonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearActionPerformed
    if(!TxtNuevoNombre.getText().isEmpty() | !TxtNuevoEmail.getText().isEmpty() | !TxtNuevaContra.getText().isEmpty()) {
    Sound.playSound("src/sound/click.wav");
    String nombre, email, contraseña, mensaje;
    
    controladorUsu = new UsuarioController();

    nombre = this.TxtNuevoNombre.getText();
    email = this.TxtNuevoEmail.getText();
    contraseña = this.TxtNuevaContra.getText();
    mensaje = controladorUsu.InsertarUsuario(nombre, email, contraseña);
         
    if (mensaje.equals("Guardado exitosamente")) {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE); 
        int idUsuario = controladorUsu.obtenerIdUsuario();
        
        LabIniciarSesion.setForeground(new Color(254, 221, 185));
        PanelIniciarSesion.setVisible(true);
        LabRegistrarse.setForeground(new Color(251, 249, 245));
        PanelRegistrarse.setVisible(false);
        
        this.TxtNuevoNombre.setText("");
        this.TxtNuevoEmail.setText("");
        this.TxtNuevaContra.setText("");
    } else {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE); } 
    } else {
        Sound.playSound("src/sound/error.wav");
        JOptionPane.showMessageDialog(null, "Complete los campos vacíos.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_BotonCrearActionPerformed

    private void BotonCrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCrearMouseEntered
        BotonCrear.setBackground(new Color(254, 221, 185));
        Sound.playSound("src/sound/cursor.wav");
    }//GEN-LAST:event_BotonCrearMouseEntered

    private void BotonCrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCrearMouseExited
        BotonCrear.setBackground(new Color(255, 207, 134));
    }//GEN-LAST:event_BotonCrearMouseExited

    private void LabIniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabIniciarSesionMouseClicked
        LabIniciarSesion.setForeground(new Color(254, 221, 185));
        PanelIniciarSesion.setVisible(true);

        LabRegistrarse.setForeground(new Color(251, 249, 245));
        PanelRegistrarse.setVisible(false);
        
        Sound.playSound("src/sound/click.wav");
    }//GEN-LAST:event_LabIniciarSesionMouseClicked

    private void LabRegistrarseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabRegistrarseMouseClicked
        LabRegistrarse.setForeground(new Color(254, 221, 185));
        PanelRegistrarse.setVisible(true);

        LabIniciarSesion.setForeground(new Color(251, 249, 245));
        PanelIniciarSesion.setVisible(false);
        
        Sound.playSound("src/sound/click.wav");
    }//GEN-LAST:event_LabRegistrarseMouseClicked

    private void PanelFondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFondoMousePressed
        moverX = evt.getX();
        moverY = evt.getY();
    }//GEN-LAST:event_PanelFondoMousePressed

    private void PanelFondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFondoMouseDragged
        x = evt.getXOnScreen();
        y = evt.getYOnScreen();
        this.setLocation(x - moverX, y - moverY);
    }//GEN-LAST:event_PanelFondoMouseDragged

    private void LabIniciarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabIniciarSesionMouseEntered
        if (!LabIniciarSesion.getForeground().equals(new Color(254, 221, 185))) {
            LabIniciarSesion.setForeground(new Color(226, 204, 236));
            Sound.playSound("src/sound/cursor.wav");
        }
    }//GEN-LAST:event_LabIniciarSesionMouseEntered

    private void LabIniciarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabIniciarSesionMouseExited
        if (!LabIniciarSesion.getForeground().equals(new Color(254, 221, 185))) {
            LabIniciarSesion.setForeground(new Color(251, 249, 245));
        }
    }//GEN-LAST:event_LabIniciarSesionMouseExited

    private void LabRegistrarseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabRegistrarseMouseEntered
        if (!LabRegistrarse.getForeground().equals(new Color(254, 221, 185))) {
            LabRegistrarse.setForeground(new Color(226, 204, 236));
            Sound.playSound("src/sound/cursor.wav");
        }
    }//GEN-LAST:event_LabRegistrarseMouseEntered

    private void LabRegistrarseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabRegistrarseMouseExited
        if (!LabRegistrarse.getForeground().equals(new Color(254, 221, 185))) {
            LabRegistrarse.setForeground(new Color(251, 249, 245));
        }
    }//GEN-LAST:event_LabRegistrarseMouseExited

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
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new IniciarSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BotonCerrar;
    private javax.swing.JButton BotonCrear;
    private javax.swing.JButton BotonEntrar;
    private javax.swing.JLabel LabAgregarUsuario;
    private javax.swing.JLabel LabCity;
    private javax.swing.JLabel LabContra;
    private javax.swing.JLabel LabEmail;
    private javax.swing.JLabel LabIniciarSesion;
    private javax.swing.JLabel LabNuevaContra;
    private javax.swing.JLabel LabNuevoEmail;
    private javax.swing.JLabel LabNuevoNombre;
    private javax.swing.JLabel LabRegistrarse;
    private javax.swing.JLabel LabUsuario;
    private swingx.CurvesPanel PanelFondo;
    private javax.swing.JPanel PanelIniciarSesion;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelRegistrarse;
    private javax.swing.JPanel PanelVentana;
    private javax.swing.JSeparator Separator;
    private javax.swing.JLabel TxtCerrar;
    private javax.swing.JPasswordField TxtContraseña;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtNuevaContra;
    private javax.swing.JTextField TxtNuevoEmail;
    private javax.swing.JTextField TxtNuevoNombre;
    // End of variables declaration//GEN-END:variables
}
