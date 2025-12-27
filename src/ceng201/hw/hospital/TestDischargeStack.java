package ceng201.hw.hospital;

public class TestDischargeStack {

    public static void main(String[] args){

        // create an empty stack for discharge records
        DischargeStack stack = new DischargeStack();

        // Push a few sample discharge records (LIFO)
        stack.push(new DischargeRecord(212));
        stack.push(new DischargeRecord(213));
        stack.push(new DischargeRecord(214));
        stack.push(new DischargeRecord(215));
        stack.push(new DischargeRecord(216));

        //print stack after pushes
        stack.printStack();

        //Pop two records and print which patient IDs were removed
        DischargeRecord r1 = stack.pop();
        System.out.println("Pop record 1 : " + (r1 !=null ? r1.getPatientId(): "---Empty---"));

        DischargeRecord r2 = stack.pop();
        System.out.println("Pop record 2 : " + (r2 != null ? r2.getPatientId(): "----Empty----"));

        //Print stack after pop
        stack.printStack();

        //Peek the current top element without removing it
        DischargeRecord top = stack.peek();
        System.out.println("Peek most recent : " + (top != null ? top.getPatientId(): "----Empty----"));

    }
}















