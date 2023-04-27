public class Lokomotywa implements LokomotywaInterface {
    private int liczbaWywolanOdZepsucia;

    @Override
    public void go() throws LokomotywaStoiException {
        this.liczbaWywolanOdZepsucia++;
        if (liczbaWywolanOdZepsucia == 20) {
            this.liczbaWywolanOdZepsucia = 0;
            throw new LokomotywaStoiException();
        }
    }

    @Override
    public void stop() {

    }
}
