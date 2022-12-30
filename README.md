# OOP.Assignment1

 <p align="center">
Nevo Gadassi and  Shani Basteker
</p>
 Describe the assignment:
The assignment is to extend the new functionality of UndoableStringBuilder.

Control the updates of UndoableStringBuilder by observer (design pattern for code).
 <p align="center">
<img  src="observer.png"/>
</p>



## GroupAdmin 
we built GroupAdmin class that Contains members and updates them on any changes that happen in the UndoableStringBuilder .


 register- function that writes new member to admin
 
 unregister- function that unregisters the member from the admins list
 
 updatemember -function that updates all the list of members

 
 insert, append, delete, undo-The methods of UndoableStringBuilder
 
 ## ConcreteMember 
This class represent a specific member and his UndoableStringBuilder
update- update member's UndoableStringBuilder to the GroupAdmin one.

## UML:
 <p align="center">
<img height="500" width="800" src="uml.png"/>
</p>




 


