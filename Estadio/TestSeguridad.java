import BaseDatos.DML;
import Logica.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSeguridad 
{
    DML dml = new DML();
    
    @Test
    public void Existe_Cliente()
    {
        assertEquals("ANGSAN0808",dml.buscar_clave("ANGSAN0808"));
    }
    
    @Test
    public void No_Existe_Cliente()
    {
        assertEquals("NO HAY",dml.buscar_clave("ITHJUA1212"));
    }
}
