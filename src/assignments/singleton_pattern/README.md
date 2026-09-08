# Instructions
In this assignment you will utilize the base code located here. You will be creating a Singleton logger to the code

Add the following updates to the code:
1) Create a new class SingletonLogger
    - This class will have the following methods
        - setLevel()
            - This method will set the level of logging (Info, Warn, Critical)
        - log()
            - This method will "log" based on Level 
            - You do not need to write to a file, for this assignment it will be enough to display to the console.
            - This should probably take two areguments, one for the level and one for the statement being logged.
3) Set the log level to INFO in the main 
4) In several classes created log statements for each level
    - You must have at least 3 statements of each level
    - Logs must have the date and time
5) *VERY IMPORTANT:* This code will be submitted as a PR as normal, but before submitting your PR, merge the base example code into your repo. This way the PR will show the differences between the base code and what you created. This will be part of the grade.  
6) Ensure the code adheres to SOLID coding principles
    - Ensure your code adheres to all other standards as well