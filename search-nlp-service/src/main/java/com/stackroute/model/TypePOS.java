package com.stackroute.model;

public enum TypePOS {
    CoordinatingConjunction("CC"),
    CardinalNumber("CD"),
    Determiner("D"),
    ExistentialThere("EX"),
    ForeignWord("FW"),
    PrepositionOrSubordinatingConjunction("IN"),
    Adjective("JJ"),
    AdjectiveComparative("JJR"),
    AdjectiveSuperlative("JJS"),
    ListItemMarker("LS"),
    Modal("MD"),
    NounSingularorMass("NN"),
    NounPlural("NNS"),
    ProperNounSingular("NNP"),
    ProperNounPlural("NNPS"),
    Predeterminer("PDT"),
    PossessiveEnding("POS"),
    PersonalPronoun("PRP"),
    PossessivePronoun("PRP$"),
    Adverb("RB"),
    AdverbComparative("RBR"),
    AdverbSuperlative("RBS"),
    Particle("RP"),
    Symbol("SYM"),
    to("TO"),
    Interjection("UH"),
    VerbBaseForm("VB"),
    VerbPastTense("VBD"),
    VerbGerundOrPresentParticiple("VBG"),
    VerbPastParticiple("VBN"),
    VerbNonThirdPersonSingularPresent("VBP"),
    VerbThirdPersonSingularPresent("VBZ"),
    WhDeterminer("WDT"),
    WhPronoun("WP"),
    PossessiveWhPronoun("WP$"),
    WhAdverb("WRB");

    private String type;

    TypePOS(String type)
    {
        this.type = type;
    }

    public String getName()
    {
        return type;
    }
}
