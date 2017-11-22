import java.io.Serializable;
import java.util.Comparator;

public class Message implements Serializable{
	/*m - the content of the message
	  ts - the timestamp
	  pid - to be found*/
	public int m, ts, id;
	
	//construct of a Message
	Message(int m, int ts, int id){
		this.m = m;
		this.ts = ts;
		this.id = id;
	}
	
	//construct of a Message(maybe I can say that ts is 0 and pid is 0)
	Message(int m){
		this.m = m;
	}
	
	//print the contents of the message
	public void print_message(){
		System.out.println(this.m + " " + this.ts + " " + this.id);
	}
}

// Used to order a list of messages
class SortQueue implements Comparator<Message>
{
    public int compare(Message a, Message b)
    {
        if (a.ts == b.ts)
        	return a.id - b.id;
        else
        	return a.ts - b.ts;
    }
}
