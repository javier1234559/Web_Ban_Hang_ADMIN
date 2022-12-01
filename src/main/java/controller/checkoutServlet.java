package main.java.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.DAO.ProductDao;
import main.java.entities.Cart;
import main.java.entities.User;


@WebServlet(urlPatterns = {"/checkoutServlet", "/HOME/checkoutServlet"})
public class checkoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public  List<Cart> lsCart ;
	public  long cost = 0;
	private String cart="";
	public User userSession;
	
	
	
	
	private ProductDao productDao ;
	
	
	public void init() throws ServletException {
		try {
			productDao = new ProductDao();
		}catch (Exception e) {
			throw new ServletException(e);	
			
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/HOME/checkout.jsp";
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		HttpSession ses = request.getSession();
		lsCart = (ArrayList<Cart>) ses.getAttribute("lsCart");
		
		cost = (long) ses.getAttribute("cost");
		
		userSession=(User) ses.getAttribute("userSession");
		if(email==null)
		{
			email=userSession.getUemail();
		}
		if(mobile==null)
		{
			mobile=userSession.getUmobile();
		}
		/*
		 * String action = request.getParameter("action");
		 * 
		 * if(action=="Order") {for(Cart item:lsCart) {
		 * cart=cart+item.getPro().getNameproduct()+"            sl:"+item.getQuantity()
		 * +"        "+item.getPro().getPrice()*item.getQuantity()+"\n"; }
		 * 
		 * 
		 * if(email!=null || !email.equals("")) { // sending otp
		 * 
		 * 
		 * 
		 * String to = email;// change accordingly // Get the session object Properties
		 * props = new Properties(); props.put("mail.smtp.host", "smtp.gmail.com");
		 * props.put("mail.smtp.socketFactory.port", "465");
		 * props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		 * props.put("mail.smtp.auth", "true"); props.put("mail.smtp.port", "465");
		 * Session session = Session.getDefaultInstance(props, new
		 * javax.mail.Authenticator() { protected PasswordAuthentication
		 * getPasswordAuthentication() { return new
		 * PasswordAuthentication("badao867@gmail.com", "cwcydjhvvnutyywj"); // Put your
		 * email // id and // password here } });
		 * 
		 * // compose message try { MimeMessage message = new MimeMessage(session);
		 * message.setFrom(new InternetAddress(email));// change accordingly
		 * message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		 * message.setSubject("Xác Nhận đơn hàng của bạn ");
		 * message.setText("Danh sách đơn hàng của bạn: \n"
		 * +cart+"\n Tổng Giá Tiền Thanh Toán"+cost); // send message
		 * Transport.send(message); System.out.println("message sent successfully"); }
		 * 
		 * catch (MessagingException e) { throw new RuntimeException(e); }}}
		 */
		//id=(Integer) ses.getAttribute("userid");
		/*
		 * try { Class.forName("com.mysql.cj.jdbc.Driver"); Connection con =
		 * DriverManager.getConnection("jdbc:mysql://localhost:3306/webbanhang","root",
		 * "Dinhquanquan123"); PreparedStatement pst =
		 * con.prepareStatement("select * from users where id=? "); pst.setInt(1, id);
		 * //String name= ResultSet rs = pst.executeQuery(); if(rs.next()) { User User2
		 * =new User(rs.getString("uname"),rs.getString("uemail"),rs.getInt("id"),rs.
		 * getString("umobile"),""); } }catch(Exception e){ e.printStackTrace(); }
		 */
		RequestDispatcher dispatcher  = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

		
		
		
		
		
		
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	}

