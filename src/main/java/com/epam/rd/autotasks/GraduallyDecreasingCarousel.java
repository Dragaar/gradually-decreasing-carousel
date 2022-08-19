package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }

    public CarouselRun run(){
        if(isCaruselRynUnique) {
            CarouselRun rynner = new CarouselGraduallyDecreasingRun(this);
            isCaruselRynUnique = false;
            return rynner;
        } else return null;
    }
}
