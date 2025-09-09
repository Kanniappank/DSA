point 1 : interview ask you to design a Tic Tac Toe game strigh forward
point 2 : collect the requirements
    - A 3 X 3 game board
    - Two human player game
    - Alternate turns between X and O 
    - Move validation to ensure no invalid moves
    - Detection of win or loss scenarios
point 3 : Identifying the Key concepts
    - Piece represents X and O 
    - class Symbol(Enum)
    - Description : Represents the two possible game pieces, as well as the empty cells. Symbols.java
    - Tic Tac Toe game always have a board so Board class Board.java
    - Two players either X or O so Player class represents the player and stores player symbol and contains logic to make moves Player.java
point 4 : Desing challenge
    - What is the desing challange here?
    - The key desing challenges for desiging a Tic Tac Toe game are
        1. Managing Game state
            - Ensuring system accuratey tracks 
                - Player turns
                - Current Board Status
                - Game completion condition
        2. Implement move validation
            - Verifying each move is legal made in an empty cell
        3. Tracking players turn
            - Ensure proper alternation between X and O after each valid move
        4. Deciding game ending condition
            - Win condition(three symbols are in a row).
            - A draw condition (all the empty cells are filled)
point 5 : Desing patterns involvement
    - I can use statergy desing pattern for players intraction not the word can 
        - Bramstram the universal
            - we can incorperate stategy and factory in most of the problems
            - we can use use to show details to the user or some message we can incoporate observer desing pattern
            - we can incorporate state pattern to change to diffrent state X state O state draw state like that
    - Now we are gone uh use statergy pattern to communication between players
        - Ensure players intract with the system through a consistent interface
        - allow flexible player move implementations supporiting 
        - human players 
        - AI player future extension
        - Example A player interface with makeMove() method implementation diffrently for human player and AI player
    - And we are gone use the State pattern for the game flow Management
        - In Progress
        - Won
        - Draw
        - Example A gameState class with methods to transision between the game states based on the game conditon



