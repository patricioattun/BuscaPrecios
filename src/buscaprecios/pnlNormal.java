
package buscaprecios;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


public class pnlNormal extends javax.swing.JPanel {

  
    public pnlNormal(Articulo a) {
        initComponents();
        this.mostrar(a);
        this.setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDesc = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblSeccion = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(750, 400));
        setLayout(null);

        lblDesc.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblDesc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(lblDesc);
        lblDesc.setBounds(0, 20, 790, 51);

        lblPrecio.setFont(new java.awt.Font("Ebrima", 1, 60)); // NOI18N
        lblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(lblPrecio);
        lblPrecio.setBounds(0, 80, 790, 55);

        lblSeccion.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        lblSeccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(lblSeccion);
        lblSeccion.setBounds(0, 150, 790, 55);
    }// </editor-fold>//GEN-END:initComponents

    private void mostrar(Articulo a) {
       this.lblDesc.setText("");
       this.lblPrecio.setText("");
       this.lblSeccion.setText("");
        if(a!=null){
        this.lblDesc.setText("");
        this.lblPrecio.setText("");
            this.lblDesc.setText(a.getDescripcion());
            this.lblPrecio.setText("$ "+this.decimales(a.getPrecio()));
            this.lblSeccion.setText("Sección: "+ a.getSeccionNombre());
        }
        else{
            this.lblDesc.setText("Este artículo no existe");
        }
    }
    
    private String decimales(Double sueldo) {
    DecimalFormatSymbols simbolo= new DecimalFormatSymbols();
    simbolo.setDecimalSeparator('.');
    simbolo.setGroupingSeparator(',');
                
    DecimalFormat df=new DecimalFormat("#,###,##0.00",simbolo);
    return df.format(sueldo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblSeccion;
    // End of variables declaration//GEN-END:variables
}
