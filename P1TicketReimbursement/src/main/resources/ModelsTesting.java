import com.revature.models.Ticket.TYPE;


public class ModelsTesting {
	
	@Test
	public void singleTicketTest() {
		Ticket t1 = new Ticket(TYPE.LODGING, 200.00, false, 1);
	}

}
