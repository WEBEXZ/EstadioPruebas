import BaseDatos.DML;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestVentas 
{
    DML dml = new DML();
    
    @Test
    public void boletos_disponibles()
    {
        assertEquals(994,dml.boletos_disponibles(1));
    }
}
