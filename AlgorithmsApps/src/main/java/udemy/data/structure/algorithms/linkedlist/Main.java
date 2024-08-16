package udemy.data.structure.algorithms.linkedlist;

public class Main {
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList("1");
		list.append("2");
		list.append("3");
		list.append("4");
		list.append("5");
		list.printList();	
		System.out.println(list.length);
		System.out.println(list.tail.value);
		
list.reverse();
		
		list.printList();
		
		list.prepend("0");
		list.prepend("-1");
		list.prepend("-2");
		
		list.removeFirst();
		list.removeFirst();
		
//		list.removeLast();
//		list.removeLast();
//		list.removeLast();
//		list.removeLast();
		
		list.printList();
		
		System.out.println(list.get(0).getValue());
		System.out.println((list.get(6)!= null)?list.get(6).getValue():"X");
		System.out.println(list.get(4).getValue());
		System.out.println(list.get(3).getValue());
		
		list.set(1, "3");
		list.set(2, "5");
		list.set(3, "7");
		list.set(4, "9");
		list.set(5, "11");
		
		list.printList();
		
		list.insert(0, "-1");
		list.insert(2, "1");
		list.insert(3, "2");
		list.insert(5, "4");
		list.insert(7, "6");
		list.insert(9, "8");
		list.insert(11, "10");
		
		list.printList();
		
		//list.remove(0);
		//list.remove(11);
		//list.remove(4);
		
		
		list.printList();
		
		//Linked List: 3 -> 8 -> 5 -> 10 -> 2 -> 1 x: 5
//		LinkedList newLinkedList = new LinkedList("3");
//		newLinkedList.append("8");
//		newLinkedList.append("5");
//		newLinkedList.append("10");
//		newLinkedList.append("2");
//		newLinkedList.append("1");
//		
//		newLinkedList.partitionList(5);
//		newLinkedList.printList();
		
		// 1 -> 4 -> 3 -> 2 -> 5 -> 2 x:3
//		LinkedList newLinkedList2 = new LinkedList("7");
//		newLinkedList2.append("6");
//		newLinkedList2.append("4");
//		newLinkedList2.append("8");
//		newLinkedList2.append("10");
//		newLinkedList2.append("2");
//		
//		newLinkedList2.partitionList(3);
//		newLinkedList2.printList();
		
		//1 -> 2 -> 3 -> 1 -> 4 -> 2 -> 5
		LinkedList duplicatedLL = new LinkedList("1");
		duplicatedLL.append("1");
		duplicatedLL.append("3");
		duplicatedLL.append("1");
		duplicatedLL.append("4");
		duplicatedLL.append("2");
		duplicatedLL.append("5");
		
		duplicatedLL.removeDuplicates();
		duplicatedLL.printList();
		
		
		
		

	}

}
