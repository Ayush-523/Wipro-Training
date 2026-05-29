package com.company.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.company.bean.MailDetail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailServiceImpl extends MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    // Sender Mail ID
    private final String sender = "yourgmail@gmail.com";

    // ---------------- SIMPLE MAIL ----------------

    @Override
    public String sendMail(MailDetail mailDetail) {

        try {

            SimpleMailMessage simpleMailMessage =
                    new SimpleMailMessage();

            simpleMailMessage.setFrom(sender);

            simpleMailMessage.setTo(
                    mailDetail.getRecipient());

            simpleMailMessage.setText(
                    mailDetail.getMsgBody());

            simpleMailMessage.setSubject(
                    mailDetail.getSubject());

            javaMailSender.send(simpleMailMessage);

            return "Mail Sent Successfully";

        } catch (Exception e) {

            return "Error while Sending Mail";
        }
    }

    // ---------------- MAIL WITH ATTACHMENT ----------------

    @Override
    public String sendMailWithAttachment(
            MailDetail mailDetail) {

        MimeMessage mimeMessage =
                javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper;

        try {

            // multipart = true
            mimeMessageHelper =
                    new MimeMessageHelper(
                            mimeMessage,
                            true);

            mimeMessageHelper.setFrom(sender);

            mimeMessageHelper.setTo(
                    mailDetail.getRecipient());

            mimeMessageHelper.setText(
                    mailDetail.getMsgBody());

            mimeMessageHelper.setSubject(
                    mailDetail.getSubject());

            // Attachment
            FileSystemResource file =
                    new FileSystemResource(
                            new File(
                                    mailDetail.getAttachment()));

            mimeMessageHelper.addAttachment(
                    new File(
                            mailDetail.getAttachment()).getName(),
                    file);

            javaMailSender.send(mimeMessage);

            return "Mail Sent Successfully With Attachment";

        } catch (MessagingException e) {

            return "Error while sending mail";
        }
    }
}