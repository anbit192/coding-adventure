package designpatterns.observer.numbersystem.observers;

import designpatterns.observer.numbersystem.Subject;

public abstract class Observer {
    protected Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
    }

    public abstract void update();
}
