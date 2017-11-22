
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
public class Main {
	
	public static void main(String args[])  {
		int num_procs = 3;
		String rmi_name_1 = "rmi://localhost:1099/p1";
		String rmi_name_2 = "rmi://localhost:1100/p2";
		String rmi_name_3 = "rmi://localhost:1101/p3";
		try {	
		
		Process p1 = new Process(1, num_procs);
	    Process p2 = new Process(2, num_procs);
		Process p3 = new Process(3, num_procs);
		
		Registry reg1 = java.rmi.registry.LocateRegistry.createRegistry(1099);
		Registry reg2 = java.rmi.registry.LocateRegistry.createRegistry(1100);
		Registry reg3 = java.rmi.registry.LocateRegistry.createRegistry(1101);
		
		reg1.bind(rmi_name_1, p1);
		reg2.bind(rmi_name_2, p2);
		reg3.bind(rmi_name_3, p3);

		java.rmi.Naming.bind(rmi_name_1, p1);
	    java.rmi.Naming.bind(rmi_name_2, p2);
	    java.rmi.Naming.bind(rmi_name_3, p3);
	    
	    p1.send_message(new Message(5,6,7),2);
	    
		reg1.unbind(rmi_name_1);
		reg2.unbind(rmi_name_2);
		reg3.unbind(rmi_name_3);
		UnicastRemoteObject.unexportObject(reg1,true);
		UnicastRemoteObject.unexportObject(reg2,true);
		UnicastRemoteObject.unexportObject(reg3,true);

		} catch ( RemoteException| MalformedURLException| AlreadyBoundException | NotBoundException e) {
			// TODO Auto-generated catch block;
			e.printStackTrace();
		}
		System.out.println(rmi_name_1);
		System.exit(0);
	}

}
