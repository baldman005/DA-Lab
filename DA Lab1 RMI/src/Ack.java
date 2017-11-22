
public class Ack {

		/*
		 * ts - timestamp
		 * id - id of the sender
		 */
		int ts;
		int id;
		int counter;
		
		Ack(int ts, int id){
			this.ts = ts;
			this.id = id;
			this.counter = 1;
		}
	}

