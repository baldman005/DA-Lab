import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Process extends UnicastRemoteObject implements Reception {
	
	private int ts = 0;
	private int id;
	private static int num_procs;
	private ArrayList<Message> queue = new ArrayList<Message>();
	private ArrayList<Message> deliveries = new ArrayList<Message>();
	private ArrayList<Ack> acks = new ArrayList<Ack>();
	

	protected Process(int id, int num_procs) throws RemoteException {
		super(1099);
		this.id=id;
		Process.num_procs=num_procs;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void receive_message(Message m) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(m.m);
		return;
	}

	@Override
	public void receive_ack(Ack a) throws RemoteException {
		// TODO Auto-generated method stub

	}
	
	public void broadcast(Message m, Ack a){
		if (a == null && m == null) {
			return;
		}
		
		return;
	}
	
	public void send_message(Message m, int proc_id) throws MalformedURLException, RemoteException, NotBoundException{
		Reception object = (Reception) java.rmi.Naming.lookup("rmi://localhost:1100/p2");
		object.receive_message(m);
		return;
		
	}
	
	public void send_Ack(Message m, int proc_id){
		
	}

}
