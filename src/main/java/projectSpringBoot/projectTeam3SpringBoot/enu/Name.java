package projectSpringBoot.projectTeam3SpringBoot.enu;

import java.util.Random;

public enum Name {
    LORENZO,
    FRANCESCO,
    FRANCO,
    FRANCA,
    FRANCESCA,
    LOREDANA,
    EDOARDO,
    ETTORE,
    ACHILLE,
    AMBROGIO,
    ANTONELLA,
    ANTONELLO,
    GABRIELE,
    GABRIELLA,
    ANNA,
    GIUSEPPE,
    GIUSEPPINA,
    SARA,
    STEFANO,
    STEFANIA,
    MARCO,
    MATTEO,
    MARIA,
    MARIO,
    MICHELE,
    MICHELA,
    ROBERTO,
    ROBERTA,
    EMANUELA,
    EMANUELE,
    SIRIA,
    CRISTIANO,
    CRISTIAN,
    ANTHONY,
    THOMAS;

    public static Name getRandomName(){
        Random r = new Random();
        return values()[r.nextInt(values().length)];
    }
}

