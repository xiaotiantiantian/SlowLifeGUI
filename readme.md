#Deliverable4 of Zhirun Tian

##1. Summary
Here is the issues I found and modifed by using VisualVM snapshots.

Firstly, I open the SlowLifeGUI and attach the VisualVM to its process. Then look at GameOfLife Tab-> Profiler Tab-> CPU, I could find the most time slices cost functions. https://github.com/xiaotiantiantian/SlowLifeGUI/blob/master/ScreenShots/PerformanceBeforeChange.png
After have a simple look, I took a snapshot of the progarm, which could help find the relationship between each time costed function. https://github.com/xiaotiantiantian/SlowLifeGUI/blob/master/ScreenShots/PerformanceBeforeChange3.png
Then I found the MainPanel.runContinuous ihave a huge time from two parts: one is its self time and another is that it called the MainPanel.calculateNextIteration, calculateNextIteration called MainPanel.iterateCell, and iterateCell called getNumNeighbors, getNumNeighbors called MainPanel.convertToInt. 

So it means the MainPanel.runContinuous and MainPanel.convertToInt has some problem inside.

Then I found another huge time slice is Cell.<init>, which was called by MainPanel.backup function. which means the two funtion may have some problems.

After a look of the source code, I found the Cell.toString also have a useless loop.

###1.1 Cell.toString
It just build a long string with all "X" or all "." and return the first char of the string, then I modifed it to just return the "X" or "."
###1.2 Cell.<init>
The original constructor would try to give the Cell a text " "(which means a space), which call its parent class and consume many time slices. I just remove the sentence and there's no difference in its appearence.
###1.3 MainPanel.convertToInt
This function just return the input parameter, its inside logic has no effect to its returned value. So I just removed it.
###1.4 MainPanel.backup
This function use the Cell class to store the life status of cells, then I modifed it to a boolean 2 dimension array. Which make it faster.
###1.5 MainPanel.runContinuous
The function has some sentence has no effect to the outside of the function, from " int origR = _r" to "_r = origR", it is just a loop which spend too much time.

##2. Screenshots before and after modified
###2.1 Before modified
https://github.com/xiaotiantiantian/SlowLifeGUI/blob/master/ScreenShots/PerformanceBeforeChange.png
https://github.com/xiaotiantiantian/SlowLifeGUI/blob/master/ScreenShots/PerformanceBeforeChange3.png
###2.2 After modified
https://github.com/xiaotiantiantian/SlowLifeGUI/blob/master/ScreenShots/PerformanceAfterChange.png
https://github.com/xiaotiantiantian/SlowLifeGUI/blob/master/ScreenShots/PerformanceAfterChange3.png

##3 Manual test of runContinuous

##4 Pining Tests

###4.1 Test of Cell.toString
####Test of toString method, of class Cell. When the cell is alive, the toString method should return "X".
####Test of toString method, of class Cell. When the cell is dead, the toString method should return ".".
####Test of toString method, of class Cell. When the cell is alive in a 2-dimension , the toString method should return ".".

###4.2 Test of Cell.<init>
####Test of constructor method, of class Cell. When the cell is built in constructor without constructor ,then set it dead,  the toString method should return ".".
####Test of constructor method, of class Cell. When the cell is built in constructor with an parameter "true" then the method should return "X".
####Test of constructor method, of class Cell. When the cell is built in constructor with an parameter "false" then the method should return " ".

###4.3 Test of MainPanel.convertToInt
####Test of ConvertToInt method, of class MainPanel. If the input is a zero, the return is also a zero
####Test of ConvertToInt method, of class MainPanel. If the input is a positive 1, the return is also a positive 1
####Test of ConvertToInt method, of class MainPanel. If the input is a negative one, the return is also a negative one.

###4.4 Test of MainPanel.backup
####Testing that backup works when the _backupCells array is just constructed and has nothing inside.
####Testing that backup is worked, the backed up result matches the expected value of cells, if not same, the test would be fail.
####Testing that backup is worked stable. It means: I would give same input to run the backup function twice and the result would be the same.
