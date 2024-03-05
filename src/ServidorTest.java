import org.junit.jupiter.api.Test;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServidorTest {
    private static final String IP = "localhost"; // Puedes cambiar a localhost
    private static final int PUERTO = 1100; //Si cambias aquí el puerto, recuerda cambiarlo en el servidor
    @Test
    public void testSumar() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
        Interfaz interfaz = (Interfaz) registry.lookup("Calc"); //Buscar en el registro...
        assertEquals(4.0f, interfaz.sumar(1.0f, 3.0f));
    }
    @Test
    public void testRestar() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
        Interfaz interfaz = (Interfaz) registry.lookup("Calc"); //Buscar en el registro...
        assertEquals(1.0f, interfaz.restar(4.0f, 3.0f));
    }
    @Test
    public void testMultiplicar() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
        Interfaz interfaz = (Interfaz) registry.lookup("Calc"); //Buscar en el registro...
        assertEquals(12.0f, interfaz.multiplicar(4.0f, 3.0f));
    }
    @Test
    public void testDividir() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
        Interfaz interfaz = (Interfaz) registry.lookup("Calc"); //Buscar en el registro...
        assertEquals(2.0f, interfaz.dividir(16.0f, 8.0f));
    }
    @Test
    public void testFibonacci() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
        Interfaz interfaz = (Interfaz) registry.lookup("Calc"); //Buscar en el registro...
        assertEquals(13.0F, interfaz.fibonacci(8.0F));
    }
}
