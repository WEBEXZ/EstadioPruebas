import BaseDatos.DML;
import Logica.Login;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestLogin 
{
    Login logeo = new Login();    
    DML dml = new DML();
    
    @Test
    public void acceso_correcto_Ventas()
    {
        assertEquals("BOLIS,bolis123", dml.accesoVentas("BOLIS","bolis123"));
    }
    
    @Test
    public void acceso_incorrecto_Ventas()
    {
        assertEquals("NO HAY", dml.accesoVentas("BOLIS1","BOLIS123"));
    }
    
    @Test
    public void acceso_correcto_Seguridad()
    {
        assertEquals("MARY,mary14", dml.accesoSeguridad("MARY","mary14"));
    }
    
    @Test
    public void acceso_incorrecto_Seguridad()
    {
        assertEquals("NO HAY", dml.accesoSeguridad("MARY","mary114"));
    }
}