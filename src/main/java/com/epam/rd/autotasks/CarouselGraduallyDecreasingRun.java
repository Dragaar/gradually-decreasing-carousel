package com.epam.rd.autotasks;

public class CarouselGraduallyDecreasingRun extends CarouselRun{
    private int decreasingIndex = 1;
    private  int cycleLenght;
    private int passageCycleIndex = 0;

    public CarouselGraduallyDecreasingRun(DecrementingCarousel dec) {
        super(dec);
        cycleLenght = elementsCount();
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

        } while (listElement <= 0 );
        //визначаєм довжину одного кола


        dec.carosel[runnerIndex-1] -= decreasingIndex;
        System.out.println("Current = " + listElement + " Current changed - " + dec.carosel[runnerIndex-1]);
        passageCycleIndex++;
        // З кожним пройденим колом збільшити декремент

        if(passageCycleIndex == cycleLenght) {
            decreasingIndex++;
            passageCycleIndex = 0;
            cycleLenght = elementsCount();
            System.out.println("----------------- cycleLenght = " + elementsCount());
        }

        return listElement;
    }

    private int elementsCount()
    {
        int counter = 0;
        for(int i = 0; i < dec.carosel.length; i++)
        {
            if(dec.carosel[i] > 0) counter++;
        }
        return counter;
    }
    public boolean isFinished() {

        if(elementsCount() == 0) return true;
        else return false;
    }
}
