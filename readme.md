#Deliverable4 of Zhirun Tian

##1. Summary
Here is the issues I found and modifed by using VisualVM snapshots.
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

##2. Screenshots before and after the modifies

##3. 