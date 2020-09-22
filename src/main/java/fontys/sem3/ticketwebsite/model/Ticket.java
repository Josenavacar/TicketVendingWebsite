package fontys.sem3.ticketwebsite.model;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class Ticket {

	String ownerName, ownerID;
	int row, seat;
	private static int seatCounter = 1;
	private boolean space = true;

	public Ticket(String ownerName, String ownerID)
	{
		if(space) {
			this.seat = seatCounter;
			seatCounter++;

			if(seatCounter == 30000)
			{
				space = false;
			}
			this.row = seat % 500;

			this.ownerName = ownerName;
			this.ownerID = ownerID;
		}
		else {
			this.row = -1;
			this.seat = -1;
		}
	}

	public int getSeat()
	{
		return this.seat;
	}
}
