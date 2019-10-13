import javax.print.DocFlavor.STRING;

public class Lab4 {
	private Node<String> head;
	private Node<String> tail;

	public void addHead(Node<String> n) {
		// add a node to the head of the list.
		if (isEmpty()) {
			head = n;
			tail = n;
			// adds to the front
		} else {
			n.setNext(head);
			head = n;
		}
	}

	public void addTail(Node<String> n) {
		// adds if list is empty
		if (isEmpty()) {
			head = n;
			tail = n;
			// adds to the end
		} else {
			tail.setNext(n);
			tail = n;
		}
	}

	public Node<String> find(String key) {
		Node<String> ptr = head;
		// loops through the list
		while (ptr.getNext().getData() != null) {
			// stops if the pointer is found
			if (ptr.getData().equals(key)) {
				return ptr;
			} else {
				ptr = ptr.getNext();
			}
		}
		System.out.println(key + " was not found");
		return null;
	}

	public Node<String> delete(String key) {
		Node<String> ptr = head;
		Node<String> temp;
		if(head == null) {
			return null;
		}
		// removes the head and set new head
		if (head.getData().equals(key)) {
			temp = head;
			head = head.getNext();
			temp.setNext(null);
			return temp;
		} else {
			// loops through the list
			while (ptr.getNext() != null) {
				// deletes the found node
				if (ptr.getNext().getData().equals(key)) {
					temp = ptr.getNext();
					ptr.setNext(ptr.getNext().getNext());
					temp.setNext(null);
					break;
				} else {
					ptr = ptr.getNext();
				}
			}
		}
		return null;
	}

	public void printList() {
		System.out.println();
		Node<String> currentNode = head;
		if (isEmpty()) {
			System.out.println("\nThe list is empty");
		}
		while (currentNode != null) {
			// Visit the node. In this case, print it out.
			System.out.println(currentNode.toString());
			currentNode = currentNode.getNext();
		}
	}

	public void emptyList() {
		Node <String> mover;
		// Checks to see if the list size is 1 or 0
		if(head == null || head.getNext() == null){
			head = null;
			tail = null;
		}else {
			// mover: holds the next node
			mover = head.getNext();
			while(mover != null) {
				head.setNext(null);
				head = mover;
				mover = mover.getNext();
			}
			head = null;
			tail = null;
		}
	}

	public void addInOrder(Node<String> n) {
		Node<String> currentNode;
		// Add if head is empty or should be behind n
		if (isEmpty() || head.getData().compareTo(n.getData()) > 0) {
			addHead(n);
			// Add to the end
		} else if (tail.getData().compareTo(n.getData()) < 0) {
			addTail(n);
		} else {
			currentNode = head;
			// Keep looping until it hits the end of the list
			while (currentNode.getNext() != null) {
				// Add in the middle
				if (currentNode.getNext().getData().compareTo(n.getData()) > 0) {
					n.setNext(currentNode.getNext());
					currentNode.setNext(n);
					break;
				} 
				currentNode = currentNode.getNext();
			}
		}
	}

	private boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	public void run() {
		Node<String> a = new Node<String>("Athabasca");
		Node<String> b = new Node<String>("Andromeda");
		Node<String> c = new Node<String>("Hector");
		Node<String> d = new Node<String>("Victoria");
		System.out.println("Add everyone to the list");
		addHead(b);
		addTail(c);
		addTail(a);
		addHead(d);
		printList();
		System.out.println("\nRemove Hector");
		delete("Hector");
		printList();
		System.out.println("\nRemove Victoria");
		delete("Victoria");
		printList();
		emptyList();
		printList();
		System.out.println("Add in order");
		addInOrder(a);
		addInOrder(b);
		addInOrder(d);
		addInOrder(c);
		printList();
	}

	public static void main(String[] args) {
		Lab4 l = new Lab4();
		l.run();
	}
}
