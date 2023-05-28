package parsery;

import obiekty.HouseBoat;
import obiekty.ObiektNawodny;

import java.util.ArrayList;
import java.util.List;

public class OffersProcessor {
    public List<HouseBoat> getAtMostFourSelectedHouseBoatOffers(List<ObiektNawodny> obiekty) {
        List<HouseBoat> domki = new ArrayList<>();
        int found = 0;
        HouseBoat houseBoat;

        int i = obiekty.size() - 1;
        while (i >=0 && found < 4) {
            if (obiekty.get(i) instanceof HouseBoat) {
                houseBoat = (HouseBoat)obiekty.get(i);

                if (!houseBoat.isPoimprezowy()) {
                    domki.add(houseBoat);
                    found++;
                }
            }

            i--;
        }

        return domki;
    }
}
