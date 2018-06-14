/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formularioderequerimientodeproductoservicio;

import java.util.Properties;
 import javax.mail.Message;
 import javax.mail.Session;
 import javax.mail.Transport;
 import javax.mail.internet.InternetAddress;
 import javax.mail.internet.MimeMessage;
 

 public class Mail {
 
// partes del mail declaradas como privadas
 private String user, pass, destino, subject, mensaje;
 //objeto Propierties donde pondremos los parametros del servidor
 private Properties props;
 
// COnstructor de nuestra clase,le pasamos todos los datos, el mensaje, destinatario, etc etc
 public Mail(String mensaje1) {
 user = "FormulariosInh@gmail.com";
 pass = "asdf12345678";
 destino = "WalterMunoz@Inh.cl";
 subject = "Cambio en base de datos de Formulario";
 mensaje = mensaje1;
 props = new Properties();
 
 setGmailProps();
 }
 //metodo para poner las parametros necesarios
 private void setGmailProps() {
 // el host de correo, en nuestro caso gmail
 props.setProperty("mail.smtp.host", "smtp.gmail.com");
 props.setProperty("mail.smtp.starttls.enable", "true");
 //el puerto que vamos a usar
 props.setProperty("mail.smtp.port", "587");
 //el usuario
 props.setProperty("mail.smtp.user", user);
 //le indicamos que es necesario autentificarse
 props.setProperty("mail.smtp.auth", "true");
 }
 
public String send() {
 String error;
 try {
 //creamo un objeto session donde le setearemos los parametros.
 Session session = Session.getDefaultInstance(props);
 //crearemos lo que viene a ser el mensaje en si, utilizaremos la sesion creada.
 //esto seria como entrar en gmail y darle al boton redactar
 MimeMessage message = new MimeMessage(session);
 //le seteamos el remitente
 message.setFrom(new InternetAddress(user));
 //le seteamos el destinatario
 message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
 //el asunto
 message.setSubject(subject);
 // y por ultimo le seteamos el cuerpo del mensaje, hay varios modos, en nuestro caso utilizamos
 //html pero podria ser en texto plano
 message.setContent(mensaje, "text/html");
 
// con estas 4 linias creamos la conexion y enviamos el mensaje
 Transport t = session.getTransport("smtp");
 t.connect(user, pass);
 t.sendMessage(message, message.getAllRecipients());
 t.close();
 
// como podemos ver devolvemos un string, esto lo hago por si el envio falla poder devolver el error,
 
error = "";
 } catch (Exception e) {
 error = e.toString();
 }
 return error;
 }
 
//GETTERS Y SETTERS
 
public String getDestino() {
 return destino;
 }
 
public void setDestino(String destino) {
 this.destino = destino;
 }
 
public String getMensaje() {
 return mensaje;
 }
 
public void setMensaje(String mensaje) {
 this.mensaje = mensaje;
 }
 
public String getPass() {
 return pass;
 }
 
public void setPass(String pass) {
 this.pass = pass;
 }
 
public Properties getProps() {
 return props;
 }
 
public void setProps(Properties props) {
 this.props = props;
 }
 
public String getSubject() {
 return subject;
 }
 
public void setSubject(String subject) {
 this.subject = subject;
 }
 
public String getUser() {
 return user;
 }
 
public void setUser(String user) {
 this.user = user;
 }
 
}