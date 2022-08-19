package com.epam.rd.autotasks;

public class CarouselRun {

    DecrementingCarousel dec;
    protected int runnerIndex = 0;
    CarouselRun(DecrementingCarousel dec)
    {
        this.dec = dec;
    }
    public int next() {
        int passesNumber = 0;
        int listElement;
        do {
            if(passesNumber > dec.carosel.length) return -1;
            if(runnerIndex == dec.carosel.length) runnerIndex = 0;

            listElement = dec.carosel[runnerIndex];

            runnerIndex++;
            passesNumber++;

        } while (listElement == 0);


        dec.carosel[runnerIndex-1] -= 1;
        //System.out.println("Current = " + listElement + " Current changed - " + dec.carosel[runnerIndex-1]);
        return listElement;
    }


    public boolean isFinished() {
        int passesNumber = 0;
        for(int i = 0; i < dec.carosel.length; i++)
        {
            if(dec.carosel[i] == 0) passesNumber++;
        }
        if(passesNumber == dec.carosel.length) return true;
        else return false;
    }
}
