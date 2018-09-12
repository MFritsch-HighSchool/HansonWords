import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class WordFreqList implements List<WordFreq> {

	WordFreq[] array = new WordFreq[10];
	//private int lastEmptySpot =0;
	private int boxesFilled=0;


	@Override
	public boolean add(WordFreq t) {
		int i = this.indexOf(t);
		//the word isn't present
		if(i<0) { 
			insert(t);
		}
		else {
			//word is already in list
			this.get(i).increaseFreq();
		}

		return true;
	}

	private void insert(WordFreq newWord) {
		// check to see that we aren't out of room, if we are, double array and copy over
		if(this.size() ==array.length) {
			this.increaseCapacity();
		}
		// I have enough room 

		int x = size()-1;
		while(x >=0 ) {
			if(this.get(x).compareTo(newWord)>0) {
				array[x+1]=this.get(x);
			}
			else {// found out where this newWord goes!
				break;
			}
			x--;
		}
		// at this point, either x == -1, or x is the spot of something not bigger
		array[x+1]=newWord;
		boxesFilled++;
	}

	private void increaseCapacity() {
		// TODO Auto-generated method stub
		WordFreq[] array = new WordFreq[this.size()*2];
		for (int z=0; z<this.size();z++) {
			array[z] = this.array[z]; 

		}
		this.array = array ;
	}

	@Override
	public void add(int arg0, WordFreq arg1) {
		// TODO Auto-generated method stub
		add(arg1);
	}

	@Override
	public boolean addAll(Collection<? extends WordFreq> arg0) {
		boolean addedSomething = false;
		for(WordFreq m: arg0) {
			if(this.add(m)) {
				addedSomething = true;
			}
		}
		// if this List has changed, then return true
		return addedSomething;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends WordFreq> arg1) {
		// TODO Auto-generated method stub
		return this.addAll(arg1);
	}

	@Override
	public void clear() {
		array = new WordFreq[10];
		//private int lastEmptySpot =0;
		boxesFilled=0;
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return this.indexOf(arg0)>-1;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub

		for(Object p: arg0) {
			if(!this.contains(p)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public WordFreq get(int index) {
		if(index <0 || index > this.size()-1)
			throw new IndexOutOfBoundsException("Dude!  What the frown!!");
		// TODO Auto-generated method stub
		return this.array[index];
	}

	@Override
	public int indexOf(Object arg0) {

		return bSearch(0,size()-1, arg0);
	}

	private int bSearch(int i, int j, Object arg0) {
		if(i>j) {
			return -1;
		}
		
		int mid = (i+j)/2;
		
		int comp = this.get(mid).compareTo((WordFreq) arg0);
		
		if(comp == 0)
			return mid;
		if(comp < 0) {
			return bSearch(mid+1, j, arg0);
		}
		
		return bSearch(i, mid-1, arg0);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size()==0;
	}
	
	public boolean sortAlpha(){
		
		return false;
	}
	
	public boolean sortFreq(){
		for(int looper = 1; looper < size(); looper++){
			if(this.get(looper-1).compareTo(this.get(looper)) > 0){
				
			}
		}
		return false;
	}
	
	public boolean sortLength(){
		
		return false;
	}

	@Override
	public Iterator<WordFreq> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return indexOf(arg0);
	}

	@Override
	public ListIterator<WordFreq> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<WordFreq> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		int ind = indexOf(arg0);
		if(ind < 0)
			return false;
		remove(ind);
		return true;
	}

	@Override
	public WordFreq remove(int index) {
		if(index <0 || index > this.size()-1)
			throw new IndexOutOfBoundsException("Dude!  What the frown!!");
		// index is valid
		WordFreq temp = this.get(index);
		int x = index;
		while( x+1 < size()) {
			array[x] = array[x+1];
			x++;
		}
		boxesFilled--;
		return temp;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		int s = this.size();
		for(Object t: c) {
			remove(t);
		}
		
		int after = this.size();
		if(s > after)
			return true;
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public WordFreq set(int arg0, WordFreq arg1) {
		throw new UnsupportedOperationException();
		//return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return boxesFilled;
	}

	@Override
	public List<WordFreq> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		Object[] copy = new Object[size()];
		int x = 0;
		for(Object swag: array) {
			copy[x]  = swag;
			x++;
		}	
		return copy;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString() {
		String result = "{ ";
		
		for(int x = 0; x < size(); x++) {
			result += this.get(x);
			if(x < size()-1)
				result += ", ";
		}
		return result + " }";
	}
}
