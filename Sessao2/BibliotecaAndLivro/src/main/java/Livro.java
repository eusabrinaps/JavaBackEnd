public class Livro {
    final private String titulo;
    final private String autor;
    private boolean emprestado;


    public Livro(String titulo, String autor, boolean emprestado){
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = emprestado;
    }

    public void emprestar(){
        this.emprestado = true;
    }


    public void devolver(){
        this.emprestado = false;
    }

    public String obterInformacoes(){
        return "Livro: "+ titulo + ", autor: " + autor +", " + (emprestado ? "Emprestado" : "Livre") ;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean getEmprestado(boolean emprestado){
        return emprestado;
    }

}
