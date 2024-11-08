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
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import sound.Sound;


public class UsuarioPerfil extends javax.swing.JFrame {

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
    
   UsuarioPerfil (UsuarioController ControllerUsuario, PresupuestoController ControllerPresupuesto, CuentaController ControllerCuenta, TransaccionController ControllerTransaccion, DeudaController ControllerDeuda) {
        initComponents();
        controladorUsu = ControllerUsuario;
        controladorPres = ControllerPresupuesto;
        controladorCue = ControllerCuenta;
        controladorTra = ControllerTransaccion;
        controladorDeu = ControllerDeuda;
        Sound.playSound("src/sound/change.wav");
        mostrarUsuario();
        mostrarEditarUsuario();
        SwingUtilities.invokeLater(() -> {
            LabInicio.requestFocusInWindow();
        });
    }   

   @Override
    public Image getIconImage() {
        if (icono == null) {
        icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/icono.png"));
    }
    return icono;
    }
    
public void mostrarUsuario() {
    UsuarioController controladorUsu = new UsuarioController();
    UsuarioModel usuario = controladorUsu.obtenerUsuario();   
    if (usuario != null) {
        LabNombre.setText(usuario.getNombre());
        LabEmail.setText(usuario.getEmail());
        LabContraseña.setText(usuario.getContraseña());
        String letra = usuario.getNombre().substring(0, 1);
        LabUsuario.setText(letra);
        LabUsuarioEd.setText(letra);
        }
    }

public void mostrarEditarUsuario() {
    UsuarioController controladorUsu = new UsuarioController();
    UsuarioModel usuario = controladorUsu.obtenerUsuario();
    if (usuario != null) {
        TxtNuevoNombre.setText(usuario.getNombre());
        TxtNuevoEmail.setText(usuario.getEmail());
        TxtNuevaContra.setText(usuario.getContraseña());
        }
}   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFondo = new javax.swing.JPanel();
        PanelSuperior = new javax.swing.JPanel();
        LabInicio = new javax.swing.JLabel();
        PanelVentana = new javax.swing.JPanel();
        PanelPerfil = new javax.swing.JPanel();
        LabUsuario = new swingx.RoundLabel();
        LabelEmail = new javax.swing.JLabel();
        LabelNombre = new javax.swing.JLabel();
        LabelContra = new javax.swing.JLabel();
        BotonEliminar = new javax.swing.JButton();
        BotonEditar = new javax.swing.JButton();
        LabNombre = new javax.swing.JLabel();
        LabEmail = new javax.swing.JLabel();
        LabContraseña = new javax.swing.JPasswordField();
        PanelEditarPerfil = new javax.swing.JPanel();
        LabUsuarioEd = new swingx.RoundLabel();
        LabelNuevoEmail = new javax.swing.JLabel();
        TxtNuevoEmail = new javax.swing.JTextField();
        LabelNuevoNombre = new javax.swing.JLabel();
        TxtNuevoNombre = new javax.swing.JTextField();
        LabelNuevoContra = new javax.swing.JLabel();
        TxtNuevaContra = new javax.swing.JTextField();
        BtnGuardar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();

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

