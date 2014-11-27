package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion 
{
    String base_datos = "Estadio";
    String usuario = "root";
    String contrasena = "";
    String url = "jdbc:mysql://localhost/"+base_datos; 
    Connection conexion = null;
    
    Conexion()
    {
        try
        {
            Class.forName(("com.mysql.jdbc.Driver"));
            conexion = DriverManager.getConnection(url,usuario,contrasena);
            if(conexion!=null)
            {
                //JOptionPane.showMessageDialog(null, "CONEXIÓN ESTABLECIDA", "EXITO", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException e)
        { 
             JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch(ClassNotFoundException ex)
        { 
             JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    public Connection getConexion()
    {
        return conexion;
    }
    
    public void Desconectar()
    {
        conexion = null;
    }
}