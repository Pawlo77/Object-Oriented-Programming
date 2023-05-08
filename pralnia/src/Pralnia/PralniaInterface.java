package Pralnia;

import java.util.LinkedList;
import java.util.Set;

public interface PralniaInterface {
    public void washAll() throws GranatException;
    public Set<Ubranie> pickUpWashedClothes();
    public LinkedList<ElKieszeni> getPocketStuffByClothes(Ubranie u);
    public void putToWash(Ubranie u);
}
