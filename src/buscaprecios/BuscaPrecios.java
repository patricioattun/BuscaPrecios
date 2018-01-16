
package buscaprecios;

import Persistencia.Conexion;
import Persistencia.MiExcepcion;
import com.sun.javafx.PlatformUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BuscaPrecios {

    private static Date hoy=null;
    private static ArrayList<Integer> secciones=new ArrayList<>();
    private static String ip;
    public static void main(String[] args) throws ClassNotFoundException, SQLException, UnknownHostException, IOException, InterruptedException {
        Interfaz i=new Interfaz();
        hoy=new Date();
        //ip=BuscaPrecios.obtieneIp();
        ip="10.136.1.2";
        secciones=BuscaPrecios.buscarSeccionesDescuento();
    }
    
    public Articulo busca(String barras) throws MiExcepcion{
        Articulo a=null;
        try {
            switch (ip){
                case "10.136.40.1":
                    a=buscarFrayCane(barras);
                    if(a==null){
                        try {
                            a=buscar1(barras);
                            if(a==null){
                                a=buscar2(barras);
                            }
                        } catch (MiExcepcion ex) {
                            throw new MiExcepcion(ex.getMessage());
                        }
                    }
                    break;
                case "10.136.41.1":
                    a=buscarFrayCane(barras);
                    if(a==null){
                        try {
                            a=buscar1(barras);
                            if(a==null){
                                a=buscar2(barras);
                            }
                        } catch (MiExcepcion ex) {
                            throw new MiExcepcion(ex.getMessage());
                        }
                    }
                    break;
                default:
                    a=buscar1(barras);
                    if(a==null){
                        a=buscar2(barras);
                    }
                    break;
            }
            
        } catch (MiExcepcion ex) {
            throw new MiExcepcion(ex.getMessage());
        }
        return a;
}

    Articulo buscar1(String barras) throws MiExcepcion {
       Articulo a=null;
        if(barras.length()<=13 && this.esNum(barras)){
       try {
            
            
            String consulta="";
            Connection cnn=null;
            try {
                cnn=Conexion.Cadena(ip);
            } catch (MiExcepcion ex) {
                throw new MiExcepcion(ex.getMessage());
            }
            
            Promocion p=null;
            
            PreparedStatement ps=null;
            consulta="Select a.DESCRIPCION, a.P_VENTA,a.SECCION,a.CODIGO_INT, s.nombre FROM VTAS_ARTICULOS a inner join vtas_secciones s on a.seccion=s.numero WHERE trim(a.BARRAS)=?";
            try {
                ps=cnn.prepareStatement(consulta);
            } catch (SQLException ex) {
                throw new MiExcepcion(ex.getMessage());
            }
            ps.setString(1, barras);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                a=new Articulo();
                a.setDescripcion(rs.getString("DESCRIPCION").trim());
                a.setPrecio(rs.getDouble("P_VENTA"));
                a.setSeccion(rs.getInt("SECCION"));
                a.setSeccionNombre(rs.getString("NOMBRE").trim().toUpperCase());
                a.setCodigoInt(rs.getInt("CODIGO_INT"));
                
                consulta="Select desde,hasta FROM VTAS_promo_seccion WHERE seccion=? and fechaini<=? AND fechafin>=?";
                ps=cnn.prepareStatement(consulta);
                ps.setInt(1, a.getSeccion());
                ps.setString(2, this.convertirFecha(hoy) );
                ps.setString(3, this.convertirFecha(hoy) );
                ResultSet rss=ps.executeQuery();
                while(rss.next()){
                    p=new Promocion();
                    p.setDesde(rss.getInt("DESDE"));
                    p.setHasta(rss.getInt("HASTA"));
                    
                }
                a.setPromocion(p);
                this.promoRebajas(a);
            }
            
            if(cnn!=null){
                ps.close();
                rs.close();
                cnn.close();
                
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(BuscaPrecios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuscaPrecios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BuscaPrecios.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return a;
    }
    Articulo buscar2(String barras) throws MiExcepcion{
       Articulo a=null;
       if(barras.length()<=14 && this.esNum(barras)){
        try {
                        
            String consulta="";
            Connection cnn=null;
            try {
                cnn=Conexion.Cadena(ip);
            } catch (MiExcepcion ex) {
                throw new MiExcepcion(ex.getMessage());
            }
            
            Promocion p=null;
            PreparedStatement ps=null;
            consulta="Select DESCRIPCION, P_VENTA FROM VSUP_INVENARTI WHERE BARRAS=? OR BARRAS1=?";
            ps=cnn.prepareStatement(consulta);
            ps.setString(1, barras);
            ps.setString(2, barras);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                a=new Articulo();
                a.setDescripcion(rs.getString("DESCRIPCION").trim());
                a.setPrecio(rs.getDouble("P_VENTA"));
                a.setSeccionNombre("SUPERMERCADO");
                a.setSeccion(1);
                
                consulta="Select desde,hasta FROM VTAS_promo_seccion WHERE seccion=? and fechaini<=? AND fechafin>=?";
                ps=cnn.prepareStatement(consulta);
                ps.setInt(1, a.getSeccion());
                ps.setString(2, this.convertirFecha(hoy) );
                ps.setString(3, this.convertirFecha(hoy) );
                ResultSet rss=ps.executeQuery();
                while(rss.next()){
                    p=new Promocion();
                    p.setDesde(rss.getInt("DESDE"));
                    p.setHasta(rss.getInt("HASTA"));
                    
                }
                a.setPromocion(p);
            }
            if(cnn!=null){
                ps.close();
                rs.close();
                cnn.close();
                
            }
            
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(BuscaPrecios.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
         return a;
    }
    
    Articulo buscarFrayCane(String barras) throws MiExcepcion{
        Articulo a=null;
        if(barras.length()<=14 && this.esNum(barras)){
        try {
            
            String consulta="";
            Connection cnn=null;
            try {
                cnn=Conexion.Cadena(ip);
            } catch (MiExcepcion ex) {
                throw new MiExcepcion(ex.getMessage());
            }
            Promocion p=null;
            PreparedStatement ps=null;
            consulta="Select DESCRIPCION, P_VENTA FROM VSUP_INVENARTI_LOCAL WHERE BARRAS=? OR BARRAS1=?";
            ps=cnn.prepareStatement(consulta);
            ps.setString(1, barras);
            ps.setString(2, barras);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                a=new Articulo();
                a.setDescripcion(rs.getString("DESCRIPCION").trim());
                a.setPrecio(rs.getDouble("P_VENTA"));
                a.setSeccionNombre("SUPERMERCADO");
                a.setSeccion(1);
                
                consulta="Select desde,hasta FROM VTAS_promo_seccion WHERE seccion=? and fechaini<=? AND fechafin>=?";
                ps=cnn.prepareStatement(consulta);
                ps.setInt(1, a.getSeccion());
                ps.setString(2, this.convertirFecha(hoy) );
                ps.setString(3, this.convertirFecha(hoy) );
                ResultSet rss=ps.executeQuery();
                while(rss.next()){
                    p=new Promocion();
                    p.setDesde(rss.getInt("DESDE"));
                    p.setHasta(rss.getInt("HASTA"));
                }
                a.setPromocion(p);
            }
            if(cnn!=null){
                ps.close();
                rs.close();
                cnn.close();
                
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(BuscaPrecios.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return a;
    }
    
    private String convertirFecha(Date fecha){
   String str=null;
        if(fecha!=null){
         SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); 
         str= sdf.format(fecha);
    }
        return str;
    }
    

   private static String obtieneIp() throws FileNotFoundException, IOException {
      //String archivo="Z:\\JAVA\\Escritorio\\BuscaPrecios\\src\\buscaprecios\\ip.txt";
      String archivo=null;
      if(PlatformUtil.isWindows()){
         archivo = System.getProperty("user.dir");
         archivo+="\\ip.txt";
      }
      else{
         archivo="/opt/buscaPrecios/ip.txt";
      }
      String cadena;
      FileReader f = new FileReader(archivo);
      BufferedReader b = new BufferedReader(f);
      cadena = b.readLine();
      b.close();
      return cadena;
}
//   private static String obtieneIp() throws FileNotFoundException, IOException{
//       String cadena;
//       
//        File archivo=new File("ip.txt");
//        String retorno=archivo.getAbsolutePath();
//        FileReader f = new FileReader(retorno);
//        BufferedReader b = new BufferedReader(f);
//        cadena = b.readLine();
//        b.close();
//    
//        return cadena;
//   }
   
    private static ArrayList<Integer> buscarSeccionesDescuento() throws ClassNotFoundException, SQLException, UnknownHostException, IOException {
        String consulta="";
        Connection cnn=null;
        cnn=Conexion.CadenaMon();
        PreparedStatement ps=null;
        consulta="Select DISTINCT(SECCION) FROM VTAS_ARTICULOS WHERE CODIGO_INT IN(SELECT CODIGO_INTERNO FROM VTAS_ARTICULOS_REBAJAS)";
        ps=cnn.prepareStatement(consulta);
        ResultSet rs=ps.executeQuery();
           while (rs.next()){
               secciones.add(rs.getInt("SECCION"));
           }
        
        if(cnn!=null){
            ps.close();
            rs.close();
            cnn.close();
            
        }
        return secciones;
    } 

    private void promoRebajas(Articulo a) throws ClassNotFoundException, SQLException, UnknownHostException, IOException {
        a.setPrecioOriginal(null);
        if(secciones.size()==0){
            secciones=BuscaPrecios.buscarSeccionesDescuento();
        }
        if(secciones.contains(a.getSeccion())){
        String consulta="";
        Connection cnn=null;
        cnn=Conexion.CadenaMon();
        PreparedStatement ps=null;
        consulta="Select PRECIO_ORIGINAL FROM VTAS_ARTICULOS_REBAJAS WHERE CODIGO_INTERNO=?";
        ps=cnn.prepareStatement(consulta);
        ps.setInt(1, a.getCodigoInt());
        ResultSet rs=ps.executeQuery();
           while (rs.next()){
               a.setPrecioOriginal(rs.getDouble("PRECIO_ORIGINAL"));
           }
           if(cnn!=null){
            ps.close();
            rs.close();
            cnn.close();
            
           }
        }
        
    }
    
        private Boolean esNum(String num){
        Boolean es=true;
        Integer i=0;
        if(num.equals("")){
            es=false;
        }
        while(i<num.length() && es){
            if(!Character.isDigit(num.charAt(i))){
                es=false;
            }
            i++;
        }
        return es;
    }
    
}
