# Group Project - Stack
# Group 9
# Group Members
- Glaiza Mae Uyangurin Orence 

- Rosel Andraje

- Mary De Jesus

- Joshandrew Mariano

- Zhandy Corpuz


# Description of the program
This program demonstrates the implementation of a Stack data structure using Java. It allows users to perform basic stack operations such as Push, Pop, and Peek through a graphical user interface (GUI). The program follows the Last In, First Out (LIFO) principle, where the most recently added item is the first one to be removed.

# Features

1. Push – Adds a new value to the top of the stack.
2. Pop – Removes the top value from the stack.
3. Peek – Shows the top value without removing it.
4. Vertical Stack Visualization – Displays the stack items vertically in the GUI.
5. Input Field – Allows users to enter values to add to the stack.
6. Clear Stack – Removes all items from the stack.
7. Check Stack – Shows the current number of items in the stack.
8. Random Value – Generates a random number and adds it to the stack.
9. Empty Stack Check – Prevents Pop and Peek from working when the stack is empty.
10. Full Stack Check – Prevents adding more items when the array reaches its maximum capacity.


# Requirements
Software Requirements:

- Java Development Kit (JDK) 8 or higher
- Visual Studio Code (VS Code)
- Extension Pack for Java (VS Code Extension)

Hardware Requirements:

- Computer or laptop
- At least 4 GB RAM
- Minimum 200 MB free storage space


# How to run the program

1. Install Java JDK. Download and install a JDK if you do not have one yet.
2. Install Visual Studio Code. Open VS Code and install the Extension Pack for Java from the Extensions Marketplace.
3. Create a Java file. Create a folder for your project, open it in VS Code, and create a file.
4. Copy the code. Paste your Stack Visualization Java code and save it.
5. Run the program. Click the Run button above the `main` method, or right-click the code and select Run Java.
6. View the GUI. A separate window titled Stack Visualization should appear.
7. Test the buttons. Enter a value and click PUSH, POP, or PEEK to test the stack operations.


# Project Structure

1. Main.java – Contains the graphical user interface, including the input field, buttons, status message, and vertical stack display.

2. Array Stack – Uses an array to store the values entered by the user and manages the top position of the stack.

3. Button Actions – Handles the Push, Pop, and Peek operations when the user clicks the buttons. It also includes Clear, Check Stack, and Random actions.

4. Stack Visualization – Updates the GUI to display the current stack contents whenever an item is added or removed.

5. Main Method – Runs the program and opens the Stack Visualization window.


# Stack Implementation
Our group implemented the stack using an array to store the values entered by the user. We used the LIFO (Last In, First Out) principle, which means the last item added is the first one removed. We connected the stack to our GUI buttons so that Push adds an item, Pop removes the top item, and Peek displays the top item without removing it. We also added checks to prevent errors when the stack is full or empty. The GUI updates whenever the stack changes, allowing us to see the items displayed vertically.

# Screenshots

# AI Disclosure

**1. Name the specific AI tool and its version number.**

ChatGPT by OpenAI (GPT-6).
Claude (Sonnet 5.5 Extra).

**2. State the task the tool performed.**

We used ChatGPT for minor assistance in checking our Java code and understanding how to connect the Push, Pop, and Peek buttons to our array stack and GUI.

We used Claude for minor assistance to understand how to add undo button, second stack and implement a way to transfer elements from stack A to stack
B, operation history, and a maximum capacity selector.

**3. State the prompts used for this activity.**

We asked ChatGPT for small suggestions on how to connect our existing GUI buttons to the array stack and make the button actions work properly.

We asked claude what function/command in our buttons in array stack.

**4. Confirm the extent of use, from a single check to substantial drafting.**

We mainly developed the code ourselves and only used ChatGPT for minor guidance when we encountered problems or needed clarification.



**5. Include a statement that a human author verified the output.**

We reviewed and tested the code ourselves to make sure the buttons worked correctly and the output matched our activity requirements.

**6. Why and how was AI used in this activity?**

We used ChatGPT as a guide to help us understand some parts of the code and fix minor issues. It helped us clarify how the buttons interact with the array stack.

**7. Estimated percentage of the submitted work assisted by AI.**

Approximately 10% of our work was assisted by AI, mainly through suggestions and explanations.

15% of our work assisted by AI.

**8. What are the changes you made to the AI-generated output?**

We made our own adjustments to the code to fit our existing GUI design, button names, and array stack implementation.

I rejected Claude’s first two versions and asked for a simpler one that keeps my original code.

**9. What have you learned from using the tool?**

We learned how to connect GUI buttons to array stack operations. We also gained a better understanding of how Push, Pop, and Peek work and how to display stack items vertically in a GUI.

I learned how undo can work by saving a copy of the stacks before each operation, and that AI code must be run and tested before I submit it.

# Contributors
