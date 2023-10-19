package espiritodoguerreiro;

public class EspiritoDoGuerreiro {

    public static void main(String[] args) {
        boolean continuar = true;
        Oraculo master = new Oraculo();
        master.warrior = new Guerreiro();
        
        
        
        do {
            master.nome = InOut.leString("Digite o nome do Oráculo");
            master.warrior.setVidas();
            InOut.MsgDeInformacao("Introdução", master.prologoIntroducao());
            
            if (master.loadLevel01()) {
                master.prologoProximoNivel();
                if (master.loadLevel02()) {
                    master.prologoVencedor();
                } else {
                    master.prologoPerdedor();
                }
            } else {
                master.prologoPerdedor();
            }

            continuar = InOut.leBoolean("Fim do jogo", "Jogar Novamente?");
        } while (continuar == true);
              
        
        
    }    
}