        javax.swing.GroupLayout PanelSuperiorLayout = new javax.swing.GroupLayout(PanelSuperior);
        PanelSuperior.setLayout(PanelSuperiorLayout);
        PanelSuperiorLayout.setHorizontalGroup(
            PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSuperiorLayout.createSequentialGroup()
                .addComponent(LabInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 922, Short.MAX_VALUE))
        );
        PanelSuperiorLayout.setVerticalGroup(
            PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSuperiorLayout.createSequentialGroup()
                .addComponent(LabInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelVentana.setLayout(new java.awt.CardLayout());

        PanelPerfil.setBackground(new java.awt.Color(251, 249, 245));
        PanelPerfil.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 2, new java.awt.Color(128, 109, 183)), javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED)));

        LabUsuario.setBackground(new java.awt.Color(128, 109, 183));
        LabUsuario.setForeground(new java.awt.Color(255, 255, 255));
        LabUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabUsuario.setText("A");
        LabUsuario.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 55)); // NOI18N
        LabUsuario.setRoundBottomLeft(150);
        LabUsuario.setRoundBottomRight(150);
        LabUsuario.setRoundTopLeft(150);
        LabUsuario.setRoundTopRight(150);

        LabelEmail.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        LabelEmail.setForeground(new java.awt.Color(128, 109, 183));
        LabelEmail.setText("Correo Electrónico");

        LabelNombre.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        LabelNombre.setForeground(new java.awt.Color(128, 109, 183));
        LabelNombre.setText("Nombre de Usuario");

        LabelContra.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        LabelContra.setForeground(new java.awt.Color(128, 109, 183));
        LabelContra.setText("Contraseña");

        BotonEliminar.setBackground(new java.awt.Color(251, 249, 245));
        BotonEliminar.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        BotonEliminar.setForeground(new java.awt.Color(228, 55, 68));
        BotonEliminar.setText("ELIMINAR");
        BotonEliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 2, true));
        BotonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarActionPerformed(evt);
            }
        });

        BotonEditar.setBackground(new java.awt.Color(251, 249, 245));
        BotonEditar.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        BotonEditar.setForeground(new java.awt.Color(84, 70, 82));
        BotonEditar.setText("EDITAR");
        BotonEditar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 2, true));
        BotonEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEditarActionPerformed(evt);
            }
        });

        LabNombre.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        LabNombre.setForeground(new java.awt.Color(84, 70, 82));
        LabNombre.setText("Nombre de Usuario");

        LabEmail.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        LabEmail.setForeground(new java.awt.Color(84, 70, 82));
        LabEmail.setText("Correo Electrónico");

        LabContraseña.setEditable(false);
        LabContraseña.setBackground(new java.awt.Color(251, 249, 245));
        LabContraseña.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        LabContraseña.setForeground(new java.awt.Color(84, 70, 82));
        LabContraseña.setText("Contraseña");
        LabContraseña.setBorder(null);
        LabContraseña.setOpaque(true);
        LabContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LabContraseñaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPerfilLayout = new javax.swing.GroupLayout(PanelPerfil);
        PanelPerfil.setLayout(PanelPerfilLayout);
        PanelPerfilLayout.setHorizontalGroup(
            PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPerfilLayout.createSequentialGroup()
                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelPerfilLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BotonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPerfilLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelPerfilLayout.createSequentialGroup()
                                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LabelContra)
                                        .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(LabContraseña, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LabelEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LabEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(PanelPerfilLayout.createSequentialGroup()
                                        .addComponent(LabUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                        .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(PanelPerfilLayout.createSequentialGroup()
                                                .addComponent(LabelNombre)
                                                .addGap(68, 68, 68))
                                            .addComponent(LabNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(19, 19, 19)))))
                .addGap(42, 42, 42))
        );
        PanelPerfilLayout.setVerticalGroup(
            PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPerfilLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelPerfilLayout.createSequentialGroup()
                        .addComponent(BotonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(LabelNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LabUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(LabelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(LabelContra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        PanelVentana.add(PanelPerfil, "card2");

        PanelEditarPerfil.setBackground(new java.awt.Color(251, 249, 245));
        PanelEditarPerfil.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 2, new java.awt.Color(128, 109, 183)), javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED)));

        LabUsuarioEd.setBackground(new java.awt.Color(128, 109, 183));
        LabUsuarioEd.setForeground(new java.awt.Color(255, 255, 255));
        LabUsuarioEd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabUsuarioEd.setText("A");
        LabUsuarioEd.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 55)); // NOI18N
        LabUsuarioEd.setRoundBottomLeft(150);
        LabUsuarioEd.setRoundBottomRight(150);
        LabUsuarioEd.setRoundTopLeft(150);
        LabUsuarioEd.setRoundTopRight(150);

        LabelNuevoEmail.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        LabelNuevoEmail.setForeground(new java.awt.Color(128, 109, 183));
        LabelNuevoEmail.setText("Correo Electrónico");

        TxtNuevoEmail.setEditable(false);
        TxtNuevoEmail.setBackground(new java.awt.Color(251, 249, 245));
        TxtNuevoEmail.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        TxtNuevoEmail.setForeground(new java.awt.Color(153, 153, 153));
        TxtNuevoEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 208, 194)));

        LabelNuevoNombre.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        LabelNuevoNombre.setForeground(new java.awt.Color(128, 109, 183));
        LabelNuevoNombre.setText("Nombre de Usuario");

        TxtNuevoNombre.setBackground(new java.awt.Color(251, 249, 245));
        TxtNuevoNombre.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        TxtNuevoNombre.setForeground(new java.awt.Color(84, 70, 82));
        TxtNuevoNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));
        TxtNuevoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNuevoNombreActionPerformed(evt);
            }
        });

        LabelNuevoContra.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        LabelNuevoContra.setForeground(new java.awt.Color(128, 109, 183));
        LabelNuevoContra.setText("Contraseña");

        TxtNuevaContra.setBackground(new java.awt.Color(251, 249, 245));
        TxtNuevaContra.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        TxtNuevaContra.setForeground(new java.awt.Color(84, 70, 82));
        TxtNuevaContra.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 195, 151)));
        TxtNuevaContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNuevaContraActionPerformed(evt);
            }
        });

        BtnGuardar.setBackground(new java.awt.Color(255, 207, 134));
        BtnGuardar.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BtnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        BtnGuardar.setText("GUARDAR");
        BtnGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BtnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        BtnCancelar.setBackground(new java.awt.Color(255, 207, 134));
        BtnCancelar.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        BtnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        BtnCancelar.setText("CANCELAR");
        BtnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 169, 106), 1, true));
        BtnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelEditarPerfilLayout = new javax.swing.GroupLayout(PanelEditarPerfil);
        PanelEditarPerfil.setLayout(PanelEditarPerfilLayout);
        PanelEditarPerfilLayout.setHorizontalGroup(
            PanelEditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEditarPerfilLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(PanelEditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEditarPerfilLayout.createSequentialGroup()
                        .addGroup(PanelEditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelEditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(LabelNuevoContra, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LabelNuevoEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TxtNuevoEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelEditarPerfilLayout.createSequentialGroup()
                                .addComponent(LabUsuarioEd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addGroup(PanelEditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelNuevoNombre)
                                    .addComponent(TxtNuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(61, 61, 61))
                    .addGroup(PanelEditarPerfilLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(TxtNuevaContra, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEditarPerfilLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        PanelEditarPerfilLayout.setVerticalGroup(
            PanelEditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEditarPerfilLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelEditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelEditarPerfilLayout.createSequentialGroup()
                        .addComponent(LabelNuevoNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtNuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LabUsuarioEd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(LabelNuevoEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtNuevoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(LabelNuevoContra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtNuevaContra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(PanelEditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        PanelVentana.add(PanelEditarPerfil, "card4");

        javax.swing.GroupLayout PanelFondoLayout = new javax.swing.GroupLayout(PanelFondo);
        PanelFondo.setLayout(PanelFondoLayout);
        PanelFondoLayout.setHorizontalGroup(
            PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelFondoLayout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(PanelVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelFondoLayout.setVerticalGroup(
            PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFondoLayout.createSequentialGroup()
                .addComponent(PanelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
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

    private void TxtNuevoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNuevoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNuevoNombreActionPerformed

    private void TxtNuevaContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNuevaContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNuevaContraActionPerformed

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
        MenuPrincipal Menu = new MenuPrincipal(controladorUsu, controladorPres, controladorCue, controladorTra, controladorDeu);
        Menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LabInicioMouseClicked

    private void BotonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEditarActionPerformed
        Sound.playSound("src/sound/click.wav");
        PanelEditarPerfil.setVisible(true);
        PanelPerfil.setVisible(false);
    }//GEN-LAST:event_BotonEditarActionPerformed

    private void BotonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarActionPerformed
    Sound.playSound("src/sound/error.wav");
    int confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar su cuenta y todos los registros asociados?", "Confirmar la eliminación", JOptionPane.YES_NO_OPTION);
        
    if (confirmar == JOptionPane.YES_OPTION) {
        int idUsuario = Sesion.getInstancia().getIdUsuario();
        UsuarioController controladorUsuario = new UsuarioController();
        String mensaje = controladorUsuario.eliminarUsuario(idUsuario);
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
                
        IniciarSesion Sesion = new IniciarSesion();
        Sesion.setVisible(true);
        this.dispose();
    } else {
        Sound.playSound("src/sound/success.wav");
        JOptionPane.showMessageDialog(null, "Su cuenta no fue eliminada", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    }//GEN-LAST:event_BotonEliminarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        Sound.playSound("src/sound/click.wav");
        PanelPerfil.setVisible(true);
        PanelEditarPerfil.setVisible(false);
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
    if(!TxtNuevoNombre.getText().isEmpty() | !TxtNuevoEmail.getText().isEmpty() | !TxtNuevaContra.getText().isEmpty()) {
    Sound.playSound("src/sound/click.wav");
    String nombre, email, contraseña, mensaje;
    int idUsuario;

    controladorUsu = new UsuarioController();

    idUsuario = Sesion.getInstancia().getIdUsuario();
    nombre = TxtNuevoNombre.getText();
    email = TxtNuevoEmail.getText();
    contraseña = TxtNuevaContra.getText();

    mensaje = controladorUsu.ModificarUsuario(idUsuario, nombre, email, contraseña);
    JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    mostrarUsuario();
    
    PanelPerfil.setVisible(true);
    PanelEditarPerfil.setVisible(false);
    } else {
        Sound.playSound("src/sound/error.wav");
        JOptionPane.showMessageDialog(null, "Complete los campos vacíos.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void LabContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LabContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LabContraseñaActionPerformed

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
            java.util.logging.Logger.getLogger(UsuarioPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEditar;
    private javax.swing.JButton BotonEliminar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JPasswordField LabContraseña;
    private javax.swing.JLabel LabEmail;
    private javax.swing.JLabel LabInicio;
    private javax.swing.JLabel LabNombre;
    private swingx.RoundLabel LabUsuario;
    private swingx.RoundLabel LabUsuarioEd;
    private javax.swing.JLabel LabelContra;
    private javax.swing.JLabel LabelEmail;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LabelNuevoContra;
    private javax.swing.JLabel LabelNuevoEmail;
    private javax.swing.JLabel LabelNuevoNombre;
    private javax.swing.JPanel PanelEditarPerfil;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JPanel PanelPerfil;
    private javax.swing.JPanel PanelSuperior;
    private javax.swing.JPanel PanelVentana;
    private javax.swing.JTextField TxtNuevaContra;
    private javax.swing.JTextField TxtNuevoEmail;
    private javax.swing.JTextField TxtNuevoNombre;
    // End of variables declaration//GEN-END:variables
}
