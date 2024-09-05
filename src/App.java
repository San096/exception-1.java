import java.util.*;                             // biblioteca util .o * ultiliza todo o pacote 
import java.text.ParseException;
import java.text.SimpleDateFormat;             //  Biblioteca para formatação de Texto 
import java.util.concurrent.TimeUnit;         //manter o controle do padrão de tempo 
import Model.DomainException;
import Model.Reservetio;


public class App {
    public static void main(String[] args) throws DomainException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  // definir o padrão da formatação de tempo 
try {
        System.out.println("****ROOM NUMBER******");   //BLOCO DE COMANDO DE LANÇAMENTO DE EXCEÇÕES 
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/mm/yyy)"); //
        Date checkin = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/mm/yyy)");//
        Date checkout = sdf.parse(sc.next());

       
        Reservetio reserva = new Reservetio(number , checkin, checkout);

        System.out.println(reserva);
        
        System.out.println();

        System.out.println("Entre com dados para atualizar os adados da reserva :");

        System.out.print("Check-in date (dd/mm/yyy)");

        checkin = sdf.parse(sc.next());

        System.out.print("Check-out date (dd/mm/yyy)");

         checkout = sdf.parse(sc.next());

       
        reserva.upDate(checkin, checkout);
           
        System.out.println(reserva);
            

         }
         catch(ParseException e){
            System.out.println("data invalida:");
         }
         catch(DomainException e) {
            System.out.println("erro na reserva" + e.getMessage());

       }
       
    }
}


