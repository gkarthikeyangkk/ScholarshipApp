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
        FOREIGN KEY (Entity_ID) REFERENCES Entity_Details(ID)
	);        
        