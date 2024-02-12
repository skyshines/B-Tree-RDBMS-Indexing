# B-Tree-RDBMS-Indexing
Java Project made with the use of Java Libraries and core concepts like Java OOPS, Multithreading, Serialization, Java Swing, etc.

## Tech Stack Used
Java, Java Swing and AWT, and core Java Programming concepts like OOPS, Multithreading, Serialization, etc.

## Introduction and Aim of the Project

The relational database i.e. a database in the form of rows and columns is stored in the form of extents and data pages. The extents can be understood as folders and the data pages can be understood as files. So, each row is stored in the data page sequentially. Usually, the limit of a data page is 8KB. So, after a data page gets completely filled, the next row goes into a new data page. Usually, an extent can accomodate 8 data pages i.e. its size is usually limited to 64 KB. So, after an extent has accomodated 8 data pages, a new extent is created and a new data page is created and the further rows start getting stored from there.

### Table Scan Method
Now, if we want to search some data, the entire database is searched for it i.e. every extent, and every data page in those extents and every row in those data pages is searched. So, the time complexity of this searching is O(N) where N is the number of rows in the data base. This technique of searching the data is called Table Scan as the entire table is being scanned.

### Index Seek Method
We know that if the data has some particular indices attached to it, the searching becomes faster. We also know that arranging the data in the form of a Binary Tree makes searching faster. In a binary tree, the data in the left sub-tree of a node is smaller than its data and the data in the right sub-tree of a node is larger than it. So, a B-Tree has the same property but not just with 2 children, with multiple children. So, we create indices upon the attributes of the relational database and for each attribute, we maintain a seperate B-Tree that stores the indices. The data is present in the last level of the B-Tree and it tells us the exact location of the data. Exact location means the extent number, data page number and the row-offset of the data. So, we first have to reach the correct index and then that index helps us reach the data. Reaching the correct index means traversing the B-Tree and it takes O(logdN) (d is in the base of the log) time where d is the number of child nodes of a node in B-Tree and N is the number of rows in the database. Then, it tells us the exact location of the data which means it takes O(1) time to reach the data after we have reached the correct index. This technique of using indices to make searching faster is called Index Seek Method.

### Aim of the Project
So, the project aims at showing the differnce in speed and searching time of the Index Seek and Table Scan Searching methods and analyzing the advantages and siadvantages of both the methods.

### Advantage of Index Seek Over Table Scan
The advantage of Index Seek Method over the Table Scan method is very clear. The searching time is reduced from Linear to Logarithmic.

### Drawbacks of Index Seek
1. In index seek method, let us say that there are C number of columns (attributes). So, if we want to create indices upon every attribute, we will have to scan the entire data base C times initially for creating the indices. So, the entire database will be scanned for creating the indices every time. After this, the search upon the attribute using Index Seek method will always be logarithmic.
2. The second major drawback is extra space. We will create Index Pages. These index pages are nothing but the nodes of the B-Tree. So, extra space is used for making the searching faster.

## How to run the Project?

Download the source code from GitHub to your local. Now, go to the location B-Tree-master\IndexDemo\IndexDemo\src.
Here, compile the Java Client program using the command: javac Client.java
Now, you have to create an empty folder at any location. This will be the folder in which the entire database will be created. So, we have to run the Java Client file and while running, provide the path of the empty folder that you have just created as a command line argument. For instance, in my case, I have created a folder named IndexPrj. So, this is the command that I run on the terminal: java Client E:\IndexPrj

