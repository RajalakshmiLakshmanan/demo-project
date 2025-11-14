package learnCollection;

public class stackImpArray {
	int size;
	int[] arr;
	int top;
	stackImpArray(int size){
		this.size = size;
	    this.arr = new int[size];
	    this.top = -1;	
	}
	
	public boolean isStackEmpty() {
		return (top == -1);
	}
	
	public boolean isStackFull() {
		return(size-1 == top);
		
	}
	public int pop() {
		if(!isStackEmpty()) {
			int returntop = top;
			top--;
			System.out.println("popped element: "+arr[returntop]);
			return arr[returntop];
		}else {
			System.out.println("stack is empty");
		}
		
		return-1;
	}
	
	
	public int push(int element) {
		if(!isStackFull()) {
			top++;
			arr[top]= element;
			
			System.out.println("pushed element: "+arr[top]);
			return arr[top];
		}else {
			System.out.println("stack is full");
		}
		
		return -1;
		
	}
	
	public int peek() {
		if(!isStackEmpty()) {
			System.out.println("peek element: "+arr[top]);
			return arr[top];
			
		}else {
			System.out.println("stack is empty");
		}
		return -1;
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		stackImpArray stack = new stackImpArray(10);
        System.out.println(stack.isStackEmpty());
        System.out.println(stack.isStackFull());
        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);
        System.out.println(stack.isStackEmpty());
        System.out.println(stack.isStackFull());
        stack.pop();
        stack.peek();
        
	}

}
