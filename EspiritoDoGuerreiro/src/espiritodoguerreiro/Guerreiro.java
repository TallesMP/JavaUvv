package espiritodoguerreiro;

public class Guerreiro {
    String nome;
    int qtdVidas;
    boolean reviveu = false;
    
    String vidaExtra() {
        String a = InOut.leString("Me parece que suas chances acabaram!\nEntretanto, te darei uma vida extra, desde que IMPLORE POR MISERICÓRDIA!!!");
        return a;
    }
    
    int setVidas() {
        this.qtdVidas = ((int) (Math.random() * 4)) + 9;
        return qtdVidas;
    }
}
