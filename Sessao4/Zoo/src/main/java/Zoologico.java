public class Zoologico {
    private final Animal[] jaulas;
    private int qtd_animais;

    public Zoologico() {
        this.jaulas = new Animal[5];

    }

    public void addAnimaisJaula(Animal qualquer) {
        if(qtd_animais < jaulas.length) {
            jaulas[qtd_animais] = qualquer;
            qtd_animais++;
        }
    }

    public void assustandoAnimais(){
        for(int i = 0; i < qtd_animais; i++){
            jaulas[i].fazerSom();
            if(jaulas[i] instanceof Correr)
                ((Correr) jaulas[i]).correr();
        }
    }
}
