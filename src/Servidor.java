import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class Servidor {
    private static final int PUERTO = 1100; //Si cambias aquí el puerto, recuerda cambiarlo en el cliente
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Remote remote = UnicastRemoteObject.exportObject(new Interfaz() {
            /*
                Sobrescribir opcionalmente los métodos que escribimos en la interfaz
            */
            @Override
            public float sumar(float numero1, float numero2) throws RemoteException {
                return numero1 + numero2;
            }
            @Override
            public float restar(float numero1, float numero2) throws RemoteException {
                return numero1-numero2;
            }
            @Override
            public float multiplicar(float numero1, float numero2) throws RemoteException {
                return numero1 * numero2;
            }
            @Override
            public int fibonacci(float numero1) throws RemoteException { //Empieza en 0 como primera posicion 0, 1, 1, 2, 3,...
                int num1 = 0, num2 = 1, count=(int)numero1,  sum=0;
                for (int i = 2; i < count; i++) {
                    sum = num1 + num2;
                    num1 = num2;
                    num2 = sum;
                }
                return sum;
            }
            @Override
            public float dividir(float numero1, float numero2) throws RemoteException {
                return numero1 / numero2;
            };
        }, 0);
        Registry registry = LocateRegistry.createRegistry(PUERTO);
        System.out.println("Servidor escuchando en el puerto " + String.valueOf(PUERTO));
        registry.bind("Calc", remote); // Registrar calculadora
    }
}