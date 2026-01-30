import kotlin.system.exitProcess


//Antoine Price
//11/28/2024

fun main()
{

    //Menu greeting
    greeting_menu()
    val Exit_Program_lowercase = "e"
    val Exit_Program_uppercase = "E"
    User_End_Session()
    // user input
    val userinput = readln()
    if(userinput == Exit_Program_lowercase || userinput == Exit_Program_uppercase)
    {
        EndSessionMessage()
        exitProcess(0)
    }
    //Finding username
    val user_access_limit = 0

    //Calling Function
    FindUserName(userinput,user_access_limit,Exit_Program_lowercase,Exit_Program_uppercase)





}
fun EndSessionMessage()
{
    println("Program is ending...")
}
fun User_End_Session()
{
    println("if you wish to end session type e OR E at any time doing the program")
}

fun greeting_menu()
{
    println("list of ID numbers for users 10038 10027 10083")
    println("Please enter your library ID number to find your name")
}


// Book information
fun User_Book_Info( Access_Key: Boolean, exitUpercase: String,exitLowercase: String ): Int
{
    val Access_Unathorized = false

    // user failed to input user data correctly send unable to access user data message
    if (Access_Key == Access_Unathorized)
    {
        println("\nunable to access user data.")
        return 0
    }
    println("Please input the number of books you want to check out. ")
    println("If you want to end the session input a number less then or equal to zero")
    // user has input zero number of books
    var number_of_books = 0

    //If user input a number one or greater then one
    var User_Books = 1

    //Count to zero in the for loop
    var Zero_Count = 0

    var Subtract_Books = 1

    var globeVarPass =""

    //try to get user input
    try
    {


        val User_Input_Books = readln().toInt()

        //User input value will be assigned to a variable outside the scope of try
        number_of_books = User_Input_Books
         globeVarPass = User_Input_Books.toString()
        println(User_Input_Books.toString())

        // If user input for number of books is less then or equal to zero
        if(User_Input_Books <= Zero_Count )
        {
            println("Do you wish to end this session if so press e OR E to end session if not press any key ")
            var User_answer = readln()
            if (User_answer == exitLowercase || User_answer == exitUpercase)
            {
                EndSessionMessage()
                exitProcess(0)
            }else
            {
                println("!!The number of Books you want to check out must be greater than 0!!\n")
                User_Book_Info(Access_Key, exitLowercase, exitUpercase)
            }
            }
    }

    //exceptoion catch if user inputs is a string and not integer
    catch ( e: NumberFormatException)
    {

        //Printing Error message
        println("Error ${e.message}, input a number instead." )

        //Program waits for 1 minute then calls the function User_Book_Info
        Thread.sleep(1000)

        //recusion
        User_Book_Info(Access_Key,exitLowercase,exitUpercase)
    }

    //having a dynamic array
    val list_of_books = ArrayList<String>()

    //increment means count to number of books
    for (increment in 0 until number_of_books)
    {

        if (number_of_books >= User_Books && increment == Zero_Count)
        {
            println("So you have $number_of_books Books. ")
            println("Please list the name of the books you want to borrow.")
        }


        val names_of_books = readLine()

        //this is the last book
        var LastBook = number_of_books - Subtract_Books

        //LastInput variable is the last input for list of books for user
        var LastInput = LastBook - Subtract_Books

        // this will allow the user to exit the program
        if(names_of_books == exitLowercase || names_of_books == exitUpercase)
        {
            EndSessionMessage()
            exitProcess(0)
        }
        // Adding User Books names to List
        list_of_books.add(names_of_books.toString())

        // i must be one least then the number of books so at the end of listing all books "Next Book"
        if (increment < LastBook)
        {
            // if i variable does not equal to user last input execute print statement
            if (increment != LastInput)
            {
                println("Next Book")

            }
            // if the user is ready to type his last input the print statement will execute
            else
            {
                println("Last Book")
            }
        }
    }

    for ((index,book) in list_of_books.withIndex())
    {
        // the program will wait for one second
        Thread.sleep(1000)
        println("${index + 1}# $book")

    }
    return 0
}


fun FindUserName(inputID: String, User_Attempt : Int, exitLowercase: String, exitUppercase: String )
{




    //Using a pair having to id and the two values for user first name and last namew
    val user_map = HashMap<String, Pair<String, String>>()

    user_map["10038"] = Pair("Antoine", "Price")
    user_map["10027"] = Pair("Jessica", "Mars")
    user_map["10083"] = Pair("Chris", "Mills")
    val user_info = user_map[inputID.toString()]


    if (user_info != null)
    {
        //user is given access
        var User_Access = true

        //store pair one in  first name and pair two in last name
        val (firstName, lastName) = user_info
        print("print user information.\n")
        println("User first name is $firstName and Last name is $lastName.")

        //calling function
        User_Book_Info(User_Access,exitLowercase,exitUppercase)

    }
    else
    {

        //this adds one to keep count with user input
        val ADD_TRiES = 1

        // this is the number of tries for your data
        val MAX_TRIES = 2




        // updating variable to keep count of user attempt
        val Update_User_Access = ADD_TRiES + User_Attempt


        // Substracing UPDATE_MAX_TRIES to get count of number of attempts
        if (User_Attempt <= MAX_TRIES)
        {
            //subtracting the maxiuam amount of tires by the amoumt times to show how many attempt have left
            val Update_User_Attempt = MAX_TRIES - User_Attempt
            println("Cant not find user information .\n")
            println("you have $Update_User_Attempt tries left.")
        }

        //if user have excceed the amount of MAX tries end program
        if (User_Attempt == MAX_TRIES )
        {
            println("thank you for your patience good bye.")
            // User acsess is getting restricted
            var User_Access = false

            //calling function
            User_Book_Info(User_Access,exitLowercase,exitUppercase)

        }
        else
        {
            // User greeting menu
            greeting_menu()
            User_End_Session()
            // User input
            val UserInput = readln()
            if(UserInput == exitLowercase || UserInput == exitUppercase)
            {
                EndSessionMessage()
                exitProcess(0)
            }
            //Tail recusion
            FindUserName(UserInput, Update_User_Access,exitLowercase,exitUppercase)
        }


    }
}



