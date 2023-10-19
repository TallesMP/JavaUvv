package espiritodoguerreiro;

public class Oraculo {
    String nome;
    Guerreiro warrior;
    
    String prologoIntroducao() {
        String intro = "Bem vindo, guerreiro! Eu sou o oráculo " + this.nome + ".\nVocê tem " + warrior.qtdVidas + " vidas."; 
        return intro;
    }
    
    String prologoPerdedor() {
        InOut.MsgDeInformacao("Vitória", "Parabéns, guerreiro! Você superou os desafios e se sagrou vencedor.");
        return null;
    }
    
    String prologoVencedor() {
        InOut.MsgDeInformacao("Derrota", "Oh não! Infelizmente você foi derrotado por mim: O incrível Oráculo! Tente novamente.");
        return null;
    }

    String prologoProximoNivel() {
        InOut.MsgDeInformacao("Avançando", "Estou impressionado!\nVocê venceu esse desafio e pode avançar para o próximo.");
        return null;
    }
    
    boolean loadLevel01() {
        int valor = (int)(Math.random() * 100);
        int escolha = InOut.leInt("Você tem " + this.warrior.qtdVidas + " vidas.\nEscolha um número de 0 a 100.");
        while (escolha != valor && this.warrior.qtdVidas > 0) {
            if (escolha < valor) {
                this.warrior.qtdVidas--;
                escolha = InOut.leInt("Você tem " + this.warrior.qtdVidas + " vidas.\nEscolha um número maior.");
            }
            if (escolha > valor) {
                this.warrior.qtdVidas--;
                escolha = InOut.leInt("Você tem " + this.warrior.qtdVidas + " vidas.\nEscolha um número menor.");
            }
        }

        if (this.warrior.qtdVidas == 0) {
            if (this.decidirVidaExtra(this.warrior.vidaExtra())) {
                if (escolha > valor) {
                    escolha = InOut.leInt("Por mil raios e trovões!\nSeu pedido de misericórdia foi atendido e você tem uma vida extra.\nEscolha outro número maior.");
                    if (escolha == valor) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    escolha = InOut.leInt("Por mil raios e trovões!\nSeu pedido de misericórdia foi atendido e você tem uma vida extra.\nEscolha outro número menor.");
                    if (escolha == valor) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
    
    boolean loadLevel02() {
        
        String[] options = {"PAR" , "IMPAR"}; 
        int esc_orac = (int)(Math.random() * 5);
        int esc_guer = (int)(Math.random() * 5);
        boolean isEven = false;
        int palpite = InOut.duasOpcoes("Palpite", "Seu número é " + esc_guer + ".\nVocê acha que a soma do meu número com o seu será par ou ímpar?", options);
        
        if ((esc_orac + esc_guer) % 2 == 0) {
            isEven = true;
        }
    

        if ((palpite == 1 && isEven) || (palpite == 2 && !isEven)) {
            return true;
        } else {
            if (!this.warrior.reviveu) {
                if(decidirVidaExtra(this.warrior.vidaExtra())) {
                    palpite = InOut.duasOpcoes("Palpite", "Por mil raios e trovões!\nSeu pedido de misericórdia foi atendido e você tem uma vida extra.\nSeu número é " + esc_guer + ".\nVocê acha que a soma do meu número com o seu será par ou ímpar?", options);
                    if ((palpite == 1 && isEven) || (palpite == 2 && !isEven)) {
            return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

    }
    
    boolean decidirVidaExtra(String frase) {
        if (InOut.contarPalavras(frase) >= 5) {
            this.warrior.reviveu = true;
            return true;
        } else {
            return false;
        }
    }
    
    void setNome(String Nome) {
        this.nome = Nome;
    }
}
