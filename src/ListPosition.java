import java.util.concurrent.RecursiveTask;

public class ListPosition implements IListPosition {
	private Object content;
	private IListPosition successor;
	private IListPosition predecessor;

	public ListPosition(Object c, IListPosition n, IListPosition p) {
		content = c;
		successor = n;
		predecessor = p;
	}

	@Override
	public Object value() {
		return this.content;
	}

	@Override
	public IListPosition next() {
		return this.successor;
	}

	@Override
	public void setNext(IListPosition newNext) {
		this.successor = newNext;
	}

	@Override
	public IListPosition prev() {
		return this.predecessor;
	}

	@Override
	public void setPrev(IListPosition newPrev) {
		this.predecessor = newPrev;
	}

	public String getStr(){

		String res = "" + this.content + " -->";
			IListPosition tmp = this.successor;
			while(tmp != null){
				res += " " + tmp.value() + " -->";
				tmp = tmp.next();
			}
			res += " X ";
		return res;
	}

}