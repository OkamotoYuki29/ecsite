
package net.tkxtools;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;


@Stateless
public class MailSender {
	String	mail_id = "japan.fittness@gmail.com";
	String	mail_pw = "fittness29";
	String	from    = "japan.fittness@gmail.com";

	String	host =	"smtp.gmail.com";
	int	port =	587;
	public	MailSender(){}
	@Asynchronous
	public	void send(String c_mail, String subject, String body){
		try {
			JmSender.send(mail_id, mail_pw, host, port,c_mail, from, subject, body);
		} catch (Exception e) {}
	}
}
