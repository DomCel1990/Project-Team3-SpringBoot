package projectSpringBoot.projectTeam3SpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendTo(String email, String title, String text) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setSubject(title);
        helper.setTo(email);

        boolean html = true;
        String textHtml =
                        "<h1>" + title + "</h1><h2></h2>" +
                        "<img src=https://www.carmacod.it/wp-content/uploads/2020/07/pack_ok.gif>" +
                        "<h3>"+text +"</h3>";

        helper.setText(textHtml, html);

        javaMailSender.send(message);
    }
    public void sendToShop(String email, String title, String text) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setSubject(title);
        helper.setTo(email);

        boolean html = true;
        String textHtml =
                "<h1>" + title + "</h1><h2></h2>" +
                        "<img src=https://www.gifanimate.com/data/media/1103/congratulazione-e-complimento-immagine-animata-0092.gif>" +
                        "<h3>"+text +"</h3>";

        helper.setText(textHtml, html);

        javaMailSender.send(message);
    }
}
