# Laboratory 4
## The Student / High School Admission Problem (SAP)
This repository contains all the problems proposed for the second laboratory in Advanced Programming course solved by me.

# Essentials tools
You need to have Java RE or JDK >= 8 installed on your computer.

# Build and run the above programs
Launch IntelliJ IDEA and click ▶️ in the gutter and select Run 'Main()' in the popup. The IDE starts compiling your code. When the compilation is complete, the Run tool window opens at the bottom of the screen

# Tasks
An instance of SAP involves a set of students and a set of high schools, each student seeking admission to one school, and each school having a number of available places (its capacity). Each student ranks some (acceptable) schools in strict order, and each school ranks its applicants in some order. A matching is a set of pairs (student, school) such that each student is assigned to at most one school and the capacities of the schools are not exceeded. A matching is stable if there is no pair (s, h) such that s is assigned to h' but s prefers h better than h' and h prefers s better than some of its assigned students. We consider the problem of creating a stable matching between students and schools.

```
Example: 4 students S0,S1,S2,S3, 3 high schools H0,H1,H2, capacity(H0)=1, capacity(H1)=2, capacity(H2)=2.
students preferences
S0: (H0, H1, H2)
S1: (H0, H1, H2)
S2: (H0, H1)
S3: (H0, H2)
schools preferences
H0: (S3, S0, S1, S2)
H1: (S0, S2, S1)
H2: (S0, S1, S3)
A solution for this example might be: [(S0:H1),(S1:H2),(S2:H1),(S3:H0)]
```

## Compulsory 
- [x] Create an object-oriented model of the problem. You should have at least the following classes: Student, School and the main class.
- [x] Create all the objects in the example using streams.
- [x] Create a list of students, using LinkedList implementation. Sort the students, using a comparator.
- [x] Create a set of schools, using a TreeSet implementation. Make sure that School objects are comparable.
- [x] Create two maps (having different implementations) describing the students and the school preferences and print them on the screen.
### Output
```
Name students:
Student(name=Gheorghe Ioana)
Student(name=Vasile Ana)
Student(name=Ion Alin)
Student(name=Marin Andrei)

Name schools:
School(name=C.N.S.H., capacity=35)
School(name=C.N.C.H., capacity=91)
School(name=C.N.A.E., capacity=84)

Sort student list by name: 
[Student(name=Gheorghe Ioana), Student(name=Ion Alin), Student(name=Marin Andrei), Student(name=Vasile Ana)]

Sort school list by name:
[School(name=C.N.A.E., capacity=84), School(name=C.N.C.H., capacity=91), School(name=C.N.S.H., capacity=35)]

The preferences for each student:
The student Vasile Ana has the next preferences: [C.N.S.H., C.N.C.H., C.N.A.E.]
The student Ion Alin has the next preferences: [C.N.S.H., C.N.C.H.]
The student Marin Andrei has the next preferences: [C.N.C.H., C.N.A.E.]
The student Gheorghe Ioana has the next preferences: [C.N.S.H., C.N.C.H., C.N.A.E.]

The preferences for each school:
The preferences of the  C.N.A.E. school are: [Gheorghe Ioana, Vasile Ana, Marin Andrei]
The preferences of the  C.N.C.H. school are: [Gheorghe Ioana, Vasile Ana, Ion Alin]
The preferences of the  C.N.S.H. school are: [Marin Andrei, Gheorghe Ioana, Vasile Ana, Ion Alin]

Process finished with exit code 0
```
## Optional
- [x] Create a class that describes the problem and one that describes a solution (a matching) to this problem.
- [x] Using Java Stream API, write queries that display the students who find acceptable a given list of schools, and the schools that have a given student as their top preference.
- [x] Use a third-party library in order to generate random fake names for students and schools. (I didn't make it )
- [x] Implement an algorithm for creating a matching, considering that each student has a score obtained at the evaluation exam and the schools rank students based on this score.
- [x] Test your algorithm.
### Output
```
Students who find acceptable of [School(name=Western Arizona Academy, capacity=13), School(name=Kirlin College, capacity=53), School(name=Bogan College, capacity=66)]: [Student(name=Barton Spinka III, grade=8), Student(name=Gilberto Mertz, grade=8)]

Schools that have the student Barton Spinka III as their top preference: [School(name=Kirlin College, capacity=53), School(name=Bogan College, capacity=66)]

Student preferences map: 
Barton Spinka III: Western Arizona Academy Kirlin College Bogan College 
Gilberto Mertz: Western Arizona Academy Kirlin College Bogan College 
Rocky Stanton: Kirlin College Bogan College 
Eddie Marvin Sr.: Western Arizona Academy Kirlin College 

School preferences map: 
Western Arizona Academy: Rocky Stanton, Barton Spinka III, Gilberto Mertz, Eddie Marvin Sr., 
Kirlin College: Barton Spinka III, Gilberto Mertz, Eddie Marvin Sr., 
Bogan College: Barton Spinka III, Gilberto Mertz, Rocky Stanton, 

The stable matching found is:
Student Barton Spinka III will go to school Kirlin College
Student Gilberto Mertz will go to school Kirlin College
Student Rocky Stanton will go to school Bogan College
Student Eddie Marvin Sr. will go to school Kirlin College
```

## Bonus
- [x] Consider the case in which a school can rank the students based on their specific criteria.
- [x] Implement the Gale Shapley algorithm in order to find a stable matching.
- [x] Consider the case in which preferences are not necessarily strict. Some consecutive preferences in an element's list may form a tie. For example S1: H1, [H2,H3] means that S1 prefers H1 over H2 and H3, but H2 and H3 have no precedence one over the other.
- [ ] Prove that in the case of SAP with ties, a problem may have multiple stable matchings, not all of the same size.
- [x] Check out other examples of matching in practice.
### Output
```
 Student Joycelyn DuBuque : West Gibson College  [ West Huel ]
 Student Mr. Rich Douglas : West Gibson College  [ West Huel Corkery University ]
 Student January Williamson : West Huel  [ Corkery University ]
 Student Tanisha Beier : Corkery University  [ West Gibson College ]
```
