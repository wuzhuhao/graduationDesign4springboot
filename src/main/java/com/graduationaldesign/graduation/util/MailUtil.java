package com.graduationaldesign.graduation.util;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.MailException;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * 发送邮件通用工具类
 * @author wanyang3
 * 
 */
//@Component
public class MailUtil {
	
//	private Logger logger = LoggerFactory.getLogger(MailUtil.class);
//
//	@Autowired
//	private JavaMailSenderImpl mailSender;
//
//	/**
//	 * 发送文本邮件地址邮件，可指定单个或多个邮件接收人
//	 * @param subject
//	 * @param content
//	 * @param emailFrom
//	 * @param emailTo
//	 * @return boolean
//	 */
//	public boolean sendTextMail(String subject, String content, String emailFrom, String[] emailTo) {
//		SimpleMailMessage msg = new SimpleMailMessage();
//		msg.setSubject(subject);//主题
//		msg.setText(content);//内容
//		msg.setTo(emailTo);//接受者多个
//		msg.setFrom(emailFrom);//发送者
//		msg.setSentDate(new Date());//发送时间
//		try {
//			mailSender.send(msg);
//			return true;
//		} catch (MailException e) {
//			logger.error("sendTextMails", e);
//			return false;
//		}
//	}
//
//	/**
//	 * 发送html邮件
//	 * @param subject
//	 * @param content
//	 * @param emailTo
//	 * @return
//	 */
//	public boolean sendHtmlMail(String subject,String content,String mailFrom,String[] emailTo){
//		MimeMessage mimeMessage = mailSender.createMimeMessage();
//	    MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,"utf-8");
//		try {
//		    messageHelper.setFrom(mailFrom, "scm email message center"); //发送方
//		    messageHelper.setTo(emailTo); //接受者
//		    messageHelper.setSubject(subject); //主题
//		    messageHelper.setSentDate(new Date()); //发送时间
//		    messageHelper.setText(content, true); //参数设置为true 表示启动HTML格式的邮件
//		    mailSender.send(mimeMessage);
//			return true;
//		} catch (Exception e) {
//			logger.error("sendHtmlMail", e);
//			return false;
//		}
//	}
	
}
