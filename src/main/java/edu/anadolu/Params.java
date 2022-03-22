package edu.anadolu;

import com.lexicalscope.jewel.cli.Option;

public interface Params {
    @Option(
            description = "number of depots",
            shortName = {"d"},
            longName = {"depots"},
            defaultValue = {"4"}
    )
    int getNumDepots();

    @Option(
            description = "number of salesmen per depot",
            shortName = {"s"},
            longName = {"salesmen", "vehicles"},
            defaultValue = {"2"}
    )
    int getNumSalesmen();

    @Option(
            description = "use city names when displaying/printing",
            shortName = {"v"},
            longName = {"verbose"}
    )
    boolean getVerbose();

    @Option(
            description = "initial city, if customer want initialize with spesific city",
            shortName = {"i"},
            longName = {"initialCity"},
            defaultValue = {""}
    )
    String getInitialCity();

    @Option(
            helpRequest = true,
            description = "display help",
            shortName = {"h"}
    )
    boolean getHelp();
}