![image](https://user-images.githubusercontent.com/77784585/174325396-030a2121-8220-4591-99f0-c2bb4492ac50.png)

When you do this, the Java Application should run and this is what you will see.

![image](https://user-images.githubusercontent.com/77784585/174325654-5043f28f-6bb0-4572-988a-8975ae8b676d.png)

## Creating Test Database

For creating the random database, you have to input the number of rows in the text area available in the Data-Panel as shown below.

![image](https://user-images.githubusercontent.com/77784585/174327004-24805422-ec8c-487b-af09-dbfcf7a57f87.png)

A random test data of 10000 rows will be created in the same folder whose location you mentioned in the command line arguments.

![image](https://user-images.githubusercontent.com/77784585/174327143-5a4b14e2-12f1-4a19-8987-208b5402cc06.png)

![image](https://user-images.githubusercontent.com/77784585/174327198-17553063-ba06-486d-a95e-15241dbec35e.png)

![image](https://user-images.githubusercontent.com/77784585/174327236-b4f79406-8d30-44a5-9747-35811f0b788c.png)

You can see the data in the form of extents and data pages. You can open any random page in any random extent. You will see some random strings seperated by the pipe (|) symbol. They are Roll Number, Name, UserName and Password respectively.

![image](https://user-images.githubusercontent.com/77784585/174327723-1fcf24cf-9ea6-41e0-8856-2f0ec4f1596c.png)

The Metadata file contains the number of rows in the database.

![image](https://user-images.githubusercontent.com/77784585/174327930-44822ed3-8b12-4fdb-b59b-a86bff012af7.png)

The size of each page is maximum 8 KB and the size of each extent is maximum 64 KB.

## Searching using Table Scan

Open any random extnet and random data page. Pick any row from it and choose any attribute. Let us say UserName. Now, search the UserName in the Query Panel.

For instance, the UserName with Roll Number 7658 in Page 4 of extent 5 is chosen here.

![image](https://user-images.githubusercontent.com/77784585/174328471-9bfdae94-c290-4e13-b1be-82f7a5a4dae6.png)

![image](https://user-images.githubusercontent.com/77784585/174328591-15229960-dad7-48ec-ac32-fc7d8085c36b.png)

As you can see, it takes 201ms time and 35 pages were read.

## Creating Indices upon an Attribute

Now, let us create indices upon UserName.

![image](https://user-images.githubusercontent.com/77784585/174328866-6a346b40-2941-4b7c-8d15-d2c55881fc31.png)

We can see the indices being created in the progress bar of the Project as well as in the terminal.

![image](https://user-images.githubusercontent.com/77784585/174329282-8b0bb51c-dfc0-4c43-85e5-540635d6206d.png)

![image](https://user-images.githubusercontent.com/77784585/174328961-656a73c7-4ace-4b16-bc91-9fd6d53b81bd.png)

This is a time consuming process as the entire database is being read. 

After the process is completed, we can see that indices have been created upon the UserName.

![image](https://user-images.githubusercontent.com/77784585/174330749-2a8c90d4-6925-4648-abbc-91d8008140af.png)

![image](https://user-images.githubusercontent.com/77784585/174330782-13419913-df1d-40d6-97ec-e2a95eb4bb3e.png)

![image](https://user-images.githubusercontent.com/77784585/174330810-b5de9d8a-89fc-4fc1-bd53-f2d84c4a23a1.png)

![image](https://user-images.githubusercontent.com/77784585/174330852-645a5c44-4fa7-419a-b838-42430c822188.png)

![image](https://user-images.githubusercontent.com/77784585/174330870-baef2132-ed8a-4d87-b6e3-57154e3d8595.png)

![image](https://user-images.githubusercontent.com/77784585/174330909-0a6fbe18-8ae5-4dd3-921d-b0c58d2eadca.png)

As you can see above, we have a root page and all the other pages are the nodes of the B-Tree. The metadata file consists the data that which pages are non-leaf, root, and leaves, etc.

## Index Seek

So, let us now search for the same username. Now that indices have been created, Index Seek method will be used automatically by the Project.

![image](https://user-images.githubusercontent.com/77784585/174331328-27c13c5b-db3c-4b14-8731-6f77b0e5b1b4.png)

So, you can see that the Search time reduced to 7ms and only 2 pages were read. This is the advantage of index seek method over the table scan method.
