public class Biblioteca {
    private String nome;
    private String localizacao;
    private Livro[] livros;
    private int quantidadeLivros;

    public Biblioteca(String nome, String localizacao, int capacidadeMax) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.quantidadeLivros = 0;
        this.livros = new Livro[capacidadeMax];
    }

    public void adicionaLivro(Livro livro){
        if(livro == null) return;
        if(quantidadeLivros >= livros.length)return;

        for(Livro l : livros){
            if(l == livro ) return;
        }

        livros[quantidadeLivros] = livro;
        quantidadeLivros++;
    }

    public void removerLivro(Livro livro){
        if(livro == null) return;

        for(int i = 0; i < quantidadeLivros; i++){
            if(livro == livros[i]){
                for(int j = i; j < quantidadeLivros-1; j++){
                    livros[j] = livros[j+1];
                }
                livros[quantidadeLivros-1] = null;
                quantidadeLivros--;
                break;
            }
        }
    }

    public String buscarLivro(String titulo){
        for(int i = 0; i < quantidadeLivros; i++){
            if(livros[i].getTitulo().equals(titulo)){
                return livros[i].obterInformacoes();
            }
        }
        return null;
    }

}
