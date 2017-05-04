Create database tripleSDb;

Use tripleSDb;

CREATE TABLE Entity_Details 
	(id INT primary key, 
		Entity_Type VARCHAR(100), 
        Reference_Entity_ID int,
        Entity_Category VARCHAR(100),
        First_Name VARCHAR(100),
        Middle_Name VARCHAR(100),
        Last_Name VARCHAR(100),
        Full_Name VARCHAR(300),
        Telephone_No VARCHAR(15),
        Mobile_No VARCHAR(15),
        Alternate_Contact_No VARCHAR(15),
        Salary_Per_Month numeric(15,2),
        Occupation_Profession VARCHAR(500),
        Education_Loan_Amount numeric(15,2),
        Help_Amount numeric(15,2)
	);
        
ALTER TABLE Entity_Details 
	ADD FOREIGN KEY ref_entity_id_fk (Reference_Entity_ID) 
	REFERENCES Entity_Details (id);
        
CREATE TABLE Student_Entity_Details 
	(id INT primary key, 
		Entity_ID INT,
        Mother_Tongue VARCHAR(100), 
        Religion VARCHAR(50),
        Have_Won_Prize CHAR(1),
        Describe_Prize_Details VARCHAR(5000),
        Aim_In_Life VARCHAR(5000),
        Have_Job_Or_Business CHAR(1),
        Describe_Job_Business_Details VARCHAR(5000),
        Have_Other_Problem_In_Family CHAR(1),
        Describe_Other_Problems_In_Family VARCHAR(5000),
        Got_Help_From_Other_Sources CHAR(1),
        Have_Education_Loan CHAR(1),
        Have_Other_Family_Members_Got_Help CHAR(1),
        Describe_If_Other_Family_Members_Got_Help CHAR(1),
        Date_Of_Birth VARCHAR(10),
        Place_Of_Birth VARCHAR(100),
        FOREIGN KEY (Entity_ID) REFERENCES Entity_Details(id)
	);        
----------------------------------------------------
-- 21st Feb 2017
Use tripleSDb;
CREATE TABLE Entity_Bank_Details 
	(id INT primary key, 
		Entity_ID INT,
        Is_Current CHAR(1), 
        Bank_Account_No VARCHAR(25),
        Bank_Name VARCHAR(100),
        Branch VARCHAR(100),
        IFSC_Code VARCHAR(25),
        Account_Holder_Name1 VARCHAR(300),
        Account_Holder_Name2 VARCHAR(300),
        Account_Holder_Name3 VARCHAR(300),
        FOREIGN KEY (Entity_ID) REFERENCES Entity_Details(id)
	);    
    
CREATE TABLE Entity_Address_Details 
	(id INT primary key, 
		Entity_ID INT,
        Address_Type VARCHAR(50), 
        Address_Line1 VARCHAR(1000),
        Address_Line2 VARCHAR(1000),
        City VARCHAR(50),
        State VARCHAR(50),
        Country VARCHAR(50),
        PinCode VARCHAR(10),
        FOREIGN KEY (Entity_ID) REFERENCES Entity_Details(id)
	);
    
CREATE TABLE Residence_Details
	(id INT primary key, 
		Entity_ID INT,
        Residence_Ownership VARCHAR(50), 
        Residence_Ownership_Other_Description VARCHAR(500),
        Residence_Size_In_SqFt numeric(8,2),
        Residence_Rent_Amount numeric(15,2),
        Residence_Type VARCHAR(50),
        Have_Water_Supply CHAR(1),
        Have_Bathroom CHAR(1),
        Have_Toilet CHAR(1),
        Have_Cot_Bed CHAR(1),
        Have_Cup_Board CHAR(1),
        Have_Cooking_Gas CHAR(1),
        Have_Television CHAR(1),
        Have_Refrigerator CHAR(1),
        Have_Vehicle CHAR(1),
        Have_Washing_Machine CHAR(1),
        Have_Oven CHAR(1),
        Have_Computer CHAR(1),
        FOREIGN KEY (Entity_ID) REFERENCES Entity_Details(id)
	);

CREATE TABLE Student_Course_Details
	(id INT primary key, 
		Entity_ID INT,
        Course_Name VARCHAR(200), 
        Course_Duration VARCHAR(25),
        Expected_Total_Course_Fees NUMERIC(15,2),
        School_College_Institute_Name VARCHAR(300),
        FOREIGN KEY (Entity_ID) REFERENCES Entity_Details(id)
	);
    
CREATE TABLE Student_Curriculum_Record
	(id INT primary key, 
		Entity_ID INT,
        Student_Course_Details_ID INT, 
        Course_Year VARCHAR(100),
        Passing_Year CHAR(4),
        Percentage_Marks NUMERIC(6,2),
        Grade VARCHAR(25),
        FOREIGN KEY (Entity_ID) REFERENCES Entity_Details(id),
        FOREIGN KEY (Student_Course_Details_ID) REFERENCES Student_Course_Details(id)
	);
    
CREATE TABLE Student_File
	(id INT primary key, 
		File_No VARCHAR(10) unique,
        File_Status VARCHAR(50), 
        Entity_ID INT,
        Created_By VARCHAR(50),
        Created_Date DATE,
        Interviewed_By VARCHAR(50),
        Interviewed_Date DATE,
        FOREIGN KEY (Entity_ID) REFERENCES Entity_Details(id)
	);
    
CREATE TABLE Student_Application
	(id INT primary key, 
		Application_No VARCHAR(10) unique,
        File_ID INT,
        Application_Status VARCHAR(50),
        Student_Curriculum_Record_ID INT,
        Created_By VARCHAR(50),
        Created_Date DATE,
        Interviewed_By VARCHAR(50),
        Interviewed_Date DATE,
        FOREIGN KEY (Student_Curriculum_Record_ID) REFERENCES Student_Curriculum_Record(id),
        FOREIGN KEY (File_ID) REFERENCES Student_File(id)
	);
    
----------------------------------------------------
-- 16th Mar 2017    
ALTER TABLE Student_File MODIFY COLUMN id INT AUTO_INCREMENT;
ALTER TABLE Student_File AUTO_INCREMENT=1001;

ALTER TABLE Entity_Details MODIFY COLUMN id INT AUTO_INCREMENT;
ALTER TABLE Entity_Details AUTO_INCREMENT=1001;
ALTER TABLE Entity_Details MODIFY Reference_Entity_ID INT NULL;
----------------------------------------------------
-- 26th Mar 2017
Use tripleSDb;
CREATE TABLE User
	(id INT primary key, 
		First_Name VARCHAR(100),
        Last_Name VARCHAR(100),
        Display_User_Name VARCHAR(100),
        Created_Date DATE,
        Password VARCHAR(20),
        Email_ID VARCHAR(100),
        Mobile_No VARCHAR(15)
	);
    
CREATE TABLE Role
	(id INT primary key, 
		Name VARCHAR(200)
	);    
    
CREATE TABLE User_Role
	(User_ID INT, 
		Role_ID INT,
        PRIMARY KEY (User_ID,Role_ID),
        FOREIGN KEY (User_ID) REFERENCES User(id),
        FOREIGN KEY (Role_ID) REFERENCES Role(id)
	);

----------------------------------------------------
-- 03rd May 2017    
ALTER TABLE User MODIFY COLUMN id INT AUTO_INCREMENT;
ALTER TABLE Role MODIFY COLUMN id INT AUTO_INCREMENT;

----------------------------------------------------
-- 04th May 2017
use triplesdb;
ALTER TABLE user MODIFY COLUMN Password VARCHAR(70);