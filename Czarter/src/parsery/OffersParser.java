package parsery;

import obiekty.HouseBoat;
import obiekty.Jacht;
import obiekty.Motorowka;
import obiekty.ObiektNawodny;
import parsery.DublicatedOfferException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OffersParser {
    public List<ObiektNawodny> parseNonDuplicatedOffers(String filePath) throws DublicatedOfferException {
        List<ObiektNawodny> oferty = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while (line != null) {
                ObiektNawodny oferta = parseOffer(line);

                if (!oferty.contains(oferta)) oferty.add(oferta);
                else throw new DublicatedOfferException("Zdublikowana oferta: " + oferta);

                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return oferty;
    }

    private ObiektNawodny parseOffer(String oferta) {
        String[] czesci = oferta.split("----");
        String typ = czesci[0].trim();
        String id = czesci[1].trim();
        String model = czesci[2].trim();
        String port = czesci[3].trim();
        float cena = Float.parseFloat(czesci[5].trim());

        String[] lokalizacja = czesci[4].trim().split(";");
        float dlugoscGeo = Float.parseFloat(lokalizacja[0].trim());
        float szerokoscGeo = Float.parseFloat(lokalizacja[1].trim());

        if (typ.equals("obiekty.Jacht")) {
            int przedplata = Integer.parseInt(lokalizacja[6].trim());
            return new Jacht(id, model, port, dlugoscGeo, szerokoscGeo, cena, przedplata);
        } else {
            int mocSilnikow = Integer.parseInt(lokalizacja[6].trim());
            if (typ.equals("House boat")) {
                boolean poimprezowy = lokalizacja[7].trim().equals("Y");
                return new HouseBoat(id, model, port, dlugoscGeo, szerokoscGeo, cena, mocSilnikow, poimprezowy);
            }
            return new Motorowka(id, model, port, dlugoscGeo, szerokoscGeo, cena, mocSilnikow);

        }
    }
}
