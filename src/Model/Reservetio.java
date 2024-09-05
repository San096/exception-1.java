package Model;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import Model.DomainException;


public class Reservetio {
    private int roomNumber;
    private Date chekin;
    private Date chekaut;

    private static SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservetio(int roomNumber, Date chekin, Date chekaut) {
        
        this.roomNumber = roomNumber;
        this.chekin = chekin;
        this.chekaut = chekaut;

      
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getChekin() {
        return chekin;
    }


    public Date getChekaut() {
        return chekaut;
    }

    public long duration() {
        long diff = chekaut.getTime() - chekin.getTime();  // retorna a diferença da entrada e saida em mili segundas 
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS); // passa de milisegundos para dias 
    }
    
    public void upDate(Date chekin, Date chekaut) {
		Date now = new Date();
         if (chekin.before(now) || chekaut.before(now)) {     // before antes 

            throw new DomainException( "erro in reservetin : data incorretas");
         }
         if(!chekaut.after(chekin)){

         throw new DomainException ("erro in reservetin : data incorretas");
         }
         else {  
        this.chekin = chekin;
        this.chekaut = chekaut;
		 }

    }
    @Override

    public String toString(){
        return "Room :" +
                roomNumber +
                ",check-in :" +
                sdf.format(chekin) +
                ", heck-out: " +
                sdf.format(chekaut)+
                ", "+
                duration()+
                " nigthes;";


    }

  

    
}
