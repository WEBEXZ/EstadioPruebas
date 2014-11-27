package BaseDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DML 
{
    Conexion conexion = new Conexion();
    
    public void agregar_cliente(String id_Cliente,String nom_Cliente,String ap_Cliente,String tipo_Cliente)
    {
        try
        {
        String insertar = "INSERT INTO cliente(id_Cliente,nom_Cliente,ap_Cliente,tipo_Cliente) VALUES(?,?,?,?);";
        PreparedStatement p = conexion.getConexion().prepareStatement(insertar);
            p.setString(1,id_Cliente);
            p.setString(2,nom_Cliente);
            p.setString(3,ap_Cliente);
            p.setString(4,tipo_Cliente);
            p.execute();
            p.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void agregar_boleto(int id_Boleto,int id_Partido, int id_Evento)
    {
        try
        {
        String insertar = "INSERT INTO boleto(id_Boleto,partido_id_Partido,otro_Evento_id_Evento) VALUES(?,?,?);";
        PreparedStatement p = conexion.getConexion().prepareStatement(insertar);
            p.setInt(1,id_Boleto);
            p.setInt(2,id_Partido);
            p.setInt(3,id_Evento);
            p.execute();
            p.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void agregar_Compra(String id_Compra,String tipo_Compra,String fecha_Compra, String id_Cliente)
    {
        try
        {
        String insertar = "INSERT INTO compra(id_Compra,tipo_Compra,fecha_Compra,cliente_id_Cliente) VALUES(?,?,?,?);";
        PreparedStatement p = conexion.getConexion().prepareStatement(insertar);
            p.setString(1,id_Compra);
            p.setString(2,tipo_Compra);
            p.setString(3,fecha_Compra);
            p.setString(4,id_Cliente);
            p.execute();
            p.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void agregar_DetalleCompra(int id_Compra,int id_Boleto,double monto_Compra,int cantidad_Boletos)
    {
        try
        {
        String insertar = "INSERT INTO detalle_compra(compra_id_Compra,boleto_id_Boleto,monto_Compra,cantidad_Boletos) VALUES(?,?,?,?);";
        PreparedStatement p = conexion.getConexion().prepareStatement(insertar);
            p.setInt(1,id_Compra);
            p.setInt(2,id_Boleto);
            p.setDouble(3,monto_Compra);
            p.setInt(4,cantidad_Boletos);
            p.execute();
            p.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void agregar_Partido(int id_Partido,String encuentro, String fecha_Partido,String hora_Partido,double costo_Partido,int asientos_disponibles)
    {
        try
        {
        String insertar = "INSERT INTO partido(id_Partido,encuentro,fecha_Partido,hora_Partido,costo_Partido,asientos_disponibles) VALUES(?,?,?,?,?,?);";
        PreparedStatement p = conexion.getConexion().prepareStatement(insertar);
            p.setInt(1,id_Partido);
            p.setString(2,encuentro);
            p.setString(3,fecha_Partido);
            p.setString(4,hora_Partido);
            p.setDouble(5,costo_Partido);
            p.setInt(6,asientos_disponibles);
            p.execute();
            p.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void agregar_evento(int id_Evento,int costo_Evento, int lugares_disponibles)
    {
        try
        {
        String insertar = "INSERT INTO otro_evento(id_Evento,costo_Evento,lugares_disponibles) VALUES(?,?,?);";
        PreparedStatement p = conexion.getConexion().prepareStatement(insertar);
            p.setInt(1,id_Evento);
            p.setInt(2,costo_Evento);
            p.setInt(3,lugares_disponibles);
            p.execute();
            p.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String accesoVentas(String user,String password)
    {
        String consulta = "NO HAY";
        try
        {
        String usuario = "SELECT usuario,password FROM usuarioventas where usuario = ? and password = ?;";
        PreparedStatement p = conexion.getConexion().prepareStatement(usuario);
        p.setString(1,user);
        p.setString(2,password);
        ResultSet rs = p.executeQuery(); 
            while (rs.next())
            {
                consulta = rs.getString("usuario")+","+rs.getString("password");
            }
            rs.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return consulta;
    }
    
    public String accesoSeguridad(String user,String password)
    {
        String consulta = "NO HAY";
        try
        {
        String usuario = "SELECT usuario,password FROM usuarioseguridad where usuario = ? and password = ?;";
        PreparedStatement p = conexion.getConexion().prepareStatement(usuario);
        p.setString(1,user);
        p.setString(2,password);
        ResultSet rs = p.executeQuery(); 
            while (rs.next())
            {
                consulta = rs.getString("usuario")+","+rs.getString("password");
            }
            rs.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return consulta;
   }
    
    public String buscar_clave(String clave)
    {
        String consulta = "NO HAY";
        try
        {
            String query = "SELECT CLAVE FROM estadio.seguridad where clave = ?;";
            PreparedStatement p = conexion.getConexion().prepareStatement(query);
            p.setString(1,clave);
            ResultSet rs = p.executeQuery(); 
            while (rs.next())
            {
                consulta = rs.getString("clave");
            }
            rs.close();
       }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
       return consulta;
   }
    
    public int boletos_disponibles(int indice)
    {
        int disponibles = 0;
        
        try
        {
            String query = "SELECT asientos_disponibles FROM partido where id_Partido = ?;";
            PreparedStatement p = conexion.getConexion().prepareStatement(query);
            p.setInt(1,indice);
            ResultSet rs = p.executeQuery(); 
            while (rs.next())
            {
                disponibles = rs.getInt("asientos_disponibles");
            }
            rs.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return disponibles;
    }
}
