##Command to execute elevator command:
java -jar elevator.jar cmd.txt

## cmd.txt
10:8-1
9:1-5,1-6,1-5
2:4-1,4-2,6-8
3:7-9,3-7,5-8,7-11,11-1
7:11-6,10-5,6-8,7-4,12-7,8-9
6:1-8,6-8


## Out put will be like this.
_____________________________________________________________________________________________________________________________
Mode A                                                          | Mode B
--------------------------------------------------------------------------------------------------------------------------------
10 8 1 (9)                                                      | 10 8 1 (9)
9 1 5 1 6 1 5 (30)                                              | 9 1 5 6 (13)
2 4 1 4 2 6 8 (16)                                              | 2 4 2 1 6 8 (12)
3 7 9 3 7 5 8 7 11 1 (36)                                       | 3 5 7 8 9 11 1 (18)
7 11 6 10 5 6 8 7 4 12 7 8 9 (40)                               | 7 6 8 9 12 11 10 7 6 5 4 (15)
6 1 8 6 8 (16)                                                  | 6 1 6 8 (12)

Note** 	elevator.jar is an exported jar file using eclipse. 
		If you like; you may export jar with different name

##Command to rum unit test case
mvn test

