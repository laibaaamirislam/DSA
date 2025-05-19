public class charStack {
        private char[] array;
        private int tos;

        charStack(int size){
            array = new char[size];
            tos = -1;
        }

        public void push(char val){
            if(tos == array.length-1){
                System.out.println("stack is full");
            }
            else {
                array[++tos] = (char) val;
            }
        }
        public char pop(){
            if(tos == -1){
                System.out.println("stack is empty");
                return 'e';
            }
            else {
                return array[tos--];
            }
        }

        public char myPeak(){
                return array[tos];
        }

        public void printStack(){
            if (tos == -1) {
                System.out.println("empty stack");
            }
            for(int i = 0; i <= tos; i++){
                System.out.println(array[i]);
            }
        }
        public boolean isStackEmpty(){
            if (tos==-1)
                return true;
            else
                return false;
        }




}
