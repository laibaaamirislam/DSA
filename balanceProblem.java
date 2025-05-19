public class balanceProblem {
    charStack myStack;

    public void balance(String str) {
        myStack = new charStack(str.length()); // Initialize stack with the string length as capacity

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            // Check for opening brackets
            if (currentChar == '[' || currentChar == '{' || currentChar == '(') {
                myStack.push(currentChar);
            }
            // Check for closing brackets
            else if (currentChar == ']' || currentChar == '}' || currentChar == ')') {
                // If the stack is empty when encountering a closing bracket, it's imbalanced
                if (myStack.isStackEmpty()) {
                    System.out.println("Equation is not balanced (early mismatch).");
                    return;
                }

                // Check for matching pairs
                char topChar = myStack.myPeak();
                if ((topChar == '[' && currentChar == ']') ||
                        (topChar == '{' && currentChar == '}') ||
                        (topChar == '(' && currentChar == ')')) {
                    myStack.pop();
                } else {
                    System.out.println("Equation is not balanced (mismatched pair).");
                    return;
                }
            }
        }

        // Final check after processing all characters
        if (myStack.isStackEmpty()) {
            System.out.println("Equation is balanced.");
        } else {
            System.out.println("Equation is not balanced (extra opening brackets).");
        }
    }
}


