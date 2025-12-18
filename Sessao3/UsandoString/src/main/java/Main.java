import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        String texto = "Hello";
        texto += " World";

        for(char c : texto.toCharArray()){
            System.out.print(c); //vai printar char por char
        }

        System.out.println("Char do index 4: " + texto.charAt(4)); //o
        System.out.println("Index do char 'o': " + texto.indexOf("o")); //4
        System.out.println("Tamanho do texto: " + texto.length());//11

        //COMPARAÇÃO ENTRE OBJETOS

        String literalA = "Orientação-Objetos";
        String literalB = "Orientação-Objetos";

        String objetoA = new String(literalA);
        String objetoB = new String(literalB);

        // O operador == verifica se duas variáveis apontam para o mesmo objeto  na memória
        // Comparar strings use método equals
        System.out.println(literalA == literalB);
        System.out.println(objetoA == objetoB);
        System.out.println(literalA == objetoA);
        System.out.println(literalA.equals(objetoB));

        // métodos úteis da classe String:
        String texto2 = "Aprendendo Java";

        System.out.println(texto2.toUpperCase());
        System.out.println(texto2.toLowerCase());
        System.out.println(texto2.substring(0, 5));
        System.out.println(texto2.replace("Java", "String"));

        final String[] repartido = texto2.split(" ");
        for (String repar : repartido) {
            System.out.println(repar);
        }
        System.out.println(repartido.length);


        //Concatenação

        // O uso do operador + dentro de loops pode ser muito ineficiente. Nesses casos, deve-se adotar a classe StringBuilder.

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i <5; i++){
            builder.append(",").append(i);
        }
        System.out.println(builder);


        StringJoiner joiner = new StringJoiner(",", "[", "]");
        for (int i = 0; i <5 ; i++){
            joiner.add(String.valueOf(i));
        }

        System.out.println(joiner);
    }
}
