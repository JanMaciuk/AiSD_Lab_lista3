import java.util.AbstractList;

public class OneWayLinkedListWithHead<E> extends AbstractList<E> {

    private class Element {
        private E obecnaKarta;
        private Element nastepnaKarta;
        public E getKarta() { return obecnaKarta; }
        public Element getNext() { return nastepnaKarta; }
        public void setKarta(E karta) { obecnaKarta = karta; }
        public void setNext(Element next) { nastepnaKarta = next; }
        Element(E data) {
            obecnaKarta = data;
        }
    }
    Element head = null;
    public OneWayLinkedListWithHead(){}
    public boolean isEmpty() { return head == null; }
    public void clear() { head = null; }
    public Element getElement(int index){ //zwracam referencje do elementu
        Element currentElement=head;
        while(index>0 && currentElement!=null){
            index--;
            currentElement=currentElement.getNext();
        }
        return currentElement;
    }
    public E get(int index) { // zwracam null lub kartę zawartą w elemencie
        Element currentElement = getElement(index);
        if (currentElement != null) {
            return currentElement.getKarta();
        }
        return null;
    }
    public int size() {
        int pos = 0;
        Element currentElement = head;
        while(currentElement != null) {
            pos++;
            currentElement = currentElement.getNext();
        }
        return pos;
    }
    public void add(int index, E element) {
        Element currentElement = head;
        Element previousElement = null;
        while(index > 0 && currentElement != null) {
            index--;
            previousElement = currentElement;
            currentElement = currentElement.getNext();
        }
        Element newElement = new Element(element);
        if (previousElement == null) {
            newElement.setNext(head);
            head = newElement;
        } else {
            newElement.setNext(currentElement);
            previousElement.setNext(newElement);
        }}

    @Override
    public E remove(int index) {
        if(head==null)
            return null;
        if(index==0){
            E retValue=head.getKarta();
            head=head.getNext();
            return retValue;
        }
        Element actElem=getElement(index-1);
        if(actElem==null || actElem.getNext()==null)
            return null;
        E retValue=actElem.getNext().getKarta();
        actElem.setNext(actElem.getNext().getNext());
        return retValue;
    }
    public boolean cardExists(E data) {
        Element currentElement=head;
        while(currentElement!=null)
        {
            if(currentElement.getKarta()==data)
                return true;
            currentElement=currentElement.getNext();
        }
        return false;
    } //W sumie redundant, bo mam do tego osobną listę.


}
