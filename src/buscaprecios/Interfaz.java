
package buscaprecios;

import Persistencia.MiExcepcion;
import com.sun.javafx.PlatformUtil;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;





public class Interfaz extends javax.swing.JFrame{

   
   private BuscaPrecios bp;
   public pnlRebajas pnlRebajas=null;
   public pnlNormal pnlNormal=null;
   public Interfaz() throws InterruptedException {
        initComponents();
        if(!PlatformUtil.isWindows()){
        Thread.sleep(7000);
        }
//        else if(PlatformUtil.isWindows()){
//            Thread.sleep(30000);
//        }
        this.bp=new BuscaPrecios();
        this.txtCod.requestFocus();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
        this.panelTabla.setVisible(false);
        this.getContentPane().setBackground(Color.white);
   }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panelTabla = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtCod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblMsj = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONSULTA DE PRECIOS");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));

        tabla.setBackground(new java.awt.Color(157, 201, 255));
        tabla.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pago en", "$Total", "$Cuota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panelTabla.setViewportView(tabla);

        txtCod.setBackground(new java.awt.Color(157, 201, 255));
        txtCod.setFont(new java.awt.Font("Ebrima", 1, 28)); // NOI18N
        txtCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCod.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));
        txtCod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodFocusGained(evt);
            }
        });
        txtCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Consulta de Precios");

        lblMsj.setFont(new java.awt.Font("Ebrima", 3, 18)); // NOI18N
        lblMsj.setForeground(new java.awt.Color(255, 0, 0));
        lblMsj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addContainerGap(166, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblMsj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(txtCod)))
                .addGap(234, 234, 234))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMsj, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyTyped
       
       this.jPanel1.setVisible(false);
       this.panelTabla.setVisible(false);
       this.lblMsj.setText(""); 
       int k = (int) evt.getKeyChar();
//       if(this.txtCod.getText().length()>=15){
//           evt.consume();
//       }
        if(k==10){
            this.txtCod.selectAll();
            this.txtCod.setText(this.txtCod.getText().replace(" ", ""));
            this.buscar();
            
        }    
    }//GEN-LAST:event_txtCodKeyTyped

    private void txtCodFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodFocusGained
       this.txtCod.selectAll();
    }//GEN-LAST:event_txtCodFocusGained

     private void buscar(){
       
        this.panelTabla.setVisible(false);
        String barras=this.txtCod.getText();
        
        Articulo a=null;
       
        if(!"".equals(barras)){
           
            try {
                barras=barras.trim();
                barras=barras.replace(" ","");
                
                a=this.bp.busca(barras);
                
                
                if(a!=null){
                    if(a.getPrecioOriginal()==null){
                        if(pnlRebajas!=null){
                            this.pnlRebajas.setVisible(false);
                        }
                        this.txtCod.requestFocus();
                        this.jPanel1.removeAll();
                        this.pnlNormal=new pnlNormal(a);
                        this.jPanel1.add(this.pnlNormal);
                        this.jPanel1.repaint();
                        this.jPanel1.revalidate();
                        this.txtCod.selectAll();
                        this.armarTabla(a);
                        this.jPanel1.setVisible(true);
                        this.txtCod.selectAll();
                        this.txtCod.requestFocus();
                        
                    }
                    else{
                        if(pnlNormal!=null){
                            this.pnlNormal.setVisible(false);
                        }
                        this.txtCod.requestFocus();
                        this.pnlRebajas=new pnlRebajas(a);
                        this.jPanel1.removeAll();
                        this.jPanel1.add(this.pnlRebajas);
                        this.jPanel1.repaint();
                        this.jPanel1.revalidate();
                        this.txtCod.selectAll();
                        this.armarTabla(a);
                        this.jPanel1.setVisible(true);
                        this.txtCod.selectAll();
                        this.txtCod.requestFocus();
                        a=null;
                    }
                    
                }
                else{
                    a=null;
                    this.txtCod.requestFocus();
                    this.jPanel1.removeAll();
                    this.pnlNormal=new pnlNormal(a);
                    this.jPanel1.add(this.pnlNormal);
                    this.jPanel1.repaint();
                    this.jPanel1.revalidate();
                    this.txtCod.selectAll();
                    this.jPanel1.setVisible(true);
                    this.txtCod.selectAll();
                    
                }
            
                
                
                
                //Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MiExcepcion ex) {
                this.lblMsj.setText("NO HAY CONEXION");
                this.txtCod.selectAll();
                a=null;
                this.jPanel1.setVisible(false);
                this.panelTabla.setVisible(false);
            } 
            
        }
        this.txtCod.selectAll();
        
        }
  
   
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Interfaz().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMsj;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCod;
    // End of variables declaration//GEN-END:variables
    private String dobleCero(Double price){
   
    String s = String.format("%.2f", price);
    return s;
    }

    private void armarTabla(Articulo a) {
       this.LimpiarTabla();
       if(a.getPromocion()!=null){
           DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
           Object[] filas=new Object[modelo.getColumnCount()];
           
           for(int i=1;i<=a.getPromocion().getHasta();i++){
               filas[0]=i;
               filas[1]=this.decimales(a.getPrecio());
               filas[2]=this.decimales(a.getPrecio()/i);
               modelo.addRow(filas);
           }
        JTableHeader th; 
        th = tabla.getTableHeader(); 
        Font fuente = new Font("Ebrima", Font.BOLD, 14); 
        th.setBackground(Color.LIGHT_GRAY);
        th.setFont(fuente); 
        this.tabla.setVisible(true);
        this.panelTabla.setVisible(true);
        this.Alinear_Grillas();
       }
       
    }
    private void LimpiarTabla() {
      DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
        //primero limpio todas las filas
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i-=1;
        }
    }
    private String decimales(Double sueldo) {
    DecimalFormatSymbols simbolo= new DecimalFormatSymbols();
    simbolo.setDecimalSeparator('.');
    simbolo.setGroupingSeparator(',');
                
    DecimalFormat df=new DecimalFormat("#,###,##0.00",simbolo);
    return df.format(sueldo);
    }
    private void Alinear_Grillas(){
            
        DefaultTableCellRenderer modelo = new DefaultTableCellRenderer();
        modelo.setHorizontalAlignment(SwingConstants.RIGHT);
        this.tabla.getColumnModel().getColumn(0).setCellRenderer(modelo); 
        this.tabla.getColumnModel().getColumn(1).setCellRenderer(modelo); 
        this.tabla.getColumnModel().getColumn(2).setCellRenderer(modelo);
    }
}
