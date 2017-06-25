package ldg.mybatis.controller.mail;

import javax.servlet.http.HttpSession;
import ldg.mybatis.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/email")
public class EmailController {
	
	@Autowired
	private EmailSender emailSender;
    
	@Autowired
	private Email email;
	
	
	@RequestMapping("/sendNumber.do")
	public String regist( HttpSession session, Model model) throws Exception {
		
		User member =(User)session.getAttribute("loginSession");
		if (member == null)
			return "redirect:/member/login.do";

		String to = member.getStu_num() + "@dongduk.ac.kr";
		String ranNum = randomNum();
		
		email.setContent("		������ȣ�� [	"+ranNum+"	] �Դϴ�.		");
        email.setReceiver(to);
        email.setSubject("ACCIO ȸ�� ���� �����Դϴ�.");
        emailSender.SendEmail(email);
	
        //������ȣ�� ���ǿ� �־���	
		session.setAttribute("ranNum", ranNum );
       
        return "redirect:/member/authentication.do";
	}
		
	private String randomNum() {
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i<7; i++){
			int n = (int)(Math.random()*10);
			buffer.append(n);
		}
		return buffer.toString();
	}


}
