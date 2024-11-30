//Antoine Price
//11/28/2024

fun main()
{

    //Menu greeting
    greeting_menu()

    // user input
    val userinput = readln()

    //Finding username
    val user_access_limit = 0

    //Calling Function
    FindUserName(userinput,user_access_limit)






}

fun greeting_menu()
{
    println("list of ID numbers for users 10038 10027 10083.")
    println("Please enter your library ID number to find your name.")
}


// Book information
fun User_Book_Info( Access_Key: Boolean ): Int
{

    val Access_Unathorized = false

    // user failed to input user data correctly send unable to access user data message
    if (Access_Key == Access_Unathorized)
    {
        println("\nunable to access user data.")
        return 0
    }
    println("Please input the number of books you want to check out. ")

    // user has input zero number of books
    var number_of_books = 0


    //try to get user input
    try
    {

        val User_Input_Books = readln().toInt()

        //User input value will be assigned to a variable outside the scope of try
        number_of_books = User_Input_Books

    }

    //exceptoion catch if user inputs is a string and not integer
    catch ( e: NumberFormatException)
    {
        //Printing Error message
        println("Error ${e.message}, input a number instead." )

        //Program waits for 1 minute then calls the function User_Book_Info
        Thread.sleep(1000)

        //recusion
        User_Book_Info(Access_Key)
    }

    //having a dynamic array
    val list_of_books = ArrayList<String>()
    for (i in 0 until number_of_books)
    {
        if (number_of_books >= 1 && i == 0)
        {
            println("So you have $number_of_books Books. ")
            println("Please list the name of the books you want to borrow.")
        }


        val names_of_books = readLine()

        //this is the last book
        var LastBook = number_of_books - 1

        // Adding User Books names to List
        list_of_books.add(names_of_books.toString())

        // i must be one least then the number of books so at the end of listing all books "Next Book"
        if (i < LastBook)
        {
            println("Next Book")
        }
    }

    for ((index,book) in list_of_books.withIndex())
    {
        Thread.sleep(1000)
        println("${index + 1}# $book")

    }
    return 0
}


fun FindUserName(inputID: String, User_Attempt : Int)
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
        print("print user information.")
        println("User first name is $firstName and Last name is $lastName.")

        //calling function
        User_Book_Info(User_Access)

    }
    else
    {

        //this adds one to keep count with user input
        val ADD = 1

        // this is the number of tries for your data
        val MAX_TRIES = 2




        // updating variable to keep count of user attempt
        val Update_User_Access = ADD + User_Attempt


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
            User_Book_Info(User_Access)

        }
        else
        {
            // User greeting menu
            greeting_menu()

            // User input
            val UserInput = readln()

            //Tail recusion
            FindUserName(UserInput, Update_User_Access)
        }


    }
}
