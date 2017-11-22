import java.rmi.Remote;

public interface Reception extends Remote {
	public void receive_message(Message m)throws java.rmi.RemoteException;
	public void receive_ack(Ack a)throws java.rmi.RemoteException;

}
