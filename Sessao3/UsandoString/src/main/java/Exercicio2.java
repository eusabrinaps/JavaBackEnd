public class Exercicio2 {
    String email;


    public Exercicio2(String email){
        this.email = email;
    }

    public String validaEmail(){
        if(email == null) return "Sem valor";

        email = email.trim();
        int arrobaIndex = email.indexOf("@");

        if(arrobaIndex <= 0){return "Inválido";}
        if(arrobaIndex != email.lastIndexOf("@")){return "Inválido";}

        String usuario = email.substring(0, arrobaIndex);
        String dominio = email.substring(arrobaIndex+1);

        if(usuario.startsWith(".")) return "Inválido";
        if(dominio.startsWith(".")) return "Inválido";
        if(!dominio.contains(".")) return "Inválido";

        if(email.contains(" ")) return "Inválido";

        return "Email válido";
    }
}
