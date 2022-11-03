package projectSpringBoot.projectTeam3SpringBoot.enu;

import java.util.Random;

public enum Surname {
    FALCO,
    ROSSI,
    BIANCHI,
    BOTTE,
    DEPROPRIES,
    SALVINI,
    BATTIATO,
    PEZZALI,
    MATERAZZI,
    TOTTI,
    POLIDORI,
    SANTIAGO,
    AMENDOLA,
    ANCOMARZIO,
    BARCA,
    MILITO,
    PETRELLA,
    ORLANDI,
    GERARDI,
    GARIBALDI,
    VERDI,
    SAVOIA,
    CAVOUR,
    MOTTA,
    MILETTI,
    MULETTO,
    CARNICI;

    public static Surname getRandomSurname(){
        Random r = new Random();
        return values()[r.nextInt(values().length)];
    }

}
