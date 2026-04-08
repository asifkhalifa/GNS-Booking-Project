package com.gnsbooking.app.utility;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmailTemplate {
	
	public String getOtpTemplate(String otp) {
		String html =
                "<!DOCTYPE html>" +
                "<html>" +
                "<body style='font-family: Arial; background:#f4f6f8; padding:20px;'>" +

                "<div style='max-width:500px; margin:auto; background:#fff; padding:20px; border-radius:10px;'>" +

                "<h2 style='text-align:center;'>GNS Booking 🎉</h2>" +

                "<p>Hi,</p>" +

                "<p>Thank you for logging in.</p>" +

                "<p>Your OTP is:</p>" +

                "<h1 style='text-align:center; color:blue;'>" + otp + "</h1>" + 

                "<p>This OTP is valid for 5 minutes.</p>" +

                "<p>If you did not request this, ignore this email.</p>" +

                "<hr/>" +

                "<p style='font-size:12px; text-align:center;'>© 2026 GNS Booking</p>" +

                "</div>" +

                "</body></html>";
			
		return html;
	}
	
	public String bookingConfirmTemplate(List<String> seatList, Long bkngId, int total) {
		String html =
				"<html>" +
				"<body style='font-family: Arial, sans-serif; background-color:#f4f6f8; padding:20px;'>" +

				"<div style='max-width:500px; margin:auto; background:#ffffff; padding:20px; border-radius:10px; box-shadow:0 2px 8px rgba(0,0,0,0.1);'>" +

				"<h2 style='text-align:center; color:#333;'>GNS Booking Confirmation 🎉</h2>" +

				"<p>Hi,</p>" +

				"<p>Your booking has been successfully created. Please find the details below:</p>" +

				"<div style='background:#f9f9f9; padding:15px; border-radius:8px;'>" +

				"<p><b>📌 Booking ID:</b> " + bkngId + "</p>" +
				"<p><b>🎟️ Ticket Numbers:</b> " + seatList + "</p>" +
				"<p><b>💰 Total Amount:</b> ₹" + total + "</p>" +

				"</div>" +

				"<p style='margin-top:20px;'>Please complete your payment using the UPI ID below:</p>" +

				"<div style='text-align:center; margin:20px 0;'>" +
				"<p style='font-size:18px; font-weight:bold; color:#007bff;'>UPI ID: 7738612015@ptaxis</p>" +
				"</div>" +

				"<p>After completing the payment, kindly send your payment receipt along with:</p>" +

				"<ul>" +
				"<li>📧 Your Booking Email ID</li>" +
				"<li>🆔 Booking ID</li>" +
				"</ul>" +

				"<p>Send the details on WhatsApp:</p>" +

				"<p style='font-size:16px; font-weight:bold;'>📱 +91-7738612015</p>" +

				"<p style='margin-top:20px;'>Once verified, your booking will be confirmed.</p>" +

				"<p>Thank you for booking with us! 🙌</p>" +

				"<hr>" +

				"<p style='font-size:12px; color:#777; text-align:center;'>© 2026 GNS Booking. All rights reserved.</p>" +

				"</div>" +

				"</body>" +
				"</html>";
		return html;
	}
	
	
	public static String getApprovedTicketTemplate(Long bookingId, List<String> seats, int amount) {
		StringBuilder ticketsHtml = new StringBuilder();
		for (String seat : seats) {
			ticketsHtml.append(
					"<div style='background:#1a1a1a; border-radius:15px; padding:20px; margin:15px 0; color:white; border:1px solid #333;'>" +
							"<h2 style='margin:0; color:#FFD700;'>🎟️ NAACH '26</h2>" +
							"<p style='margin:5px 0; color:#ccc;'>Theme: Mumbai Meri Jaan</p>" +
							"<div style='margin:15px 0; padding:10px; background:#2a2a2a; border-radius:10px; text-align:center;'>" +
							"<p style='margin:0; font-size:14px; color:#aaa;'>SEAT</p>" +
							"<p style='font-size:28px; font-weight:bold; color:#00BFFF; margin:5px 0;'>" + seat + "</p>" +
							"</div>" +
							"<p style='margin:5px 0;'><b>Amount:</b> ₹" + amount + "</p>" +
							"<p style='font-size:12px; color:#bbb;'>📅 25th April | 🕖 7 PM</p>" +
							"<p style='font-size:12px; color:#bbb;'>📍 Ghatkopar Auditorium</p>" +
							"</div>"
					);
		}
		return "<html><body style='font-family: Arial; background:#0d0d0d; padding:20px;'>" +
		       "<div style='max-width:600px; margin:auto;'>" +
		       "<h1 style='text-align:center; color:#FFD700;'>🎉 Booking Confirmed</h1>" +
		       "<p style='color:white; text-align:center;'>Your payment is verified successfully</p>" +
		       "<p style='color:#ccc; text-align:center;'>Booking ID: " + bookingId + "</p>" +
		       ticketsHtml.toString() +
		       "<p style='color:white; text-align:center; margin-top:20px;'>Show this email at entry gate</p>" +
		       "<hr style='border-color:#333;'/>" +
		       "<p style='font-size:12px; color:#777; text-align:center;'>© 2026 GNS Booking</p>" +
		       "</div></body></html>";
	}
	
	

}
