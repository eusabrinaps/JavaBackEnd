public class Main {
    public static void main(String[] args) {
        Biblioteca b1 = new Biblioteca("São Carlos", "Santa Catarina", 10);
        Biblioteca b2 = new Biblioteca("Ribeirão Preto", "São Paulo", 11);

        Livro l1 = new Livro("Jantar Secreto", "Rafhael Montes", false);
        Livro l2 = new Livro("Os três mosqueteiros", "Alexandre Dumas", true);

        b1.adicionaLivro(l1);
        b2.adicionaLivro(l2);

        System.out.println(b1.buscarLivro("Jantar Secreto"));
        System.out.printf(b2.buscarLivro("Os três mosqueteiros"));

        b1.removerLivro(l1);
        System.out.println("\n" + b1.buscarLivro("Jantar Secreto"));
    }
}
