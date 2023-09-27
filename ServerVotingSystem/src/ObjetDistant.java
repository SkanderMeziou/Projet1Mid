import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ObjetDistant extends UnicastRemoteObject implements Distante{


    public ObjetDistant(int numport) throws RemoteException {
        super(numport);
    }

    @Override
    public void echo(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("message : ");
        System.out.println(java.time.LocalTime.now());
    }

    public static void main(String[] args) throws Exception {
        Registry reg= LocateRegistry.createRegistry(2001);
        Distante d = new ObjetDistant(10001);
        Naming.rebind("rmi://localhost:2001/MonOD",d);
    }
}
