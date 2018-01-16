
package buscaprecios;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


public class pnlRebajas extends javax.swing.JPanel {


    public pnlRebajas(Articulo a) {
        initComponents();
        this.setVisible(true);
        this.armarRebajas(a);
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("Tu resolución es de " + screenSize.width + "x" + screenSize.height);
    }
    
    
    private void armarRebajas(Articulo a){
        this.lblDesc.setText(a.getDescripcion());
        this.lblPorcentaje.setText(this.porcentaje(a)+"% de Descuento");
        this.lblPrecioOrig.setText("Antes " +this.decimales(a.getPrecioOriginal()));
        this.lblPrecio.setText("Ahora "+this.decimales(a.getPrecio()));
        this.lblSeccion.setText("Sección: " +a.getSeccionNombre());
        this.repaint();
    }
    
     private String decimales(Double sueldo) {
    DecimalFormatSymbols simbolo= new DecimalFormatSymbols();
    simbolo.setDecimalSeparator('.');
    simbolo.setGroupingSeparator(',');
                
    DecimalFormat df=new DecimalFormat("#,###,##0.00",simbolo);
    return df.format(sueldo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDesc = new javax.swing.JLabel();
        lblPrecioOrig = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblPorcentaje = new javax.swing.JLabel();
        lblSeccion = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 400));

        lblDesc.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblDesc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblPrecioOrig.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        lblPrecioOrig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblPrecio.setFont(new java.awt.Font("Ebrima", 1, 40)); // NOI18N
        lblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblPorcentaje.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        lblPorcentaje.setForeground(new java.awt.Color(255, 0, 0));
        lblPorcentaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblSeccion.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        lblSeccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioOrig, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPrecioOrig, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblPorcentaje;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblPrecioOrig;
    private javax.swing.JLabel lblSeccion;
    // End of variables declaration//GEN-END:variables

    private String porcentaje(Articulo a) {
        String retorno="";
        Double dif=a.getPrecioOriginal()-a.getPrecio();
        Double por=dif/a.getPrecioOriginal();
        Double fin=por*100;
        int r = (int) Math.round(fin);
        return String.valueOf(r);
    }
}
