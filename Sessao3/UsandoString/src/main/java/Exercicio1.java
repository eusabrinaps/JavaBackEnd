public class Exercicio1 {
    //Crie uma classe com um método que conte quantas vezes uma palavra aparece em uma frase.
    String frase;

    public Exercicio1(String frase){
        this.frase = frase;
    }

    public int countPalavras(String palavra){
        int count = 0;
        String[] palavras = frase.split(" ");

        for(int i = 0; i < palavras.length; i++){
            if(palavra.equals(palavras[i])){
                count++;
            }
        }

        return count;
    }
}
