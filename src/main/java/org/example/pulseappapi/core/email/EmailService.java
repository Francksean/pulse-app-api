package org.example.pulseappapi.core.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.example.pulseappapi.center_management.enums.AccreditationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    EmailRepository emailRepository;

    public void sendEmail(String to, String subject, String body) {
        String from = "franck.djuissou@2027.ucac-icam.com";
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);
            mailSender.send(message);

            Email email = new Email();
            email.setSubject(subject);
            email.setBody(body);
            email.setTo(to);
            email.setFrom(from);
            emailRepository.save(email);
            System.out.println("Email envoyé avec succès à " + to);
        } catch (MessagingException e) {
            System.err.println("Erreur lors de l'envoi de l'email : " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    /**
     * Génère un email en HTML en fonction du statut d'accréditation.
     *
     * @param centerName Nom du centre
     * @param status Statut du centre (APPROVED, REJECTED, REVOKED)
     * @return Contenu HTML de l'email
     */
    public String generateCenterApprobationStatusEmailContent(String centerName, AccreditationStatus status) {
        String title;
        String message;

        switch (status) {
            case APPROVED:
                title = "🎉 Félicitations ! Votre centre est accrédité";
                message = "<p>Nous sommes ravis de vous informer que votre centre <strong>" + centerName + "</strong> a été <strong>approuvé</strong> par notre plateforme.</p>" +
                        "<p>Vous pouvez dès à présent recevoir des donneurs et participer à nos campagnes.</p>" +
                        "<p>N’hésitez pas à consulter votre tableau de bord pour suivre vos activités.</p>";
                break;

            case REJECTED:
                title = "❌ Votre demande d'accréditation a été rejetée";
                message = "<p>Après étude de votre demande, nous sommes au regret de vous informer que votre centre <strong>" + centerName + "</strong> n'a pas été accrédité.</p>" +
                        "<p>Les raisons peuvent être :</p>" +
                        "<ul>" +
                        "<li>Dossier incomplet ou incorrect</li>" +
                        "<li>Critères non remplis</li>" +
                        "<li>Problèmes de vérification</li>" +
                        "</ul>" +
                        "<p>Nous vous encourageons à soumettre une nouvelle demande en prenant en compte ces éléments.</p>";
                break;

            case REVOKED:
                title = "⚠️ Votre accréditation a été révoquée";
                message = "<p>Nous vous informons que l'accréditation de votre centre <strong>" + centerName + "</strong> a été <strong>révoquée</strong>.</p>" +
                        "<p>Cette décision peut être due à :</p>" +
                        "<ul>" +
                        "<li>Non-respect des règles</li>" +
                        "<li>Rapports de non-conformité</li>" +
                        "<li>Manque d'activité prolongé</li>" +
                        "</ul>" +
                        "<p>Si vous souhaitez en savoir plus ou contester cette décision, veuillez nous contacter.</p>";
                break;

            default:
                title = "Mise à jour de votre statut";
                message = "<p>Votre centre a subi une mise à jour de son statut.</p>";
                break;
        }

        return generateEmailTemplate(title, message);
    }

    /**
     * Génère le template HTML de l'email.
     *
     * @param title Titre de l'email
     * @param message Contenu du message
     * @return HTML formaté
     */
    private String generateEmailTemplate(String title, String message) {
        return "<!DOCTYPE html>" +
                "<html lang='fr'>" +
                "<head>" +
                "<meta charset='UTF-8'>" +
                "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "<title>" + title + "</title>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }" +
                ".container { max-width: 600px; margin: 20px auto; background: white; padding: 20px; border-radius: 8px; box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1); }" +
                "h2 { color: #2c3e50; }" +
                "p { font-size: 16px; line-height: 1.5; color: #444; }" +
                "ul { padding-left: 20px; }" +
                ".button { display: inline-block; padding: 10px 20px; margin-top: 10px; background: #3498db; color: white; text-decoration: none; border-radius: 5px; }" +
                ".footer { margin-top: 20px; font-size: 12px; color: #777; text-align: center; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='container'>" +
                "<h2>" + title + "</h2>" +
                message +
                "<p>Nous restons à votre disposition pour toute question.</p>" +
                "<p><a href='https://pulse-app.com/auth/login' class='button'>Accéder à votre compte</a></p>" +
                "<div class='footer'>" +
                "<p>© 2025 Pulse - Tous droits réservés.</p>" +
                "</div>" +
                "</div>" +
                "</body>" +
                "</html>";
    }
}
