/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Jeroen
 */
public class Klas {

    private String naam;
    private List<Leerling> leerlingen;
    private List<Toets> toetsen;
    private Double[] gemiddeldeToetsen;
    private Double gemiddeldeAlleToetsen = 0.00;
    private Leerling max;
    private Leerling min;
    private final Comparator<Leerling> byBehaald = (x, y) -> Double.compare((x.getMax().getBehaald() / x.getMax().getTotaal()), (y.getMax().getBehaald() / y.getMax().getTotaal()));

    public Klas(String naam) {
        this.naam = naam;
        leerlingen = new LinkedList<>();
        toetsen = new LinkedList<>();
    }

    private void berekenMin() {

        min = leerlingen.stream().min(byBehaald).get();
    }

    private void berekenMax() {
        max = leerlingen.stream().max(byBehaald).get();
    }

    private void berekenGemiddeldeAlleToetsen() {
        if (toetsen.size() > 0) {
            leerlingen.forEach(l -> {
                gemiddeldeAlleToetsen += (l.getGemiddelde());
            });
            gemiddeldeAlleToetsen /= toetsen.size();
        }

    }

    @PostConstruct 
    public void update() {
        berekenMin();
        berekenMax();
        berekenGemiddeldeAlleToetsen();
    }

    public void addLeerling(Leerling l) {
        leerlingen.add(l);

    }

    public void addToets(Toets t) {
        toetsen.add(t);
    }

    public List<Leerling> getLeerlingen() {
        return leerlingen;
    }

    public void setLeerlingen(List<Leerling> leerlingen) {
        this.leerlingen = leerlingen;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<Toets> getToetsen() {
        return toetsen;
    }

    public void setToetsen(List<Toets> toetsen) {
        this.toetsen = toetsen;
    }

    public Double[] getGemiddeldeToetsen() {
        return gemiddeldeToetsen;
    }

    public void setGemiddeldeToetsen(Double[] gemiddeldeToetsen) {
        this.gemiddeldeToetsen = gemiddeldeToetsen;
    }

    public Double getGemiddeldeAlleToetsen() {
        return gemiddeldeAlleToetsen;
    }

    public void setGemiddeldeAlleToetsen(Double gemiddeldeAlleToetsen) {
        this.gemiddeldeAlleToetsen = gemiddeldeAlleToetsen;
    }

    public Leerling getMax() {
        return max;
    }

    public void setMax(Leerling max) {
        this.max = max;
    }

    public Leerling getMin() {
        return min;
    }

    public void setMin(Leerling min) {
        this.min = min;
    }

}
