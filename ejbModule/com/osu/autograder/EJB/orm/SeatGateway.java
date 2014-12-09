package com.osu.autograder.EJB.orm;

import com.osu.autograder.EJB.Entity.SeatEntity;

public class SeatGateway {
	public static String insertSeat(SeatEntity seat) {

		return "Insert into Seat (UserID, CourseID) values ("
				+ seat.getUserID() + "," + seat.getCourseID() + ")";
		
	}

	public static String updateSeat(SeatEntity seat) {
		return "Update Seat Set CourseID= " + seat.getCourseID()
				+ ", UserID=" + seat.getUserID() + " where SeatID = "
				+ seat.getSeatID();
	}

	public static String deleteSeat(SeatEntity seat) {
		return "Delete from Seat where SeatID=" + seat.getSeatID();
		
	}

	public static String findSeatBySeatID(SeatEntity seat) {

		return "Select TOP 1 * from Seat where SeatID="
				+ seat.getSeatID();
	

	}
}