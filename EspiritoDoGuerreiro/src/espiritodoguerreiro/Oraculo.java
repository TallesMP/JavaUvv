package espiritodoguerreiro;

public class Oraculo {
    String nome;
    Guerreiro warrior;
    
    String prologoIntroducao() {
        String intro = "Bem vindo, guerreiro! Eu sou o oráculo " + this.nome + ".\nVocê tem " + warrior.qtdVidas + " vidas."; 
        return intro;
    }
    
    String prologoPerdedor() {
        InOut.MsgDeInformacao("Derrota", "Oh não! Infelizmente você foi derrotado por mim: O incrível Oráculo! Tente novamente.");
        return null;
    }
    
    String prologoVencedor() {
        InOut.MsgDeInformacao("Vitória", "Parabéns, guerreiro! Você superou os desafios e se sagrou vencedor.");
        return null;
    }

    String prologoProximoNivel() {
        InOut.MsgDeInformacao("Avançando", "Estou impressionado!\nVocê venceu esse desafio e pode avançar para o próximo.");
        return null;
    }
    
    boolean loadLevel01() {
        int valor = (int)(Math.random() * 100);
        System.out.println(valor);
        int escolha = InOut.leInt("Você tem " + this.warrior.qtdVidas + " vidas.\nEscolha um número de 0 a 100.");
        boolean next_level = false;
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

        if (this.warrior.qtdVidas > 0) {
            next_level = true;
        } else {
            if (this.decidirVidaExtra(this.warrior.vidaExtra())) {
                escolha = InOut.leInt("Por mil raios e trovões!\nOs deuses ouviram seu pedido de misericórdia.\nVocê tem uma vida extra, escolha outro número.");
                if (escolha == valor) {
                    next_level = true;
                }
            }
        }

        return next_level;
    }
    
    boolean loadLevel02() {
        
        String[] options = {"PAR" , "IMPAR"}; 
        int esc_orac = (int)(Math.random() * 5);
        int esc_guer = (int)(Math.random() * 5);
        boolean check_par = false;
        boolean next_level = false;
        
        if ((esc_orac + esc_guer) % 2 == 0) {
            check_par = true;
        }
        System.out.println("Escolha do oraculo: " + esc_orac); // DEBUG
        System.out.println(check_par); // DEBUG

        int palpite = InOut.duasOpcoes("Palpite", "Seu número é " + esc_guer + ".\nVocê acha que a soma do meu número com o seu será par ou ímpar?", options);

        
        if (palpite == 1 && check_par) {
            next_level = true;
        } else if (palpite == 2 && !check_par) {
            next_level = true;
        } else if (!this.warrior.reviveu) {
            if (this.decidirVidaExtra(this.warrior.vidaExtra())) {
                palpite = InOut.duasOpcoes("Segunda chance", "Por mil raios e trovões!\nOs deuses ouviram seu pedido de misericórdia.\nVocê acha que a soma do meu número com o seu será par ou ímpar?", options);
                if (palpite == 1 && check_par) {
                next_level = true;
                } else if (palpite == 2 && !check_par) {
                next_level = true;
                }
            }
        }
    
        return next_level;
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
