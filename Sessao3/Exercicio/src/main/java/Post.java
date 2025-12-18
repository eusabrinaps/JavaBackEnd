import java.time.LocalDate;

public class Post {
    private String quote;
    private UserAccount account;
    private LocalDate date;
    private int claps;
    private int boos;


    public Post(UserAccount account, String quote){
        this.quote = quote;
        this.account = account;
        this.date = LocalDate.now();
        this.claps = 0;
        this.boos = 0;
    }


    public String show(){
        return String.format("[%s] - %s says '%s' | Claps: %d | Boos: %d.", date, account, quote, claps, boos );
    }


    public void clap(){
        this.claps++;
    }


    public void boo(){
        this.boos++;
    }


}
